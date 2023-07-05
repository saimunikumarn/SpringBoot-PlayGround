package com.learning.productservice.services;

import com.learning.productservice.dao.ProductRepository;
import com.learning.productservice.exceptions.OrderNotFoundException;
import com.learning.productservice.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //method for getting data
    public ProductDetails findProducts(int pId) {
        return productRepository.findById(pId).orElse(null);
    }

    //method for posting data
    public ProductDetails saveProduct(ProductDetails productDetails) {
        return productRepository.save(productDetails);
    }

    public ProductDetails updateProduct(int pId, ProductDetails productDetails) {
        if (getProduct(pId) != null) {
            productRepository.save(productDetails);
        }
        return getProduct(pId);
    }

    public void deleteProduct(int pId) {
        ProductDetails existingProductDetails = productRepository.findById(pId)
                .orElseThrow(() -> new OrderNotFoundException("No data available with given Product Id :" + pId));

        productRepository.deleteById(existingProductDetails.getPid());
    }

    public List<ProductDetails> getAllProducts() {
        return (List<ProductDetails>) productRepository.findAll();
    }

    //Common utility method to get the product details
    public ProductDetails getProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<ProductDetails> getProductsByOid(int oId) {
        return productRepository.findProductDetailsByOid(oId);
    }

}

