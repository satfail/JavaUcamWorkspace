package interfaces.ComparableAndComparator;

public class Programa {

	   

    public static void main(String arg[]) {      

        Persona p1 = new Persona(74999999,35);

        Persona p2 = new Persona(72759474,30);   
        
        Persona p3 = new Persona(3131233, 50);
        
        Persona p4 = new Persona(3131233, 40);

     if (p1.compareTo(p2) < 0 ) { System.out.println("La persona p1: es menor."); }

    else if (p1.compareTo(p2) > 0 ) {System.out.println("La persona p1: es mayor."); }

     else { System.out.println ("La persona p1 es igual a la persona p2"); }
     

     if (p3.compare(p3, p4) < 0 ) { System.out.println("La persona p3: es menor."); }

    else if (p3.compare(p3, p4) > 0 ) {System.out.println("La persona p3: es mayor."); }

     else { System.out.println ("La persona p3 es igual a la persona p4"); }

      } 
    
    
    
    
    
    

}