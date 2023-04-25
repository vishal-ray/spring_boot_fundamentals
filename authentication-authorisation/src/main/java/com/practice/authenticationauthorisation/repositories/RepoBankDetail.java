package com.practice.authenticationauthorisation.repositories;

import com.practice.authenticationauthorisation.modules.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoBankDetail extends JpaRepository<BankDetail,Integer> {
}
