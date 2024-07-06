package streamEx;

import java.util.*;
import java.util.stream.Stream;

public class ArrayListStreamTest {

	public static void main(String[] args) {
		
		List<String> sList = new ArrayList<String>();
		sList.add("Tomas");
		sList.add("Edward");
		sList.add("Jack");
		
		Stream<String> stream = sList.stream();
		stream.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		sList.stream().sorted().forEach(s->System.out.println(s));
		// 스트림은 한 번 쓰면 재사용할 수 없다. scanner 돌려 쓰기처럼 불가. 다시 새로운 스트림을 만들어야 함
		// 중간연산과 최종연산이 있음
		// 기존 자료를 변경하지 않음
	}

}
