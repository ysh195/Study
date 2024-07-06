package exceptionEx;

public class AutoCloseTest {

	public static void main(String[] args) {
		try(AutoCloseObj obj = new AutoCloseObj()){ // 이건 그냥 외부에서 생성하고, 생성된 객체만 괄호에 넣어도 됨
			throw new Exception();
		}
		catch(Exception e){
			System.out.println("예외");
		}

	}

}
