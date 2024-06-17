package controller;

import model.dto.ProductDto;
import model.service.ProductService;
import model.service.ProductServiceImpl;

import java.util.List;

public class ProductController {
    ProductService productService = new ProductServiceImpl();
    public void AddNewProduct(ProductDto productDto) {
        productService.addNewProduct(productDto);
    }

    public List<ProductDto> queryAllProduct(){
        return productService.queryAllProducts();
    }

    public void searchProductById(Integer id){
        productService.searchProductById(id);
    }

    public void deleteProductById(Integer id){
        productService.deleteProductById(id);
    }

    public void updateProductById(Integer id) {
        productService.updateProductById(id);
    }
}
