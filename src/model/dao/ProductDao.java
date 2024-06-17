package model.dao;

import model.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> queryAllProducts();
    int updateProductById(Integer id);
    int addNewProductByid(Product product);
    int deleteProductByid(Integer id);
    Product searchProductById(Integer id);
}
