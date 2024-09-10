package com.it.rmu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.ProductTypeEntity;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Integer>{ 

}
