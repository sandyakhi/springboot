package com.satya.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.satya.mvc.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>
{
	

}
