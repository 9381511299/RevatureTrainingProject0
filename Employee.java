package projectbank;
import java.sql.Connection;
import org.apache.log4j.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Employee {
 Scanner sc2 = new Scanner(System.in);
 private static Logger log = Logger.getLogger(Employee.class);
 public void Login() throws SQLException 
 {
  // TODO Auto-generated method stub
  System.out.println("/*************************************************************/");
  System.out.println("Welcome to the HDFC Employee Login Portal");
  int aa=2;
  while(aa>0) 
  {
   System.out.println("Enter the user Name:");
   aa=0;
   String str1 = (String) sc2.nextLine();
   System.out.println("Enter the password:");
   String str2 = (String) sc2.nextLine();
   String url="jdbc:mysql://localhost:3306/customer";
   String username="root";
   String password="Keerthi@510";
   try 
   {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(url,username,password);
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("select Emp_Pswd from employe where Emp_UName='"+str1+"' ");
    rs.next();
    String p = rs.getString("Emp_Pswd");
    if(str2.contentEquals(p))
    {
     log.info("Successfully login into your account");
     aa=0;
     int a=1;
     System.out.println("Welcome to HDFC Employee Portal");
     while(a>0)
     {
      System.out.println("/*************************************************************************/");
      System.out.println("1. Customer details");
      System.out.println("2. Withdraw");
      System.out.println("3. Deposit");
      System.out.println("4. Transfer");
      System.out.println("Enter the value:");
      int b = sc2.nextInt();
      if(b==1)
      {
       int dd=1;
       while(dd>0)
       {
        System.out.println("Enter the account number of the customer:");
        int ac = sc2.nextInt();
        try 
        {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con1 = DriverManager.getConnection(url,username,password);
         Statement stmt1 = con1.createStatement();
         ResultSet rs1 = stmt1.executeQuery("select * from customer where Acc_no='"+ac+"' ");
         while(rs1.next())
         {
          System.out.println("Customer account number : "+rs1.getInt(1));
          System.out.println("Customer user id : "+rs1.getString(2));
          System.out.println("Customers name : "+rs1.getString(4));
          System.out.println("Customers Phone number : "+rs1.getString(5));
          System.out.println("Customers E-MAil ID : "+rs1.getString(6));
          System.out.println("Customers Balance amount : "+rs1.getInt(7));
         }
        } 
        catch (ClassNotFoundException e) 
        {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
        System.out.println("Enter 0 to view another customers info");
        System.out.println("Else enter any number");
        int z = sc2.nextInt();
        if(z==0)
        {
         dd=1;
        }
        else
        {
         dd=0;
         System.out.println("Enter 0 to exit from employe portal");
         System.out.println("Enter any number to continue on Employe portal");
         int zz = sc2.nextInt();
         if(zz==0)
         {
          a=0;
          System.out.println("**********************THANK YOU************************");
         }
         else
         {
          a=1;
         }
        }
       }
      }
      else if(b==2)
      {
       int dd=1;
       while(dd>0)
       {
        System.out.println("/*******************************************************/");
        System.out.println("Enter customers account number");
        int n = sc2.nextInt();
        try
        {
Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con2 = DriverManager.getConnection(url,username,password);
         Statement stmt2 = con2.createStatement();
         ResultSet rs2 = stmt2.executeQuery("select Balance_Amount from customer where Acc_no='"+n+"'");
         rs2.next();
         int bal = rs2.getInt("Balance_Amount");
         if(bal>1000)
         {
          System.out.println("Enter the amount to withdraw :");
          int wd = sc2.nextInt();
          int rbal=bal-wd;
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
            boolean rs22 = stmt1.execute("update customer set Balance_Amount='"+rbal+"' where Acc_no ='"+n+"'");
            System.out.println("withdrawl is successful");
            System.out.println("Balance amount is : "+rbal);
            System.out.println("Enter 0 to withdraw amount from another customer");
            System.out.println("Else enter any number");
            int zz = sc2.nextInt();
            if(zz==0)
            {
             dd=1;
            }  
            else
            {
             dd=0;
             System.out.println("Enter 0 to exit from employe portal");
             System.out.println("Enter any other number to continue on employe portal");
             int v=sc2.nextInt();
             if(v==0)
             {
              a=0;
              System.out.println("**********************THANK YOU************************");
             } 
             else
             {
              a=1;
             }
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
           System.out.println("If you withdraw this amount then there is no minimum balance in your account");
          }
         }
         else
         {
          System.out.println("You dont have minimun balance in your account that's why we are stopping your with drawl");
         }
        } 
        catch (ClassNotFoundException e)
        {
         // TODO Auto-generated catch block
         e.printStackTrace();
        }
       }
      }
      else if(b==3)
      {
       int d=1;
       while(d>0)
       {
        System.out.println("/*************************************************************/");
        System.out.println("Enter the customers account number");
        int n = sc2.nextInt();
        try
        {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con3 = DriverManager.getConnection(url,username,password);
         Statement stmt3 = con3.createStatement();
         ResultSet rs3 = stmt3.executeQuery("select Balance_Amount from customer where Acc_no='"+n+"'");
         rs3.next();
         int bal = rs3.getInt(1);   
         System.out.println("Enter the amount to Deposit:");
         int ad = sc2.nextInt();
         int rbal=bal+ad;
          String url1="jdbc:mysql://localhost:3306/customer";
          String username1="root";
          String password1="Keerthi@510";
          try 
          {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con1 = DriverManager.getConnection(url1,username1,password1);
           Statement stmt1 = con1.createStatement();
           boolean rs11 = stmt1.execute("update customer set Balance_Amount='"+rbal+"' where Acc_no ='"+n+"'");
           System.out.println("Deposit is successful");
System.out.println("Balance amount is : "+rbal);
           System.out.println("Enter 0 to deposite amount in another customer account");
           System.out.print("Else enter any number");
           int ff = sc2.nextInt();
           if(ff==0) 
           {
            d=1;
           }
           else
           {
            d=0;
            System.out.println("Enter 0 to exit from employe portal");
            System.out.println("Enter any number to continue on employe portal");
            int dd =sc2.nextInt();
            if(dd==0)
            {
             a=0;
             System.out.println("**********************THANK YOU************************");
            }
            else
            {
             a=1;
            }
           }
          }
          catch (ClassNotFoundException e) 
          {
           // TODO Auto-generated catch block
           e.printStackTrace();
          }
        } 
        catch (ClassNotFoundException e)
        {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
       }
      }
      else if(b==4)
      {
       System.out.println("Enter your account number");
       int ac = sc2.nextInt();
        System.out.println("Enter Account number which you have to send money");
        int tac = sc2.nextInt();
        sc2.nextLine();
        System.out.println("Enter the correct name of your recipient");
        String tn = sc2.nextLine();
        System.out.println("Enter the amount you have to transfer");
        int tam = sc2.nextInt();
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
            System.out.println("Money transfered is successful");
            System.out.println("Your Balance amount is : "+rbal);
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
          System.out.println("Your Recipent name or your receipient account number are incorrect");
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
       System.out.println("Enter the correct number");
      }
     }
    }
    else
    {
     System.out.println("Your password or User name is incorrect try to login once again");
     aa-=1;
    }
   } 
   catch (ClassNotFoundException e)
   {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   
  }
 }                                                 
 public void Signin() throws SQLException
 {
  // TODO Auto-generated method stub
  int aa=2;
  while(aa>0) 
  {
   System.out.println("/********************************************************************/");
   System.out.println("Welcome to the Employee signin portal:");
   System.out.println("Create an user name:");
   String str1 = sc2.nextLine();
   System.out.println("Create a strong password:");
   String str2 = sc2.nextLine();
   System.out.println("Enter the password once again:");
   String str3 = sc2.nextLine();
   System.out.println("Remember the password");
   System.out.println("Enter your name");
   String en = sc2.nextLine(); 
   System.out.println("Enter your Phone Number");
   String ep = sc2.nextLine();
   System.out.println("Enter your EMail Id");
   String ee = sc2.nextLine();
   if(str2.contentEquals(str3))
   {
    String url="jdbc:mysql://localhost:3306/customer";
    String username="root";
    String password="Keerthi@510";
    try 
    {
     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con = DriverManager.getConnection(url,username,password);
     Statement stmt = con.createStatement();
     ResultSet rs = stmt.executeQuery("Select count(*) from customer");
     rs.next();
     int count = rs.getInt(1);
     int eid = count+10000;
     stmt.executeUpdate("insert into Employe values('"+eid+"','"+str1+"','"+str2+"','"+en+"','"+ep+"','"+ee+"')");
     System.out.println("Your account is created"); 
     aa=0;
    }
    catch (ClassNotFoundException e)
    {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
   }
   else
   {
    System.out.println("You entered the wrong password at secound time try once again and remember the password");
    aa-=1;
   }
  }
 }
public int login(String string, String string2) {
	// TODO Auto-generated method stub
	return 0;
}
}