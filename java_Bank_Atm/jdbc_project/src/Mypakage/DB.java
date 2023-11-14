package Mypakage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB  {
            static Connection conn =null;
            public static Connection connect(){
            try {
            String url = "jdbc:mysql://127.0.0.1:3306/bank_And_Atm_Interface";

            String userName = "root";
            String password = "Verma456@";
    
            conn = DriverManager.getConnection(url,userName, password);
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
        }
    }

