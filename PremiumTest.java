import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

//import random.numbers.Numbers;
//import random.numbers.ResourceReader;

public class PremiumTest 
{
	public static void main(String[] args) throws IOException
	{
		PremiumTest pt = new PremiumTest();
		
		ArrayList<Premiums> pres = new ArrayList<Premiums>();
		
		BufferedReader readerF = pt.read("PremTable.txt");
		String next = null;
		while((next = readerF.readLine()) != null)
		{
			String[] a = next.split(" ");
			pres.add(new Premiums(Integer.parseInt(a[0]), Integer.parseInt(a[1])));
		}
		readerF.close();
		
		Collections.sort(pres);
		
		boolean done = false;
		while(!done)
		{
			String fileName = JOptionPane.showInputDialog("Enter an customer file:");
			if(fileName == null || fileName.equals(""))
				done = true;
			else
			{
				ArrayList<Customer> cus = new ArrayList<Customer>();
				
				BufferedReader readerC = pt.read(fileName);
				next = null;
				while((next = readerC.readLine()) != null)
				{
					String[] a = next.split("-");
					cus.add(new Customer(a[0], Integer.parseInt(a[1])));
				}
				readerC.close();
				
				System.out.println("Unsorted Data:");
				System.out.println("Name                   Age");
				System.out.println(cus);
				
				Collections.sort(cus);
				
				System.out.println("Sorted Data:");
				System.out.println("Name                   Age");
				System.out.println(cus);
				
				System.out.println("Premium Table:");
				System.out.println("Name                   Age   Premium");
				for(int i = 0; i < cus.size(); i++)
				{
					int k = Collections.binarySearch(pres, new Premiums(cus.get(i).getAge(), 0));
					if(k >= 0)
						System.out.println(cus.get(i) + "   " + pres.get(k).getPremium());
					else
					{
						int loc = -k - 1;
						System.out.println(cus.get(i) + "   " + pres.get(loc).getPremium());
					}
				}
			}
		}
	}
	public BufferedReader read(String fileName) throws FileNotFoundException
	{
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		return reader;
	}
}
