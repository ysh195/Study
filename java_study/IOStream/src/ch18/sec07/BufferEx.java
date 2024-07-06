package ch18.sec07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferEx {

	public static void main(String[] args) throws Exception {
		String originalPath1 = BufferEx.class.getResource("originalFile1.jpg").getPath();
		String targetFilePath1 = "C:/Temp/targetFile1.jpg";
		FileInputStream fis = new FileInputStream(originalPath1);
		FileOutputStream fos = new FileOutputStream(targetFilePath1);
		
		String originalPath2 = BufferEx.class.getResource("originalFile2.jpg").getPath();
		String targetFilePath2 = "C:/Temp/targetFile2.jpg";
		FileInputStream fis2 = new FileInputStream(originalPath2);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		long nonBufferTime = copy(fis, fos);
		System.out.println("버퍼 미사용 : " + nonBufferTime + "ns");
		
		long BufferTime = copy(fis2, fos2);
		System.out.println("버퍼 사용 : " + BufferTime + "ns");
		
		fis.close();
		fos.close();
		bis.close();
		bos.close();
	
	}
	
	public static long copy(InputStream is, OutputStream os) throws Exception{
		long start = System.nanoTime();
		while(true) {
			int data = is.read();
			if(data == -1) {break;}
			os.write(data);
		}
		os.flush();
		long end = System.nanoTime();
		
		return (end-start);
	}

}
