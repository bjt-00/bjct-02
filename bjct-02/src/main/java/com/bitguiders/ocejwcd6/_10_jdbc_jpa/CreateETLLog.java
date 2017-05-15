package com.bitguiders.ocejwcd6._10_jdbc_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateETLLog {

	public static void main(String arg[]){
		EntityManagerFactory em = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager emm = em.createEntityManager();
		emm.getTransaction().begin();
		ETLEntity etlEntity = emm.find(ETLEntity.class,"ARAAAKG-BRZ1");
		
		System.out.println("Contract ID :"+etlEntity.getContractId());
		System.out.println("Contract Name :"+etlEntity.getContractName());
	}
}
