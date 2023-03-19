package com.pis.apis.model;



import java.math.BigDecimal;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class JobInfo {
	
	@Id 
	String jobId;
	String name;
	String siteAddress;
	String siteCity;
	String sitePostalCode;
	String siteState;
	Timestamp inspectionDate;
	BigDecimal invoiceTotal;
	String contactName;
	String cellular;
	String email;
	String contactAddress;
}
