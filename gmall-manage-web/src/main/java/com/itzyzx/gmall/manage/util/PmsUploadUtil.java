package com.itzyzx.gmall.manage.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @CLassName PmsUploadUtil
 * @Description: 文件资源上传工具类
 * @date: 2020/3/26 14:46
 * @Version 1.0
 */
public class PmsUploadUtil {
	public static String uploadImage(MultipartFile multipartFile) {
		String imgUrl = "http://192.168.13.128";

		//上传图片到服务器
		//配置fdfs的全局链接地址
		String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();
		// 获得配置文件的路径

		try {
			ClientGlobal.init(tracker);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TrackerClient trackerClient = new TrackerClient();

		//获得一个trackerServer的实例
		TrackerServer trackerServer = null;

		try {
			trackerServer = trackerClient.getTrackerServer();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//通过tracker获得一个Storage链接客户端
		StorageClient storageClient = new StorageClient(trackerServer, null);
		try {
			byte[] bytes = multipartFile.getBytes();//获得上传的二进制对象

			//获得文件后缀名
			String originalFileName = multipartFile.getOriginalFilename();//a.jpg
			System.out.println(originalFileName);
			int i = originalFileName.lastIndexOf(".");
			//文件的类型：jpg /mp4/avi/jpeg
			String extName = originalFileName.substring(i + 1);

			String[] uploadInfos = storageClient.upload_file(bytes, extName, null);
			for (String uploadInfo : uploadInfos) {
				imgUrl += "/" + uploadInfo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgUrl;

	}
}
