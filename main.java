package projectbank;

import java.sql.SQLException;
import java.util.*;
public class main {
 public static void main(String args[]) throws SQLException
 {
  @SuppressWarnings("resource")
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter 1 to login as a Employee:");
  System.out.println("Enter 2 to login as an Customer:");
  int a = sc.nextInt();
  if(a==1) {
   System.out.println("Enter 1 to login:");
   System.out.println("Enter 2 for Signin:");
   int b = sc.nextInt();
   Employee Em1 = new Employee();
   if(b==1) {
    Em1.Login();
   }
   else if(b==2){
    Em1.Signin();
   }
  }
  else if(a==2) {
   System.out.println("Enter 1 for login:");
   System.out.println("Enter 2 for Account Creation:");
   int c = sc.nextInt();
   Customer cu = new Customer();
   if(c==1)
   {
    cu.Login();
   }
   if(c==2)
   {
    cu.AccountCreation();
   }
  }
 }
}