package com.suixiang.util;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class zkCuratorClient {
   //zookeeper客户端
   private CuratorFramework client = null;
   //日志
   final static Logger log = LoggerFactory.getLogger(zkCuratorClient.class);
   
   public zkCuratorClient(CuratorFramework client) {
		this.client = client;
   }
   public void init() {
	   client = client.usingNamespace("admin");
	   try {
		//判断admin命名空间下是否有bgm节点   /admin/bgm
		if(client.checkExists().forPath("/bgm") == null) {
			  client.create().creatingParentsIfNeeded()  
			  .withMode(CreateMode.PERSISTENT)   //节点类型: 持久节点
			  .withACL(Ids.OPEN_ACL_UNSAFE)   //acl权限: 匿名权限
			  .forPath("/bgm");
			  log.info("zookeeper客户端初始化成功");
		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("zookeeper客户端初始化错误");
		e.printStackTrace();
	}
   }
   /**
    * 增加或删除bgm,向zkServer创建子节点,供小程序后端监听
    * @param bgmId  背景音乐id
    * @param operatorType 操作类型
    */
   public void sendBgmOperator(String bgmId,String operatorMap) {
	   try {
		client.create().creatingParentsIfNeeded()  
			  .withMode(CreateMode.PERSISTENT)   //节点类型: 持久节点
			  .withACL(Ids.OPEN_ACL_UNSAFE)   //acl权限: 匿名权限
			  .forPath("/bgm/" + bgmId,operatorMap.getBytes());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
