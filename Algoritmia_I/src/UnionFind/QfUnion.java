package UnionFind;

public class QfUnion {
	
	 private int[] id;
	 private int [] sz;
	 public QfUnion(int N)
	 {
		 id = new int[N];
		 sz = new int[N];
		 for (int i = 0; i < N; i++) {
			 id[i] = i;
			 sz[i] = 1; 
		 }
	 }
	 private int root(int i)
	 {
		 while (i != id[i]) i = id[i]; //Pasa un valor mira en esa poscicion y toma el valor hasta que llegue a igual (raiz)
		 return i;
	 }
	 public boolean connected(int p, int q)
	 {
		 return root(p) == root(q);
		 
	 }
	 public void union(int p, int q)
	 {
		 int i = root(p);
		 int j = root(q);
		 if ( i == j) return;
		 if(sz[i] < sz[j]) { ///Si el arbol es mas pequenyo voy al grande id a valor dej
			 id[i] = j; 
			 sz[j] += sz[i];
		 }else {
			 id[j] = i; sz[i] += sz[j];  //Si es mas grande voy al pequenyo
			 
		 }
	 }
	 
		public void list1() {
			for (int i = 0; i< id.length; i++) {
				System.out.println(i + " -- " +id[i]);
			}
		}

		public static void main(String[] args) {
			QfUnion qU = new QfUnion(10);
			qU.union(0, 3);
			qU.union(3,5);
			qU.union(3, 7);
			qU.union(1,2 );
			qU.union (1,3);
			System.out.println(qU.connected(1, 7));
			qU.list1();
			
		}
}
