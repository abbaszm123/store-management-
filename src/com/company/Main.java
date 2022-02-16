package com.company;

/**
 *
 * @author FA20-BECE-0001 / FA20-BECE-0011
 */
import java.util.Arrays;

import java.util.Scanner;
import java.sql.*;
import java.util.InputMismatchException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import static java.util.logging.Logger.global;

public class Main{
    public static void main(String[] args){


        System.out.println("\n                **************  *************  **************  *************  **************       "
                + "\n                **************  *************  **************  *************  **************       "
                + "\n                ****            *************  ***        ***  ***       ***  ****                 "
                + "\n                ****                 ****      ***        ***  ***       ***  ****                 "
                + "\n                **************       ****      ***        ***  *************  ***********          "
                + "\n                 **************       ****      ***        ***  *************  ***********          "
                + "\n                           ****      ****      ***        ***  *** ****       ****                 "
                + "\n                           ****      ****      ***        ***  ***    ****    ****                 "
                + "\n                 **************      ****      **************  ***      ****  **************       "
                + "\n                 **************      ****      **************  ***       **** **************       ");




//        Scanner sc = new Scanner(System.in);
//        profit_loss s=new profit_loss();
//        s.password();



        System.out.println(               ""+"   MAIN MENU  "+""
                + "\n Enter the number  you want to do from the list provided below"
                + "\n 1.  PRODUCT QUERY"
                + "\n 2.  Customer Query "
                + "\n 3.  Store Entites"
                + "\n 4.  Employees"
                + "\n 5.  Exit" );





        while (true) {


            try{
                System.out.println("ENTER THE NUMBER: ");
                Scanner user_option=new Scanner (System.in);
                int user=user_option.nextInt();


                if(user==1){
                    try {
                        System.out.println("1-QUERY TO ADD\n 2-QUERY TO REMOVE\n 3-QUERY TO UPDATE");
                        int prod_choice = user_option.nextInt();
                        if (prod_choice == 1) {
                            addProduct additem = new addProduct();
                            additem.addproduct();
                        } else if (prod_choice == 2) {
                            addProduct.updategoods updateitem = new addProduct.updategoods();
                            updateitem.updateproduct();
                        } else {
                            addProduct.removeProduct removeprod = new addProduct.removeProduct();
                            removeprod.removeproduct();
                        }
                    }
                    catch (InputMismatchException e){
                        System.out.println("INVALID INPUT PLEASE TRY AGAIN");
                    }

                }

                if(user==2){


                    System.out.println("1-QUERY TO ADD\n 2-QUERY TO REMOVE\n 3-QUERY TO UPDATE");
                    int cust_choice=user_option.nextInt();
                    switch (cust_choice) {
                        case 1:
                            customer cust = new customer();
                            cust.addcustomer();
                            break;
                        case 2:
                            customer cust1=new customer();
                            cust1.removecustomer();
                            break;
                        case 3:
                            customer cust2=new customer();
                            cust2.updatecustomer();
                            break;

                        default:
                            System.out.println("sorry input valid input");
                            break;
                    }

                }
                if (user==3){
                    System.out.println("press 1 for first foor , press 2 for ground floor");
                    int choic=user_option.nextInt();
                    switch(choic){
                        case 1:
                            firstfloor ff=new firstfloor();
                            ff.securitysystem();
                            ff.shopingbaskets();
                        case 2:
                            groundfloor gfl=new groundfloor();
                            gfl.securitysystem();
                            gfl.shopingbaskets();

                    }
                }
                if (user==4){
                    System.out.println("press 1 for 1-department employees \npress 2 for 2nddepartment employees ");
                    int depchoice=user_option.nextInt();
                    switch(depchoice){
                        case 1:
                            employeeofdepartment1 dep1=new employeeofdepartment1();
                            dep1.employees();
                            dep1.stafsalary();
                        case 2:
                            employeeofdepartment2 dep2=new employeeofdepartment2();
                            dep2.employees();
                            dep2.stafsalary();

                    }
                }
                if (user==5){

                    System.out.println("**************");

                    System.out.println("exiting...");
                    System.exit(0);

                    break;
                }



            } catch (InputMismatchException e) {
                System.out.println("Invalid input given please try again");
            }

        }

    }

}

class storebasicthings{
    void securitysystem(){
        System.out.println("total cameras in the store are 5");
    };
    void shopingbaskets(){
        System.out.println("100 shoping carts in the store");}

}
class firstfloor extends storebasicthings{ //******inheritance*******
    @Override   //*****polymorphism****
    void securitysystem(){
        System.out.println("3 cameras are there in first floor ");
    }
    @Override
    void shopingbaskets(){
        System.out.println("We have 50 shopping carts in firstfloor");}


}
class groundfloor extends storebasicthings{
    @Override
    void securitysystem(){
        System.out.println("2 cameras are there in ground floor");
    }
    @Override
    void shopingbaskets(){
        System.out.println("we have 50 shopping carts in groundfloor");}

}







