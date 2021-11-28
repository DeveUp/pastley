package com.pastley.models.model;

import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import com.pastley.util.PastleyDate;
import com.pastley.util.PastleyValidate;

import java.io.Serializable;

public class Buy implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Provider provider;
	private BigInteger totalNet;
	private BigInteger totalGross;
	private boolean statu;
	private String dateRegister;
	private String dateUpdate;
	private LocalDate dateWithoutTime;
	
	private List<BuyDetail> details;
	
	public Buy() {
		totalNet = BigInteger.ZERO;
		totalGross = BigInteger.ZERO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buy other = (Buy) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public LocalDate getDateWithoutTime() {
		dateWithoutTime = LocalDate.now();
		PastleyDate date = new PastleyDate();
		try {
			dateWithoutTime = PastleyDate.convertToLocalDate(date.convertToDate(dateRegister));
		} catch (ParseException e) {
		}
		return dateWithoutTime;
	}
	
	public void calculate() {
		totalNet = BigInteger.ZERO;
		totalGross = BigInteger.ZERO;
		calculateTotal();
	}

	public BigInteger calculateTotal() {
		if (!PastleyValidate.isList(details))
			return BigInteger.ZERO;
		BigInteger value = BigInteger.ZERO;
		for (BuyDetail bt : details) {
			bt.calculate();
			if (PastleyValidate.bigIntegerHigherZero(bt.getSubtotalNet()))
				totalNet = totalNet.add(bt.getSubtotalNet());
			if(PastleyValidate.bigIntegerHigherZero(bt.getSubtotalGross()))
				totalGross = totalGross.add(bt.getSubtotalGross());
		}
		return value;
	}
	
	public void setDateWithoutTime(LocalDate dateWithoutTime) {
		this.dateWithoutTime = dateWithoutTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<BuyDetail> getDetails() {
		return details;
	}

	public void setDetails(List<BuyDetail> details) {
		this.details = details;
	}

	public BigInteger getTotalNet() {
		return totalNet;
	}

	public void setTotalNet(BigInteger totalNet) {
		this.totalNet = totalNet;
	}

	public BigInteger getTotalGross() {
		return totalGross;
	}

	public void setTotalGross(BigInteger totalGross) {
		this.totalGross = totalGross;
	}

	public boolean isStatu() {
		return statu;
	}

	public void setStatu(boolean statu) {
		this.statu = statu;
	}

	public String getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(String dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
