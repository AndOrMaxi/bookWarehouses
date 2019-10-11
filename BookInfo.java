//typos antikeimenwn gia kataxwrhsh bibliwn stis apo8hkes
public class BookInfo 
{
	private int isbn;
	private int copies;
	
	BookInfo(int isbn)
	{
		if (isbn < 0 || isbn > 9999)  throw new IllegalArgumentException();//elegxos an to isbn einai egkyro
		this.isbn = isbn;
		this.copies=0;
	}
	
	BookInfo(int isbn,int copies)
	{
		if (isbn < 0 || isbn > 9999)  throw new IllegalArgumentException();//elegxos an to isbn einai egkyro
		this.isbn = isbn;
		this.copies=copies;
	}
	
	int getIsbn()
	{
		return this.isbn;
	}
	
	void setCopies(int copies)
	{
		this.copies=copies;
	}
	
	int getCopies()
	{
		return this.copies;
	}
	public String toString()//override ths toString() gia emfanish tou bibliou symfwna me tiw apaithseis ths ekfwnhshs
	{
		return ("Book " + this.isbn + ", copies: " + this.copies) ;
	}
}
