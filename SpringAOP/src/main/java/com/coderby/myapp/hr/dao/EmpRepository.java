package com.coderby.myapp.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coderby.myapp.hr.model.Employee;

@Repository
public class EmpRepository implements IEmpRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public int getEmpCount() {
		// TODO Auto-generated method stub
		String sql ="select count(*) from employees";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getEmpCount(int deptid) {
		// TODO Auto-generated method stub
		String sql ="select count(*) from employees where department_id=?";
		Object[] args ={deptid};
		return jdbcTemplate.queryForObject(sql, args,Integer.class);
		
	
	}

	@Override
	public int getEmpCountBySalary(int salary) {
		// TODO Auto-generated method stub
		String sql ="select count(*) from employees where salary>=?";
		Object[] args ={salary};
		return jdbcTemplate.queryForObject(sql, args,Integer.class);
	}

	@Override
	public List<Employee> getEmplist() {
		// TODO Auto-generated method stub
		String sql ="select * from employees";
		return jdbcTemplate.query(sql, new RowMapper<Employee>(){
		
			@Override
			public Employee mapRow(ResultSet rs, int count) throws SQLException {
				Employee emp= new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				return emp;
			}
		});
	}

	@Override
	public Employee getEmpInfoByEmpId(int empid) {
		String sql="select last_name,salary from employees where employee_id=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int count) throws SQLException {
				// TODO Auto-generated method stub
				Employee emp= new Employee();
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getDouble("salary"));
				return emp;
			}
			
		},empid);
	}

	@Override
	public void setSalaryByEmpId(int empid) {
		String sql="update employees set salary=salary*1.1 where employee_id=?";
		jdbcTemplate.update(sql,empid);
		
	}

	@Override
	public void insertEmp(Employee emp) {
		String sql="insert into emp1 (employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id)values(?,?,?,?,?,sysdate,?,?,?,?,?)";
		jdbcTemplate.update(sql,emp.getEmployeeId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getPhoneNumber(),emp.getJobId(),emp.getSalary(),emp.getCommissionPct(),emp.getManagerId(),emp.getDepartmentId());
		
	}

	@Override
	public void deleteEmp(int empid) {
		// TODO Auto-generated method stub
		String sql="delete from employees where employee_id=?";
		jdbcTemplate.update(sql,empid);
	}
	class EmpMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int count) throws SQLException {
			Employee emp= new Employee();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setEmail(rs.getString("email"));
			emp.setJobId(rs.getString("job_id"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			return emp;
			
			
		}
	
}
}