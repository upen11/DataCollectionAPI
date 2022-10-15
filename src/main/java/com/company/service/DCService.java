package com.company.service;

import java.util.List;
import java.util.Map;

import com.company.binding.EducationDetails;
import com.company.binding.IncomeDetails;
import com.company.binding.KidsDetail;

public interface DCService {
	
	public Integer getAppId(Integer appId);

	public Integer createCase(Integer appId);
	
	public Map<Integer, String> getPlanName();
	
	public boolean getIncomeDetails(IncomeDetails incomeDetails);
	
	public boolean getEducationDetails(EducationDetails eduDetails);
	
	public List<KidsDetail> getKidsDetails(KidsDetail kidsDetails);
	
	public void showSummary(Integer caseNumber);
	
	
}
