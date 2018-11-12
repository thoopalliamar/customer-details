package com.capgemini.customer.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class DeletedCustomer {
	
	@Id
	private Long accountID;
	private Long empID;
	@JsonInclude(Include.NON_EMPTY)
	private String type;
	@JsonInclude(Include.NON_EMPTY)
	private String classType;
	@JsonInclude(Include.NON_EMPTY)
	private String holderName;
	@JsonInclude(Include.NON_EMPTY)
	private String token;
	@JsonInclude(Include.NON_EMPTY)
	private String cardType;
	@JsonInclude(Include.NON_EMPTY)
	private String cardExpiry;
	@JsonInclude(Include.NON_EMPTY)
	private String bankType;
	@JsonInclude(Include.NON_EMPTY)
	private String bankRouting;
	@JsonInclude(Include.NON_EMPTY)
	private int deletePending;
	public Long getAccountID() {
		return accountID;
	}
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
	public Long getEmpID() {
		return empID;
	}
	public void setEmpID(Long empID) {
		this.empID = empID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public String getBankRouting() {
		return bankRouting;
	}
	public void setBankRouting(String bankRouting) {
		this.bankRouting = bankRouting;
	}
	public int getDeletePending() {
		return deletePending;
	}
	public void setDeletePending(int deletePending) {
		this.deletePending = deletePending;
	}
	public DeletedCustomer(Long accountID, Long empID, String type, String classType, String holderName, String token,
			String cardType, String cardExpiry, String bankType, String bankRouting, int deletePending) {
		super();
		this.accountID = accountID;
		this.empID = empID;
		this.type = type;
		this.classType = classType;
		this.holderName = holderName;
		this.token = token;
		this.cardType = cardType;
		this.cardExpiry = cardExpiry;
		this.bankType = bankType;
		this.bankRouting = bankRouting;
		this.deletePending = deletePending;
	}
	public DeletedCustomer() {
		super();
	}
	
	

}
