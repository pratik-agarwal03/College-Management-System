package university.management.system;

import java.sql.*;  

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","Aps@0312");    
            s =c.createStatement();             
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
