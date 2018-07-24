package com.cg.mypaymentapp.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wallet {
	@Id
	@Column(name = "wallet_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private BigDecimal balance;

	public Wallet() {
		super();
	}

	public Wallet(BigDecimal amount) {
		this.balance = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return ", balance=" + balance;
	}

}
