package ui;
import model.Stock;
import service.StockService;
import service.impl.StockServiceImpl;
import util.StockApiFetcher;

import java.util.Scanner;
import java.util.concurrent.*;

public class ApiTest {

	public static void main(String[] args) {
        StockApiFetcher fetcher = new StockApiFetcher();
        StockService svc = new StockServiceImpl(); // 請確保 addStock() 或 insert() 可用

        Scanner sc = new Scanner(System.in);
        System.out.print("輸入股票代號（例如 2330），或 exit 離開：");
        String code = sc.nextLine().trim();
        if (code.equalsIgnoreCase("exit")) return;
        String market = "tse"; // 預設上市

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable job = () -> {
            try {
                Stock stock = fetcher.fetch(code, market);
                if (stock == null) {
                    System.out.println("[" + java.time.LocalTime.now() + "] 無資料 for " + code);
                    return;
                }
                System.out.println("[" + java.time.LocalTime.now() + "] 抓到: " + stock);
                // 存入 DB
                svc.addStock(stock); // 請對應你的 service 方法名稱
                System.out.println(" -> 已寫入 DB");
            } catch (Exception e) {
                System.err.println("錯誤: " + e.getMessage());
            }
        };

        // 立刻執行一次，之後每 5 秒執行（示範用，實務建議 >=5s）
        scheduler.scheduleAtFixedRate(job, 0, 30, TimeUnit.SECONDS);

        System.out.println("輸入 stop 停止，exit 結束程式");
        while (true) {
            String cmd = sc.nextLine().trim();
            if (cmd.equalsIgnoreCase("stop")) {
                scheduler.shutdownNow();
                System.out.println("已停止自動抓取。");
            } else if (cmd.equalsIgnoreCase("exit")) {
                scheduler.shutdownNow();
                System.out.println("結束程式。");
                System.exit(0);
            }
        }
    }

}
