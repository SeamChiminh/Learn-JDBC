import model.dao.CustomerDaoImpl;
import model.entity.Customer;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        new CustomerDaoImpl()
//                .addNewCustomer(new Customer(
//                        2,
//                        "kako",
//                        "kak012@gmail.com",
//                        "@#$%",
//                        false,
//                        Date.valueOf(LocalDate.now())
//                ));

        new CustomerDaoImpl()
                .queryAllCustomers()
                .forEach(System.out::println);
    }
}