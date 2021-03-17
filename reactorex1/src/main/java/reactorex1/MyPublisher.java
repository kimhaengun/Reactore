package reactorex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

//<T> = 내가 발행할 데이터 타입
// 출판사
public class MyPublisher implements Publisher<Integer>{
	
	//데이터베이스-MyPublisher는 데이터베이스 정보를 가지고 있음.
	Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//	List<Integer> itss = new ArrayList<Integer>();
	
	//구독 = subscribe = Subscriber --> onSubscribe
	public void subscribe(Subscriber<? super Integer> s) {
		// TODO Auto-generated method stub
		System.out.println("1.MyPublisher - 구독");
		s.onSubscribe(new MySubscription((MySubscriber)s, its));
		 //MySubscription
		//구독정보
	}

}
