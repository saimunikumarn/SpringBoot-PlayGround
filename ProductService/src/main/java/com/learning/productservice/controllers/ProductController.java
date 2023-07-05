package com.learning.productservice.controllers;

import com.learning.productservice.model.ProductDetails;
import com.learning.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("productHealth")
    public String getHealthOfProduct() {
        return "I'm fine, Thanks for checking my health!!! from ProductService";
    }

    @GetMapping("/getProducts/{index}")
    public ResponseEntity<ProductDetails> getProducts(@PathVariable int index) {
        return new ResponseEntity<>(productService.findProducts(index), HttpStatus.OK);
    }

    @GetMapping("/products")
    public List<ProductDetails> getAllOrders() {
        return productService.getAllProducts();
    }

    @GetMapping("/findProductByOId/{oId}")
    public ResponseEntity<List<ProductDetails>> findProductByOId(@PathVariable int oId) {
        return new ResponseEntity<>(productService.getProductsByOid(oId), HttpStatus.OK);
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductDetails> saveProduct(@RequestBody ProductDetails productDetails) {
        return new ResponseEntity<>(productService.saveProduct(productDetails), HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct/{pId}")
    public ResponseEntity<ProductDetails> updateProduct(@RequestBody ProductDetails productDetails, @PathVariable int pId) {
        return new ResponseEntity<>(productService.updateProduct(pId, productDetails), HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{pId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int pId) {
        productService.deleteProduct(pId);
        return new ResponseEntity<>("Product Deleted With Id: " + pId, HttpStatus.OK);

    }

}
