package interview;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Item
{
	String name;
	int price;
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String toString()
	{
		return this.name + " : "+this.price;
	}
}

public class Teja
{
  public static void main(String[] args) throws Exception 
  {
    FileInputStream fis=new FileInputStream("C:\\Users\\TEJA\\Downloads\\input.txt");       
    Scanner sc=new Scanner(fis);
    int number_of_employees = Integer.parseInt(sc.nextLine().split(": ")[1]);
    sc.nextLine(); sc.nextLine(); sc.nextLine();

    ArrayList<Item> goodies_items = new ArrayList<Item>();

    while(sc.hasNextLine())  
    {
      String current[] = sc.nextLine().split(": ");
      goodies_items.add(new Item(current[0], Integer.parseInt(current[1])));
    }
    sc.close();

    Collections.sort(goodies_items, new Comparator<Item>(){
      public int compare(Item a, Item b) { 
        return a.price - b.price; 
      } 
    });

    int min_diff = goodies_items.get(goodies_items.size()-1).price;
    int min_index = 0;
    for(int i=0;i<goodies_items.size()-number_of_employees+1;i++) {
      int diff = goodies_items.get(number_of_employees+i-1).price-goodies_items.get(i).price;

      if(diff<=min_diff) {
        min_diff = diff;
        min_index = i;
      }
    }
    System.out.println(" The Goodies selected for distribution are :");
    
    for(int i=min_index;i<min_index + number_of_employees; i++)
    {
    	System.out.println(goodies_items.get(i).toString());
    }
    System.out.println("\nAnd the difference between the chosen goodie with highest price and the lowest price is " + min_diff);
  }
}
