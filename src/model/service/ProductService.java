package model.service;

import model.dto.ProductDto;
import model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> queryAllProducts();
    Product updateProductById(Integer id);
    Product deleteProductById(Integer id);
    void addNewProduct(ProductDto productDto);
    ProductDto searchProductById(Integer id);

}
