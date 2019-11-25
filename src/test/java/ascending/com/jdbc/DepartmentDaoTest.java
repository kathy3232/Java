package ascending.com.jdbc;

import ascending.com.model.Department;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DepartmentDaoTest {
    private DepartmentDao departmentDao; // provide CRUD
    private Department d;

    @Before
    public void init() {
        departmentDao = new DepartmentDao();
        d = new Department();
        d.setDescription("xxxx");
        departmentDao.save(d);
    }

    @After
    public void tearDown(){
        departmentDao.delete(d.getId());
    }

    @Test
    public void getDepartmentTest() {
        List<Department> departments = departmentDao.getDepartments();
        int expectedNumOfDept = 4;

        for (Department department : departments) {
            System.out.println(department);
        }
        Assert.assertEquals(expectedNumOfDept, departments.size());
    }

}
