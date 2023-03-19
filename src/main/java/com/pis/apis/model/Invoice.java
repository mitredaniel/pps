package com.pis.apis.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class Invoice {
	
	@Id
	String jobId;
	Integer lineIndex;
	String description;
	BigDecimal amount;
	String reportName;
}
