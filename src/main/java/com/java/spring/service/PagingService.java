package com.java.spring.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.dao.pagingDaoInterface;

@Service
public class PagingService implements PagingServiceInterface {

	@Autowired
	pagingDaoInterface pdi;
	
	@Override
	public HashMap<String, Object> select(HashMap<String, Object> param) {
		
		List<HashMap<String, Object>> list = pdi.select(param);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		
		HashMap<String, Object> totCnt = pdi.totCnt();
		map.put("totCnt", totCnt);
		
		return map;
	}

}
