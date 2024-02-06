package com.prashanth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashanth.model.product;

public interface productRepo extends JpaRepository<product, Integer> {

}
