package com.suixiang.utils;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
 
/**
 * 视频中获取音频文件
 */
public class VideoBgmUtil {
	//FFmpeg全路径
    private static final String FFMPEG_PATH = "C:\\ffmpeg\\bin\\ffmpeg.exe";
    //音频保存路径
    private static final String TMP_PATH = "C:\\ffmpeg\\bin";
 
    /**
     * 从视频中提取音频信息
     * @param videoUrl
     * @return
     */
    public static String videoToAudio(String videoUrl){
        String aacFile = "";
        try {
            aacFile = TMP_PATH + "/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
                    + UUID.randomUUID().toString().replaceAll("-", "") + ".mp3";
            String command =   FFMPEG_PATH + " -i "+ videoUrl + " -vn -acodec copy "+ aacFile;
            System.out.println("video to audio command : " + command);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return "";
    }
    
	public static void main(String[] args){
		try {
			String videoInputPath = "E:\\ffmpeg\\bin\\desk1.mp4";
			String audioInputPath = "E:\\ffmpeg\\bin\\auoz.mp3";
			String videoOutPath = "E:\\ffmpeg\\bin\\带bgm的desk1.mp4";
			convetor(videoInputPath,audioInputPath,videoOutPath,8.1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---------获取音频文件成功！-----------");
		
	}
	 /**
     * @param videoInputPath 原视频的全路径
     * @param audioInputPath 音频的全路径
     * @param videoOutPath   视频与音频结合之后的视频的路径
     * @throws Exception
     */
    public static void convetor(String videoInputPath, String audioInputPath, String videoOutPath,double seconds)
            throws Exception {
        Process process = null;
        try {
        	String videoTime = String.valueOf(seconds);
  // ffmpeg.exe -ss 00:00:10  -t 5 -i "video.mp4" -ss 0:00:01 -t 5 -i "music.m4a" -map 0:v:0 -map 1:a:0 -y out.mp4
        //   String command =FFMPEG_PATH + " -i " + videoInputPath + " -i " + audioInputPath + 
        //     " -c:v copy -c:a aac -strict experimental " + " -map 0:v:0 -map 1:a:0 " + " -y " + videoOutPath;
        //       String command = FFMPEG_PATH + " -ss " + "00:00:1" + " -t " +"5" +" -i "+ videoInputPath + 
        //  		   " -ss "+ "0:00:01" + " -t " + "5" + " -i " + audioInputPath +
        // 		   " -map 0:v:0 -map 1:a:0 " + " -y " + videoOutPath;
        	 String command = FFMPEG_PATH + " -i "+ videoInputPath + 
          		   " -ss "+ "0:00:01" + " -t " + videoTime + " -i " + audioInputPath + " -c:v copy -c:a aac -strict experimental " +
          		   " -map 0:v:0 -map 1:a:0 " + " -y " + videoOutPath;		        		
            process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 使用这种方式会在瞬间大量消耗CPU和内存等系统资源，所以这里我们需要对流进行处理
        InputStream errorStream = process.getErrorStream();
        InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
 
        String line = "";
        while ((line = br.readLine()) != null) {
        }
        if (br != null) {
            br.close();
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (errorStream != null) {
            errorStream.close();
        }
 
    }
 
}