package com.cg.paytm.test;


import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;






import com.cg.paytm.bean.AccountPay;
import com.cg.paytm.exception.AccountException;
import com.cg.paytm.service.AccountService;
import com.cg.paytm.service.AccountServiceImp;

public class AccountServiceImpTest {

	AccountService accService=new AccountServiceImp();
	
	@Test
	public void testCreateAccountMobileNum()  {
		AccountPay acc=new AccountPay();
		acc.setBalance(2500.0);
		acc.setEmailid("anusha@gmail.com");
		acc.setMobileNo("909090");
		acc.setName("Anusha");
		
		try {
			accService.createAccount(acc);
		
		} catch (AccountException e) {
			
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
		
	}
	@Test
	public void testCreateAccountName() {
		AccountPay acc=new AccountPay();
		acc.setBalance(2500.0);
		acc.setEmailid("anusha@gmail.com");
		acc.setMobileNo("9704865324");
		acc.setName("anu123");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Name should contain only alphabets",e.getMessage());
		}
	}
	/*@Test
	public void testCreateAccountMailId() {
		AccountPay acc=new AccountPay();
		acc.setBalance(2000.0);
		acc.setEmailid("anusha123@gmail");
		acc.setMobileNo("9704865324");
		acc.setName("Anusha");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Invalid mailId",e.getMessage());
		}
	}*/
	@Test
	public void testCreateAccountAmount() {
		AccountPay acc=new AccountPay();
		acc.setBalance(-2000.0);
		acc.setEmailid("anusha@gmail.com");
		acc.setMobileNo("9704865324");
		acc.setName("anusha");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	
	@Test
	public void testCreateAccount() {
		AccountPay acc=new AccountPay();
		acc.setBalance(10000.0);
		acc.setEmailid("archu@gmail.com");
		acc.setMobileNo("9790468250");
		acc.setName("Archu");
		try {
			String mobileNo = accService.createAccount(acc);
			assertNotNull(mobileNo);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
		
	}
	@Test
	public void testShowBalanceMobileNum()  {
		try {
			accService.showBalance("970468");
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	
	/*@Test
	public void testShowBalance()  {
		AccountPay acc=new AccountPay();
	try {
			double amount=accService.showBalance("1234567890");
			assertEquals(2000.0, amount,0.00);
		} catch (AccountException e) {
			assertEquals("Account with mobileno 1234567890 does not exist",e.getMessage());
			}
	
	}*/
	@Test
	public void testDepositMobileNum()  {
		try {
			accService.deposit("970486",50.0);
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testDepositAmount() {
		try {
			accService.deposit("9704865324",-1.0);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	
	/*@Test
	public void testDeposit() {
		AccountPay acc=new AccountPay();
		acc.setMobileNo("9790468250");
		try {
			double ac= accService.deposit(acc.getMobileNo(),500);
			assertEquals(7000.0, ac,0.00);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}*/
	@Test
	public void testWithdrawMobileNum()  {
		try {
			accService.withdraw("970486",50.0);
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testWithdrawAmount()  {
		try {
			accService.withdraw("9704865324",-1.0);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	
	
	/*@Test
	public void testWithdrawMoreAmount() {
		try {
			accService.withdraw("9704865324",10000);
		} catch (AccountException e) {
			assertEquals("Enter amount less than existing amount",e.getMessage());
		}
	}*/
	/*@Test
	public void testWithdraw()  {
		AccountPay acc=new AccountPay();
		acc.setMobileNo("9704865324");
		try {
			double acc1 = accService.withdraw(acc.getMobileNo(),1000);
			assertEquals(12000.0, acc1,0.00);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			
		}
		}*/
	@Test
	public void testFundTransferMobileNo1()  {
		try {
			accService.fundTransfer("97048653","9790468250",50.0);
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testFundTransferMobileNo2()  {
		try {
			accService.fundTransfer("9704865324","97904682",50.0);
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testFundTransferAmount()
	{
		try {
			accService.fundTransfer("9704865324","9790468250",-1);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	
	/*@Test
	public void testFundTransferMoreAmount() {
		try {
			accService.fundTransfer("9704865324","9790468250",100000);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			assertEquals("Enter amount less than existing amount",e.getMessage());
		}
	}*/
	/*@Test
	public void testFundTransfer()  
	{
		AccountPay acc=new AccountPay();
		AccountPay acc1=new AccountPay();
		try {
			boolean b = accService.fundTransfer("9704865324","9790468250",100);
			assertNotNull(b);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
		}*/
	@Test
	public void testPrintTransactionMobileNo()  {
		try {
			accService.printTransactions("970486");
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	
	/*@Test
	public void testPrintTransactions()  {
		AccountPay acc=new AccountPay();
		try {
			AccountPay acc1 = accService.printTransactions("9790468250");
			assertNotNull(acc1);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			
		}
		}*/

	

}