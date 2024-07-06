package test;

public class GenT<T> {
	
	Boolean tf = true;
	Short sh = 100;
	Character ch = 'a';
	String text = "AAAA";
	Integer num = 10;
	Long lo = 555555L;
	
	T get_someone(String className){
		
		if(tf.getClass().getSimpleName().equals(className)){
			return (T)tf; // 타입이 서로 달라서 값을 대입할 수 없음. (T)로 타입을 전환하면 가능해짐.
		}
		else if(sh.getClass().getSimpleName().equals(className)){
			return (T)sh;
		}
		else if(ch.getClass().getSimpleName().equals(className)){
			return (T)ch;
		}
		else if(num.getClass().getSimpleName().equals(className)){
			return (T)num;
		}
		else if(lo.getClass().getSimpleName().equals(className)){
			return (T)lo;
		}
		else{
			return (T)text;
		}
			
	}
	
	T getT(Object obj) {
		T t = (T)obj;
		return t;
	}
	
	

}
