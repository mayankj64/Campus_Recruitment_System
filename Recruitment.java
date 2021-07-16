package Campus_Recruitment_System;

import java.util.*;

interface Form
{
public abstract void details();
public abstract void display();
}

class Admin implements Form
{
static String name;
static String preferred_branch;
static int rank;
static ArrayList<String> branches = new ArrayList<String>();	
public void details()
	{
	   System.out.println("Available Branches : \n CSE  \n EC \n ME \n EE \n CE ");
	   Scanner sc = new Scanner(System.in);
	   System.out.print("Enter your name : ");
	   name = sc.nextLine();
	   System.out.println("Enter your Preferred Branches in the order you want them : ");
	   for(int n=1;n<=5;n++) 
	   	{
	   	  Scanner tc = new Scanner(System.in);
	   	  preferred_branch = tc.nextLine();
	   	  branches.add(preferred_branch);
	   	}
	   System.out.print("Enter your Jee Mains Rank : ");
	   rank = sc.nextInt();
	   
	} 
	 
public void display()
	{
	System.out.println(name + "\n"+ rank + "\n" + branches);
	}
}

class Applicants implements Form
{ 
static ArrayList<Integer> al = new ArrayList<Integer>();

public void details()
	{
	   
	   Random random = new Random();
	   for(int i=1;i<=50;i++)
	   	{
	   	   int rank = random.nextInt(10000)+1;
	   	   al.add(rank);
	   	}	
	   Collections.sort(al);
	 }
	 
public void display()
	{
		System.out.println(al);
	}

}

class Comparison extends Admin
{
ArrayList<Integer> Ranks = Applicants.al;
static int a = 0 , b = 0 ;
public void getRank()
	{
	  
	   for(int i=0;i<=49;i++)
	 {
	   b = Ranks.get(i);
	   if(b >=  rank)
	   	{
	    	  a = i + 1;
	    	  break;
	    	}
	    else
	    a = 51; 	
	   
	 } 
       System.out.println("Your rank is " + a + " Among 50 Students");
       } 

} 

class Allocation extends Comparison
{
public void result()
	{
	  if(a >=1 && a<=10)
	  	{
	  	  System.out.println("Congrats! " + name +" Based on your rank and your preference list you have been allocated " + branches.get(0) + " branch");
	  	}
	   else if(a>=11 && a<=20)
	   	{
	   	  branches.remove("CSE");
	   	  System.out.println("Congrats! " + name +" Based on your rank and your preference list you have been allocated " + branches.get(0) + " branch");
	   	}
	   else if(a>=21 && a<=30)
	   	{
	   	  branches.remove("CSE");
	   	  branches.remove("EC");
	   	  System.out.println("Congrats! " + name +" Based on your rank and your preference list you have been allocated " + branches.get(0) + " branch");
	   	}
	   else if(a>=31 && a<=40)
	   	{
	   	  branches.remove("CSE");
	   	  branches.remove("EC");
	   	  branches.remove("EE");
	   	  System.out.println("Congrats! " + name +" Based on your rank and your preference list you have been allocated " + branches.get(0) + " branch");
	   	}
	   else if(a>=41 && a<=50)
	   	{
	   	  branches.remove("CSE");
	   	  branches.remove("EC");
	   	  branches.remove("EE");
	   	  branches.remove("ME");
	   	  System.out.println("Congrats! " + name +" Based on your rank and your preference list you have been allocated " + branches.get(0) + " branch");
	   	}
	    else
	    	{
	    	  System.out.println("Sorry! " + name + "\n Based on your rank you are not eligible to get any branch in our college");
	    	}			
	
	}
}


class Recruitment
{
public static void main(String[]args)
	{
	   Admin user = new Admin();
	   Applicants students = new Applicants();
	   Comparison cmp = new Comparison();
	   Allocation branch = new Allocation();
	   user.details();
	   students.details();
	   cmp.getRank();
	   branch.result();
	}
}

























