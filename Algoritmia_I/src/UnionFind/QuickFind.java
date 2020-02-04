package UnionFind;

import java.util.Scanner;

public class QuickFind {
	Scanner entrada = new Scanner(System.in);
	int [] id;
	
	public QuickFind (int n) {
		id = new int[n];
		for(int i = 0  ; i < n; i++) {
			id[i] = i;
		}//Init
		
	}
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public void union (int p, int q) {
		int idp =id[p];
		int idq = id[q];
		/// Le pone p a la id de q, voy cambiando p en funcion del valor de q
		for(int i =0; i < id.length; i++) {
			if(id[i]== idp) id[i] = idq; 
		}
		
	}
	
	public void list1() {
		for (int i = 0; i< id.length; i++) {
			System.out.println(id[i]);
		}
	}
	
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		qf.union(1, 3);
		qf.union(3, 7);
		qf.list1();
		System.out.println(qf.connected(1, 7));
		
	}

}
