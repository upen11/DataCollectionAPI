package com.company.service;

import java.util.Map;

import com.company.binding.ChildRequest;
import com.company.binding.DcSummary;
import com.company.binding.Education;
import com.company.binding.Income;
import com.company.binding.PlanSelection;

public interface DcService {
	
	public Long loadCaseNum(Integer appId);
	
	public Map<Integer, String> getPlanNames();
	
	public Long savePlanSelection(PlanSelection planSelection);
	
	public Long saveIncomeDetails(Income income);
	
	public Long saveEducationDetails(Education education);
	
	public Long saveChildren(ChildRequest request);
	
	public DcSummary showSummary(Long caseNumber);

}
	
	
//	public Integer getAppId(Integer appId);
//
//	public Integer createCase(Integer appId);
//	
//	public Map<Integer, String> getPlanName();
//	
//	public boolean getIncomeDetails(IncomeDetails incomeDetails);
//	
//	public boolean getEducationDetails(EducationDetails eduDetails);
//	
//	public List<KidsDetail> getKidsDetails(KidsDetail kidsDetails);
//	
//	public void showSummary(Integer caseNumber);
	
//}
