package com.clarivate.foodapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dao.BranchDao;
import com.clarivate.foodapp.dto.Branch;

@Service
public class BranchService {
	
	@Autowired
	BranchDao branchDao;
	
	public ResponseStructure<Branch> saveBranch(Branch branch){
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		
		Branch tempBranch = branchDao.addBranch(branch);
		
		if(tempBranch != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(branchDao.addBranch(tempBranch));
		}
		return responseStructure;
	}
	
	public ResponseStructure<List<Branch>> getAllBranch(){
		ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<List<Branch>>();
		
		List<Branch> branchList = branchDao.getAllBranchs();
		
		if (branchList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food order Details");
			responseStructure.setData(branchList);
		}
		
		return responseStructure;
	}
	
	public ResponseStructure<Branch> getBranchById(int id) {

		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();

		Branch branch = branchDao.getBranchById(id);

		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Branch Details Obtained");
			responseStructure.setData(branch);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Branch Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteBranch(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		Branch branch = branchDao.getBranchById(id);

		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Branch Details Deleted Successfully");
			responseStructure.setData(branchDao.deleteBranch(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Branch Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

	public ResponseStructure<Branch> updateBranch(Branch branch) {
		
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		
		Branch u1 = branchDao.getBranchById(branch.getId());
		
		if (u1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Branch data missing");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Branch is present");
			responseStructure.setData(branchDao.updateBranch(branch));

		}
		return responseStructure;

	}

}
