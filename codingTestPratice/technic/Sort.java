package one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Arrays.stream(str.split(""))
			.mapToInt(Integer::parseInt)
			.boxed()
			.sorted(Comparator.reverseOrder())
			.forEach(n -> System.out.println(n));
	}

}
