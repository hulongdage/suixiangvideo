package com.suixiang.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suixiang.enums.VideoStatusEnum;
import com.suixiang.pojo.Backgroundmusic;
import com.suixiang.pojo.Comment;
import com.suixiang.pojo.Vision;
import com.suixiang.pojo.vo.VisionVO;
import com.suixiang.service.BgmService;
import com.suixiang.service.VideoService;
import com.suixiang.utils.FetchVideoCover;
import com.suixiang.utils.PageResult;
import com.suixiang.utils.ReturnJSONResult;
import com.suixiang.utils.VideoBgmUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value="操作视频的接口",tags= {"操作视频的controller"})
@RequestMapping("/video")
public class VideoController extends BasicController{
	
	@Autowired
	private BgmService bgmService;
	
	@Autowired
	private VideoService videoService;
	
	@ApiOperation(value="上传视频",notes="上传视频的接口")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId", value="用户id", required=true, 
				dataType="String", paramType="form"),
		@ApiImplicitParam(name="bgmId", value="背景音乐id", required=false, 
				dataType="String", paramType="form"),
		@ApiImplicitParam(name="videoSeconds", value="背景音乐播放长度", required=true, 
				dataType="String", paramType="form"),	
		@ApiImplicitParam(name="videoHeight", value="视频高度", required=true, 
				dataType="String", paramType="form"),
		@ApiImplicitParam(name="videoWidth", value="视频宽度", required=true, 
		        dataType="String", paramType="form"),
		@ApiImplicitParam(name="desc", value="视频描述", required=false, 
				dataType="String", paramType="form")
	})
	@PostMapping(value="/uploadVideo",headers="content-type=multipart/form-data")
	public ReturnJSONResult uploadVideo(String userId,
			String bgmId,double videoSeconds,int videoHeight,int videoWidth,String desc,
			@ApiParam(value="视频", required=true) MultipartFile file) throws Exception {
		if(StringUtils.isBlank(userId)) {
			return ReturnJSONResult.errorMsg("用户id为空...");
		}
		//文件上传地址命名空间
		String fileNameSpace = "C:/suixiangsoul_file";
		//视频地址的相对路径
		String videoPath = "/" + userId + "/video";
		//封面地址的相对路径
		String coverPathDB = "/" + userId + "/video";
		//视频保存的最终路径
		String finalPath = "";
		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		try {
			if(file != null) {			
				String fileName = file.getOriginalFilename();
				String arrayFilenameItem[] = fileName.split("\\.");
				String prefixFileName = "";
				for (int i = 0 ; i < arrayFilenameItem.length-1 ; i ++) {
					prefixFileName += arrayFilenameItem[i];
				}
				if(StringUtils.isNoneBlank(fileName)) {
					finalPath = fileNameSpace + videoPath + "/" + fileName;
					//数据库保存的路径
					videoPath += ("/" + fileName); 
					coverPathDB = coverPathDB + "/" + prefixFileName + ".jpg";
					File video = new File(finalPath);
					if(video.getParentFile() != null || !video.getParentFile().isDirectory() ) {
						video.getParentFile().mkdirs();
					}
					fileOutputStream = new FileOutputStream(video);
					inputStream = file.getInputStream();
					IOUtils.copy(inputStream, fileOutputStream);
				}
			}else {
				return ReturnJSONResult.errorMsg("视频上传出错...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnJSONResult.errorMsg("视频上传出错...");
		}finally {
			if(fileOutputStream != null) {
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}	
		//判断bgmId是否为空，如果不为空则查询bgm信息
		if(StringUtils.isNoneBlank(bgmId)) {
			Backgroundmusic bgm = bgmService.queryBgmById(bgmId);
			String audioinputPath = bgm.getPath();
			
			VideoBgmUtil videoBgmUtil = new VideoBgmUtil();
			String videoInputPath =  finalPath;
			
			String audioInputPath = fileNameSpace + audioinputPath ;
			String videoOutputName = UUID.randomUUID().toString() + ".mp4";	
			videoPath = "/" + userId + "/video" +"/" + videoOutputName;
			finalPath = fileNameSpace + videoPath;
			//调用视频合成工具类合成新的视频
			videoBgmUtil.convetor(videoInputPath, audioInputPath, finalPath,videoSeconds);			
		}
		//对视频进行截图
		FetchVideoCover fetchVideoCover = new FetchVideoCover(FFMPEG_EXE);
		fetchVideoCover.getCover(finalPath,fileNameSpace + coverPathDB);
		Vision vision = new Vision();
		vision.setAudioid(bgmId);
		vision.setCreattime(new Date());
		vision.setUserid(userId);
		vision.setVisionheight(videoHeight);
		vision.setVisionwidth(videoWidth);
		vision.setVisionseconds((float)videoSeconds);
		vision.setStatus(VideoStatusEnum.SUCCESS.value);
		vision.setVisiondesc(desc);
		vision.setVisionpath(videoPath);
		vision.setCoverpath(coverPathDB);
		String vId = videoService.saveVideo(vision);
		return ReturnJSONResult.ok(vId);
	}
	
	@PostMapping(value="/queryAllVideo")
	public ReturnJSONResult queryAllVideo(Integer currentPage) {
		if(currentPage == null) {
			currentPage = 1;
		}
		PageResult pageResult = videoService.queryAllVideos(currentPage, PAGE_SIZE);
		return ReturnJSONResult.ok(pageResult);
	}
	
	@PostMapping(value="/queryHotVideos")
	public ReturnJSONResult queryHotVideos() {
		 List<VisionVO> list = videoService.queryHotVideos();
		return ReturnJSONResult.ok(list);
	}
	
	@PostMapping("/showMyLikeList")
	public ReturnJSONResult showMyLikeList(String userId) throws Exception {
		
		if (StringUtils.isBlank(userId)) {
			return ReturnJSONResult.ok();
		}	
		List<VisionVO> likeList = videoService.showMyLikeList(userId);
		
		return ReturnJSONResult.ok(likeList);
	}
	
	@PostMapping("/showMyLike")
	public ReturnJSONResult showMyLike(String userId, Integer currentPage, Integer pageSize) throws Exception {
		
		if (StringUtils.isBlank(userId)) {
			return ReturnJSONResult.ok();
		}
		
		if (currentPage == null) {
			currentPage = 1;
		}

		if (pageSize == null) {
			pageSize = 6;
		}
		
		PageResult videosList = videoService.queryMyLikeVideos(userId, currentPage, pageSize);
		
		return ReturnJSONResult.ok(videosList);
	}
	
	@PostMapping("/showMyFollow")
	public ReturnJSONResult showMyFollow(String userId, Integer currentPage,Integer pageSize) throws Exception {
		
		if (StringUtils.isBlank(userId)) {
			return ReturnJSONResult.ok();
		}
		
		if (currentPage == null) {
			currentPage = 1;
		}

		if (pageSize == null) {
			pageSize = 6;
		}
		
		PageResult videosList = videoService.queryMyFollowVideos(userId, currentPage, pageSize);
		
		return ReturnJSONResult.ok(videosList);
	}
	
	@PostMapping("/showMyFollowList")
	public ReturnJSONResult showMyFollowList(String userId) throws Exception {
		
		if (StringUtils.isBlank(userId)) {
			return ReturnJSONResult.ok();
		}	
		List<VisionVO> followList = videoService.showMyFollowList(userId);
		
		return ReturnJSONResult.ok(followList);
	}
	
	@PostMapping(value="/searchVideo")
	public ReturnJSONResult searchVideo(@RequestBody Vision vision,Integer isSavedRecords,
			Integer currentPage, Integer pageSize) {
		if(currentPage == null) {
			currentPage = 1;
		}		
		if(pageSize == null) {
			pageSize = PAGE_SIZE;
		}
		PageResult pageResult = videoService.searchVideo(vision,isSavedRecords,currentPage, pageSize);
		return ReturnJSONResult.ok(pageResult);
	}
	
	@PostMapping(value="/hotWord")
	public ReturnJSONResult hotWord() {
		List<String> list = videoService.getHotWordList();
		return ReturnJSONResult.ok(list);
	}
	
	@PostMapping(value="/userLoveVideo")
	public ReturnJSONResult userLoveVideo(String userId, String videoId, String publisherId) {
		videoService.userLoveVideo(userId, videoId, publisherId);
		return ReturnJSONResult.ok();
	}
	
	@PostMapping(value="/userDisLoveVideo")
	public ReturnJSONResult userDisLoveVideo(String userId, String videoId, String publisherId) {
		videoService.userDisLoveVideo(userId, videoId, publisherId);
		return ReturnJSONResult.ok();
	}
	
	@PostMapping("/saveComment")
	public ReturnJSONResult saveComment(@RequestBody Comment comment, 
			String fatherCommentId, String toUserId) throws Exception {	
		//System.out.println("fatherCommentId======="+fatherCommentId+"toUserId======="+toUserId);
		if (StringUtils.isNotBlank(fatherCommentId) && StringUtils.isNotBlank(toUserId)) {
			comment.setFcommentid(fatherCommentId);
			comment.setTouserid(toUserId);
		}				
		videoService.saveComment(comment);
		return ReturnJSONResult.ok();
	}
	
	@PostMapping("/getVideoComments")
	public ReturnJSONResult getVideoComments(String videoId, Integer currentPage, Integer pageSize) throws Exception {
		
		if (StringUtils.isBlank(videoId)) {
			return ReturnJSONResult.ok();
		}
		
		// 分页查询视频列表，时间顺序倒序排序
		if (currentPage == null) {
			currentPage = 1;
		}

		if (pageSize == null) {
			pageSize = 10;
		}
		
		PageResult list = videoService.getAllComments(videoId, currentPage, pageSize);
		
		return ReturnJSONResult.ok(list);
	}
	
	
}
