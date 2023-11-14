package Mypakage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;


public class bank extends Main {
    public void CreateAccount() throws SQLException{
        Scanner sc =new Scanner(System.in);
        Connection con =DB.connect();
        System.out.println("Enter Details Carefully");
        System.out.println("Enter Your Full Name:");
        String name =sc.nextLine();
        System.out.println("Enter Your Contact No:");
        int contact =sc.nextInt();
        System.out.println("Enter Your Address:");
        String address =sc.nextLine();
        System.out.println("Enter Amount For First Time Deposite In Your Account:");
        int amount =sc.nextInt();

        String q ="select AccNo from bank_user_details order by AccNo desc limit 1";
        Statement st =con.createStatement();
        ResultSet rs = st.executeQuery(q);
        int acc=0;
        while(rs.next()){
            acc =rs.getInt(1);
        }
        String query ="INSERT INTO bank_user_details VALUES (?,?,?,?,?)";
        PreparedStatement pst =con.prepareStatement(query);
        pst.setInt(1, acc+1);
        pst.setString(2, name);
        pst.setInt(3, contact);
        pst.setString(4, address);
        pst.setInt(5, amount);
        pst.executeUpdate();
        st.close();
        pst.close();
        acc++;
        System.out.println("------------------------------");
        System.out.println("Account open successfully");
        System.out.println("Your Account No is: "+acc);
        System.out.println("------------------------------");        
    }

    public void ReadDetails() throws SQLException{
        Connection con =DB.connect();
        System.out.println("Enter you Account No:");
        int acc =sc.nextInt();

        String query ="select * from bank_user_details where accno=?";
        PreparedStatement pst =con.prepareStatement(query);
        pst.setInt(1, acc);
        ResultSet rs =pst.executeQuery();
        while(rs.next()){
        System.out.println("--------------------------------------------");
        System.out.println("Account No is: "+rs.getInt(1));
        System.out.println("--------------------------------------------");
        System.out.println("Name is: "+rs.getString(2));
        System.out.println("--------------------------------------------");
        System.out.println("Contact No is: "+rs.getLong(3));
        System.out.println("--------------------------------------------");
        System.out.println("Address is: "+rs.getString(4));
        System.out.println("--------------------------------------------");
        System.out.println("Amount is: "+rs.getInt(5));
        System.out.println("--------------------------------------------");
        System.out.println("Account Read Successfully");
        System.out.println("--------------------------------------------");

        }
    }

    public void UpdateDetails() throws SQLException{
        Connection con =DB.connect();
        System.out.println("Menu for Updation:");
        System.out.println("1.Update Name");
        System.out.println("2.Contack NO");
        System.out.println("3.Address");
        System.out.println("Enter Your Choice:");
        int choice  =sc.nextInt();
        

        if(choice == 1){
            Scanner sc =new Scanner(System.in);
        System.out.println("Enter Your Account No:");
        int acc =sc.nextInt();
            System.out.println("Enter Your name for Updation:");
           String newname =sc.nextLine();
           String query ="UPDATE bank_user_details set fullname=? where accno=?";
           PreparedStatement pst =con.prepareStatement(query);
           pst.setString(1, newname);
           pst.setInt(2, acc);
           pst.executeUpdate();
           pst.close();
        }
        else if(choice == 2){
            Scanner sc =new Scanner(System.in);
           System.out.println("Enter Your Account No:");
           int acc =sc.nextInt();
           System.out.println("Enter your contact no for Updation:");
           int contact =sc.nextInt();
           String query ="UPDATE bank_user_details set ContactNo=? where accno=?";
           PreparedStatement pst =con.prepareStatement(query);
           pst.setInt(1, contact);
           pst.setInt(2, acc);
           pst.executeUpdate();
           pst.close();
        }
        else{
            Scanner sc1 =new Scanner(System.in);
            System.out.println("Enter Your Account No:");
            int acc =sc1.nextInt();
            System.out.println("Enter your address for Updation:");
           String add =sc1.nextLine();
           String query ="UPDATE bank_user_details set address=? where accno=?";
           PreparedStatement pst =con.prepareStatement(query);
           pst.setString(1, add);
           pst.setInt(2, acc);
           pst.executeUpdate();
           pst.close();
        }
        System.out.println("--------------------------------");
        System.out.println("Details Update successfully");
        System.out.println("--------------------------------");

    }

