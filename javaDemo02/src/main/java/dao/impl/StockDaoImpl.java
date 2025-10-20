package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.StockDao;
import model.Stock;
import util.DbConn;

public class StockDaoImpl implements StockDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static Connection conn=DbConn.connDb();

	@Override
	public void insert(Stock stock) {
		String sql="insert into stock(stockno,stocknm,lastprice,tradetime)"
				+"values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, stock.getStockno());
			ps.setString(2, stock.getStocknm());
			ps.setBigDecimal(3, stock.getLastprice());
			ps.setString(4, stock.getTradetime());			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	@Override
	public List<Stock> findLatest(String stockno, int limit) {
		String sql="select * from stock where stockno=? ORDER BY createtime DESC LIMIT ?";
		List<Stock> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, stockno);
			ps.setInt(2, limit);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next())
			{
			Stock stock=new Stock();
			stock.setSeq(rs.getInt("seq"));
			stock.setStockno(rs.getString("stockno"));
			stock.setStocknm(rs.getString("stocknm"));
			stock.setLastprice(rs.getBigDecimal("lastprice"));
			stock.setTradetime(rs.getString("tradetime"));
			stock.setCreatetime(rs.getString("createtime"));
			list.add(stock);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return list;
	}

}
