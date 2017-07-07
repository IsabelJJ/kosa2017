package com.coderby.myapp.analytics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.coderby.myapp.analytics.model.SampleVO;

public interface IAnalyticsService {
	//List<Map<String, Double>> getPie();
	ArrayList<SampleVO> getAvgPetalBySpecies2();

}
