package ch12.sec10;

import java.util.regex.Pattern;

public class PatternEx {

	public static void main(String[] args) {
		
		String regEXP = "(02|010)-\\d{3,4}-\\d{4}";
		// (02|010) : ?가 없으니 반드시 있어야 하는 그룹이고, 02과 010 둘 중 하나여야 한다
		// - |  \\d : 숫자열이다 | {3,4} : 그리고 그것은 3~4자리이다 |  \\d : 숫자열이다 | {4} : 그리고 그것은 4자리이다 
		String data = "010-123-4567";
		boolean result = Pattern.matches(regEXP, data);
		if(result) {
			System.out.println("일치");
		}
		else {
			System.out.println("불일치");
		}
		
		regEXP = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		// \\w : 문자열이다 | + : 전부 출력한다 | @ | \\w : 문자열이다 | + : 전부 출력한다 | \\. : .을 출력한다 | \\w : 문자열이다 | + : 전부 출력한다
		// (\\.\\w+)? : ?가 있으니, 있든 없든 상관없는 그룹이다.| \\. : .을 출력한다 | \\w : 문자열이다 | + : 전부 출력한다.
		data = "angel@myCompany.com";
		
		result = Pattern.matches(regEXP, data);
		if(result) {
			System.out.println("일치");
		}
		else {
			System.out.println("불일치");
		}
		
		regEXP = "\\d{6}-(1|2|3|4)\\d{6}";
		data = "000000-1000000";
		result = Pattern.matches(regEXP, data);
		if(result) {
			System.out.println("일치");
		}
		else {
			System.out.println("불일치");
		}
	}

}
