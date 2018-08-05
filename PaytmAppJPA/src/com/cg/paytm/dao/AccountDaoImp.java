package com.cg.paytm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.paytm.bean.AccountPay;
import com.cg.paytm.dao.AccountDao;
import com.cg.paytm.exception.AccountException;


public class AccountDaoImp implements AccountDao {
	
	EntityManagerFactory fact=Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em=fact.createEntityManager();
	
	@Override
	public String createAccount(AccountPay account) throws AccountException {
	em.getTransaction().begin();
	em.persist(account);
	em.getTransaction().commit();
	return account.getMobileNo();		
	}
   @Override
	public double showBalance(String mobileNo) throws AccountException {
	   String strqry="select e from AccountApp1 e where e.mobileNo=?";
		TypedQuery<AccountPay> query=em.createQuery(strqry,AccountPay.class);
		query.setParameter(1,mobileNo);
		AccountPay acc=query.getSingleResult();
		if(acc!=null){
			return acc.getBalance();
		}
		else{
	throw new AccountException("the mobile number is not there in the data base");
}
		
	} 
	
@Override
	public double deposit(String mobileNo, double amount)
			throws AccountException {
	String strqry="select e from AccountApp1 e where e.mobileNo=?";
	TypedQuery<AccountPay> query=em.createQuery(strqry,AccountPay.class);
	query.setParameter(1,mobileNo);
	AccountPay acc=query.getSingleResult();
	double bal=acc.getBalance()+amount;
	acc.setBalance(bal);
	em.getTransaction().begin();
	em.merge(acc);
	em.getTransaction().commit();
	return acc.getBalance();
}
@Override
	public double withdraw(String mobileNo, double amount)
			throws AccountException {
	String strqry="select e from AccountApp1 e where e.mobileNo=?";
	TypedQuery<AccountPay> query=em.createQuery(strqry,AccountPay.class);
	query.setParameter(1,mobileNo);
	AccountPay acc=query.getSingleResult();
	if(acc.getBalance()>amount)
	{
	double bal=acc.getBalance()-amount;
	acc.setBalance(bal);
	em.getTransaction().begin();
	em.merge(acc);
	em.getTransaction().commit();
	}
	return acc.getBalance();
	}
@Override
	public boolean fundTransfer(String mobileNo1, String mobileNo2, double amount)
			throws AccountException {
		deposit(mobileNo1, amount);
	    withdraw(mobileNo2, amount);
		return true;
			}

	@Override
	public AccountPay printTransactions(String mobileNo) throws AccountException {
		String strqry="select e from AccountApp1 e where e.mobileNo=?";
		TypedQuery<AccountPay> query=em.createQuery(strqry,AccountPay.class);
		query.setParameter(1,mobileNo);
		AccountPay acc=query.getSingleResult();
		if(acc==null){
			throw new AccountException("the mobile number is not there in the data base");
		}
		return acc;
	}

}
