package ascending.com.jdbc;

import ascending.com.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //step 1: Database Information
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER = "admin";
    private static final String PASS = "Training123!";

    public List<Users> getUsers() {
        logger.info("Enter the method getUsers...");
        List<Users> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //Step 2: Open a Connection
            logger.info("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            //Step 3: Execute a query
            System.out.println("Creating statement...");
            statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            resultSet = statement.executeQuery(sql);

            //Step 4: Extract data from result set
            while (resultSet.next()) {
                //Retrieve by column name
                int id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Date registeredDate = resultSet.getDate("registered_date");
                Date birtyday = resultSet.getDate("registered_date");


                //fill the object
                Users user = new Users();
                user.setUserId(id);
                user.setUsername(username);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setAddress(address);
                user.setRegisteredDate(registeredDate);
                user.setBirthday(birtyday);
                users.add(user);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();

        } finally {
            //Step 6: finally block used to close resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

            logger.info("Exit the method getDepartments");
            return users;
        }
    }
}
