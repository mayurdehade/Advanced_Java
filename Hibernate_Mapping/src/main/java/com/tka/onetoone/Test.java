package com.tka.onetoone;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	static Scanner sc = new Scanner(System.in);

	//display player using id
	public static void displayPlayer() {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		Session sesn = sf.openSession();

		System.out.println("Enter player id: ");
		int id = sc.nextInt();
		Player player = sesn.get(Player.class, id);

		System.out.println(player);

	}

	//add new player
	public static void addPlayer() {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		Session sesn = sf.openSession();

		System.out.println("Enter the player address: \nEnter address id: ");
		int id = sc.nextInt();		
		System.out.println("Enter City: ");
		String city = sc.next();
		System.out.println("Enter pincode: ");
		int pincode = sc.nextInt();
		
		Address address = new Address(id, city, pincode);

		System.out.println("Enter the player information: \nEnter player id: ");
		int pid = sc.nextInt();
		System.out.println("Enter player name: ");
		String name = sc.next();
		System.out.println("Enter jersey number: ");
		int jersey = sc.nextInt();
		System.out.println("Enter total runs: ");
		int run = sc.nextInt();
		Player player = new Player(pid, name, jersey, run, address);

		sesn.save(player);

		sesn.beginTransaction().commit();
		System.out.println("done");
	}
	
	//display all players
	public static void displayAll() {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		Session sesn = sf.openSession();
		Criteria criteria = sesn.createCriteria(Player.class);
		List<Player> Players = criteria.list();
		
		for (Player player : Players) {
			System.out.println(player);
		}
	}
	
	//delete player 
	public static void deletePlayer() {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		Session sesn = sf.openSession();
		System.out.println("Enter id of player want to delete: ");
		int id = sc.nextInt();
		Player p = sesn.get(Player.class, id);
		sesn.delete(p);
		sesn.beginTransaction().commit();
	}
	
	//update player
	public static void updatePlayer() {
		SessionFactory sf = HibernateConfigure.getSessionFactory();
		Session sesn = sf.openSession();
		System.out.println("Enter the player id you want to update: ");
		int id = sc.nextInt();
		Player p = sesn.get(Player.class, id);
		
		boolean flag = true;
		while(flag) {
			System.out.println("1. Update name \n2. Update jersey number \n3. Update total runs \n4. Update city \n5. Update pincode \n6. Exit");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter player name: ");
				String name = sc.next();
				p.setPlayername(name);
				break;
			case 2:
				System.out.println("Enter player jersey number: ");
				int jersey = sc.nextInt();
				p.setPlayerjersey(jersey);
				break;
			case 3:
				System.out.println("Enter total runs: ");
				int runs = sc.nextInt();
				p.setRuns(runs);
				break;
			case 4:
				System.out.println("Enter player city:");
				String city = sc.next();
				Address a = p.getAddress();
				a.setCity(city);
				p.setAddress(a);
				break;
			case 5:
				System.out.println("Enter player city pin code:");
				int pin = sc.nextInt();
				Address a1 = p.getAddress();
				a1.setPincode(pin);;
				p.setAddress(a1);
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("You entered wrong choice!");
			}
			
		}
		sesn.update(p);
		sesn.beginTransaction().commit();
	}
	

	public static void main(String[] args) {
		boolean flag = true;
		while(flag) {
			System.out.println("\n1. Insert player \n2. Update player \n3. Display player By ID \n4. Display all players \n5. Delete player \n6. Exit");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: 
				Test.addPlayer();
				break;
			case 2:
				Test.updatePlayer();
				break;
			case 3: 
				Test.displayPlayer();
				break;
			case 4:
				Test.displayAll();
				break;
			case 5:
				Test.deletePlayer();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("You entered wrong choice!");
			}
		}
	}

}