interface  Product {
    abstract void addproduct();
    abstract void removeproduct();



}
class addProduct implements Product {
    @Override
    public void removeproduct() {}

    @Override
    public void addproduct() {

        Scanner sc = new Scanner(System.in);
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Opened database successfully");
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            //System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS prod" +
                    " (ID          KEY     NOT NULL,"+
                    "NAME           TEXT    NOT NULL, " +
                    " Price            INT     NOT NULL, " +
                    " Stock         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Table created successfully");
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = c.createStatement();

            int i = 1;
            System.out.println("Enter the number of PRODUCTS you want to enter ");
            try{

                int a = sc.nextInt();
                while (i <= a) {
                    System.out.println("Enter the ID of prod"+i);
                    int id=sc.nextInt();
                    System.out.println("Enter the name of prod"+i);
                    String name = sc.next();
                    System.out.println("Enter the price of prod"+i);
                    int price = sc.nextInt();
                    System.out.println("Enter the stocks of prod"+i);
                    double stock = sc.nextDouble();

                    String sql = "INSERT INTO prod (ID,NAME,Price,Stock) " +
                            "VALUES ( "+ id +",'" + name + "' , " + price + ", " + stock + ");";
                    stmt.executeUpdate(sql);
                    System.out.println("item succesfully added"+i);

                    i = i + 1;


                }
                if(i==a) {
                    System.out.println("FOR FURTHER OPERATIONS \n" + "press 2- For removing a product from data base \n" + "press 3-Update price of data base");
                }


            }
            catch(InputMismatchException e){
                System.out.println("Invalid input please try again ");
            }




            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        // System.out.println("Records created successfully");
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            // System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM prod;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                float stock = rs.getFloat("stock");

                System.out.println( "ID = " + id  );
                System.out.println("NAME = " + name);
                System.out.println("PRICE = " + price);
                System.out.println("STOCK = " + stock+"\n");

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Operation done successfully");


    }
    static  class removeProduct   {
        Scanner sc = new Scanner(System.in);
        public void addproduct(){}
        public void updateproduct(){}
        public void removeproduct() {
            Connection c = null;
            Statement stmt = null;

            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);
                // System.out.println("Opened database successfully");

                stmt = c.createStatement();
                System.out.println("Enter the ID of the products you want to remove ");
                int id = sc.nextInt();
                String sql = "DELETE from prod where ID=" + id + ";";
                stmt.executeUpdate(sql);
                c.commit();

                ResultSet rs = stmt.executeQuery("SELECT * FROM prod;");

                while (rs.next()) {
                    id = rs.getInt("id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    double stock = rs.getFloat("stock");

                    System.out.println( "ID = " + id  );
                    System.out.println("NAME = " + name);
                    System.out.println("PRICE = " + price);
                    System.out.println("STOCK = " + stock+"\n");
                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            // System.out.println("Operation done successfully");
        }
    }





    static class updategoods  {



        public void addproduct() {

        }


        public void removeproduct() {

        }
        public void updateproduct(){
            Connection c = null;
            Statement stmt = null;
            Scanner updatesc = new Scanner(System.in);
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);
                //System.out.println("Opened database successfully");

                stmt = c.createStatement();
                System.out.println(" Enter the price you want to change ");
                int price  =updatesc.nextInt();
                System.out.println(" Enter the ID you want to change to price in  ");
                int id =updatesc.nextInt();

                String sql = "UPDATE prod set price = " + price + " where "+id+";";
                stmt.executeUpdate(sql);
                c.commit();

                ResultSet rs = stmt.executeQuery( "SELECT * FROM prod;" );

                while ( rs.next() ) {
                    id = rs.getInt("id");
                    String name = rs.getString("name");
                    price = rs.getInt("price");
                    double stock = rs.getFloat("stock");

                    System.out.println( "ID = " + id  );
                    System.out.println("NAME = " + name);
                    System.out.println("PRICE = " + price);
                    System.out.println("STOCK = " + stock+"\n");
                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            // System.out.println("Operation done successfully");
        }

    }



}



class customer {


