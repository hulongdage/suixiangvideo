package com.suixiang.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.suixiang.enums.VideoStatusEnum;
import com.suixiang.pojo.Backgroundmusic;
import com.suixiang.pojo.vo.AdminUser;
import com.suixiang.service.BgmService;
import com.suixiang.utils.PagedResult;
import com.suixiang.utils.ReturnJSONResult;

@Controller
@RequestMapping("bgm")
public class BgmController extends BasicController{
	
	@Autowired
	private BgmService bgmService;
	
	
	@GetMapping("/toAddBgmPage")
	public String toAddBgmPage() {	
		return "video/addBgm";
	}
	
	@GetMapping("/toBgmListPage")
	public String toBgmListPage() {
		return "video/bgmList";
	}
	
	@PostMapping("/queryBgmList")
	@ResponseBody
	public PagedResult queryBgmList(Integer page) {		
		PagedResult pageResult = bgmService.queryBgmList(page, PAGE_SIZE);
		return pageResult;
	}
	
	@PostMapping("/uploadBgm")
	@ResponseBody
	public ReturnJSONResult uploadBgm(@RequestParam("file") MultipartFile[] files) throws Exception {
		
		// 文件保存的命名空间    C:/suixiangsoul_file
        // linux系统上      String fileSpace = File.separator + "suixiangsoul_file" + File.separator + "bgmAdmin";
		String fileSpace = "C:" + File.separator + "suixiangsoul_file" + File.separator + "bgmAdmin";
		// 保存到数据库中的相对路径
		String uploadPathDB = File.separator + "bgm";
		
		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		try {
			if (files != null && files.length > 0) {
				
				String fileName = files[0].getOriginalFilename();
				if (StringUtils.isNotBlank(fileName)) {
					// 文件上传的最终保存路径
					String finalPath = fileSpace + uploadPathDB + File.separator + fileName;
					// 设置数据库保存的路径
					uploadPathDB += (File.separator + fileName);
					
					File outFile = new File(finalPath);
					if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
						// 创建父文件夹
						outFile.getParentFile().mkdirs();
					}
					
					fileOutputStream = new FileOutputStream(outFile);
					inputStream = files[0].getInputStream();
					IOUtils.copy(inputStream, fileOutputStream);
				}
				
			} else {
				return ReturnJSONResult.errorMsg("上传出错...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnJSONResult.errorMsg("上传出错...");
		} finally {
			if (fileOutputStream != null) {
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}
		
		return ReturnJSONResult.ok(uploadPathDB);
	}
	
	@PostMapping("/addBgm")
	@ResponseBody
	public ReturnJSONResult addBgm(Backgroundmusic bgm) {
		String bgmName = bgm.getName();
		boolean isExitBgm = bgmService.queryIsExitBgm(bgmName);
		if(isExitBgm) {
			return ReturnJSONResult.errorMsg("该BGM已存在");
		}
		bgmService.addBgm(bgm);
		return ReturnJSONResult.ok();
	}
	
	@PostMapping("/deleteBgm")
	@ResponseBody
	public ReturnJSONResult deleteBgm(String bgmId) {		
		bgmService.deleteBgm(bgmId);
		return ReturnJSONResult.ok();
	}
	
	
}
