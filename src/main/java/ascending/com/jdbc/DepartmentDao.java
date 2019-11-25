package ascending.com.jdbc;

import ascending.com.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //step 1: Database Information
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER = "admin";
    private static final String PASS = "Training123!";

    public Department save() {
        public
    }
    public List<Department> getDepartments() {
        logger.info("Enter the method getDepartments...");
        List<Department> departments = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //Step 2: Open a Connection
            logger.info("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Step 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM department";
            rs = stmt.executeQuery(sql);

            //Step 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String location = rs.getString("location");

                //fill the object
                Department department = new Department();
                department.setId(id);
                department.setName(name);
                department.setDescription(description);
                department.setLocation(location);
                departments.add(department);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();

        } finally {
            //Step 6: finally block used to close resources
            try {
                if (rs != null)rs.close();
                if (stmt != null)stmt.close();
                if (conn != null)conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

            logger.info("Exit the method getDepartments");
            return departments;
        }
    }

}


