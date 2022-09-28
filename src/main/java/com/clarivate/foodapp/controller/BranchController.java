package com.clarivate.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.Branch;
import com.clarivate.foodapp.services.BranchService;


@RestController
public class BranchController {
	
	@Autowired
	BranchService branchService;

	@PostMapping("/branch/{id}")
	public ResponseStructure<Branch> saveFoodOrder(@RequestBody Branch branch, @PathVariable int id) {
		return branchService.saveBranch(branch,id);
	}

	@GetMapping("/branch")
	public ResponseStructure<List<Branch>> getAllBranch() {
		return branchService.getAllBranch();
	}

	@GetMapping("/branch/{id}")
	public ResponseStructure<Branch> getBranchById(@PathVariable int id) {
		return branchService.getBranchById(id);
	}

	@DeleteMapping("/branch/{id}")
	public ResponseStructure<String> deleteBranch(@PathVariable int id) {
		return branchService.deleteBranch(id);

	}

	@PutMapping("/branch/{id}")
	public ResponseStructure<Branch> updateBranch(@RequestBody Branch branch, @PathVariable int id) {
		return branchService.updateBranch(branch,id);
	}
}