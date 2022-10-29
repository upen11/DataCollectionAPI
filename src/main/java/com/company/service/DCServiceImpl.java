package com.company.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.binding.Child;
import com.company.binding.ChildRequest;
import com.company.binding.DcSummary;
import com.company.binding.Education;
import com.company.binding.Income;
import com.company.binding.PlanSelection;
import com.company.entity.CitizenAppEntity;
import com.company.entity.DcCasesEntity;
import com.company.entity.DcChildrenEntity;
import com.company.entity.DcEducationEntity;
import com.company.entity.DcIncomeEntity;
import com.company.entity.PlanEntity;
import com.company.repository.CitizenAppRepository;
import com.company.repository.DcCaseRepo;
import com.company.repository.DcChildrenRepo;
import com.company.repository.DcEducationRepo;
import com.company.repository.DcIncomeRepo;
import com.company.repository.PlanRepository;

@Service
public class DcServiceImpl implements DcService {

	@Autowired
	private CitizenAppRepository appRepo;

	@Autowired
	private DcCaseRepo dcCaseRepo;

	@Autowired
	private PlanRepository planRepo;
	
	@Autowired
	private DcIncomeRepo incomeRepo;
	
	@Autowired
	private DcEducationRepo educationRepo;
	
	@Autowired
	private DcChildrenRepo childrenRepo;

	@Override
	public Long loadCaseNum(Integer appId) {

		Optional<CitizenAppEntity> findById = appRepo.findById(appId);

		if (findById.isPresent()) {
//			CitizenAppEntity citizenAppEntity = findById.get(); find By id will have this, it's just for validating appId
			DcCasesEntity dcCasesEntity = new DcCasesEntity();

			dcCasesEntity.setAppId(appId);

			dcCaseRepo.save(dcCasesEntity);

//			or dcCaseEntity = dcCaseRepo.save(dcCasesEntity);
//			return dcCasesEntity.getCaseNumber();

			return dcCasesEntity.getCaseNumber();
		}

		return 0L;
	}

	@Override
	public Map<Integer, String> getPlanNames() {

		List<PlanEntity> findAll = planRepo.findAll();

		Map<Integer, String> plansMap = new HashMap<>();

		for (PlanEntity planEntity : findAll) {
			plansMap.put(planEntity.getPlanId(), planEntity.getPlanName());
		}

		return plansMap;
	}

	@Override
	public Long savePlanSelection(PlanSelection planSelection) {

		Optional<DcCasesEntity> findById = dcCaseRepo.findById(planSelection.getCaseNumber());

		if (findById.isPresent()) {
			DcCasesEntity dcCasesEntity = findById.get();
			
			dcCasesEntity.setPlanId(planSelection.getPlanId());
			
			dcCaseRepo.save(dcCasesEntity);
			
			return dcCasesEntity.getCaseNumber();

		}
		return null;
	}

	@Override
	public Long saveIncomeDetails(Income income) {
		
		DcIncomeEntity entity = new DcIncomeEntity();
		BeanUtils.copyProperties(income, entity);

		incomeRepo.save(entity);
		
		return income.getCaseNumber();
	}

	@Override
	public Long saveEducationDetails(Education education) {
		
		DcEducationEntity entity = new DcEducationEntity();
		BeanUtils.copyProperties(education, entity);

		educationRepo.save(entity);
		
		return education.getCaseNumber();
	}

	@Override
	public Long saveChildren(ChildRequest request) {
		
		List<Child> children = request.getChildren();
		
		long caseNum = request.getCaseNum();
		
		for(Child c : children) {
			DcChildrenEntity entity = new DcChildrenEntity();
			BeanUtils.copyProperties(c, entity);
			entity.setCaseNumber(caseNum);	//check in debug
			
			childrenRepo.save(entity);
		}
		
		return caseNum;
//		return childs.get(0).getCaseNumber();
		
		
	}

	@Override
	public DcSummary showSummary(Long caseNumber) {
		// we want income, education, children and plan names
		String planName = "";
		
		Optional<DcCasesEntity> dcCase = dcCaseRepo.findById(caseNumber);
		
		if(dcCase.isPresent()) {
			Integer planId = dcCase.get().getPlanId();
			
			Optional<PlanEntity> plan = planRepo.findById(planId);
			
			if(plan.isPresent()) {
				planName = plan.get().getPlanName();
			}
		}
		
		DcIncomeEntity incomeEntity = incomeRepo.findByCaseNumber(caseNumber);
		
		Income income = new Income();
		BeanUtils.copyProperties(incomeEntity, income);
		
		
		DcEducationEntity educationEntity = educationRepo.findByCaseNumber(caseNumber);
		
		Education education = new Education();
		BeanUtils.copyProperties(educationEntity, education);
		
		List<DcChildrenEntity> childrenEntity = childrenRepo.findByCaseNumber(caseNumber);
		
		List<Child> children = new ArrayList<>();
		
		for(DcChildrenEntity entity : childrenEntity) {
			Child child = new Child();
			
			BeanUtils.copyProperties(entity, child);
			
			children.add(child);
			
		}
		
		DcSummary summary = new DcSummary();
		
		summary.setPlanName(planName);
		summary.setIncome(income);
		summary.setEducation(education);
		summary.setChild(children);
		
		return summary;
	}

}
