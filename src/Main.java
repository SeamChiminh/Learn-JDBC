import controller.CustomerController;
import controller.OrderController;
import controller.ProductController;
import model.dto.CustomerDto;
import model.dto.OrderDto;
import model.dto.ProductDto;
import model.entity.Customer;
import view.Menu;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static void handleMenuProduct(ProductController productController ,Scanner sc) {
        while (true)
        {
            switch (Menu.productMenu())
            {
                case 1:
                    System.out.print("Input product code: ");
                    String pCode = sc.nextLine();

                    System.out.print("Input product name: ");
                    String pName = sc.nextLine();

                    System.out.print("Input description: ");
                    String pDesc = sc.nextLine();

                    Date pImportDate = Date.valueOf(LocalDate.now());
                    Date pExpireDate = Date.valueOf(
                            LocalDate.of(
                                    2025,12,31
                            ));

                    productController.AddNewProduct(
                            new ProductDto(
                                    pName,pCode,false, pImportDate, pExpireDate,pDesc
                            ));
                    break;

                case 2:
                    productController.queryAllProduct().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Input id to search product: ");
                    Integer id = sc.nextInt();
                    productController.searchProductById(id);
                    break;

                case 4:
                    System.out.print("Input id to update product: ");
                    Integer updateId = sc.nextInt();
                    productController.updateProductById(updateId);
                    break;

                case 5:
                    System.out.print("Input id to delete product: ");
                    Integer deleteId = sc.nextInt();
                    productController.deleteProductById(deleteId);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("+" + "~".repeat(50) + "+");
                    System.out.println("invalid input, please try again");
                    System.out.println("+" + "~".repeat(50) + "+");
            }
        }
    }

    private static void handleMenuCustomer(CustomerController customerController ,Scanner sc) {
        while (true)
        {
            switch (Menu.customerMenu()){
                case 1:
                    System.out.print("Input customer Id: ");
                    Integer cId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input customer name: ");
                    String cName = sc.nextLine();

                    System.out.print("Input customer email: ");
                    String cEmail = sc.nextLine();

                    customerController.addNewCustomer(new CustomerDto(cId,cName,cEmail));
                    break;

                case 2:
                    customerController.queryAllCustomers()
                            .forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Input id to search customer: ");
                    Integer sId = sc.nextInt();
                    customerController.searchCustomerById(sId);
                    break;

                case 4:
                    System.out.print("Input id to delete customer: ");
                    Integer dId = sc.nextInt();
                    customerController.deleteCustomerById(dId);
                    break;

                case 5:
                    System.out.print("Input id to update customer: ");
                    Integer uId = sc.nextInt();
                    customerController.updateCustomerById(uId);
                    break;
                case 0:
                    return;

                default:
                    System.out.println("+" + "~".repeat(50) + "+");
                    System.out.println("invalid input, please try again");
                    System.out.println("+" + "~".repeat(50) + "+");

            }

        }
    }

    private static void handleMenuOrder(OrderController orderController, Scanner sc)
    {
        while (true)
        {
            switch (Menu.orderMenu()){
                case 1:
                    System.out.print("Input order name: ");
                    String orName = sc.nextLine();

                    System.out.print("Input order description: ");
                    String orDes = sc.nextLine();

                    System.out.print("Input Customer id: ");
                    Integer orCusId = sc.nextInt();

                    Date orderDate = Date.valueOf(LocalDate.now());
                    Customer customer = Customer.builder()
                            .id(orCusId)
                            .build();
                    orderController.AddNewOrder(new OrderDto(
                            orName, orDes, customer, orderDate
                    ));

                    break;

                case 2:
                    orderController.queryAllOrders()
                            .forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Input id to search order: ");
                    Integer sId = sc.nextInt();
                    orderController.searchOrderById(sId);
                    break;

                case 4:
                    System.out.print("Input id to update order: ");
                    Integer uId = sc.nextInt();
                    orderController.updateOrderById(uId);
                    break;

                case 5:
                    System.out.print("Input id to delete order: ");
                    Integer dId = sc.nextInt();
                    orderController.deleteOrderById(dId);
                    break;
                case 0:
                    return;

                default:
                    System.out.println("+" + "~".repeat(50) + "+");
                    System.out.println("invalid input, please try again");
                    System.out.println("+" + "~".repeat(50) + "+");

            }
        }
    }

    public static void main(String[] args) {
        ProductController productController = new ProductController();
        CustomerController customerController = new CustomerController();
        OrderController orderController = new OrderController();

        Scanner sc = new Scanner(System.in);

        while (true)
        {
            try{
                switch (Menu.mainMenu())
                {
                    case 1:
                        handleMenuCustomer(customerController, sc);
                        break;

                    case 2:
                        handleMenuProduct(productController, sc);
                        break;

                    case 3:
                        handleMenuOrder(orderController, sc);
                        break;

                    case 99:
                        System.out.println("+" + "~".repeat(50) + "+");
                        System.out.println("Exiting program!");
                        System.out.println("+" + "~".repeat(50) + "+");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("+" + "~".repeat(50) + "+");
                        System.out.println("invalid input, please try again");
                        System.out.println("+" + "~".repeat(50) + "+");
                }
            }catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            }
        }
    }
}

