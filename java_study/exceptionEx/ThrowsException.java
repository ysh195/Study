package exceptionEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {
	
	public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException{ 
		FileInputStream fis = new FileInputStream(fileName);
		Class c = Class.forName(className);
		return c; // 딱기 뭔가 기능을 하는 건 아니고 전형적인 오류를 일으키는 것들을 모아둔 클래스
	}
	
	public static void main(String[] args) {
		ThrowsException test = new ThrowsException();
		try {
		test.loadClass("a.txt", "java.lang.String");
		}
		catch(FileNotFoundException|ClassNotFoundException e) { // catch를 여러 개 써서 각 오류마다 다르게 대응하는 것도 가능
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
