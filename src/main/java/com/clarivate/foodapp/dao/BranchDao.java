package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.Branch;
import com.clarivate.foodapp.dto.FoodOrder;
import com.clarivate.foodapp.repository.BranchRepository;

@Component
public class BranchDao {
	private static final Optional<Branch> branch = null;
	
	
	@Autowired
	BranchRepository branchRepository;
	
	public Branch addBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public List<Branch> getAllBranchs() {
		return branchRepository.findAll();
	}

	public String deleteBranch(int id) {
	Optional<Branch> branch = branchRepository.findById(id);
		
		if(branch.isPresent()) {
			branchRepository.delete(branch.get());
			return "Branch data "+ id +" has been deleted successfully";
		} else {
			return "Branch with ID:"+ id +" doesn't exist";
		}
	}
	public Branch updateBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch getBranchById(int id) {
		Optional<Branch> branch = branchRepository.findById(id);
		return branch.get();
	}

}
