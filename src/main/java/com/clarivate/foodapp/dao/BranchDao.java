package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.Branch;
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

	public void deleteBranch(int id) {
		branchRepository.deleteById(id);
	}

	public Branch getBranchrById(int id) {
		Optional<Branch> branch = branchRepository.findById(id);
		return branch.get();
	}

}
