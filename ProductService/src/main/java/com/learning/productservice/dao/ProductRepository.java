package com.learning.productservice.dao;

import com.learning.productservice.model.ProductDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductDetails, Integer> {
    List<ProductDetails> findProductDetailsByOid(int oid);
}
