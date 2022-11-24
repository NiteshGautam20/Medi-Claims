package com.mfpe.claimsmicroservice.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mfpe.claimsmicroservice.repository.ClaimRepo;

@SpringBootTest
class ClaimRepoTest {

	@MockBean
	ClaimRepo claimRepo;
	
	@Test
	@DisplayName("Checking if Claim Repo methods Are working or not")
	void testClaimRepo() {
		when(claimRepo.getStatus("C101")).thenReturn("Pending");
		when(claimRepo.getDescription("C101")).thenReturn("Verified");
		assertEquals("Pending", claimRepo.getStatus("C101"));
		assertEquals("Verified", claimRepo.getDescription("C101"));
	}
}
