package com.it.rmu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

@Modifying(clearAutomatically = true)
@Query("delete from ProductEntity t where t.id = ?1")
void deleteByProductId(Integer productId);
}





