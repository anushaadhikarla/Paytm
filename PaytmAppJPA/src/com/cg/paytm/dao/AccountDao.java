package com.cg.paytm.dao;

import com.cg.paytm.bean.AccountPay;
import com.cg.paytm.exception.AccountException;

public interface AccountDao {
	String createAccount(AccountPay account) throws AccountException;
	double showBalance(String mobileNo) throws AccountException;
	double deposit(String mobileNo,double amount) throws AccountException;
	double withdraw(String mobileNo,double amount) throws AccountException;
	boolean fundTransfer(String mobileNo1,String mobileNo2,double amount) throws AccountException;
	AccountPay printTransactions(String mobileNo) throws AccountException;
}
