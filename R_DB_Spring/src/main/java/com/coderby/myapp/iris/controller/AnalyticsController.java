package com.coderby.myapp.iris.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderby.myapp.analytics.model.SampleVO;
import com.coderby.myapp.analytics.service.IAnalyticsService;
import com.google.gson.Gson;

@Controller
public class AnalyticsController {

	@Autowired
	IAnalyticsService analyticsService;
	
	@RequestMapping("/analytics/iris2")
	public String getAvgPetalbySpecies2(Model model){
		ArrayList<SampleVO> irisList = analyticsService.getAvgPetalBySpecies2();
		Gson gson = new Gson();
		String irisData = gson.toJson(irisList);
		model.addAttribute("irisData", irisData);
		return "analytics/chart";
	}
	
}
