package ch17.sec12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import createRandomVariable.Crv;

public class CollectEx {
	
	public static void main(String[] args) {
		Crv.setMax_length(2);
		List<Student> totallist = new ArrayList<>();
		totallist.add(new Student(Crv.kor(), "남", Crv.inum()));
		totallist.add(new Student(Crv.kor(), "남", Crv.inum()));
		totallist.add(new Student(Crv.kor(), "여", Crv.inum()));
		totallist.add(new Student(Crv.kor(), "여", Crv.inum()));
		
		List<Student> maleList = totallist.stream()
								.filter(s -> s.getSex().equals("남"))
								.toList();

		maleList.stream()
		.forEach(s -> System.out.println(s.getName()));
		
		System.out.println();
		
		Map<String, Integer> map = totallist.stream() // 리스트의 내용물을 꺼내서 Map에 저장하는 과정이다.
								.collect(
										Collectors
										.toMap(s -> s.getName(), s -> s.getScore())
										);

	}

}
