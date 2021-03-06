package reactorex1;

import java.util.Iterator;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

//구독 정보
public class MySubscription implements Subscription{
	
	private final MySubscriber subscriber;
	private Iterator<Integer> it;
	
	public MySubscription(MySubscriber s,Iterable<Integer> its) {
		System.out.println("2.MySubscription - 구독 정보 생성");
		this.subscriber = s;
		this.it=its.iterator();
	}

	public void request(long n) {
		// TODO Auto-generated method stub
		System.out.println("4.MySubscription - "+n+"개씩 구독 시작");
		// n 개씩 돌려주는 로직이 필요함 / MySubscriber에게 돌려줘야함.
		while(n>0) {

			if(it.hasNext()) {
				subscriber.onNext(it.next());	
			}else {
				subscriber.onComplete();
				break;
			}
			n--;	
		}
		System.out.println("==================");
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}


}
