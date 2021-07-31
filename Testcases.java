package projectbank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class Testcases {
	Employee Em1=new Employee();
	Customer cu = new Customer();
	@Test
	public void Test_login() {
		int a=Em1.login("h","k@gmail.com");
		assertEquals(0,a);
	}
	
}
