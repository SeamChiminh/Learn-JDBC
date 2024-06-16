import model.dao.CustomerDaoImpl;
import model.dao.OrderDaoImpl;
import model.dao.ProductDao;
import model.dao.ProductDaoImpl;
import model.entity.Customer;
import model.entity.Order;
import model.entity.Product;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        new CustomerDaoImpl()
//                .addNewCustomer(new Customer(
//                        3,
//                        "panha",
//                        "panha012@gmail.com",
//                        "@#$%",
//                        false,
//                        Date.valueOf(LocalDate.now())
//                ));

//        new CustomerDaoImpl()
//                .addNewCustomer(
//                        Customer.builder()
//                                .id(1)
//                                .name("sear")
//                                .email("sear@sear.com")
//                                .password("!#$%#")
//                                .isDeleted(false)
//                                .createdDate(Date.valueOf(LocalDate.now()))
//                                .build()
//                );

//        new CustomerDaoImpl()
//                .queryAllCustomers()
//                .forEach(System.out::println);

//        new CustomerDaoImpl()
//                .deleteCustomerById(1);

//        new CustomerDaoImpl()
//                .updateCustomerById(10);

//        new OrderDaoImpl()
//                .addNewOrder(
//                        Order.builder()
//                                .id(1)
//                                .orderName("hot pot")
//                                .orderDescription("hot pot kilo let 7")
//                                .customer(
//                                        Customer.builder()
//                                                .id(2)
//                                        .build())
//                                .orderedAt(Date.valueOf(LocalDate.of(2000,6,7)))
//                        .build());


//        new OrderDaoImpl()
//                .queryAllOrders()
//                .forEach(System.out::println);

//        new OrderDaoImpl()
//                .deleteOrderById(3);

//          new OrderDaoImpl()
//                  .updateOrderById(4);

            new OrderDaoImpl()
                    .addNewOrder(Order.builder()
                            .id(1)
                            .orderName("ទឹកផ្លែឈើ")
                            .orderDescription("ផលិតផលខ្មែរ")
                            .orderedAt(Date.valueOf(LocalDate.now()))
                            .customer(Customer.builder()
                                    .id(2)
                                    .build())
                            .productList(new ArrayList<>(
                                    List.of(Product.builder()
                                                    .id(2)
                                            .build())
                            ))
                            .build());

//        new ProductDaoImpl()
//                .addNewProduct(Product
//                        .builder()
//                        .id(1)
//                        .productName("vital")
//                        .productCode("002")
//                        .isDeleted(false)
//                        .importAt(Date.valueOf(LocalDate.now()))
//                        .expiredAt(Date.valueOf(LocalDate.of(2026,2,5)))
//                        .productDescription("buy 1 free 1")
//                        .build());

//        new ProductDaoImpl()
//                .queryAllProducts()
//                .forEach(System.out::println);

//        new ProductDaoImpl()
//                .updateProduct(1);

//        new ProductDaoImpl()
//                .deleteProduct(1);





    }
}