package streamEx;

import java.util.ArrayList;
import java.util.List;

public class TravelTest {

	public static void main(String[] args) {
		TravelCustomer customer1 = new TravelCustomer("이순신",40,100);
		TravelCustomer customer2 = new TravelCustomer("김유신",20,100);
		TravelCustomer customer3 = new TravelCustomer("홍길동",13,50);
		
		List<TravelCustomer> customerList = new ArrayList<>();
		
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		
		System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
		
		customerList.stream().map(c -> c.getName()).forEach(s -> System.out.println(s)); // 커스터머 리스트에서 고객 정보 c를 가져와서 getName으로 이름을 추출. 그리고 forEach로 이름 s를 각각 출력
		
		int total = customerList.stream().mapToInt(c -> c.getPrice()).sum(); // 커스터머 리스트에서 고객 정보 c를 가져와서 getPrice로 가격을 불러오고 그걸 sum으로 처리. 근데 그냥 끝에 sum 하나 쓰는 걸로 끝?
		System.out.println("총 여행 비용은 : " + total + "입니다.");
		
		System.out.println("== 20세 이상 고객 명단 정렬하여 출력 ==");
		customerList.stream().filter(c -> c.getAge() >= 20).map(c -> c.getName()).sorted().forEach(s -> System.out.println(s));
		// 커스터머 리스트에서 고객 정보 c를 가져와서 getAge로 고객의 이름을 가져오고, filter로 20세 이상만 추림. 근데 괄호도 없이 그냥 -> 하면 좌우가 분리되는 건가?
		// 그리고 map으로 데이터를 테이블화하고, 해당 나이에 맞는 고객의 데이터를 가져옴. 그리고 getName으로 이름을 불러오고, sorted로 정렬
		// forEach로 고객 이름 s를 각각 출력

	}

}
