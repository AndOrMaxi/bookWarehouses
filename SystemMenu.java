import java.util.Scanner;
//menou diaxeirishs apo8hkwn ekdotikou oikou
public class SystemMenu 
{
	public static void main(String args[])
	{
	
		ST whTree = new ST();//dhmiourgw ena dentro me tis apo8hkes ths ekdotikhs etairias
		
		
		String line = "---------------------------------------";
		String prompt = " > ";
        Scanner in = new Scanner(System.in);
        boolean done = false;
        String answer;
        while (!done)//atermwn broxos, emfanish menou mexri na dwsei o xrhsths 0
        {
        	System.out.printf("%n%s%n%15s%n%s%n", line, "Book Warehouses", line);
            System.out.println(" 1. Insert Warehouse");
            System.out.println(" 2. Insert Book");  
            System.out.println(" 3. Remove Warehouse"); 
            System.out.println(" 4. Remove Book");
            System.out.println(" 5. Search By Warehouse");
            System.out.println(" 6. Search Book In Warehouse");
            System.out.println(" 7. Search Book");
            System.out.println(" 8. Print Warehouses and Books");            
            System.out.println(" 0. Exit");
            System.out.println(line);
            System.out.print(prompt);
            answer = in.nextLine();
            
            if(answer.equals("1"))//eisagwgh apo8hkhs
            {
            	System.out.println("Insert Warehouse");
            	System.out.println(line);
				System.out.println("Give warehouse id and city");
				System.out.print(prompt);
				
				String[] temp1 = in.nextLine().trim().split(" ");	
				if (temp1.length==2)// elegxos an do8hkan dyo orismata
				{
					whTree.insertWarehouse(Integer.parseInt(temp1[0]), temp1[1]);
					System.out.println();
					System.out.println("Warehouse with id "+temp1[0]+", located in "+temp1[1]+", was inserted.");
					
					
				}
				else	
				{
					System.out.println("Wrong numbern of arguments!Expected \"id city\"");
				}
            }
            else if(answer.equals("2"))//eisagwgh bibliou se apo8hkh
            {
            	System.out.println("Insert Book");
            	System.out.println(line);
				System.out.println("Give warehouse id");
				System.out.print(prompt);
				
				String[] temp1 = in.nextLine().trim().split(" ");
				if (temp1.length==1)//elegxos an do8hke ena orisma
				{
					System.out.println("Give book isbn and number of copies");
					System.out.print(prompt);
					String[] temp2 = in.nextLine().trim().split(" ");
					
					if(temp2.length==2)
					{
						whTree.insertBookAtWarehouse(Integer.parseInt(temp1[0]), Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]));
						System.out.println();
						System.out.println("Book with isbn "+temp2[0]+" was inserted (No. of copies: "+temp2[1]+") in Warehouse with id "+temp1[0]+".");
					}
					else	
					{
						System.out.println("Wrong numbern of arguments!Expected \"isbn copies\"");
					}
					
				}
				else	
				{
					System.out.println("Wrong numbern of arguments!Expected \"id\"");
				}
				
            }
            else if(answer.equals("3"))//afairesh apo8hkhs
            {
            	System.out.println("Remove Warehouse");
            	System.out.println(line);
				System.out.println("Give warehouse id");
				System.out.print(prompt);
				String[] temp1 = in.nextLine().trim().split(" ");
				if (temp1.length==1)
				{
					whTree.removeWarehouse(Integer.parseInt(temp1[0]));
					System.out.println();
					System.out.println("Warehouse with id "+temp1[0]+", was removed.");
					
					
				}
				else	
				{
					System.out.println("Wrong numbern of arguments!Expected \"id\"");
				}
            }
            else if(answer.equals("4"))//afairesh antitypou bibliou
            {
            	System.out.println("Remove Book");
            	System.out.println(line);
				System.out.println("Give warehouse id");
				System.out.print(prompt);
				
				String[] temp1 = in.nextLine().trim().split(" ");
				if (temp1.length==1)
				{
					System.out.println("Give book isbn");
					System.out.print(prompt);
					String[] temp2 = in.nextLine().trim().split(" ");
					
					if(temp2.length==1)
					{
						whTree.removeBook(Integer.parseInt(temp1[0]), Integer.parseInt(temp2[0]));
						System.out.println();
						System.out.println("One copy of book with isbn "+temp2[0]+" was removed from Warehouse with id "+temp1[0]+".");
					}
					else	
					{
						System.out.println("Wrong numbern of arguments!Expected \"isbn\"");
					}
					
				}
				else	
				{
					System.out.println("Wrong numbern of arguments!Expected \"id\"");
				}
            }
            else if(answer.equals("5"))//emfanish periexomenwn apo8hkhs
            {
            	System.out.println("Search By Warehouse");
            	System.out.println(line);
				System.out.println("Give warehouse id");
				System.out.print(prompt);
				String[] temp1 = in.nextLine().trim().split(" ");
				if (temp1.length==1)
				{
					whTree.searchByWarehouse(Integer.parseInt(temp1[0]));
					System.out.println();
							
					
				}
				else	
				{
					System.out.println("Wrong numbern of arguments!Expected \"id\"");
				}
            }
            else if(answer.equals("6"))//anazhthsh bibliou se apo8hkh
            {
            	System.out.println("Search Book In Warehouse");
            	System.out.println(line);
				System.out.println("Give warehouse id");
				System.out.print(prompt);
				
				String[] temp1 = in.nextLine().trim().split(" ");
				if (temp1.length==1)
				{
					System.out.println("Give book isbn");
					System.out.print(prompt);
					String[] temp2 = in.nextLine().trim().split(" ");
					
					if(temp2.length==1)
					{
						whTree.searchBookInWareHouse(Integer.parseInt(temp1[0]), Integer.parseInt(temp2[0]));
						System.out.println();
					}
					else	
					{
						System.out.println("Wrong numbern of arguments!Expected \"isbn\"");
					}
					
				}
				else	
				{
					System.out.println("Wrong numbern of arguments!Expected \"id\"");
				}
            }
            else if(answer.equals("7"))//anazhthsh bibliou se oles tis apo8hkes
            {
            	System.out.println("Search Book");
            	System.out.println(line);
				
				System.out.println("Give book isbn");
				System.out.print(prompt);
				String[] temp1 = in.nextLine().trim().split(" ");
				
				if(temp1.length==1)
				{
					whTree.searchBook(Integer.parseInt(temp1[0]));
					System.out.println();
				}
				else	
				{
					System.out.println("Wrong numbern of arguments!Expected \"isbn\"");
				}
					
				
            }
            else if(answer.equals("8"))//emfanish olwn twn bibliwn olwn twn apo8hkwn
            {
            	System.out.println("Print Warehouses and Books");
            	System.out.println(line);
				
				whTree.printTree(System.out);
				System.out.println();
					
            }
            else if(answer.equals("0"))//eksodos apo to menu
            {
            	done = true;            	
            }
            else
            	System.out.println("Choose 1, 2, 3, 4, 5, 6, 7 or 0.\n");
                        
        }
        in.close();
	}
}
