package org.example;

import java.sql.*;
class OracleCon{
    public static void main(String args[]){
        try{
//step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","c##dimitris","123456");

//step3 create the statement object
            Statement stmt=con.createStatement();

//step4 execute query
            ResultSet rs=stmt.executeQuery("select * from PERSON");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            System.out.println("The number of columns is "+ columnsNumber);
            System.out.println("The first column name is "+ rsmd.getColumnName(1));
            System.out.println("The second column name is "+ rsmd.getColumnName(2));

            while(rs.next()) {

                System.out.println(rs.getString("id") + "  " + rs.getString("name"));
            }
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
//step5 close the connection object

}