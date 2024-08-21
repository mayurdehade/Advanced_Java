//Singleton: Ensures that a class has only one instance and provides a global point of access to it.
//Singleton: means single bean definition to a single object instance per Spring IOC container.

//Prototype: The Prototype Design Pattern is used to create objects based on a template of an existing object through cloning.
//Prototype: means a single bean definition to any number of object instances.
package com.controller;

import com.entity.Student;

public class Controller {

	public static void main(String[] args) {
		
		
		Student student1 = Student.getInstance();
		
		Student student2 = Student.getInstance();
		
		System.out.println(student1);
		System.out.println(student2);
	}

}

//output:
//com.entity.Student@b1bc7ed
//com.entity.Student@b1bc7ed
