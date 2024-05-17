package miniproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
 
public class Excel {
	/*public void excelsheet(String alert1,String alert2,String title) {
	try {
		File file2 =new File(System.getProperty("user.dir")+"\\output\\outputdata.xlsx");
        FileOutputStream file = new FileOutputStream(file2);
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet();
        XSSFRow r1 = sheet.createRow(0);
        XSSFRow r2 = sheet.createRow(1);
        r1.createCell(1).setCellValue("First Alert Text");
        r1.createCell(2).setCellValue("Second Alert Text");
        r1.createCell(3).setCellValue("The New Tab Title");
        r2.createCell(1).setCellValue(alert1);
        r2.createCell(2).setCellValue(alert2);
        r2.createCell(3).setCellValue(title);
        System.out.println("data entered into excel");
        workbook.write(file);
        workbook.close();
        file.close();
      } 
		catch (IOException e) {
    	  e.printStackTrace();
      }
	}*/
	public static File file2;
	public static FileOutputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow r1;
 
	public static void excelInit() throws FileNotFoundException {
		file2 = new File(System.getProperty("user.dir") + "\\ExcelData\\outputdata4.xlsx");
		file = new FileOutputStream(file2);
		workbook = new XSSFWorkbook();
 
	}
 
	public static XSSFSheet CreateSheet(String name) {
		sheet = workbook.createSheet(name);
		return sheet;
	}
 
	public static XSSFRow createRow(int j, XSSFSheet sheet1) {
		return sheet1.createRow(j);
	}
 
	public static void setData(XSSFRow r1, int j, String data) {
		r1.createCell(j).setCellValue(data);
	}
	public static void setDataForHealth(List<WebElement> li)
	{
		XSSFSheet k1=CreateSheet("HealthInsurance");
		for(int i=1;i<li.size();i++)
		{
			XSSFRow r1=createRow(i,k1);
			setData(r1,1,li.get(i).getText());
		}
	}
	public static void closeExcel() throws IOException {
		workbook.write(file);
		workbook.close();
		file.close();
	}

}
