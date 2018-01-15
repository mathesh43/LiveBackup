package com.appranix.LiveBackUp.domain.repository;

import org.springframework.stereotype.Repository;

import com.appranix.LiveBackUp.domain.entity.LiveBackUp;

import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface LiveBackUpRepository extends PagingAndSortingRepository<LiveBackUp, Long>  {

	Iterable<LiveBackUp> findByEnvironmentId(String environmentId);
}

