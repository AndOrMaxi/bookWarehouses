//Kombos listas pou periexei ena antikemeno BookInfo
class ListNode
{
	
	BookInfo book;
	ListNode nextNode;

	ListNode(BookInfo book )
	{
		this( book, null );
	} 
		
	
	ListNode( BookInfo book, ListNode node )
	{
		this.book=book;
		nextNode = node;
	}
	
	BookInfo getBook()
	
	{
		return this.book; 
	}

	
	ListNode getNext()
	{
		return nextNode; 
	} 
	
} 