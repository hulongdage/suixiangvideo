package com.suixiang.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FFMpegUtil {
	
	private String ffmpegPath;

	public FFMpegUtil(String ffmpegPath) {
		super();
		this.ffmpegPath = ffmpegPath;
	}
	
	public void convertor(String videoInputPath,String videoOutputPath) throws IOException {
		List<String> command = new ArrayList<String>();
        command.add(ffmpegPath);	
		command.add("-i");
		command.add(videoInputPath);
		command.add("-y");
		command.add(videoOutputPath);
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.start();
		InputStream inputStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		String line = "";
		while ( (line = br.readLine()) != null ) {
		}
		
		if (br != null) {
			br.close();
		}
		if (inputStreamReader != null) {
			inputStreamReader.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}
	}

	public static void main(String[] args) {
	    FFMpegUtil ffMpegUtil = new FFMpegUtil("E:\\ffmpeg\\bin\\ffmpeg.exe");	
        try {
			ffMpegUtil.convertor("E:\\ffmpeg\\bin\\hei.mp4", "E:\\ffmpeg\\bin\\jhei.avi");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
