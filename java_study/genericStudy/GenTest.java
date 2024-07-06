package test;

import java.lang.reflect.*;

public class GenTest {

	public static void main(String[] args) {
		
		System.out.println(new GenT().get_someone("Integer"));
		System.out.println(new GenT().get_someone("Long").getClass().getSimpleName()); // (T) 붙여서 리턴해도 여전히 본래의 클래스가 유지됨
		
		System.out.println(new GenT().getT(2).getClass().getSimpleName());

	}

}
