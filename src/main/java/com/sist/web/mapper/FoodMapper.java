package com.sist.web.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.FoodVO;

@Mapper
@Repository
public interface FoodMapper {

	/*	
	<select id="foodListData" resultType="com.sist.web.vo.FoodVO" parameterType="hashmap">
  		SELECT fno, name, poster, address, num 
  		FROM (SELECT fno, name, poster, address, rownum as num 
  		FROM (SELECT fno, name, poster, addres 
  		FROM menupan_food ORDER BY fno ASC))
  		WHERE num BETWEEN #{start} AND #{end} 
  	</select>
	*/
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*) / 12.0) FROM menupan_food")
	public int foodTotalPage();
	/*
	<select id="foodDetailData" resultMap="com.sist.web.vo.FoodVO" parameterType="int">
  		SELECT fno, name, poster, address, phone, time, parking, score, price, theme, type, context 
  		FROM menupan_food
  		WHERE no=#{no}	
  	</select>
	*/
	public FoodVO foodDetailData(int no);
	
	@Update("UPDATE menupan_food SET hit=hit+1 WHERE fno=#{fno}")
	public void hitIncrement(int fno);
}
