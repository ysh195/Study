package whatever;

import java.text.SimpleDateFormat; // 사용자지정 포맷에 관련된 패키지
import java.util.Date; // 날짜에 관련된 패키지

public class DateOut {

	public static void main(String[] args) {
		
		Date date = new Date();
		
		SimpleDateFormat customed_format = new SimpleDateFormat("YYYY-MM-dd"); // 이상하게 월만 MM으로 대문자 쓰고 다른 건 소문자를 씀. 날짜를 대문자(DD)로 쓰면 이상하게 나옴
		System.out.println(date);
		System.out.println(customed_format.format(date));

	}

}
