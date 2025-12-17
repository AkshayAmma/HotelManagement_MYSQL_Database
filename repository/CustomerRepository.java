package HotelManagement.repository;

import HotelManagement.model.Customer;
import HotelManagement.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customer(CustomerName,Email,PhoneNumber,Address,IdProof) VALUES (?,?,?,?,?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhoneNumber());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getIdProof());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getInt("CustomerId"), resultSet.getString("CustomerName"), resultSet.getString("Email"), resultSet.getString("PhoneNumber"), resultSet.getString("Address"), resultSet.getString("IdProof")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customers;
    }

    public Customer getCustomerById(int custId) {
        String sql = "SELECT * FROM customer WHERE CustomerId=?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, custId);
            ResultSet set = preparedStatement.executeQuery();

            if (set.next()) {
                return new Customer(
                        set.getInt("CustomerId"),
                        set.getString("CustomerName"),
                        set.getString("Email"),
                        set.getString("PhoneNumber"),
                        set.getString("Address"),
                        set.getString("IdProof")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public void updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET CustomerName=?, Email=?, PhoneNumber=?, Address=?, IdProof=? WHERE CustomerId=?";

        try(Connection connection=DatabaseUtil.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql))
        {

            preparedStatement.setString(1,customer.getCustomerName());
            preparedStatement.setString(2,customer.getEmail());
            preparedStatement.setString(3,customer.getPhoneNumber());
            preparedStatement.setString(4,customer.getAddress());
            preparedStatement.setString(5,customer.getIdProof());
            preparedStatement.setInt(6,customer.getCustomerId());

            preparedStatement.executeUpdate();

        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
