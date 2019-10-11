
import java.io.PrintStream;

public class ST //pinakas symbolwn me tyxaiopoihmeno dentro apo8hkwn tou ekdotikou oikou
{
	
	private class TreeNode//eswterikh class, kombos tyxaiopoihmenou DDA pou paristanei mia apo8hkh bibliwn
	{
		
		int id;//id apo8hkhs
		String city;//polh sthn opoia brisketai h apo8hkh
		TreeNode l;//aristero ypodentro
		TreeNode r;//deksi ypodentro
		int N;//plh8os kombwn ypodentrou me riza ayton ton kombo
		List booklist;//taksinomhmenh lista monhs syndesh pou periexei ta biblia ths apo8hkhs
		
		TreeNode(int id, String city)
		{
			this.id=id;
			this.city=city;
			l=r=null;
			N=0;
			this.booklist=new List(this.id+" - "+this.city);
		}
				
	}
	
	
	private TreeNode head;//riza tou dentrou
	private int size;//plh8os kombwn tou DDA
	
	
	public ST()
	{
		this.head=null;
		this.size=0;
		
	}
	
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	
	public int size()
	{
		return size;
	}	
		
	
	private TreeNode insertR(TreeNode h, int nodeid, String name) //eisagwgh kombou sto DDA, me skopo th dhmiourgia tyxaiopoihmenou DDA (eksasfalizontas oti 8a einai isozygismeno me megalyterh pi8anothta)
	{
		if (h == null) 
		{
			++size;
			return new TreeNode(nodeid, name);		
		}
		if (Math.random()*(h.N+1) < 1.0)//me pi8anothta 1/N+1 eisagwgh sth riza 
			return insertT(h, nodeid, name);
		if (nodeid<h.id)
			h.l = insertR(h.l, nodeid, name);
		else if (nodeid>h.id)
			h.r = insertR(h.r, nodeid, name);	
		else
			throw new IllegalArgumentException();
		h.N++; 
		return h; 
	}
	
	
	private TreeNode insertT(TreeNode h, int nodeid, String name) //eisagwgh sth riza
	{
		if (h == null) 
		{
			++size;
			return new TreeNode(nodeid, name);		
		}
		if (nodeid<h.id) 
		{
			h.l = insertT(h.l, nodeid, name); 
			h = rotR(h); 
		} 
		else if(nodeid>h.id) 		
		{
			h.r = insertT(h.r, nodeid, name);
			h = rotL(h); 
		}
		else
			throw new IllegalArgumentException();
		h.N++;
		return h; 
	}
	
	
	private TreeNode rotR(TreeNode h)
	{
		TreeNode x = h.l; 
		h.l = x.r; 
		x.r = h; 
		return x; 
	}
	
	
	private TreeNode rotL(TreeNode h) 
	{
		TreeNode x = h.r; 
		h.r = x.l; 
		x.l = h; 
		return x; 
	}
	
	
	private TreeNode removeR(TreeNode h, int id) ////////////////////////////anadromikh afairesh kombou apo to tyxaiopoihmeno DDA -prospa8hsame na ylopoihsoume tis synarthseis tou bibliou -de leitourgei omws- den kseroume kai se poio shmeio na meiwsoume to N kai to size
	{
		if (h == null) 
			 return null;
		
		if (id<h.id) 
			h.l = removeR(h.l, id);
		if (id>h.id) 
			h.r = removeR(h.r, id);
		if (id==h.id) 
		{
			h = joinLR(h.l, h.r);
			//h.N--;
			
		}
		size--;
		return h; 
	}
	
	
	private TreeNode joinLR(TreeNode a, TreeNode b) 
	{
	
		if (a == null) 
			return b;
		if (b == null) 
			return a;
		int N = a.N + b.N;
		if (Math.random()*N < 1.0*a.N) 
		{
			a.r = joinLR(a.r, b);
			//b.N--;
			
			return a; 
		}
		else 
		{ 
			b.l = joinLR(a, b.l); 
			//a.N--;
			return b; 
		} 
	}
	
	
	private TreeNode findWarehouse(int nodeid)//anazhthsh apo8hkhs sto  DDA
	{
		TreeNode x=this.head;
		while(x!=null)
		{
			if(x.id>nodeid)
				x=x.l;
			else if (x.id<nodeid)
				x=x.r;
			else
				return x;
		}
		return x;
	}
	
//akolou8oun oi me8odoi tou pinaka symbolwn opws tis zhtaei h ekfwnhsh
	
