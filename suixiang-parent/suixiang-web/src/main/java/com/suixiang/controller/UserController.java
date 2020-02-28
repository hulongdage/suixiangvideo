package com.suixiang.controller;

import java.io.File;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suixiang.pojo.ReportNodes;
import com.suixiang.pojo.User;
import com.suixiang.pojo.vo.UserPublisherVideo;
import com.suixiang.pojo.vo.UserVO;
import com.suixiang.service.UserService;
import com.suixiang.utils.ReturnJSONResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="用户操作的接口",tags= {"用户操作的controller"})
@RequestMapping("/user")
public class UserController extends BasicController{
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="头像上传",notes="头像上传的接口")
	@ApiImplicitParam(name="userId",value="用户id",required=true,dataType="String")
	@PostMapping("/uploadHeadImage")
	public ReturnJSONResult uploadHeadImage(String userId,@RequestParam("file") MultipartFile[] files) throws Exception {
		if(StringUtils.isBlank(userId)) {
			return ReturnJSONResult.errorMsg("用户id为空...");
		}
		//文件上传地址命名空间
		String fileNameSpace = "C:/suixiangsoul_file";
		//头像地址的相对路径
		String headImagePath = "/" + userId + "/headImage";
		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		try {
			if(files != null && files.length > 0) {			
				String fileName = files[0].getOriginalFilename();
				if(StringUtils.isNoneBlank(fileName)) {
					//头像保存的最终路径
					String finalPath = fileNameSpace + headImagePath + "/" + fileName;
					//数据库保存的路径
					headImagePath += ("/" + fileName); 
					File headImage = new File(finalPath);
					if(headImage.getParentFile() != null || !headImage.getParentFile().isDirectory() ) {
						headImage.getParentFile().mkdirs();
					}
					fileOutputStream = new FileOutputStream(headImage);
					inputStream = files[0].getInputStream();
					IOUtils.copy(inputStream, fileOutputStream);
				}
			}else {
				return ReturnJSONResult.errorMsg("头像上传出错...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnJSONResult.errorMsg("头像上传出错...");
		}finally {
			if(fileOutputStream != null) {
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}
		User user = new User();
		user.setId(userId);
		user.setHeadimage(headImagePath);
		userService.updateUserDetail(user);
		return ReturnJSONResult.ok(headImagePath);
	}
	
	@ApiOperation(value="查询用户信息",notes="查询用户信息的接口")
	@ApiImplicitParams({
	@ApiImplicitParam(name="userId",value="用户id",required=true,dataType="String"),
	@ApiImplicitParam(name="fansId",value="粉丝id",required=false,dataType="String")
	})
	@PostMapping("/queryUserDetail")
	public ReturnJSONResult queryUserDetail(String userId,String fansId) throws Exception {
		
		if (StringUtils.isBlank(userId)) {
			return ReturnJSONResult.errorMsg("用户id为空...");
		}
		User user = userService.queryUserDetailById(userId);
		UserVO userVO = new UserVO();
		//将user的属性值拷贝到userVO中
		BeanUtils.copyProperties(user, userVO);
		boolean isCon = userService.isConcerned(userId, fansId);
		userVO.setConcern(isCon);
		return ReturnJSONResult.ok(userVO);
	}
	
	@ApiOperation(value="查询发布者信息",notes="查询发布者信息的接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId", value="用户id", required=true, dataType="String"),
		@ApiImplicitParam(name="publisherId", value="发布者id", required=true, dataType="String"),
		@ApiImplicitParam(name="videoId", value="视频id", required=true, dataType="String")
	})
	@PostMapping("/queryPublisherDetail")
	public ReturnJSONResult queryPublisherDetail(String userId,String publisherId,String videoId) throws Exception {	
		if (StringUtils.isBlank(publisherId)) {
			return ReturnJSONResult.errorMsg("信息为空...");
		}
		User user = userService.queryUserDetailById(publisherId);
		List<String> danmuList = userService.getDanmuList(videoId);
		UserVO publisher = new UserVO();
		//将user的属性值拷贝到userVO中
		BeanUtils.copyProperties(user, publisher);
		boolean userLoveVideo = userService.userLoveVideo(userId, videoId);
		UserPublisherVideo userPublisherVideo = new UserPublisherVideo();
		userPublisherVideo.setDanmuList(danmuList);
		userPublisherVideo.setDanmuNum(danmuList.size());
		userPublisherVideo.setUserVO(publisher);
		userPublisherVideo.setUserLoveVideo(userLoveVideo);
		return ReturnJSONResult.ok(userPublisherVideo);
	}
	
	@ApiOperation(value="关注操作",notes="关注操作的接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId", value="用户id", required=true, dataType="String"),
		@ApiImplicitParam(name="fansId", value="粉丝id", required=true, dataType="String")
	})
	@PostMapping("/addUserFansRelation")
	public ReturnJSONResult addUserFansRelation(String userId,String fansId) throws Exception {	
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(fansId)) {
			return ReturnJSONResult.errorMsg("信息为空...");
		}
		userService.addUserFansRelation(userId, fansId);
		return ReturnJSONResult.ok("关注成功");
	}
	
	@ApiOperation(value="取消关注操作",notes="取消关注操作的接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId", value="用户id", required=true, dataType="String"),
		@ApiImplicitParam(name="fansId", value="粉丝id", required=true, dataType="String")
	})
	@PostMapping("/delUserFansRelation")
	public ReturnJSONResult delUserFansRelation(String userId,String fansId) throws Exception {	
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(fansId)) {
			return ReturnJSONResult.errorMsg("信息为空...");
		}
		userService.delUserFansRelation(userId, fansId);
		return ReturnJSONResult.ok("取消关注成功");
	}
	
	@ApiOperation(value="举报用户操作",notes="举报用户操作的接口")
	@PostMapping("/tipUser")
	public ReturnJSONResult tipUser(@RequestBody ReportNodes reportNodes) throws Exception {	
		userService.tipUser(reportNodes);
		return ReturnJSONResult.ok("举报成功");
	}
}
