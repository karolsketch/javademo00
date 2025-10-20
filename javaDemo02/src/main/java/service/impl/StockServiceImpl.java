package service.impl;

import java.util.List;

import dao.impl.StockDaoImpl;
import model.Stock;
import service.StockService;

public class StockServiceImpl implements StockService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private StockDaoImpl sdi=new StockDaoImpl();

	@Override
	public List<Stock> getLatest(String stockno, int limit) {
		
		return sdi.findLatest(stockno, limit) ;
	}

	@Override
	public void addStock(Stock stock) {
		sdi.insert(stock);
		
	}
	
}
