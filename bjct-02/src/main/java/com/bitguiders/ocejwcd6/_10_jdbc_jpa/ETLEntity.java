package com.bitguiders.ocejwcd6._10_jdbc_jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ETLEntity
 *
 */
@Entity
@Table(name="BLUEID.BLUEID_CONTRACT")
public class ETLEntity implements Serializable {

	 String contractId;
	 String contractType;
	 String contractName;
	 
	 @Id
	 @Column(name="BLUEID_CONTRACT_ID")
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	@Column(name="CONTRACT_TYPE")
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	@Column(name="CONTRACT_NAME")
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
   
}
