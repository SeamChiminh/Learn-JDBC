package model.service;

import mapper.Mapper;
import model.dao.ProductDao;
import model.dao.ProductDaoImpl;
import model.dto.ProductDto;
import model.entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<ProductDto> queryAllProducts() {

        return productDao.queryAllProducts()
                .stream()
                .map(Mapper::fromProductToProductDto)
                .toList();
    }

    @Override
    public Product updateProductById(Integer id) {
        Product exitstringProduct = productDao.searchProductById(id);
        if(exitstringProduct != null) {
            productDao.updateProductById(exitstringProduct.getId());
            return exitstringProduct;
        }
        return null;
    }

    @Override
    public Product deleteProductById(Integer id) {
        Product exitstingProduct = productDao.searchProductById(id);
        if(exitstingProduct != null) {
            productDao.deleteProductByid(id);
            return exitstingProduct;
        }else {
            System.out.println("Product not found");
            return null;
        }
    }

    @Override
    public void addNewProduct(ProductDto productDto) {
        int id = 4;
        Product product = new Product(++id,
                productDto.productName(),
                productDto.productCode(),
                productDto.isDeleted(),
                productDto.importedDate(),
                productDto.expiredDate(),
                productDto.produceDescription()
                );
        productDao.addNewProductByid(product);

    }

    @Override
    public ProductDto searchProductById(Integer id) {
        Product product = productDao.searchProductById(id);
        if(product != null){
            ProductDto productDto = Mapper.fromProductToProductDto(product);
            System.out.println("Product Name: " + productDto.productName());
            System.out.println("Product Code: " + productDto.productCode());
            System.out.println("Product IsDeleted: " + productDto.isDeleted());
            System.out.println("Imported Date: " + productDto.importedDate());
            System.out.println("Expired Date: " + productDto.expiredDate());
            System.out.println("Product Description: " + productDto.produceDescription());
            return productDto;
        }else{
            System.out.println("product not found");
            return null;
        }

    }
}
