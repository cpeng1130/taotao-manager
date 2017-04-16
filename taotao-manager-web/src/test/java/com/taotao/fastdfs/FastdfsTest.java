package com.taotao.fastdfs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastdfsTest {

	@Test
	public void testUpload() throws Exception{
		
		ClientGlobal.init("E:\\Program\\Java-SSM\\TaoTao\\taotao-manager\\taotao-manager-web\\src\\main\\resources\\properties\\client.conf");
		TrackerClient trackClient = new TrackerClient();
		TrackerServer trackerServer=trackClient.getConnection();
		StorageServer storeServer=null;
		StorageClient storageClient = new StorageClient(trackerServer,storeServer);
		String[] upload_file = storageClient.upload_file("E:\\Program\\Java-SSM\\TaoTao\\image\\testimage\\imagetes1.jpg", "JPG", null);
		for(String result :upload_file){
			System.out.println(result);
		}
	}
}
