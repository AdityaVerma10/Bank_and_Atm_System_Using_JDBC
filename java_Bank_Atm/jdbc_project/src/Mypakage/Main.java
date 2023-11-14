package Mypakage;
import java.lang.String;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

   static Scanner sc =new Scanner(System.in);
   
    public static void Bank() throws SQLException {
        bank obj =new bank();
        int choice = 0;
        
        System.out.println("------------------------------------");
        System.out.println("Welcome to Our Bank Services");
        System.out.println("------------------------------------");
        while (choice != 4) {
            System.out.println("Bank Services Menu:");
            System.out.println("1.Open Account");
            System.out.println("2.Read Account Details");
            System.out.println("3.Update Account Details");
            System.out.println("4.Back To Main Menu");
            System.out.println("Enter Your Choice:");
            sc =new Scanner(System.in);
            choice = sc.nextInt();
            if (choice > 4 || choice < 1) {
                System.out.println("Pelease Enter Valid Choice:)");
            } else {
                switch (choice) {
                    case 1: {
                        System.out.print("\033[H\033[2J");  
                    System.out.flush();
                        obj.CreateAccount();
                        break;
                    }
                    case 2: {
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        obj.ReadDetails();
                        break;
                    }
                    case 3: {
                        System.out.print("\033[H\033[2J");  
                    System.out.flush();
                        obj.UpdateDetails();
                        break;
                    }
                }
            }
          
        }
        

    }

public static void Atm() throws SQLException {
                    bank obj = new bank();
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
        System.out.println("------------------------------------");
        System.out.println("Welcome to Our Atm");
        System.out.println("------------------------------------");
        int choice = 0;

        while (choice != 5) {
            System.out.println("Atm Services Menu:");
            System.out.println("1.Create Pin for Atm Card");
            System.out.println("2.Withdrawal Money");
            System.out.println("3.Deposite Money");
            System.out.println("4.Transfer Money");
            System.out.println("5.Back To Main Menu");
            System.out.println("Enter Your Choice:");
            choice = sc.nextInt();
            if (choice > 5 && choice < 1) {
                System.out.println("Enter Valid Choice:)");
            } else {
                switch (choice) {
                    case 1: {
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        obj.CreatePin();
                        break;
                    }
                    case 2: {
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        obj.Withdrawal();
                        break;
                    }
                    case 3: {
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        obj.Deposite();
                        break;
                    }
                    case 4: {
                        obj.Transfer();
                        break;
                    }

                }
            }

        }

    }

public static void main(String []args) throws SQLException  {

        Scanner sc = new Scanner(System.in);
        int choice = 0;
            System.out.print("\033[H\033[2J");  
            System.out.flush();
        System.out.println("------------------------------------");    
        System.out.println("Welcome to Our Bank and Atm");
        System.out.println("------------------------------------");
        while (choice != 3) {
            System.out.println("Main Menu:");   
            System.out.println("1.Bank Services");
            System.out.println("2.Atm Services");
            System.out.println("3.Exit");
            System.out.println("Enter Your Choice:");
            choice = sc.nextInt();

            if (choice > 3) {
                System.out.println("Pelease Enter Valid Choice :)");
            } else {
                switch (choice) {
                    case 1:
                        Bank();
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        break;

                    case 2:
                        Atm();
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        break;

                }
            }

        }
        System.out.println("Thank You For Visiting Our Bank and Atm :)");
        sc.close();

    }

}
