package com.pis.apis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pis.apis.model.Invoice;
import com.pis.apis.model.JobInfo;

@Service
public class JobInfoServiceImpl {

	@Autowired
	JdbcTemplate jdbc;

	String jobInfoQuery = "use InspectionData" + " select " + " job.JobId, " + "	job.Name, " + "	job.SiteAddress, "
			+ "	job.SiteCity, " + "	job.SitePostalCode, " + "	job.SiteState, " + "	job.InspectionDate, "
			+ "	job.InvoiceTotal, " + "	contact.Name As ContactName , " + "	contact.Cellular, " + "	contact.Email, "
			+ "	contact.Address As ContactAddress " + "	from [dbo].[tblJob] job "
			+ "	inner join [tblJobContacts] jobContacts ON job.JobID = jobContacts.JobID "
			+ "	inner join [dbo].[tblContact] contact ON jobContacts.ContactID = contact.ContactID "
			+ "	where job.Name = ? and jobContacts.ContactIndex = 0; ";

	String invoiceQuery = "use InspectionData " + "select " + "JobID, " + "LineIndex, " + "Description, " + "Amount, "
			+ "ReportName " + "from [dbo].[tblJobInvoice] "
			+ "where JobID in (select JobID from [dbo].[tblJob] where Name = ?)";

	public List<JobInfo> getJobInfo(String jobNumber) {
		return jdbc.query(jobInfoQuery, BeanPropertyRowMapper.newInstance(JobInfo.class), jobNumber);

	}

	public List<Invoice> getInvoiceItems(String jobNumber) {
		return jdbc.query(invoiceQuery, BeanPropertyRowMapper.newInstance(Invoice.class), jobNumber);
	}

}
