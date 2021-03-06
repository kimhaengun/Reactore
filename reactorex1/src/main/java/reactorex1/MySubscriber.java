package reactorex1;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// <T> 구독할 데이터 타입
// 구독자 = 일반 시민
public class MySubscriber implements Subscriber<Integer>{
	
	private Integer size = 2; //nobounded
	private Subscription s;
	
	public void onSubscribe(Subscription s) {
		this.s=s;
		// TODO Auto-generated method stub
		System.out.println("3.MySubscriber - 구독 정보 돌려 받음");
		//신문줘..
		s.request(size); //내가 하루에 읽을 수 있는 글자수의 한계(BackPressure-백프레셔)
		//MySubscription의 request가 실행된다.
		
		
	}
	//데이터를 돌려받는 함수
	public void onNext(Integer t) {
		// TODO Auto-generated method stub
		System.out.println("onNext - 신문"+t);
		size--;
		if(size==0) {
			size=2;
			s.request(size);
		}
	}

	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

	public void onComplete() {
		// TODO Auto-generated method stub
		System.out.println("신문 다 받음");
	}

}
