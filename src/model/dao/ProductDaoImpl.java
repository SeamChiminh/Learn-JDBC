package model.dao;

import model.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> queryAllProducts() {
        String sql = """
                    SELECT * FROM "product"
                """;
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234"
                );
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ){
            List<Product> productList = new ArrayList<>();
            while (resultSet.next())
            {
                productList.add(
                        new Product(
                                resultSet.getInt("id"),
                                resultSet.getString("product_name"),
                                resultSet.getString("product_code"),
                                resultSet.getBoolean("is_deleted"),
                                resultSet.getDate("imported_at"),
                                resultSet.getDate("expired_at"),
                                resultSet.getString("product_description")
                        )
                );
            }

            return productList;

        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public int updateProductById(Integer id) {
        String sql = """
                UPDATE "product"
                SET  product_name = ?, product_description = ?
                WHERE id = ?
                """;

        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234"
                );
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sql);
        ){
            Product product = searchProductById(id);
            if( product != null)
            {
                System.out.print("[+] Insert ProductName: ");
                preparedStatement.setString(1,new Scanner(System.in).nextLine());
                System.out.print("[+] Insert ProductDescription: ");
                preparedStatement.setString(2,new Scanner(System.in).nextLine());
                preparedStatement.setInt(3,id);
                System.out.println("+" + "~".repeat(50) + "+");

                int rowAffected = preparedStatement.executeUpdate();
                String message = rowAffected > 0 ? "Update successfully" : "update failed";
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println(message);
                System.out.println("+" + "~".repeat(50) + "+");
            }else {
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println("product not found");
                System.out.println("+" + "~".repeat(50) + "+");
            }


        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    @Override
    public int addNewProductByid(Product product) {
        String sql = """
                    INSERT INTO "product" (product_name, product_code, is_deleted, imported_at, expired_at, product_description)
                    VALUES (?, ?, ?, ?, ?, ?)
                """;

        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234"
                );
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductCode());
            preparedStatement.setBoolean(3, product.getIsDeleted());
            preparedStatement.setDate(4,product.getImportAt());
            preparedStatement.setDate(5,product.getExpiredAt());
            preparedStatement.setString(6, product.getProductDescription());

            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected>0){
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println("Product added successfully");
                System.out.println("+" + "~".repeat(50) + "+");
            }else{
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println("[!] Product not added");
                System.out.println("+" + "~".repeat(50) + "+");
            }

        }catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteProductByid(Integer id) {
        String sql = """
                DELETE FROM "product"
                WHERE id = ?
                """;

        try(
                Connection connection = DriverManager.getConnection(

                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234"
                );
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            Product product = searchProductById(id);
            if( product == null)
            {
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println("[!] cannot delete product");
                System.out.println("+" + "~".repeat(50) + "+");
            }else{
                preparedStatement.setInt(1, id);
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println("Product deleted successfully");
                System.out.println("+" + "~".repeat(50) + "+");
            }

        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    @Override
    public Product searchProductById(Integer id) {
        String sql = """
                    SELECT * FROM "product"
                    WHERE id = ?
                """;

        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234"
                );

                PreparedStatement preparedStatement
                        = connection.prepareStatement(sql)
        ){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            while (resultSet.next())
            {
                System.out.println("+" + "~".repeat(50) + "+");
                product = Product.builder()
                        .id(resultSet.getInt("id"))
                        .productName(resultSet.getString("product_name"))
                        .productCode(resultSet.getString("product_code"))
                        .isDeleted(resultSet.getBoolean("is_deleted"))
                        .importAt(resultSet.getDate("imported_at"))
                        .expiredAt(resultSet.getDate("expired_at"))
                        .productDescription(resultSet.getString("product_description"))
                        .build();
                System.out.println("+" + "~".repeat(50) + "+");
            }
            return product;

        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }
}
