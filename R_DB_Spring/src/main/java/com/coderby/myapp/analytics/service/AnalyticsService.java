package com.coderby.myapp.analytics.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderby.myapp.analytics.model.SampleVO;

@Service
public class AnalyticsService implements IAnalyticsService {

	private static final Logger logger = LoggerFactory.getLogger(AnalyticsService.class);
	
	@Autowired
	Rengine rEngine;
	
	@Override
	public ArrayList<SampleVO> getAvgPetalBySpecies2() {
		ArrayList<SampleVO> irisList = new ArrayList<SampleVO>();
		try{
			REXP result = rEngine.eval("tapply(iris$Petal.Length, iris$Species, mean)");
			REXP result2 = rEngine.eval("tapply(iris$Petal.Width, iris$Species, mean)");
			
			SampleVO sample1 = new SampleVO();
			sample1.setName("P.L mean");
			sample1.setType("column");
			sample1.setData(result.asDoubleArray());
			irisList.add(sample1);
			SampleVO sample2 = new SampleVO();
			sample2.setName("P.W mean");
			sample2.setType("column");
			sample2.setData(result2.asDoubleArray());
			irisList.add(sample2);
			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return irisList;
	}
	
	//----------------------------- 
	/*
	@Override
	public List<Map<String, Double>> getPie(){
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("Firefox",45.0);
		map.put("IE",26.8);
		map.put("Safari",8.5);
		map.put("Opera",6.2);
		map.put("Others",0.7);
		return map;
	}
*/
}
