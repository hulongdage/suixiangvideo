package com.suixiang;

import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.suixiang.config.ResourceConfig;
import com.suixiang.enums.BGMOperatorTypeEnum;
import com.suixiang.utils.JsonUtils;


@Component
public class zkCuratorClient {
	
	 //zookeeper客户端
	 private CuratorFramework client = null;
	 //日志
	 final static Logger log = LoggerFactory.getLogger(zkCuratorClient.class);
	 
	 @Autowired
     private ResourceConfig resourceConfig;
	 
	// public static final String ZOOKEEPER_SERVER = "192.168.25.128:2181";
	 
	 public void init() {
			
			if (client != null) {
				return;
			}
			// 重试策略
			RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 5);
			// 创建zk客户端
			client = CuratorFrameworkFactory.builder().connectString(resourceConfig.getZookeeperServer())
					.sessionTimeoutMs(10000).retryPolicy(retryPolicy).namespace("admin").build();
			// 启动客户端
			client.start();
			try {
				addChildWatch("/bgm");
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
	 
	 public void addChildWatch(String nodePath) throws Exception {
			
			final PathChildrenCache cache = new PathChildrenCache(client, nodePath, true);
			cache.start();
			cache.getListenable().addListener(new PathChildrenCacheListener() {
				
				@Override
				public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) 
						throws Exception {
					//当监听到字节点增加操作时
					if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_ADDED)) {					 
						//1.从数据库查询背景音乐对象,获取路径path
						String path = event.getData().getPath();
						String operatorObjStr = new String(event.getData().getData());
						Map<String, String> map = JsonUtils.jsonToPojo(operatorObjStr, Map.class);
						String operatorType = map.get("operatorType");
						String songPath = map.get("path");
						
						//2.定义保存到本地的bgm路径
						String filePath = resourceConfig.getFileSpace() + songPath;
						
						//3.定义下载的路径(播放的url)
						//windows
						String arrPath[] = songPath.split("\\\\");
						//linux
						//String arrPath[] = songPath.split("/");
						String finalPath = "";
						// 3.1 处理url的斜杠以及编码
						for(int i = 0; i < arrPath.length ; i ++) {
							if (StringUtils.isNotBlank(arrPath[i])) {
								finalPath += "/";
								finalPath += URLEncoder.encode(arrPath[i], "UTF-8") ;
							}
						}
						String bgmUrl = resourceConfig.getBgmServer() + finalPath;
						
						if (operatorType.equals(BGMOperatorTypeEnum.ADD.type)) {
							// 下载bgm到spingboot服务器
							URL url = new URL(bgmUrl);
							File file = new File(filePath);
							FileUtils.copyURLToFile(url, file);
							client.delete().forPath(path);
						} else if (operatorType.equals(BGMOperatorTypeEnum.DELETE.type)) {
							File file = new File(filePath);
							FileUtils.forceDelete(file);
							client.delete().forPath(path);
						}
						}
					}
			});
	 }
}
