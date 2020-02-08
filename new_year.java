package task.Maven_OOPS;
import java.util.*;
public class new_year implements NewYear_Gift {
		static String child;
		int  num_sweets;
		int num_chocos;
		static int tot_weight; 
		static sweets[] s;
		static chocos[] ch;
		static new_year[] gift;
		
		static HashMap<String,Integer> a = new HashMap<String, Integer> ();
		new_year(int num_sw, int num_ch ,String name)
		{
			child=name;
			s = new sweets[num_sw];
			ch = new chocos[num_ch];
		}
		public void num_items()
		{
			System.out.println(s.length+ch.length+gift.length);
		}
		public static void add(String child, int num)
		{
			if(a.containsKey(child)) 
			{
				a.put(child,a.get(child)+num);
			}
			else
			{
				a.put(child,num);	
			}
			
		}
		public static void chocy_count(int choice)
		{
            Scanner sc  = new Scanner(System.in);
			if(choice==1)
			{
				System.out.println("Enter child name to count chocos: ");
				String name = sc.next();
				if(a.containsKey(name))
					System.out.println(name+"  has "+a.get(name)+" chocos ");
				else
					System.out.println("Child name invalid");
				
			}
			else if(choice==2)
			{
				System.out.println("Enter  to find the number of gifts with no. of chocos less than entered value:");
				int n = sc.nextInt();
				int c=0;
				for(int i=0;i<gift.length;i++)
				{
					if(gift[i].num_chocos<n)
						c++;
				}
				System.out.println(c);
			}
			else if(choice==3)
			{
				System.out.println("Enter  to find the number of gifts with no. of chocos more than entered value:");
				int n = sc.nextInt();
				int c=0;
				for(int i=0;i<gift.length;i++)
				{
					if(gift[i].num_chocos>n)
						c++;
				}
				System.out.println(c);
			}
		}
		public static void main(String args[])
		{
			 Scanner sc = new Scanner(System.in);
			System.out.println("Enter  number of children to distribute  new year gift");
			 int t = sc.nextInt();
			 gift = new new_year[t];
			 for(int i=0;i<t;i++)
			 {
				System.out.println("Enter  name of  child: ");
				String name_child = sc.next();
				
				System.out.println("Enter  num  of types of sweets and chocolates in the gift: ");
				int num_sweets_type = sc.nextInt();
				int num_chocos_type = sc.nextInt();
				gift[i] = new new_year(num_sweets_type,num_chocos_type,name_child);
				
				int sweet_weight,sweet_price,choc_weight,choc_price;	
				int sw_count=0;
				int choc_count=0;
				
				System.out.println("Enter weight of sweets ,price ,quantity for all  sweets: ");
				for(int j=0;j<num_sweets_type;j++)
				{
				    sweet_weight= sc.nextInt();
				    sweet_price= sc.nextInt();
					int quantity =sc.nextInt();
					sw_count+=quantity;
					s[j]=new sweets(sweet_weight,sweet_price,quantity);
					gift[i].tot_weight+=sweet_weight*quantity;
				}
				
				gift[i].num_sweets=sw_count;
				
				if(num_chocos_type !=0)
					System.out.println("Enter  weight,price,quantity,flavour for all the chocos: ");
				else
					   add(name_child,0);
				
				for(int i1=0;i1<num_chocos_type;i1++)
				{
					choc_weight = sc.nextInt();
				    choc_price = sc.nextInt();
					int quantity =sc.nextInt();
					String flavour=sc.next();
					choc_count+=quantity;
					ch[i1]=new chocos(choc_weight,choc_price,quantity,flavour);
					gift[i].tot_weight+=choc_weight*quantity;
					add(name_child,quantity);
					
				}
		
				gift[i].num_chocos=choc_count;
				
				if(num_chocos_type!=0)
				{
					System.out.println("Select way to sort chocos\n 1.Cost 2.Weight 3.Quantity");
					int ans=sc.nextInt();
					Arrays.sort(ch, new chocos_sort(ans));
			       System.out.println("After sorting chocolates in a gift");
					for(int j=0;j<num_chocos_type;j++) 
					{
						System.out.print(ch[j]);
						System.out.println();
					}
				}
					System.out.println();
			 }
			 
			 
			System.out.println("Counting the candies in a gift");
			System.out.println("You have the following options:\n1.Count candies for a particular child.\n"
					+ "2.Count gifts with chocolates less than a value.\n3.Count gifts with chocolates less than a value");
			
			System.out.println("Enter the option: ");
			int opt = sc.nextInt();
			chocy_count(opt);
			
			System.out.println("Total Weight of the new year gifts is: "+tot_weight);
			sc.close();
			
		}
		
	}


	


