package operation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import entity.Address;
import entity.Employee;
import hibernateconfig.HibernateConf;

public class Operations {

	Scanner sc = new Scanner(System.in);

	public void retrieveEmpById(int empId) {
		SessionFactory sf = HibernateConf.getSessionFactory();
		Session sesn = sf.openSession();
		Employee employee = sesn.get(Employee.class, empId);
		System.out.println(employee);
	}

	public void updateEmpInfo(int empId) {
		SessionFactory sf = HibernateConf.getSessionFactory();
		Session sesn = sf.openSession();
		Employee employee = sesn.get(Employee.class, empId);
		Address address = employee.getAddress();

		boolean flag = true;
		while (flag) {
			System.out.println("Menu: " + "\n1. Update first name " + "\n2. Update last name" + "\n3. Update salary "
					+ "\n4. Update email" + "\n5. Update phone number" + "\n6. Update street" + "\n7. Update city"
					+ "\n8. Update state" + "\n9. Update zip code" + "\n10. Update country" + "\n0. Done");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter first name: ");
				employee.setFirstName(sc.next());
				break;
			case 2:
				System.out.println("Enter last name: ");
				employee.setLastName(sc.next());
				break;
			case 3:
				System.out.println("Enter salary: ");
				employee.setSalary(sc.nextFloat());
				break;
			case 4:
				System.out.println("Enter email: ");
				employee.setEmail(sc.next());
				break;
			case 5:
				System.out.println("Enter phone number: ");
				employee.setPhoneNumber(sc.nextLong());
				break;
			case 6:
				System.out.println("Enter street: ");
				address.setStreet(sc.next());
				break;
			case 7:
				System.out.println("Enter city: ");
				address.setCity(sc.next());
				break;
			case 8:
				System.out.println("Enter state: ");
				address.setState(sc.next());
				break;
			case 9:
				System.out.println("Enter zip code: ");
				address.setZipCode(sc.nextInt());
				break;
			case 10:
				System.out.println("Enter country: ");
				address.setCountry(sc.next());
			case 0:
				flag = false;
				break;
			default:
				System.out.println("You entered wrong choice");
			}
		}
		employee.setAddress(address);
		sesn.update(employee);
		sesn.beginTransaction().commit();
		System.out.println("Employee updated...");
	}

	public void deleteEmpById(int empId) {
		SessionFactory sf = HibernateConf.getSessionFactory();
		Session sesn = sf.openSession();
		Employee employee = sesn.get(Employee.class, empId);
		sesn.delete(employee);

		sesn.beginTransaction().commit();
		System.out.println("Employee deleted...");
	}

	public void displayAllEmp() {
		SessionFactory sf = HibernateConf.getSessionFactory();
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Employee.class);

		List<Employee> list = criteria.list();

		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	public void displayEmpAboveGiveSalary(float salary) {
		SessionFactory sf = HibernateConf.getSessionFactory();
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary", salary));

		List<Employee> list = criteria.list();

		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	public void displayFirstAndLastName() {
		SessionFactory sf = HibernateConf.getSessionFactory();
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Employee.class);

		ProjectionList list = Projections.projectionList();
		list.add(Projections.property("firstName"));
		list.add(Projections.property("lastName"));

		criteria.setProjection(list);

		List<Object[]> employees = criteria.list();
		for (Object[] object : employees) {
			System.out.println(object[0] + " " + object[1]);
		}

	}

	public void searchEmpByLastName(String lastName) {
		SessionFactory sf = HibernateConf.getSessionFactory();
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Employee.class);

		criteria.add(Restrictions.eq("lastName", lastName));

		List<Employee> list = criteria.list();

		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	public void searchEmpByPartialLastName(String ln) {
		SessionFactory sf = HibernateConf.getSessionFactory();
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Employee.class);

		criteria.add(Restrictions.like("lastName", "%" + ln + "%"));
		List<Employee> list = criteria.list();

		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	public void batchInsertEmp(int n) {
		SessionFactory sf = HibernateConf.getSessionFactory();
		Session sesn = sf.openSession();

		Transaction tx = null;
		
		for(int i=0; i<n; i++) {
			tx = sesn.beginTransaction();
			Employee e = new Employee();
			Address a = new Address();
			System.out.println("Enter first name: ");
			e.setFirstName(sc.next());
			System.out.println("Enter last name: ");
			e.setLastName(sc.next());
			System.out.println("Enter salary: ");
			e.setSalary(sc.nextFloat());
			System.out.println("Enter email: ");
			e.setEmail(sc.next());
			System.out.println("Enter mobile: ");
			e.setPhoneNumber(sc.nextLong());
			System.out.println("Enter street: ");
			a.setStreet(sc.next());
			System.out.println("Enter city: ");
			a.setCity(sc.next());
			System.out.println("Enter state: ");
			a.setState(sc.next());
			System.out.println("Enter zip code: ");
			a.setZipCode(sc.nextInt());
			System.out.println("Enter country: ");
			a.setCountry(sc.next());
			e.setAddress(a);
			sesn.save(e);
			
		}
		
		tx.commit();
		
	}
}
