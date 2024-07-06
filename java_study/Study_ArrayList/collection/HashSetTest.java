package collection;

import java.util.HashSet;

public class HashSetTest { // set 들어가는 인터페이스들은 중복을 허용하지 않음
							// 대표적인 set류 인터페이스에는 hashset과 treeset이 있음.

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add(new String("임정순"));
		hashSet.add(new String("박현정"));
		hashSet.add(new String("홍연의"));
		hashSet.add(new String("강감찬"));
		hashSet.add(new String("강감찬")); // 중복된 건 알아서 저장 안 되게 함
		
		System.out.println(hashSet); // 또, 출력 순서가 입력 순서와 무관함. 그냥 지 마음대로임
	}

}
