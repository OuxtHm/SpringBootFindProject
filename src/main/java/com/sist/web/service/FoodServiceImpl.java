package com.sist.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.mapper.FoodMapper;
import com.sist.web.vo.FoodVO;

import lombok.RequiredArgsConstructor;

/*
	Spring + XML
			-----
				=> 불편 => 순수하게 자바로만 코딩
					|	  ----------------
					|	  | => SpringBoot
					| Mybatis => XML / Annotation => 4.0(Annotatio)
					
		=> XML : properties / yml
*/
@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

	private final FoodMapper mapper;
	
	@Override
	public List<FoodVO> foodListData(Map map) {
		return mapper.foodListData(map);
	}
	
	@Override
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	
	@Override
	public FoodVO foodDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.foodDetailData(no);
	}
}
