package com.bitguiders.ocejwcd6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * 4. [Tests for a minimal knowledge of OO] Create a class Employee, having attributes

        String name
        Date hireDate
        double salary

    The constructor should accept values for all three of these attributes and set them.
    Then create a Test class having a main method in which the following is done: 

    a. An array of Employee instances is created, with the following data:

        [“Bob”, “11/01/2000”, 45000.00]
        [“Dave”, “10/01/1990”, 65000.00]
        [“Hal”, “01/01/1995”, 55000.00]
        [“Susan”, “08/20/2004”, 45000.00]

    b. In a separate loop, the salaries of the employees in this array are summed, and the total is printed to the console.

 */
public class Employee {
    private String name;
    private Date hireDate;
    private double salary;
    
    //set attribute values
    public Employee(String name,Date hireDate,double salary){
    	this.name = name;
    	this.hireDate=hireDate;
    	this.salary = salary;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
    
    public static void main(String arg[]){
/*
        a. An array of Employee instances is created, with the following data:

            [“Bob”, “11/01/2000”, 45000.00]
            [“Dave”, “10/01/1990”, 65000.00]
            [“Hal”, “01/01/1995”, 55000.00]
            [“Susan”, “08/20/2004”, 45000.00]
*/
    	List<Employee> employees = new ArrayList<Employee>();
    	employees.add(new Employee("Bob", new Date("11/01/2000"), 45000.00));
    	employees.add(new Employee("Dave", new Date("10/01/1990"), 65000.00));
    	employees.add(new Employee("Hal", new Date("01/01/1995"), 55000.00));
    	employees.add(new Employee("Susan", new Date("08/20/2004"), 45000.00));
    	
    	//b. In a separate loop, the salaries of the employees in this array are summed, and the total is printed to the console.
    	double sum=0;
    	for(Employee employee:employees){
    		sum += employee.getSalary();
    	}
    	System.out.println("Sum of Salaries = "+sum);
    }

}
