package operations;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import dao.HibernateConfig;
import entity.Employee;

public class Operations {
	static Scanner sc = new Scanner(System.in);

	// display all record
	public static void displayAllEmp() {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Employee.class);

		List<Employee> list = criteria.list();

		for (Employee emp : list) {
			System.out.println(emp);
		}
		
	}

	// add record
	public static void addEmp() {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session sesn = sf.openSession();

		// user input
		System.out.println("Enter the employee id: ");
		int id = sc.nextInt();
		System.out.println("Enter the employee name: ");
		String name = sc.next();
		System.out.println("Enter the employee salary: ");
		float salary = sc.nextFloat();
		System.out.println("Enter the department: ");
		String department = sc.next();

		// creating object
		Employee e1 = new Employee(id, name, salary, department);

		// save data to table
		sesn.save(e1);

		sesn.beginTransaction().commit();
		System.out.println("Record inserted successfully!");
	}

	// update record
	public static void updateEmp() {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session sesn = sf.openSession();

		System.out.println("Enter the id of the record you want to update");
		int id = sc.nextInt();

		Employee employee = sesn.get(Employee.class, id);

		System.out.println("What value you want to update: ");
		boolean ch = true;
		while (ch) {
			System.out.println(
					"1. Update employee name \n2. Update employee salary \n3. Update employee department \n4. Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter employee name: ");
				String name = sc.next();
				employee.setEmpname(name);
				break;
			case 2:
				System.out.println("Enter employee salary: ");
				float salary = sc.nextFloat();
				employee.setEmpsalary(salary);
				break;
			case 3:
				System.out.println("Enter employee department: ");
				String department = sc.next();
				employee.setDepartment(department);
				break;
			case 4:
				ch = false;
				break;
			default:
				System.out.println("Wrong Choice! Try Again");
			}
		}

		sesn.update(employee);
		sesn.beginTransaction().commit();
		System.out.println("Record is updated!");

	}

	// delete record
	public static void deleteEmpRecord() {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session sesn = sf.openSession();
		System.out.println("Enter the employee id to delete: ");
		int id = sc.nextInt();
		Employee employee = sesn.get(Employee.class, id);
		sesn.delete(employee);
		sesn.beginTransaction().commit();
		System.out.println("Record deleted successfully!");
	}

	// display single record
	public static void displayEmp() {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session sesn = sf.openSession();
		System.out.println("Enter emp id: ");
		int id = sc.nextInt();
		Employee employee = sesn.get(Employee.class, id);

		System.out.println(employee);
	}

	// Display Employees by Ids
	public static void displayEmpsByIds() {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session sesn = sf.openSession();
		System.out.println("Enter two id: ");
		int id1 = sc.nextInt();
		int id2 = sc.nextInt();
		List<Employee> employees = sesn.byMultipleIds(Employee.class).multiLoad(id1, id2);

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	// Display Limited Employees
	public static void displayLimitedEmp() {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Employee.class);
		criteria.setMaxResults(5);
		
		List<Employee> employees = criteria.list();
		
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	//display total number of employee
	public static void totalEmp() {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Employee.class);
		
		criteria.setProjection(Projections.rowCount());
		
		List<Long> total = criteria.list();
		
		System.out.println("Total Employees: "+total.get(0));
		
	}

}
