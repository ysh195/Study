package exceptionEx;

public class ArrayExceptionHandling {

	public static void main(String[] args) {
		int[] arr = new int[5];
		
		try {
			for(int i=0; i<=5; i++) { // <5 가 아니라 <=5니까 배열 범위 초과 오류
				arr[i] = i;
				System.out.println(arr[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			System.out.println("예외 처리 부분");
		}
		System.out.println("프로그램종료");

	}

}
