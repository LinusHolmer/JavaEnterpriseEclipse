package com.example.uppgift.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private  final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO CreateProductService(ProductDTO productDTO){
        Product product = new Product(productDTO.price(), productDTO.name());

        Product savedProduct = productRepository.save(product);


        return new ProductDTO(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice()
        );
    }

}
