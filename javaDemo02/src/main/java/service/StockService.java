package service;

import java.util.List;

import model.Stock;

public interface StockService {
	  // 新增（寫入資料庫）
    void addStock(Stock stock);
	
	//R  讀最近幾筆
	List<Stock> getLatest(String stockno, int limit);
}
