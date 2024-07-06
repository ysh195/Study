package ch11.classEx;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException { // forName()메서드로 클래스 이름을 못 찾을 경우 발생하는 오류 처리
		
		// throw는 에러 발생 시 출력할 메시지를 정하는 기능. 에러 발생 시의 return 임.
		// 엑셀의 iferror(계산식,출력문) 같은 것이고, 그냥 문법이 다른 것.
		
		/*
		  try{
		  		코드
		  		throw new Exception()
		  }
		  catch(Exception e){
		  	e.printStackTrace(); 오류 출력
		  	throw e
		  }
		  finally{
		  	그리고 항상 수행할 내용.
		  }
		  	
		 */
		
		/*
		 ArithmeticException : 엑셀의 div/0 에러. 0으로 나누기할 때 발생
		 ArrayIndexOutOfBoundsExcetion : 배열을 초과하는 범위의 계산
		 ClassCastExcetion : 변환 불가능한 타입으로 객체 반환
		 NullPointException : 존재하지 않는 정보를 참조해야 할 시 발생
		 IllegalArgumentException : 잘못된 인자 전달
		 IOException : 입출력 동작 실패 혹은 다른 곳에서 해당 입출력을 가로챘을 때
		 OutOfMemoryException : 메모리 부족
		 NumberFormatException : 즉 유니코드에서 문자열로 출력해줄 수 있는 숫자를 초과한 숫자를 문자열로 출력할 시. 예들 들어, 9999억 9999에 해당하는 문자는 유니코드에 없을 테니
		 */
		
		Person person = new Person(); // 퍼슨 생성자 
		
		Class pClass1 = person.getClass(); // 클래스 생성자이고, 퍼슨에 object 메서드인 getClass로 클래스명를 저장
		System.out.println(pClass1.getName());
		
		Class pClass2 = Person.class; // 메서드를 거치지 않고 그냥 바로 클래스를 저장
		System.out.println(pClass2.getName());
		
		try{Class pClass3 = Class.forName("classEx.Person"); // Person하고 아무런 연관도 없는데, 클래스 이름을 그렇게 지어줌.
		System.out.println(pClass3.getName()); // 근데 내가 막 지어주는 게 아니고 이미 있는 패키지와 클래스 이름으로 지어줘야 함.
		// throw new Exception();
		}
		catch (NullPointException | ClassCastExcetion | IllegalArgumentException | IOException | ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		finally {
			return;
		}
		
		
	}

}
