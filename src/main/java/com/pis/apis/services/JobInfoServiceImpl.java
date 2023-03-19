package com.pis.apis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.pis.apis.model.JobInfo;
@Service
public class JobInfoServiceImpl {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public List<JobInfo> getJobInfo(String jobNumber){
		String sql ="use InspectionData"
				+ " select "
				+ " job.JobId, "
				+ "	job.Name, "
				+ "	job.SiteAddress, "
				+ "	job.SiteCity, "
				+ "	job.SitePostalCode, "
				+ "	job.SiteState, "
				+ "	job.InspectionDate, "
				+ "	job.InvoiceTotal, "
				+ "	contact.Name As ContactName , "
				+ "	contact.Cellular, "
				+ "	contact.Email, "
				+ "	contact.Address As ContactAddress "
				+ "	from [dbo].[tblJob] job "
				+ "	inner join [tblJobContacts] jobContacts ON job.JobID = jobContacts.JobID "
				+ "	inner join [dbo].[tblContact] contact ON jobContacts.ContactID = contact.ContactID "
				+ "	where job.Name = ? and jobContacts.ContactIndex = 0; ";
		List<JobInfo> returnInfo = jdbc.query(sql,
				BeanPropertyRowMapper.newInstance(JobInfo.class),jobNumber);
		
		return returnInfo;
	}

}