    public void CreatePin() throws SQLException{
        System.out.println("Enter Your Account No:");
        int acc =sc.nextInt();
        System.out.println("Enter 4 digit Pincode:");
        int pin =sc.nextInt();
        Connection con =DB.connect();
        String query ="insert into atm values (?,?)";
        PreparedStatement pst =con.prepareStatement(query);
        pst.setInt(1, acc);
        pst.setInt(2, pin);
        pst.executeUpdate();
        pst.close();
        System.out.println("Pin set Successfully");
    }

    public void Withdrawal() throws SQLException{
        System.out.println("Enter Your Account No:");
        int acc =sc.nextInt();
        System.out.println("Enter 4 digit Pincode:");
        int pin =sc.nextInt();
        
        Connection con =DB.connect();
        String q1="select cust_pincode from atm where cust_acc=?";
        PreparedStatement pst1 =con.prepareStatement(q1);
        pst1.setInt(1, acc);
        ResultSet rs1 =pst1.executeQuery();
        int orpin=0;
        while(rs1.next()){
            orpin =rs1.getInt(1);
        }
        if(orpin== pin){
          System.out.println("Enter amount for Withdrawal:"); 
          int amount =sc.nextInt();
          String query ="UPDATE bank_user_details set amount =amount-? where accno =?";
          PreparedStatement pst =con.prepareStatement(query);
          pst.setInt(1, amount);
          pst.setInt(2, acc);
          pst.executeUpdate();
          pst.close();
          System.out.println(amount +" Amount Withdrawal Successfully");
        }
        else{
            System.out.println("Enter Valid Pincode:)");
        }
    }

    public void Deposite() throws SQLException{
       System.out.println("Enter Your Account No:");
        int acc =sc.nextInt();
        System.out.println("Enter 4 digit Pincode:");
        int pin =sc.nextInt();
        
        Connection con =DB.connect();
        String q1="select cust_pincode from atm where cust_acc=?";
        PreparedStatement pst1 =con.prepareStatement(q1);
        pst1.setInt(1, acc);
        ResultSet rs1 =pst1.executeQuery();
            int orpin=0;
        while(rs1.next()){
            orpin =rs1.getInt(1);
        }
        if(orpin== pin){
          System.out.println("Enter amount for deposite:"); 
          int amount =sc.nextInt();
          String query ="UPDATE bank_user_details set amount =amount+? where accno =?";
          PreparedStatement pst =con.prepareStatement(query);
          pst.setInt(1, amount);
          pst.setInt(2, acc);
          pst.executeUpdate();
          pst.close();
          System.out.println(amount +" Amount Deposite Successfully");
        }
        else{
            System.out.println("Enter Valid Pincode:)");
        }
    }
    
    public void Transfer() throws SQLException{
        System.out.println("Enter Your Account No:");
        int acc1 =sc.nextInt();
        System.out.println("Enter 4 digit Pincode:");
        int pin =sc.nextInt();

        System.out.println("Enter Amount For Transfer Money:");
        int amount =sc.nextInt();

        System.out.println("Enter the Account No To Which You Want To Transfer Money:");
        int acc2 =sc.nextInt();
        
        Connection con =DB.connect();

        String q="select cust_pincode from atm where cust_acc=?";
        PreparedStatement pst1 =con.prepareStatement(q);
        pst1.setInt(1, acc1);
        ResultSet rs1 =pst1.executeQuery();
        int orpin =0;
        while(rs1.next()){
            orpin =rs1.getInt(1);
        }

        if(orpin== pin){
        String q1 ="UPDATE bank_user_details set amount =amount-? where accno=?";
        String q2 ="UPDATE bank_user_details set amount =amount+? where accno=?";

        PreparedStatement pst =con.prepareStatement(q1);
        pst.setInt(1, amount);
        pst.setInt(2, acc1);
        pst.executeUpdate();
        pst =con.prepareStatement(q2);
        pst.setInt(1, amount);
        pst.setInt(2, acc2);
        pst.close();
        System.out.println("-----------------------------------");
        System.out.println("Amount Transfer Successfully:)");
        System.out.println("-----------------------------------");
    }
    else{
        System.out.println("Enter Valid Pincode Choice:)");
    }
}
}
