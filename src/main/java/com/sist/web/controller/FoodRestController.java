package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.FoodService;
import com.sist.web.vo.FoodVO;

import lombok.RequiredArgsConstructor;

import java.util.*;

/*
	화면변경 (x) => 다른 언어와 연동(데이터전송 목적) => JSON
	CDN => Spring에 포함
	Component => Vue에 자체 화면 이동 => router
	
	이전 => 유지보수 : SpringFramework
					--------------- 전자정부프레임워크
					--------------- 대기업 : 애니프레임워크
					--------------- 금융권 : 일반 : 스프링
*/
// vue 연동

@RestController
@RequiredArgsConstructor
public class FoodRestController {
	private final FoodService fService;

	@GetMapping("/food/find_vue/")
	public Map food_find_vue(@RequestParam("page") int page, @RequestParam(name="address", required = false) String address)
	{
		if(address == null)
			address = "마포";
		
		Map map = new HashMap();
		
		int rowSize = 12;
		int start = (rowSize * page) - (rowSize -1);
		int end = rowSize * page;
		
		map.put("start", start);
		map.put("end", end);
		map.put("address", address);
		
		List<FoodVO> list = fService.foodListData(map);
		int totalpage = fService.foodTotalPage();
		
		final int BLOCK = 10;
		
		int startPage = ((page - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((page - 1) / BLOCK * BLOCK) + BLOCK;
		
		if(endPage > totalpage)
			endPage = totalpage;
		
		// Vue로 전송
		
		map = new HashMap();
		map.put("list", list);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalpage", totalpage);
		map.put("curpage", page);
		map.put("address", address);
		
		return map; // 자동으로 JSON 변경 => jackson
	}
	
	@GetMapping("food/detail_vue/")
	public FoodVO food_detail_vue(@RequestParam("fno") int fno)
	{
		FoodVO fvo = fService.foodDetailData(fno);
		return fvo;
	}
	
}
