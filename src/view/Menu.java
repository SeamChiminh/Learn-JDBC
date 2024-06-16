package view;

import java.util.Scanner;

public class Menu {
    public static int mainMenu(){
        System.out.println("=".repeat(50));
        System.out.println(
                " [1]. Product Menu" + "\n" +
                        " [2]. Customer Menu" + "\n" +
                        " [3]. Order Menu" + "\n" +
                        " [0]. Exit"
        );
        System.out.println("=".repeat(50));
        System.out.print("[+] Insert Option: ");
        return (new Scanner(System.in).nextInt());
    }

    public static int productMenu(){
        System.out.println("=".repeat(50));
        System.out.println(
                " [1]. Add New Product" + "\n" +
                        " [2]. List All Products" + "\n" +
                        " [3]. Search Product By ID" + "\n" +
                        " [4]. Delete Product By ID" + "\n" +
                        " [5]. Update Product By ID" + "\n" +
                        " [0]. Back to Main Menu"
        );
        System.out.println("=".repeat(50));
        System.out.print("[+] Insert Option: ");
        return (new Scanner(System.in).nextInt());
    }

    public static int customerMenu(){
        System.out.println("=".repeat(50));
        System.out.println(
                " [1]. Add New Customer" + "\n" +
                        " [2]. List All Customers" + "\n" +
                        " [3]. Search Customer By ID" + "\n" +
                        " [4]. Delete Customer By ID" + "\n" +
                        " [5]. Update Customer By ID" + "\n" +
                        " [0]. Back to Main Menu"
        );
        System.out.println("=".repeat(50));
        System.out.print("[+] Insert Option: ");
        return (new Scanner(System.in).nextInt());
    }

    public static int orderMenu(){
        System.out.println("=".repeat(50));
        System.out.println(
                " [1]. Add New Order" + "\n" +
                        " [2]. List All Orders" + "\n" +
                        " [3]. Search Order By ID" + "\n" +
                        " [4]. Delete Order By ID" + "\n" +
                        " [5]. Update Order By ID" + "\n" +
                        " [0]. Back to Main Menu"
        );
        System.out.println("=".repeat(50));
        System.out.print("[+] Insert Option: ");
        return (new Scanner(System.in).nextInt());
    }

}
