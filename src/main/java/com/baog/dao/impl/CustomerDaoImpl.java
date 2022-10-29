package com.baog.dao.impl;

import com.baog.dao.CustomerDao;
import com.baog.dto.CustomerDto;
import com.baog.model.Customer;
import com.baog.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {


    final String customerInsertSql = "insert into customers (first_name, last_name, email) " + "values (?,?,?)";


    @Override
    public Customer saveCustomer(String firstName, String lastName, String email) {

        Customer savedCustomer = null ;


        try( Connection connection = DatabaseConnection.INSTANCE.getDatasource().getConnection()){

            PreparedStatement statement = connection.prepareStatement(customerInsertSql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);

            int result = statement.executeUpdate();

            final ResultSet keysResultSet = statement.getGeneratedKeys();
            keysResultSet.next();
            final long autogenerateId = keysResultSet.getLong(1);

          savedCustomer =  result == 1? new Customer(autogenerateId, firstName, lastName, email ) : null;

            System.out.println("Result: "+result);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return savedCustomer;
    }

    @Override
    public void saveCustomer1(String firstName, String lastName, String email) {
        final String customerInsertSql = "insert into customers (first_name, last_name, email) " + "values (?,?,?)";

        try( Connection connection = DatabaseConnection.INSTANCE.getDatasource().getConnection()){

            PreparedStatement statement = connection.prepareStatement(customerInsertSql);

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);

            int result = statement.executeUpdate();

            System.out.println("Result: "+result);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Customer saveCustomer(CustomerDto customerDto) {



        Customer savedCustomer = null ;



        try( Connection connection = DatabaseConnection.INSTANCE.getDatasource().getConnection()){

            PreparedStatement statement = connection.prepareStatement(customerInsertSql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, customerDto.getFirstName());
            statement.setString(2, customerDto.getLastName());
            statement.setString(3, customerDto.getEmail());

            int result = statement.executeUpdate();

            final ResultSet keysResultSet = statement.getGeneratedKeys();
            keysResultSet.next();
            final long autogenerateId = keysResultSet.getLong(1);

            savedCustomer =  result == 1? new Customer(autogenerateId, customerDto.getFirstName(), customerDto.getLastName(), customerDto.getEmail() ) : null;

            System.out.println("Result: "+result);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return savedCustomer;
    }

    @Override
    public Optional<Customer> getCustomerById(long customerId) {
        return Optional.empty();
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> returnData = new ArrayList<>();

        try(Connection connection = DatabaseConnection.INSTANCE.getDatasource().getConnection()){

            PreparedStatement statement = connection.prepareStatement("select * from customers");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                long id = resultSet.getLong("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                returnData.add(new Customer(id,firstName,lastName,email));

            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return returnData;
    }
}
