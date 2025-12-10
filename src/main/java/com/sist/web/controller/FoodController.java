package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/*
	----------------------------------------------------------------------
							ThymeLeaf					Vue3
	----------------------------------------------------------------------
		렌더링				서버 렌더링					클라이언트 렌더링
		검색 엔진				매우 뛰어나다 					=> 서버 렌더링 사용(Nuxt)
		데이터 바인딩 			단방향						양방향 => AngularsJS / React
		속도					서버처리 중심					브라우저 중심
							Back-End					Front-End
		사용처 				관리 페이지					|모바일 => 동적
							| 공공기업 사이트				|페이징 / 검색 / 예약 / 결제 / 채팅 / AI
		=> 기본 : ThymeLeaf / JSP
		=> 동적 : React / Vue
			   ------------------
			   => 가상돔 + 반응형 => 동작
			= 가상돔
				브라우저 화면 직접 실행하는 실제 돔이 아니다
				가상 메모리에 저장 => 변경시 마다 실제 돔에 전송
				|					|
				--------------------- diff (비교)
				속도를 빠르게 / 깜박이는 효과가없다
			= 컴파일 = 렌더링을 실시간 수행
				=> 데이터만 변경
	2. MVVM (Model - View - ViewModel)
		MVC (Model - View - Controller)
	
		=> 요청 = Controller(요청 받기) = Model(요청처리) = Controller(결과값 전송) = View(화면출력)
		
		=> 요청 = Model(데이터 관리) <------> ViewModel(데이터 변경/처리) <--------> View(화면출력)
					|							|								|
					data()						create()						mount 영역
												mounted()						=> <template>
												updated()
												unmounted()
												methods:{}
		Model : 데이터의 상태 관리 (state)
				Pinin / VueX => 저장 (store)
		View : HTML을 제어
		ViewModel : 양방향 바인딩, 반응성 관리
					
		*** Model이 변경되면 ViewModel ==> HTML 반영
			| (설정된 변수가 변경시)
		
	3. 생명주기 함수
		create() : Vue 생성시 자동호출
		mounted() : 브라우저에 HTML이 번역 후 출력이 된 경우
		updated() : 데이터값이 변경된 후
		unmounted()	: 화면이 변경
			=> CallBack => Vue 시스템에 의해 자동 호출
			
		methods : 사용자 정의 함수 => 자동이 안된다
		*** React / Vue / Next / Node / Nuxt => 기본 코딩은 JavaScript
		*** 자바 / 오라클
		*** JavaScript 
		--------------
	4. 디렉티브
		v-model : 입력시에 data()에 있는 변수에 값을 설정
			| 양방향
			| react에 없다 => onchange
		v-bind => 속성에 값을 설정 => :
			<img v-bind:src="vo.poster">
			<img :src="vo.poster"> 변경됨
		v-on => 이벤트 처리
			<button v-on:click="함수">
				v-on => @click=""변경됨
		v-for : 반복문 => for-each만 지원
		v-if / v-else => v-else-if ...
		=> hide / show
			|
		   v-show="조건:false" v-show="조건:true"
		 뉴스 / 날짜 => 오픈 API
		 ---------
		 	|
		 	HTML이 포함
		 	v-text(X) => v-html => html() text() attr()
		 v-pre : 있는 그대로 출력
		 v-once : 한번만 수행
		 v-slot : 컴포넌트에 데이터 전송 => prop:[]
		 ----------------------------------------------
		 1. Component => CDN
		 		| => vuex / pinia
		 		
		기본패턴
		<script>
			const app=Vue.createApp({
				data(){
					return {
					
					}
				},
				mounted(){
					// 시작과 동시에 데이터 읽기
				},
				methods:{
					// 사용자 정의 함수, 이벤트
				},
				component:{
				
				},
				computed:{
				
				}
			}).mount("제어할 HTML의 영역")
	
	
	
*/
@Controller
public class FoodController {
	@GetMapping("/food/find")
	public String food_find() 
	{
		// => 실제 return templates/food/find.html
		// application.yml에 접두/접미에 templates/ 와 .html을 넣었기 때문
		return "food/find";	
	}
	
	@GetMapping("/food/detail")
	public String food_detail(@RequestParam("fno") int fno, Model model)
	{
		model.addAttribute("fno", fno);
		return "food/detail";
	}
	
}
