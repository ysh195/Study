package collection;

import java.util.*;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>(); // 링크드 리스트는 확실히 생성자 클래스가 따로 있음
		
		myList.add("A"); // 리스트에 추가
		myList.add("B");
		myList.add("C");
		
		System.out.println(myList); // 리스트 전체 출력
		
		myList.add(1,"D"); // 링크드 리스트 첫번째 위치에 D 추가
		System.out.println(myList);
		
		myList.addFirst("0"); // 링크드리스트 맨 앞에 0 추가
		System.out.println(myList);
		
		System.out.println(myList.removeLast()); // 링크드 리스트 맨 뒤의 요소 삭제 후 삭제된 요소를 출력
		System.out.println(myList);

	}

}
