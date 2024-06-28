package com.bank.account.document;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class Account {
	
	@Id
	private String id;
	private String personId;
	private String accountType;
	private String accountNumber;
	private String currency;
	private float initialSAmount;
	private float currentAmount;
	private boolean isActive;
	private int maxMonthtransactions;
	private int currentTransactions;
	private Date transactionDay;
	private double maxMonthCredit;
	private boolean isLimited;
	private double commission;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getInitialSAmount() {
		return initialSAmount;
	}
	public void setInitialSAmount(float initialSAmount) {
		this.initialSAmount = initialSAmount;
	}
	public float getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(float currentAmount) {
		this.currentAmount = currentAmount;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getMaxMonthtransactions() {
		return maxMonthtransactions;
	}
	public void setMaxMonthtransactions(int maxMonthtransactions) {
		this.maxMonthtransactions = maxMonthtransactions;
	}
	public int getCurrentTransactions() {
		return currentTransactions;
	}
	public void setCurrentTransactions(int currentTransactions) {
		this.currentTransactions = currentTransactions;
	}
	public Date getTransactionDay() {
		return transactionDay;
	}
	public void setTransactionDay(Date transactionDay) {
		this.transactionDay = transactionDay;
	}
	public double getMaxMonthCredit() {
		return maxMonthCredit;
	}
	public void setMaxMonthCredit(double maxMonthCredit) {
		this.maxMonthCredit = maxMonthCredit;
	}
	public boolean isLimited() {
		return isLimited;
	}
	public void setLimited(boolean isLimited) {
		this.isLimited = isLimited;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public Account(String id, String personId, String accountType, String accountNumber, String currency,
			float initialSAmount, float currentAmount, boolean isActive, int maxMonthtransactions,
			int currentTransactions, Date transactionDay, double maxMonthCredit, boolean isLimited, double commission) {
		super();
		this.id = id;
		this.personId = personId;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.currency = currency;
		this.initialSAmount = initialSAmount;
		this.currentAmount = currentAmount;
		this.isActive = isActive;
		this.maxMonthtransactions = maxMonthtransactions;
		this.currentTransactions = currentTransactions;
		this.transactionDay = transactionDay;
		this.maxMonthCredit = maxMonthCredit;
		this.isLimited = isLimited;
		this.commission = commission;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", personId=" + personId + ", accountType=" + accountType + ", accountNumber="
				+ accountNumber + ", currency=" + currency + ", initialSAmount=" + initialSAmount + ", currentAmount="
				+ currentAmount + ", isActive=" + isActive + ", maxMonthtransactions=" + maxMonthtransactions
				+ ", currentTransactions=" + currentTransactions + ", transactionDay=" + transactionDay
				+ ", maxMonthCredit=" + maxMonthCredit + ", isLimited=" + isLimited + ", commission=" + commission
				+ "]";
	}
	
	
}
