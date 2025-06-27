package com.searchpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.searchpage.entity.DataEntity;

@Repository
public interface DataRepository extends JpaRepository<DataEntity, Integer>{

}
