package cn.edu.sjtu.book.report.data;

import java.math.BigDecimal;
import java.util.Date;

public class DailySale {

	private Date saleDate;
	
	private int num;
	
	private BigDecimal total;
	
	public DailySale() {}
	
	public DailySale(Date saleDate, int num, BigDecimal total) {
		this.saleDate = saleDate;
		this.num = num;
		this.total = total;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
}
