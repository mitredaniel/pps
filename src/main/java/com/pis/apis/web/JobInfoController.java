package com.pis.apis.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pis.apis.model.Invoice;
import com.pis.apis.model.JobInfo;
import com.pis.apis.services.JobInfoServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/jobInfo")
public class JobInfoController {

	@Autowired
	private JobInfoServiceImpl jobInfoService;

	@GetMapping("/{jobId}")
	public List<JobInfo> getJobInfo(@PathVariable String jobId) {
		return jobInfoService.getJobInfo(jobId);
	}

	@GetMapping("/invoice/{jobId}")
	public List<Invoice> getInvoiceItems(@PathVariable String jobId) {
		return jobInfoService.getInvoiceItems(jobId);
	}

	@RequestMapping("/test")
	public String getTest() {
		return "tested successfully";
	}

}
