package collection;

import java.util.*;

class MyQueue{
	
	private ArrayList<String> arrayQueue = new ArrayList<String>();
	// 링크드 리스트는 따로 있는데, 큐와 스택은 생성자가 따로 없고, 그냥 ArrayList를 활용하는 전형적인 방법에 불과한 것을 보임
	// 그냥 우리가 "구글링한다"고 하는데, 사실 그냥 검색하는 행위일 뿐이고, 구글이 제공하는 서비스도 그거 하나로 끝이 아니지만,
	// 구글을 활용하는 전형적인 방법 중 하나에 이름을 붙인 것과 같음
	// 그리고 이러한 활용은 arraylist가 빈 공간이 생기면 알아서 재정렬하는 특성을 이용한 것이라고 봄
	
	public void enQueue(String data) { // 선입/선출
		arrayQueue.add(data);
	}
	
	public String deQueue() {
		int len = arrayQueue.size();
		if(len==0) {
			System.out.println("큐가 비었습니다.");
			return null;
		}
		
		return (arrayQueue.remove(0));
	}
}

public class QueueTest {

	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		queue.enQueue("A");
		queue.enQueue("B");
		queue.enQueue("B");
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		

	}

}
