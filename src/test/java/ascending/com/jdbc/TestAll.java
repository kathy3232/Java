package ascending.com.jdbc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class TestAll {
    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            DepartmentDaoTest.class,
            EmployeeDaoTest.class
    })

}
