package BackEnd;
import java.util.Collection;

public class TestDeptDAO {
	
	public static void main(String[] args) {
		
		DeptDAO dept = new DeptDAO(); // No parece que estemos accediendo a base datos, 
									  //se puede intuir por la objeto de la clase DepTDAO creada
		
		Collection<DeptDTO> coll = dept.buscarTodos();
		
		for(DeptDTO obj : coll) { //imprime cada objeto
			System.out.println(obj);	
		}	
	}
}
