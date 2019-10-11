import java.io.PrintStream;


public class List //taksimomhmenh lista monhs syndeshs me antikeimena typou BookInfo
{

	private ListNode firstNode;
	private ListNode lastNode;
	private String name; 
	
	
	public List()
	{
		this("list");
	} 
	

	public List( String listName)
	{
		name = listName;
		firstNode = lastNode = null;
	} 

	
	public boolean isEmpty()//elegxos an einai adeia
	{
		return firstNode == null; 
	} 
	
	
	public void print()// emfanish stoixeiwn listas bibliwn
	{
		if (isEmpty()) 
		{
			System.out.printf("Empty %s\n", name);
			return;
		} 

		ListNode current = firstNode;
		
		while (current != null) 
		{
			System.out.println(current.book.toString());			
			current = current.nextNode;
		} 
	}
	

	public void insert(BookInfo book) //eisagwgh diathrwntas th lista taksinomhmenh
	{
		ListNode node = new ListNode(book);
		
		if (isEmpty()) 
			firstNode = lastNode = node;
		else if (firstNode.book.getIsbn()>node.book.getIsbn())//elegxos an to biblio prepei na ginei o neos firstNode
		{
			node.nextNode=firstNode;
			firstNode=node;
		}
		else if (firstNode.book.getIsbn()==node.book.getIsbn())
		{
			
			firstNode.book.setCopies(node.book.getCopies()+firstNode.book.getCopies());
		}
		else
		{ 
			ListNode current = firstNode;	
			
			while (current.nextNode != null) 
			{
				if (current.nextNode.book.getIsbn()<node.book.getIsbn())
					current = current.nextNode;
				else if(current.nextNode.book.getIsbn()>node.book.getIsbn())	
				{
					node.nextNode=current.nextNode;
					current.nextNode=node;
					break;
				}
				else
				{
					current.nextNode.book.setCopies(node.book.getCopies()+current.nextNode.book.getCopies());
					break;
				}
			
			}
		}
	}
	
	
	public ListNode find(int isbn)//eyresh stoixeiou me isbn
	{
		if (isEmpty())
			return null;	
		
		ListNode current = firstNode;	
		if(firstNode.book.getIsbn()==isbn)
			return current;
		
		while (current.nextNode != null) 
		{
			if (current.nextNode.book.getIsbn()<isbn)
				current = current.nextNode;
			else if(current.nextNode.book.getIsbn()>isbn)	
			{
				return null;
			}
			else
			{
				return current;
			}
		}
		return null;
	}
	
	
	public void removeCopy(int isbn)//afairesh antitypou bibliou
	{
		if (isEmpty())
			throw new IllegalArgumentException();
		ListNode node=find(isbn);
		if (node==null)
		{
			System.out.println("There is no book with isbn:"+isbn+"in this warehouse");
		}
		else 
		{
			node.book.setCopies(node.book.getCopies()-1);		
			if (node.book.getCopies()==0)//an ta antitypa ginoun mhden, afaireitai to biblio apo th lista
				remove(isbn);
		}
	}
	
	
	public void remove(int isbn)//afairesh bibliou apo th lista
	{
		if (isEmpty())
			throw new IllegalArgumentException();
		else if (firstNode.book.getIsbn()==isbn)
		{
			firstNode=firstNode.nextNode;			
		}
		else
		{
			ListNode current = firstNode;	
			
			while (current.nextNode != null) 
			{
				if (current.nextNode.book.getIsbn()<isbn)
					current = current.nextNode;
				else if(current.nextNode.book.getIsbn()>isbn)	
				{
					System.out.println("There is no book with isbn:"+isbn+"in this warehouse");
					break;
				}
				else
				{
					current.nextNode=current.nextNode.nextNode;
					
				}
			}
		}
	}
	
	
} 
