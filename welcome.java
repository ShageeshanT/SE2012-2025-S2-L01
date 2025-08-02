import java.util.Scanner;

public class welcome{
 public static void main(String[] args){
  
  Scanner fname= new Scanner(System.in);
  System.out.print("Enter you first name : ");
  String firstname=fname.nextLine();
  
  Scanner lname=new Scanner(System.in);
  System.out.print("Enter you last name : ");
  String lastname=lname.nextLine();
  
  System.out.println("Welcome to Second Year " + firstname + lastname);
  
  }
  }
  
  
   
  
  
  