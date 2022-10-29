package com.baog;

import com.baog.dao.CustomerDao;
import com.baog.dao.impl.CustomerDaoImpl;
import com.baog.dto.CustomerDto;
import com.baog.model.Customer;
import com.baog.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class App {

    private static CustomerDao customerDao = new CustomerDaoImpl();

    public static void main(String[] args) {


//        System.out.println("DB Connection valid: "+ DatabaseConnection.INSTANCE.isConnectionValid());
//
//        String firstName = "Paul";
//        String lastName = "Peter";
//        String email = "paulp@gmail.com";
//
//     final String customerInsertSql = "insert into customers (first_name, last_name, email) " + "values (?,?,?)";
//
//       try( Connection connection = DatabaseConnection.INSTANCE.getDatasource().getConnection()){
//
//           PreparedStatement statement = connection.prepareStatement(customerInsertSql);
//
//           statement.setString(1, firstName);
//           statement.setString(2, lastName);
//           statement.setString(3, email);
//
//           int result = statement.executeUpdate();
//
//           System.out.println("Result: "+result);
//
//       }catch (Exception e){
//           System.out.println(e.getMessage());
//       }


//        Customer customer = customerDao.saveCustomer("Shola", "Olushayo", "so@gmail.com");
//
//        System.out.println(customer);

//        CustomerDto customerDto = new CustomerDto("Chinedu", "Ukwuma", "cu@gmail.com");
//
//        Customer customer1 = customerDao.saveCustomer(customerDto);
//
//        System.out.println(customer1);

        customerDao.getAllCustomers()
                .forEach(System.out::println);


    }


}
