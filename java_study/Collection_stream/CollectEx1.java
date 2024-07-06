package ch17.sec12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import createRandomVariable.Crv;

public class CollectEx1 {

	public static void main(String[] args) {
		Crv.setMax_length(2);
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student(Crv.kor(), "남", Crv.inum()));
		totalList.add(new Student(Crv.kor(), "남", Crv.inum()));
		totalList.add(new Student(Crv.kor(), "여", Crv.inum()));
		totalList.add(new Student(Crv.kor(), "여", Crv.inum()));
		
		
		Map<String, List<Student>> map = totalList.stream().collect(Collectors.groupingBy(s -> s.getSex()));
		// totalList 내의 요소들을 성별에 따라 분류하고 그룹화해서, 각 그룹별 List<Student>를 생성한다.
		// 이 경우에는 성별이 남자인 List<Student>와 성별이 여자인 List<Student>가 각각 생성된다.
		// 이 맵의 구성 요소인 key : 성별, value : List<Student>이다.
		
		List<Student> maliList = map.get("남"); // key값이 "남"인 요소(List<Student>)를 불러와서 저장한다.
		maliList.stream().forEach(s -> System.out.println(s.getName())); // 그렇게 저장한 리스트를 스트림으로 읽는다. 
		
		List<Student> femaliList = map.get("여");
		maliList.stream().forEach(s -> System.out.println(s.getName()));
	}

}