	void insertWarehouse(int nodeid, String name)//eisagwgh apo8hkhs
	{
		head=insertR(head, nodeid, name);
	}
	
	
	void insertBookAtWarehouse(int nodeid, int isbn, int copies)//eisagwgh bibliou se apo8hkh
	{
		TreeNode x=findWarehouse(nodeid);//anazhthsh apo8hkhs
		if (x==null)
			System.out.println("There is no warehouse with id "+nodeid);
		else
		{
			x.booklist.insert(new BookInfo(isbn, copies));
		}
	}
	
	
	void removeWarehouse(int nodeid)//afairesh apo8hkhs
	{
		if (findWarehouse(nodeid)!=null)
			removeR(head, nodeid);
	}
	 
	
	void removeBook(int nodeid, int isbn)//afairesh antitypou bibliou apo apo8hkh
	{
		TreeNode x=findWarehouse(nodeid);//anazhthsh apo8hkhs
		if (x==null)
			System.out.println("There is no Warehouse with id: "+nodeid);
		else
			x.booklist.removeCopy(isbn);
	}
	
	
	void searchByWarehouse(int nodeid)//emfanish bibliwn apo8hkhs
	{
		TreeNode x=findWarehouse(nodeid);//anazhthsh apo8hkh me id
		if (x==null)
			System.out.println("There is no Warehouse with id: "+nodeid);
		else
		{
			System.out.printf("Warehouse %d located in %s: \n", x.id, x.city);
			x.booklist.print();//ektypwsh ths listas bibliwn ths apo8hkhs pou bre8hke
		}
	}
	
	
	void searchBookInWareHouse(int nodeid, int isbn)//anazhthsh biblioiu se apo8hkh
	{
		TreeNode x=findWarehouse(nodeid);//anazhthsh apo8hkhs
		if (x==null)
			throw new IllegalArgumentException();
		ListNode temp=x.booklist.find(isbn);//anazhthsh bibliou sth lista ths apo8hkhs
		if (temp==null)
			System.out.println("Warehouse "+nodeid+" does not have this book");
		else
			System.out.println("Warehouse "+nodeid+" located in "+x.city+" has "+temp.getBook().getCopies()+" copies of boook with isbn:"+isbn);
	}
	
	
	void searchBook(int isbn)//anazhthsh bibliou se oles tis apo8hkes
	{
		System.out.println("Search results - Book ISBN: "+isbn);
		System.out.println("-----------------------------------");
		System.out.println("The book is available at");
		searchBookR(head, isbn);	
	}
	
	
	void searchBookR(TreeNode h, int isbn)//anadromikh me8odos anazhthshs bibliou sto DDA 
	{
		if (h == null) return;
		searchBookR(h.l, isbn);
		
		ListNode temp=h.booklist.find(isbn);
		if (temp!=null)
			System.out.println("Warehouse "+h.id+" located in "+h.city+", copies: "+temp.getBook().getCopies());
		
		searchBookR(h.r, isbn);
	}
	
	
	void printTree(PrintStream stream)//emfanish olwn twn bibliwn olwn twn apo8hkwn
	{
		printR(head, stream);
	}
	
	
	void printR(TreeNode h, PrintStream stream) //anadromikh endodiategmenh diasxish tou dentrou gia emfanish ths listas bibliwn ka8e apo8hkhs me ayksousa seira id
	{
		if (h == null) return;
		printR(h.l, stream);
		System.out.printf("Warehouse %d located in %s: \n", h.id, h.city);
		h.booklist.print();
		printR(h.r, stream);
	}

}
