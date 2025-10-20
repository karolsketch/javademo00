package ui;

import java.math.BigDecimal;
import java.util.List;

import model.Stock;
import service.StockService;
import service.impl.StockServiceImpl;
import dao.StockDao;
import dao.impl.StockDaoImpl;

public class InsertTest {

	 public static void main(String[] args) throws Exception {
	        // 先嘗試建表（如果你有單獨建表程式可跳過）
	        // new StockDaoImpl().createTableIfNotExists(); // 如果你有此方法

	        // 測試插入
	        Stock s = new Stock();
	        s.setStockno("2330");
	        s.setStocknm("台積電");
	        s.setLastprice(new BigDecimal("830.50"));
	        s.setTradetime("09:10:00");

	        StockDao dao = new StockDaoImpl();
	        dao.insert(s);
	        System.out.println("Inserted one row.");

	        // 測試 service 取得最近資料
	        StockService svc = new StockServiceImpl();
	        List<Stock> list = svc.getLatest("2330", 5);
	        System.out.println("最近資料數: " + list.size());
	        for (Stock item : list) {
	            System.out.println(item);
	        }
	    }

}
