package model;

import java.math.BigDecimal;

public class Stock {
	private Integer seq;
	private String stockno;
	private String stocknm;
	//private BigDecimal realprice;
	private BigDecimal lastprice;
	private String tradetime;
	private String createtime;
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(String stockno, String stocknm, BigDecimal lastprice, String tradetime, String createtime) {
		super();
		this.stockno = stockno;
		this.stocknm = stocknm;
		//this.lastprice = realprice;
		this.lastprice = lastprice;
		this.tradetime = tradetime;
		this.createtime = createtime;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(int i) {
		this.seq = i;
	}

	public String getStockno() {
		return stockno;
	}

	public void setStockno(String stockno) {
		this.stockno = stockno;
	}

	public String getStocknm() {
		return stocknm;
	}

	public void setStocknm(String stocknm) {
		this.stocknm = stocknm;
	}
	/*
	public BigDecimal getRealprice() {
		return realprice;
	}

	public void setRealprice(BigDecimal realprice) {
		this.realprice = realprice;
	}
	
*/
	public BigDecimal getLastprice() {
		return lastprice;
	}

	public void setLastprice(BigDecimal lastprice) {
		this.lastprice = lastprice;
	}

	public String getTradetime() {
		return tradetime;
	}

	public void setTradetime(String tradetime) {
		this.tradetime = tradetime;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	
	

}
