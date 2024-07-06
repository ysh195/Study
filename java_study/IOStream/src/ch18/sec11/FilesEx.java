package ch18.sec11;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesEx {

	public static void main(String[] args) {
		try {
			String data = "id : winter\n"
					+ "email : winter@company.com\n"
					+ "tel : 010-1234-5678";
			Path path = Paths.get("C:/Temp/user.txt");
			
			Files.writeString(path, data, Charset.forName("UTF-8"));
			
			System.out.println("파일 유형 : " + Files.probeContentType(path));
			System.out.println("파일 크기 : " + Files.size(path) + " bytes");
			
			String content = Files.readString(path, Charset.forName("UTF-8"));
			System.out.println(content);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
