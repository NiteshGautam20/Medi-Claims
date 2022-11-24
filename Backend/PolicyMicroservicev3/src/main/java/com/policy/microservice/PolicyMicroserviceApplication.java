package com.policy.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.policy.microservice.model.Benefits;
import com.policy.microservice.model.Hospital;
import com.policy.microservice.model.MemberPolicy;
import com.policy.microservice.model.Policy;
import com.policy.microservice.repository.BenefitsRepo;
import com.policy.microservice.repository.HospitalRepo;
import com.policy.microservice.repository.MemberPolicyRepo;
import com.policy.microservice.repository.PolicyRepo;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan(basePackages = "com.policy.microservice")
@EnableFeignClients
@Slf4j
public class PolicyMicroserviceApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		
		log.info("Inside Policy Microservice...");
		SpringApplication.run(PolicyMicroserviceApplication.class, args);
	}
	
	@Autowired
	private HospitalRepo hospitalRepo;
	
	@Autowired
	private PolicyRepo policyRepo;
	
	@Autowired
	private BenefitsRepo benefitsRepo;
	
	@Autowired
	private MemberPolicyRepo memberRepo;
	
	@Override
	public void run(String... args) throws Exception{
				
		Policy policy1 = new Policy("P1001","Health Plus Classic",500000,15639);
		Policy policy2 = new Policy("P1002","Health Plus Enhanced",3000000,17361);
		Policy policy3 = new Policy("P1003","Health Plus Premium",10000000,22085);
		
		Hospital hospital1 = new Hospital("H1","Apollo Hospital","Delhi-Indraprastha");
		Hospital hospital2 = new Hospital("H2","Artemis Hospital","Gurgaon");
		Hospital hospital3 = new Hospital("H3","Fortis Escorts Heart Institute","Delhi-Okhla");
		Hospital hospital4 = new Hospital("H4","BLK Super Speciality Hospital","Delhi-New Delhi");
		Hospital hospital5 = new Hospital("H5","Max Superspecialty Hospital, Saket","Delhi-New Delhi");
		Hospital hospital6 = new Hospital("H6","Fortis Memorial Research Institute","Gurgaon");
		
		policy1.getHospitals().add(hospital5);
		policy1.getHospitals().add(hospital1);
		policy1.getHospitals().add(hospital2);
		policy1.getHospitals().add(hospital3);
		
		policy2.getHospitals().add(hospital1);
		policy2.getHospitals().add(hospital2);
		policy2.getHospitals().add(hospital3);
		policy2.getHospitals().add(hospital4);
		policy2.getHospitals().add(hospital5);
		policy2.getHospitals().add(hospital6);
		
		policy3.getHospitals().add(hospital5);
		policy3.getHospitals().add(hospital1);
		policy3.getHospitals().add(hospital6);
		policy3.getHospitals().add(hospital3);
		
		
		Benefits b1 = new Benefits("B101","Coverage for COVID-19");
		Benefits b2 = new Benefits("B102","Coverage for hospitalization at home");
		Benefits b3 = new Benefits("B103","Ambulance charges upto 2000 covered");
		Benefits b4 = new Benefits("B104","Ambulance charges upto 3000 covered");
		Benefits b5 = new Benefits("B105","Ambulance charges upto 4000 covered");
		Benefits b6 = new Benefits("B106","Hospitalization charges for Premium Twin Sharing room covered");
		Benefits b7 = new Benefits("B107","Hospitalization charges for Deluxe room covered");
		Benefits b8 = new Benefits("B108","Hospitalization charges for Premium Deluxe room covered");
		
		policy1.getBenefits().add(b1);
		policy1.getBenefits().add(b2);
		policy1.getBenefits().add(b3);
		policy1.getBenefits().add(b6);
		
		
		MemberPolicy m1=new MemberPolicy("M101","P1001",2,"10/11/2020","01/02/2012");
		MemberPolicy m2 = new MemberPolicy("M102","P1002",13,"10/04/2019","16/12/2017");
		
		policy2.getBenefits().add(b1);
		policy2.getBenefits().add(b2);
		policy2.getBenefits().add(b4);
		policy2.getBenefits().add(b7);
		
		policy3.getBenefits().add(b1);
		policy3.getBenefits().add(b2);
		policy3.getBenefits().add(b5);
		policy3.getBenefits().add(b8);
		
		hospital1.getPolicies().add(policy1);
		hospital1.getPolicies().add(policy2);
		hospital1.getPolicies().add(policy3);
		
		hospital2.getPolicies().add(policy1);
		hospital2.getPolicies().add(policy2);
		
		hospital3.getPolicies().add(policy2);
		hospital3.getPolicies().add(policy3);
		
		hospital4.getPolicies().add(policy1);
		hospital4.getPolicies().add(policy2);
		
		hospital5.getPolicies().add(policy1);
		hospital5.getPolicies().add(policy2);
		hospital5.getPolicies().add(policy3);
		
		hospital6.getPolicies().add(policy2);
		hospital6.getPolicies().add(policy3);
		
		
		
		b1.getPolicyBenefits().add(policy1);
		b1.getPolicyBenefits().add(policy2);
		b1.getPolicyBenefits().add(policy3);
		
		b2.getPolicyBenefits().add(policy1);
		b2.getPolicyBenefits().add(policy2);
		b2.getPolicyBenefits().add(policy3);
		
		b3.getPolicyBenefits().add(policy1);
		b4.getPolicyBenefits().add(policy2);
		b5.getPolicyBenefits().add(policy3);
		
		b6.getPolicyBenefits().add(policy1);
		b7.getPolicyBenefits().add(policy2);
		b8.getPolicyBenefits().add(policy3);
		
		memberRepo.save(m1);
		memberRepo.save(m2);
		
		policyRepo.save(policy1);
		policyRepo.save(policy2);
		policyRepo.save(policy3);
		
		benefitsRepo.save(b1);
		benefitsRepo.save(b2);
		benefitsRepo.save(b3);
		benefitsRepo.save(b4);
		benefitsRepo.save(b5);
		benefitsRepo.save(b6);
		benefitsRepo.save(b7);
		benefitsRepo.save(b8);
		
		hospitalRepo.save(hospital1);
		hospitalRepo.save(hospital2);
		hospitalRepo.save(hospital3);
		hospitalRepo.save(hospital4);
		hospitalRepo.save(hospital5);
		hospitalRepo.save(hospital6);
	}
	
}
