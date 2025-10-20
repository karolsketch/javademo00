package util;

import com.google.gson.*;
import model.Stock;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

public class StockApiFetcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 private static final String BASE = "https://mis.twse.com.tw/stock/api/getStockInfo.jsp";
	    private final HttpClient client = HttpClient.newHttpClient();

	    // 抓一支股票，market = "tse" or "otc"
	    public Stock fetch(String stockno, String market) throws Exception {
	        String exCh = market.toLowerCase(Locale.ROOT) + "_" + stockno + ".tw";
	        String url = BASE + "?ex_ch=" + exCh + "&json=1&delay=0&lang=zh_tw";
	        HttpRequest req = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .header("User-Agent", "Java HttpClient")
	                .GET()
	                .build();

	        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
	        if (resp.statusCode() != 200) throw new RuntimeException("HTTP " + resp.statusCode());

	        String body = resp.body();
	        JsonElement je = JsonParser.parseString(body);
	        if (!je.isJsonObject()) return null;
	        JsonObject root = je.getAsJsonObject();
	        if (!root.has("msgArray")) return null;
	        JsonArray arr = root.getAsJsonArray("msgArray");
	        if (arr.size() == 0) return null;
	        JsonObject s = arr.get(0).getAsJsonObject();

	        // 只取你要的欄位
	        String c = getStr(s, "c"); // 股票代號
	        String n = getStr(s, "n"); // 名稱
	        String z = getStr(s, "z"); // 最新價 (可能為 "-" 或 null)
	        String t = getStr(s, "t"); // 成交時間

	        BigDecimal lastprice = parseBigDecimal(z);

	        Stock stock = new Stock();
	        stock.setStockno(c);
	        stock.setStocknm(n);
	        stock.setLastprice(lastprice);
	        stock.setTradetime(t);

	        return stock;
	    }

	    private String getStr(JsonObject o, String key) {
	        try {
	            if (!o.has(key)) return null;
	            String s = o.get(key).getAsString();
	            if (s == null || s.isBlank() || s.equals("-")) return null;
	            return s;
	        } catch (Exception e) {
	            return null;
	        }
	    }

	    private BigDecimal parseBigDecimal(String s) {
	        try {
	            if (s == null) return null;
	            s = s.replaceAll(",", "");
	            return new BigDecimal(s);
	        } catch (Exception e) {
	            return null;
	        }
	    }
	

}
