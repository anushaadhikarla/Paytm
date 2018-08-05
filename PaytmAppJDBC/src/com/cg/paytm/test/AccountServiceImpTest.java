package com.cg.paytm.test;


import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.cg.paytm.bean.Account;
import com.cg.paytm.exception.AccountException;
import com.cg.paytm.service.AccountService;
import com.cg.paytm.service.AccountServiceImp;

public class AccountServiceImpTest {

	AccountService accService=new AccountServiceImp();
	
	@Test
	public void testCreateAccountMobileNum()  {
		Account acc=new Account();
		acc.setBalance(2000.0);
		acc.setEmailid("anusha@gmail.com");
		acc.setMobileNo("970486534");
		acc.setName("Anusha");
		
		try {
			accService.createAccount(acc);
		
		} catch (AccountException e) {
			
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
		
	}
	@Test
	public void testCreateAccountName() {
		Account acc=new Account();
		acc.setBalance(2000.0);
		acc.setEmailid("anusha@gmail.com");
		acc.setMobileNo("9704865324");
		acc.setName("anu123");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Name should contain only alphabets",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountMailId() {
		Account acc=new Account();
		acc.setBalance(2000.0);
		acc.setEmailid("vineesha123@gmail");
		acc.setMobileNo("9704865324");
		acc.setName("vineesha");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Invalid mailId",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountAmount() {
		Account acc=new Account();
		acc.setBalance(-2000.0);
		acc.setEmailid("vineesha@gmail.com");
		acc.setMobileNo("9704865324");
		acc.setName("vineesha");
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	
	@Test
	public void testCreateAccount() {
		Account acc=new Account();
		acc.setBalance(5000.0);
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
			accService.showBalance("97048656");
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	/*@Test
	public void testShowBalanceMobileNumNotExist()  {
		try {
			accService.showBalance("1234567890");
		} catch (AccountException e) {
			assertEquals("Account with mobileno 1234567890 does not exist",e.getMessage());
		}
	}*/
	/*@Test
	public void testShowBalance()  {
		AccountApp acc=new AccountApp();
	try {
			double amount=accService.showBalance("9380015066");
			assertEquals(2300.0, amount,0.00);
		} catch (AccountException e) {
			assertEquals("Account with mobileno 1234567890 does not exist",e.getMessage());
			}
	
	}*/
	@Test
	public void testDepositMobileNum()  {
		try {
			accService.deposit("97048653",50.0);
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
	public void testDepositMobileNumDoesNotExist()  {
		try {
			accService.deposit("9876543567",50);
		} catch (AccountException e) {
			assertEquals("Account with mobileno 9876543567 does not exist",e.getMessage());
		}
	}*/
	@Test
	public void testDeposit() {
		Account acc=new Account();
		acc.setMobileNo("9704865324");
		try {
			double ac= accService.deposit(acc.getMobileNo(),50);
			assertEquals(12550.0, ac,0.00);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testWithdrawMobileNum()  {
		try {
			accService.withdraw("97048653",50.0);
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testWithdrawAmount()  {
		try {
			accService.withdraw("9876543210",-1.0);
		} catch (AccountException e) {
			assertEquals("Enter Valid Amount should be greater than zero",e.getMessage());
		}
	}
	/*@Test
	public void testWithdrawMobileNumDoesNotExist()  {
		try {
			accService.deposit("9876543567",50);
		} catch (AccountException e) {
			assertEquals("Account with mobileno 9876543567 does not exist",e.getMessage());
		}
	}*/
	
	/*@Test
	public void testWithdrawMoreAmount() {
		try {
			accService.withdraw("9380015070",4000);
		} catch (AccountException e) {
			assertEquals("Enter Amount it should be less than available amount",e.getMessage());
		}
	}*/
	@Test
	public void testWithdraw()  {
		Account acc=new Account();
		acc.setMobileNo("9704865324");
		try {
			double acc1 = accService.withdraw(acc.getMobileNo(),500);
			assertEquals(2000.0, acc1,0.00);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			
		}
		}
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
			accService.fundTransfer("9380015060","9380015066",7000);
		} catch (AccountException e) {
			assertEquals("Enter Amount it should be less than available amount",e.getMessage());
		}
	}*/
	@Test
	public void testFundTransfer()  
	{
		Account acc=new Account();
		Account acc1=new Account();
		try {
			boolean b = accService.fundTransfer("9704865324","9790468250",100);
			assertNotNull(b);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
		}
	@Test
	public void testPrintTransactionMobileNo()  {
		try {
			accService.printTransactions("97904682");
		} catch (AccountException e) {
			assertEquals("Mobile Number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test
	public void testPrintTransactions()  {
		Account acc=new Account();
		try {
			Account acc1 = accService.printTransactions("9790468250");
			assertNotNull(acc1);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			
		}
		}

	

}
