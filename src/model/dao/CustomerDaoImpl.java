package model.dao;

import model.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> queryAllCustomers() {
        String sql = """
                    SELECT * FROM "customer"
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

            List<Customer> customerList = new ArrayList<>();
            while (resultSet.next()) {
                customerList.add(
                        new Customer(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getBoolean("is_deleted"),
                                resultSet.getDate("created_date")
                                )
                );
            }

            return customerList;

        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public int updateCustomerById(Integer id) {
        return 0;
    }

    @Override
    public int deleteCustomerById(Integer id) {
        return 0;
    }


    @Override
    public int addNewCustomer(Customer customer) {
        String sql = """
                INSERT INTO "customer" (name, email, password, is_deleted, created_date)
                VALUES (?,?,?,?,?)
                """;

        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234"
                );
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){

        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getEmail());
        preparedStatement.setString(3,customer.getPassWord());
        preparedStatement.setBoolean(4, customer.getIsDeleted());
        preparedStatement.setDate(5, customer.getCreatedDate());

        int rowAffected = preparedStatement.executeUpdate();
        if(rowAffected > 0)
        {
            System.out.println("ជោគជ័យហើយ!");
        }

        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }

        return 0;
    }
}
