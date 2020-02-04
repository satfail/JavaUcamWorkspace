package InterfazSerializable;
//Java code for serialization and deserialization 
//of a Java object 
import java.io.*; 

class Emp implements Serializable { 

	transient int a; 
	static int b; 
	String name; 
	int age; 

	// Default constructor 
public Emp(String name, int age, int a, int b) 
	{ 
		this.name = name; 
		this.age = age; 
		this.a = a; 
		this.b = b; 
	} 


public static void printdata(Emp object1) 
{ 

    System.out.println("name = " + object1.name); 
    System.out.println("age = " + object1.age); 
    System.out.println("a = " + object1.a); 
    System.out.println("b = " + object1.b); 
} 

} 



