package projectbank;

import java.sql.Connection;
import org.apache.log4j.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Customer {
 Scanner sc1 = new Scanner(System.in);
 private StringBuffer ab;
 private StringBuffer bc;
 private StringBuffer pswd;
 public static final Logger log = Logger.getLogger(Customer.class);
 public void Login() throws SQLException
 {
	 sc1.nextLine();
  System.out.println("Enter the user name:");
  String str1 = sc1.nextLine();
  System.out.println("Enter the password:");
  String str2 = sc1.nextLine();
  String url="jdbc:mysql://localhost:3306/customer";
  String username="root";
  String password="Keerthi@510";
  try {
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con = DriverManager.getConnection(url,username,password);
   Statement stmt = con.createStatement();
   ResultSet rs = stmt.executeQuery("select Pswd,Acc_no from customer where User_Name='"+str1+"' ");
   rs.next();
   String p = rs.getString("Pswd");
   int q = rs.getInt("Acc_no");
   if(str2.contentEquals(p))
   {
     log.info("Successfully login into your account");
     int n = 1;
     while(n>0)
     {
      System.out.println("/******************************************************************/");
      System.out.println("Welcome to the HDFC customer portal");
      System.out.println("0: Profile view");
      System.out.println("1: Balance Enquiry");
      System.out.println("2: Withdraw");
      System.out.println("3: Deposit");
      System.out.println("4: Transfer money");
      int p1 = sc1.nextInt();
      if(p1==0)
      {
       
        System.out.println("Enter the your account number:");
        int ac = sc1.nextInt();
        if(ac==q)
        {
         try 
         {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con1 = DriverManager.getConnection(url,username,password);
          Statement stmt1 = con1.createStatement();
          ResultSet rs1 = stmt1.executeQuery("select * from customer where Acc_no='"+ac+"' ");
          while(rs1.next())
          {
           System.out.println("Your account number : "+rs1.getInt(1));
           System.out.println("Your user id : "+rs1.getString(2));
           System.out.println("Your name : "+rs1.getString(4));
           System.out.println("Your Phone number : "+rs1.getString(5));
           System.out.println("Your E-MAil ID : "+rs1.getString(6));
           System.out.println("Your Balance amount : "+rs1.getInt(7));
          }
          
         }
         catch (ClassNotFoundException e)
         {
          // TODO Auto-generated catch block
          e.printStackTrace();
         }
         System.out.println("Enter 0 to continue on customers portal");
         System.out.println("Enter any number to continue on customers portal");
         int z = sc1.nextInt();
         if(z==0)
         {
          n=0;
          System.out.println("***************Thank You For Using HDFC Customers Portal******************");
         }
         else
         {
          n=1;
         }
        }
        else
        {
         log.wait1("Your Account number is incorrect please try again once");
        }
      }
      else if(p1==1)
      {
       System.out.println("Enter your account number");
       int a = sc1.nextInt();
       if(a==q)
       {
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con2 = DriverManager.getConnection(url,username,password);
         Statement stmt2 = con2.createStatement();
         ResultSet rs2 = stmt2.executeQuery("select Balance_Amount from customer where Acc_no='"+a+"'");
         rs2.next();
         int bal = rs2.getInt(1);
         Logger.info("Your Balance amount is : "+bal);
         } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
          e.printStackTrace();
         }
        System.out.println("Enter 0 to exit from customers portal");
        System.out.println("Enter any  number to continue on customer portal");
        int ff = sc1.nextInt();
        if(ff==0)
        {
         n=0;
         System.out.println("***************Thank You For Using HDFC Customers Portal******************");
        }
        else
        {
         n=1;
        }
       }
       else
       {
        log.wait("Your Account number is incorrect please try again once");
        n=0;
       }
      }
      else if(p1==2)
      {
       System.out.println("Enter your account number");
       int a = sc1.nextInt();
       if(a==q)
       {
        try
        {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con3 = DriverManager.getConnection(url,username,password);
         Statement stmt3 = con3.createStatement();
         ResultSet rs3 = stmt3.executeQuery("select Balance_Amount from customer where Acc_no='"+a+"'");
         rs3.next();
         int bal = rs3.getInt(1);
         if(bal>1000)
         {
          System.out.println("Enter the amount you have to withdraw :");
          int wd = sc1.nextInt();
          int rbal=bal-wd;
          if(rbal>=1000)
          {
           String url1="jdbc:mysql://localhost:3306/customer";
           String username1="root";
           String password1="Keerthi@510";
           try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con1 = DriverManager.getConnection(url1,username1,password1);
            Statement stmt1 = con1.createStatement();
            boolean rs11 = stmt1.execute("update customer set Balance_Amount='"+rbal+"' where Acc_no ='"+a+"'");
            log.info("Your withdrawl is successful");
            System.out.println("Your Balance amount is : "+rbal);
            n=0;
           }
           catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
           }
          }
          else
          {
           log.wait("If you withdraw this amount then there is no minimum balance in your account");
          }
         }
         else
         {
          log.wait("You dont have minimun balance in your account that's why we are stopping your process");
         }
        } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
        System.out.println("Enter 0 to exit from customers portal");
        System.out.println("Enter any other number to continue on customers portal");
        int gg = sc1.nextInt();
        if(gg==0)
        {
         n=0;
         System.out.println("***************Thank You For Using HDFC Customers Portal******************");
        } 
        else
        {
         n=1;
        }
       }
       else
       {
        log.wait("Your Account number is incorrect please try again once");
        n=0;
       }
      }
      else if(p1==3)
      {
       System.out.println("Enter your account number");
       int a = sc1.nextInt();
       if(a==q)
       {
        try
        {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con4 = DriverManager.getConnection(url,username,password);
         Statement stmt4 = con4.createStatement();
         ResultSet rs4 = stmt4.executeQuery("select Balance_Amount from customer where Acc_no='"+a+"'");
         rs4.next();
         int bal = rs4.getInt(1);   
         System.out.println("Enter the amount you have to Deposit:");
         int wd = sc1.nextInt();
         int rbal=bal+wd;
         String url1="jdbc:mysql://localhost:3306/customer";
         String username1="root";
         String password1="Keerthi@510";
try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con1 = DriverManager.getConnection(url1,username1,password1);
          Statement stmt1 = con1.createStatement();
          boolean rs11 = stmt1.execute("update customer set Balance_Amount='"+rbal+"' where Acc_no ='"+a+"'");
          log.info("Your Deposit is successful");
          System.out.println("Your Balance amount is : "+rbal);
         }
         catch (ClassNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
         }
        } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
        System.out.println("Enter 0 to exit from customers portal");
        System.out.println("Enter any number to continue on customers portal");
        int g = sc1.nextInt();
        if(g==0)
        {
         n=0;
         System.out.println("***************Thank You For Using HDFC Customers Portal******************");
        }
        else
        {
         n=1;
        }
       }
       else
       {
        log.wait("Your Account number is incorrect please try again once");
        n=0;
       }
      }
      else if(p1==4)
      {
       System.out.println("Enter your account number");
       int ac = sc1.nextInt();
       if(ac==q)
       {
        System.out.println("Enter Account number which you have to send money");
        int tac = sc1.nextInt();
        sc1.nextLine();
        System.out.println("Enter the correct name of your recipient");
        String tn = sc1.nextLine();
        System.out.println("Enter the amount you have to transfer");
        int tam = sc1.nextInt();
        try
        {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con3 = DriverManager.getConnection(url,username,password);
         Statement stmt3 = con3.createStatement();
         ResultSet rs3 = stmt3.executeQuery("select Balance_Amount from customer where Name='"+tn+"'");
         rs3.next();
         int rrbal = rs3.getInt("Balance_Amount");
         System.out.println(rrbal);
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con33 = DriverManager.getConnection(url,username,password);
         Statement stmt33 = con33.createStatement();
         ResultSet rs33 = stmt33.executeQuery("select Acc_no from customer where Name='"+tn+"'");
         rs33.next();
         int acc = rs33.getInt("Acc_no");
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con4 = DriverManager.getConnection(url,username,password);
         Statement stmt4 = con4.createStatement();
         ResultSet rs4 = stmt4.executeQuery("Select Balance_Amount from customer where Acc_no='"+ac+"'");
         rs4.next();
         int bal = rs4.getInt("Balance_Amount");
         if(tac==acc)
         {
          int rbal=bal-tam;
          int tbal=rrbal+tam;
          if(rbal>=1000)
          {
           String url1="jdbc:mysql://localhost:3306/customer";
           String username1="root";
           String password1="Keerthi@510";
           try 
           {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con1 = DriverManager.getConnection(url1,username1,password1);
            Statement stmt1 = con1.createStatement();
            boolean rs11 = stmt1.execute("update customer set Balance_Amount='"+rbal+"' where Acc_no ='"+ac+"'");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con2 = DriverManager.getConnection(url1,username1,password1);
            Statement stmt2 = con2.createStatement();
            boolean rs12 = stmt2.execute("update customer set Balance_Amount='"+tbal+"' where Acc_no ='"+acc+"'");
            log.info("Money transfered is successful");
System.out.println("Your Balance amount is : "+rbal);
            n=0;
           }
           catch (ClassNotFoundException e)
           {
            // TODO Auto-generated catch block
            e.printStackTrace();
           }
          }
         }
         else
         {
           log.wait("Your Recipent name or your receipient account number are incorrect");
         }
        }
        catch (ClassNotFoundException e)
        {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
       }
       else
       {
        log.wait("Your password is incorrect");
       } 
      }
      else
      {
       log.wait("Enter correct number");
      }
     }
   }
   else
   {
    log.wait("Your password or User name is incorrect try to login once again");
   }
   }
   catch (ClassNotFoundException e)
   {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
 }
 public void AccountCreation() throws SQLException 
 {
  System.out.println("Create an user name:");
  String str3 = sc1.nextLine();
  System.out.println("Create a strong password:");
  String str4 = sc1.nextLine();
  System.out.println("Enter the password once again:");
  String str5 = sc1.nextLine();
  System.out.println("Remember the Password");
  if(str5.contentEquals(str4))
  {
   System.out.println("You have to deposite atleast 1000 while Creating an account for minimun balance purpose:");
   System.out.println("Do you aggre with this enter '1' else enter '2': ");
   int z = sc1.nextInt();
   if(z==1) {
    System.out.println("/********************************************************************/");
    System.out.println("Welcome to the Employee signin portal:");
    System.out.println("Enter your phone number it's must be 10 numbers:");
    String phnNo = sc1.next();
    System.out.println(phnNo);
    sc1.nextLine();
    System.out.println("Enter your name:");
    String name = sc1.nextLine();
    System.out.println("Enter your mailid:");
    String eMail = sc1.nextLine();
    System.out.println("Enter the amount you want to deposite:");
    int bal = sc1.nextInt();
    if(bal>=1000) {
     String url="jdbc:mysql://localhost:3306/customer";
     String username="root";
     String password="Keerthi@510";
     try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,username,password);
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select count(*) from customer");
      rs.next();
      int count = rs.getInt(1);
      int a = count+1000;
      stmt.executeUpdate("insert into customer values("+a+",'"+str3+"','"+str4+"','"+name+"','"+phnNo+"','"+eMail+"',"+bal+")");
      System.out.println("You have successfully created your account");
      } catch (ClassNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
      }
    }
    else
    {
     log.wait("You have to deposite atleast 1000 rupees");
    }
   }
  }
 } 
}