    void addcustomer() {
        Scanner sc = new Scanner(System.in);
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Opened database successfully");
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            //System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS custom" +
                    " (ID          KEY     NOT NULL," +
                    "NAME           TEXT    NOT NULL, " +
                    " PRODBUY         TEXT)";

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Table created successfully");
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = c.createStatement();

            int i = 1;
            System.out.println("Enter the number of CUSTOMERS you want to enter ");
            try {

                int a = sc.nextInt();
                while (i <= a) {
                    System.out.println("Enter the ID of customer" + i);
                    int id = sc.nextInt();
                    System.out.println("Enter the name of customer" + i);
                    String name = sc.next();
                    System.out.println("Enter the products  of customer" + i);
                    String prodbuy = sc.next();


                    String sql = "INSERT INTO custom (ID,NAME,PRODBUY) " +
                            "VALUES ( " + id + ",'" + name + "' , '" + prodbuy + "');";
                    stmt.executeUpdate(sql);
                    System.out.println("customer succesfully added" + i);

                    i = i + 1;


                }



            } catch (InputMismatchException e) {
                System.out.println("Invalid input please try again ");
            }


            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        // System.out.println("Records created successfully");
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            // System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM custom;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String prodbuy = rs.getString("prodbuy");


                System.out.println("ID = " + id);
                System.out.println("NAME = " + name );
                System.out.println("PRODUCTS BOUGHT = " +prodbuy+"\n" );

            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Operation done successfully");
    }

    void removecustomer() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            Scanner sc=new Scanner(System.in);
            // System.out.println("Opened database successfully");

            stmt = c.createStatement();
            System.out.println("Enter the ID of the customer you want to remove ");
            int id = sc.nextInt();
            String sql = "DELETE from custom where ID=" + id + ";";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery("SELECT * FROM custom;");

            while (rs.next()) {
                id = rs.getInt("id");
                String name = rs.getString("name");
                String prodbuy = rs.getString("prodbuy");


                System.out.println( "ID = " + id  );
                System.out.println("NAME = " + name);
                System.out.println("PRODUCTS BOUGHT = " +prodbuy );

                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        // System.out.println("Operation done successfully");
    }



    void updatecustomer() {
        Connection c = null;
        Statement stmt = null;
        Scanner updatesc = new Scanner(System.in);
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            //System.out.println("Opened database successfully");

            stmt = c.createStatement();
            System.out.println(" Enter the name you want to change ");
            String name  =updatesc.next();
            System.out.println(" Enter the ID you want to change name in");
            int id =updatesc.nextInt();

            String sql = "UPDATE custom set name = '" +name + "' where "+id+";";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery( "SELECT * FROM custom;" );

            while ( rs.next() ) {
                id = rs.getInt("id");
                name = rs.getString("name");
                String prodbuy = rs.getString("prodbuy");

                System.out.println( "ID = " + id  );
                System.out.println("NAME = " + name);
                System.out.println("PRODUCTS BOUGHT = " + prodbuy);

                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        // System.out.println("Operation done successfully");
    }

}



class Hr {
    void Hr_people() {
        String names[] = {"abbas", "fatima ", "habib"};

        for (int i = 0; i < names.length; i++) {


        }
        System.out.println(Arrays.toString(names));


    }


}
class staff_department {
    static void stafmembers() {
        String securtity_members_names[] = {"mahad", "hamza  ", "afzal",};

        for (int i = 0; i < securtity_members_names.length; i++) {


        }
        System.out.println("security members");
        System.out.println(Arrays.toString(securtity_members_names));

    }

    void stafsalary() {
        //   void password() {

        String sec_salary[] = {"mahad:15000", "hamza:8000  ", "afzal:4500"};
        //  String sec_salary="hj";

        for (int i = 0; i < sec_salary.length; i++) {


        }
        System.out.println(Arrays.toString(sec_salary));


    }
}
class employeeofdepartment1 extends staff_department{
    void employees(){
        System.out.println("employee in first fepartment");
        String staff_members_names[] = {"Murtaza", "hurram  ", "khalid","Ahsan","Umair","Yasir"};

        for (int i = 0; i < staff_members_names.length; i++) {


        }
        System.out.println("staff members");
        System.out.println(Arrays.toString(staff_members_names));

    }
    @Override
    void stafsalary() {
        //   void password() {

        String sec_salary[] = {"Murtaza:50000", "hurram:90000 ", "khalid:45000","Ahsan:30000","Umair:67000","Yasir:56000"};
        //  String sec_salary="hj";

        for (int i = 0; i < sec_salary.length; i++) {


        }
        System.out.println(Arrays.toString(sec_salary));


    }


};
class employeeofdepartment2 extends staff_department{
    void employees(){
        System.out.println("employee in first fepartment");
        String staff_members_names[] = {"Mohammad Ali", "huzaifa  ", "khalil","sam","Ummer","Usama"};

        for (int i = 0; i < staff_members_names.length; i++) {


        }
        System.out.println("staff members");
        System.out.println(Arrays.toString(staff_members_names));

    }
    @Override
    void stafsalary() {
        //   void password() {

        String sec_salary[] = {"Mohammad Ali:67000", "huzaifa:65000  ", "khalil:34000","sam:56000","Ummer:34000","Usama:25000"};
        //  String sec_salary="hj";

        for (int i = 0; i < sec_salary.length; i++) {


        }
        System.out.println(Arrays.toString(sec_salary));


    }


};