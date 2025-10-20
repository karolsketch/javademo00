/*
 * 1.FileOutputStream(寫入檔案) , FileInputStream(讀取檔案)
 * 
 * 
 * 2.HSSFWorkbook excelBook=new HSSFWorkbook(fis);-->產生excel物件
 * 3.HSSFSheet sheet=excelBook.getSheet(sheetName);-->產生工作表
 * 
 * ->int count=sheet.getPhysicalNumberOfRows();-->讀取目前工作表有內容的列數
 * 
 * 4.HSSFRow row=sheet.createRow(count);-->寫入第幾列
 * 5.row.createCell(0).setCellValue(name);-->同一列的儲存格位置
 *
 * 
 */

package ApiEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


//資料寫入
public class CreateExcel {

	public static void main(String[] args) {
		
		//CreateExcel.createExcelFile("Test.xls", "員工資料表");
		
		try {
			FileInputStream fis=new FileInputStream("Test.xls");
			HSSFWorkbook excelBook=new HSSFWorkbook(fis);
			HSSFSheet sheet=excelBook.getSheet("員工資料表");
			int count=sheet.getPhysicalNumberOfRows();
			System.out.println(count);
			
			HSSFRow row=sheet.createRow(count);
			row.createCell(0).setCellValue("004");
			row.createCell(1).setCellValue("abc");
			row.createCell(2).setCellValue("台北市");
			row.createCell(3).setCellValue("00000");
			
			FileOutputStream fos=new FileOutputStream("Test.xls");
			
			excelBook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	public static void inserValue()
	{
		
	}
	
	public static void createExcelFile(String excelFilename,String sheetName)
	{
		try {
			FileOutputStream excelFile=new FileOutputStream(excelFilename);
			HSSFWorkbook excelBook=new HSSFWorkbook();
			HSSFSheet sheet=excelBook.createSheet(sheetName);
			
			HSSFRow row=sheet.createRow(0);
			row.createCell(0).setCellValue("員工編號");
			row.createCell(1).setCellValue("員工姓名");
			row.createCell(2).setCellValue("員工地址");
			row.createCell(3).setCellValue("員工電話");
			
			excelBook.write(excelFile);
			excelFile.flush();
			excelFile.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
/*
開啟舊檔
指定物件
寫入的sheet
算有幾筆
算格子填回去
輸出
接物件導向 靜態class
*/
/************************************************************************/
/*
// 測試沒問題method
public class CreateExcel {
	public static void main(String[] args) {
		CreateExcel.createExcelFile("Test.xls", "測試1");
	}
	


//method 把測試成功的貼到裡面

public static void createExcelFile(String excelFilename, String sheetName) 
{
	try {
		FileOutputStream excelFile=new FileOutputStream(excelFilename); //改變數
		HSSFWorkbook excelBook=new HSSFWorkbook();
		HSSFSheet sheet=excelBook.createSheet(sheetName); //改變數
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("員工編號"); // 第一格
		row.createCell(1).setCellValue("員工姓名");
		row.createCell(2).setCellValue("員工地址");
		row.createCell(3).setCellValue("員工電話");
		
		
		excelBook.write(excelFile);
		excelFile.flush();
		excelFile.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

*/


/************************************************************************/



/*
public class CreateExcel {

	public static void main(String[] args) {
		try {
			FileOutputStream excelFile=new FileOutputStream("ex1.xls");
			HSSFWorkbook excelBook=new HSSFWorkbook();
			HSSFSheet sheet=excelBook.createSheet("薪資表");
			HSSFRow row=sheet.createRow(0);
			row.createCell(0).setCellValue("員工編號");
			row.createCell(1).setCellValue("員工姓名");
			row.createCell(2).setCellValue("員工地址");
			row.createCell(3).setCellValue("員工電話");
			
			
			excelBook.write(excelFile);
			excelFile.flush();
			excelFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
*/

//output是寫入
//第一列編號從 0開始 0是標列