package com.mfpe.memberService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfpe.memberService.model.Bills;

@Repository
public interface BillsRepo extends JpaRepository<Bills, String> {

}