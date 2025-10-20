package dao;

import java.util.List;

import model.Stock;

public interface StockDao {
	
	
	//C 寫入資料庫
	void insert(Stock stock);
	
	//R 找最近幾筆
	List<Stock> findLatest(String stockno, int limit);
	
	
	//U
	
	
	//D

}
