package com.cos.reactorex2;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//Netty 서버는 비동기 서버, Tomcat 서버는 스레드 서버
//Flux = N개 이상의 데이터를 응답할 때 사용
//Mono = 0~1개의 데이터를 응답할 때 사용 (응답할 데이터가 정해짐)
@RestController
public class TestController1 {
	
	@GetMapping("/flux1")
	public Flux<Integer> flux() {
		return Flux.just(1,2,3,4).log(); //request(unbounded)
	}
	
	//MediaType = MessegeConverte를 건듬
	@GetMapping(value = "/flux2",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> flux2() {
		return Flux.just(1,2,3,4).delayElements(Duration.ofSeconds(3)).log(); //request(unbounded)
	}
	
	@GetMapping(value = "/flux3",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Long> flux3() {
		return Flux.interval(Duration.ofSeconds(1)).log();
	} //무한 실행
	
	@GetMapping(value = "/mono1")
	public Mono<Integer> mono1() {
		return Mono.just(1).log();
	}
}
