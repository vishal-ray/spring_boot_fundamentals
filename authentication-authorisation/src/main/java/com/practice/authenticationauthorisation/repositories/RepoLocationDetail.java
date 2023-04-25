package com.practice.authenticationauthorisation.repositories;

import com.practice.authenticationauthorisation.modules.LocationDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoLocationDetail extends JpaRepository<LocationDetail,Integer> {
}
