package com.pis.apis.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pis.apis.model.JobInfo;

@Repository
public interface JobInfoRepository extends JpaRepository<JobInfo, String> {
	
	@Query(value="select"
		 
			+ " job.TenantID as id "
			+ "	job.Name as job, "
			+ "	job.SiteAddress as direccion, "
			+ "	job.SiteCity as city, "
			+ "	job.SitePostalCode as zip, "
			+ "	job.SiteState as state, "
			+ "	job.InspectionDate as dd, "
			+ "	job.InvoiceTotal as invoice, "
			+ "	contact.Name , "
			+ "	contact.Cellular, "
			+ "	contact.Email, "
			+ "	contact.Address "
			+ "from [dbo].[tblJob] job "
			+ "inner join [tblJobContacts] jobContacts ON job.JobID = jobContacts.JobID "
			+ "inner join [dbo].[tblContact] contact ON jobContacts.ContactID = contact.ContactID "
			+ "where job.Name = ?1 ", nativeQuery = true)
	List<JobInfo> getJobInfo(Long jobNumber);

}
