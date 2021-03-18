package com.cos.webflux.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Customer {
	
	@Id
	private Long id;
	//final = 생성자 생성하기
	private final String firstName;
	private final String lastName;
	
}
