package com.company.employeeattendance.repositories.employee;

import com.company.employeeattendance.entities.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT e FROM Employee e WHERE e.active = :active ")
    List<Employee> findAllActiveIs(@Param("active") boolean active);

    @Query(value = " select e.* from employee e \n" +
            " inner join `employee_designation` ed on ed.employee_id = e.id \n " +
            " inner join `designation` d on ed.`designation_id` = d.id \n " +
            " inner join department dep on d.`dept_id` = dep.id \n " +
            " where d.id = ?1 and ( ?2 between ed.`start_date` and ed.`end_date` \n" +
            " OR \n" +
            " ed.`start_date` <= ?2 ) ", nativeQuery = true)
    List<Employee> findAllByDepartmentId(Integer deptId, Date date);
}
