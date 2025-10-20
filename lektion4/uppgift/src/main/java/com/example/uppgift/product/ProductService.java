package com.example.uppgift.product;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProductService(ProductDTO productDTO){
        log.info("Creating product with name: {} and price: {}", productDTO.name(), productDTO.price());

        Product product = new Product(productDTO.price(), productDTO.name());
        Product savedProduct = productRepository.save(product);

        log.info("Product created with ID: {}", savedProduct.getId());

        return new ProductDTO(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice()
        );
    }

    public ProductDTO findByNameService(String name){
        log.info("Finding product with name: {}", name);

        Product product = productRepository.findByName(name)
                .orElseThrow(() -> {
                    log.warn("Product with name {} not found", name);
                    return new ProductNotFoundException(name);
                });


        log.info("Product found with ID: {}", product.getId());

        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice()
        );

    }

}
