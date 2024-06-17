package model.dao;

import model.entity.Customer;
import model.entity.Order;
import model.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDaoImpl implements OrderDao{

    @Override
    public int addNewOrder(Order order) {
        String sql = """
                INSERT INTO "order" (order_name, order_description, cus_id, ordered_at)
                VALUES (?, ?, ?, ?)
                """;
        String sql1 = """
                INSERT INTO "product_order"
                VALUES (?, ?)
                """;

        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234"
                );
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        ){
            preparedStatement.setString(1, order.getOrderName());
            preparedStatement.setString(2, order.getOrderDescription());
            preparedStatement.setInt(3,order.getCustomer().getId());
            preparedStatement.setDate(4,order.getOrderedAt());

            int rowAffected = preparedStatement.executeUpdate();
            String message = rowAffected > 0? "insert order successfully" : "insert order failed";
            System.out.println("+" + "~".repeat(50) + "+");
            System.out.println(message);
            System.out.println("+" + "~".repeat(50) + "+");

            //product_order
            for(Product product: order.getProductList()){
                preparedStatement1.setInt(1, product.getId());
                preparedStatement1.setInt(2, order.getId());
            }

            int rowAffected1 = preparedStatement1.executeUpdate();
            if(rowAffected1 > 0){
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println("Product has been ordered");
                System.out.println("+" + "~".repeat(50) + "+");
            }else{
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println("Product out of stock");
                System.out.println("+" + "~".repeat(50) + "+");
            }

        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteOrderById(Integer id) {
        String sql = """
                DELETE FROM "order"
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
        )
        {
            Order order = searchOrderById(id);
            if(order != null){
                preparedStatement.setInt(1, order.getId());
                int rowAffected = preparedStatement.executeUpdate();
                String message = rowAffected > 0? "delete successfully" : "delete failed";
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println(message);
                System.out.println("+" + "~".repeat(50) + "+");
                return rowAffected;
            }else{
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println("Order not found");
                System.out.println("+" + "~".repeat(50) + "+");
            }


        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    @Override
    public int updateOrderById(Integer id) {
        String sql = """
                UPDATE "order"
                SET order_name = ?, order_description = ?
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
        )
        {
            Order order = searchOrderById(id);
            if(order != null)
            {
                System.out.println("[+] Insert order_name: ");
                preparedStatement.setString(1,new Scanner(System.in).nextLine());
                System.out.println("[+] Insert order_description: ");
                preparedStatement.setString(2,new Scanner(System.in).nextLine());
                preparedStatement.setInt(3,id);
                int rowAffected = preparedStatement.executeUpdate();
                if(rowAffected > 0)
                {
                    System.out.println("+" + "~".repeat(50) + "+");
                    System.out.println("Update successfully.");
                    System.out.println("+" + "~".repeat(50) + "+");
                    return rowAffected;
                }
                else {
                    System.out.println("+" + "~".repeat(50) + "+");
                    System.out.println("[!] Update failed");
                    System.out.println("+" + "~".repeat(50) + "+");
                }
            }else{
                System.out.println("+" + "~".repeat(50) + "+");
                System.out.println("[!] order not found");
                System.out.println("+" + "~".repeat(50) + "+");
            }
        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    @Override
    public Order searchOrderById(Integer id) {
        String sql = """
                SELECT * FROM "order"
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
        )
        {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = null;
            while (resultSet.next()) {
                order = Order.builder()
                        .id(resultSet.getInt("id"))
                        .orderName(resultSet.getString("order_name"))
                        .orderDescription(resultSet.getString("order_description"))
                        .customer(Customer.builder()
                                .id(resultSet.getInt("cus_id"))
                                .build())
                        .orderedAt(resultSet.getDate("ordered_at"))
                        .build();
            }
            return order;

        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    @Override
    public List<Order> queryAllOrders() {
        String sql = """
                        SELECT * FROM "order"
                        INNER JOIN "customer" c ON "order".cus_id = c.id
                """;
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234"
                );
                Statement statement = connection.createStatement();
        ){
            ResultSet resultSet = statement.executeQuery(sql);
            List<Order> orderList = new ArrayList<>();
            while (resultSet.next())
            {
                orderList.add(
                        Order.builder()
                                .id(resultSet.getInt("id"))
                                .orderName(resultSet.getString("order_name"))
                                .orderDescription(resultSet.getString("order_description"))
                                .orderedAt(resultSet.getDate("ordered_at"))
                                .customer(Customer.builder()
                                        .id(resultSet.getInt("cus_id"))
                                        .name(resultSet.getString("name"))
                                        .email(resultSet.getString("email"))
                                        .password(resultSet.getString("password"))
                                        .isDeleted(resultSet.getBoolean("is_deleted"))
                                        .createdDate(resultSet.getDate("created_date"))
                                        .build())
                                .build());
            }
            return orderList;

        }catch (SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return new ArrayList<>();
    }
}
