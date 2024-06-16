package model.dao;

import model.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> queryAllProducts();
    int updateProduct(Integer id);
    int addNewProduct(Product product);
    int deleteProduct(Integer id);
    Product searchProductById(Integer id);
}
