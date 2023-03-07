package mailVerification.genericLb;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcellUtility {
	
	public Object[][] readDataFromExcell(String sheetName) throws Throwable, IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/data.XLSX");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][] objarr= new Object[lastrow][lastcell];
		for(int i=0; i<lastrow; i++)
		{
			for(int j=0; j<lastcell; j++)
			{
				objarr[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return objarr;
		
		
	}
	
//	public Object[][] getData()
//	{
//		Object[][] objarr= new Object[2][2];
//		objarr[0][0]="dalwin.barnard@protonmail.com";
//		objarr[0][1]="Dalwin@123";
//		objarr[1][0]="harry.barnard@protonmail.com";
//		objarr[1][1]="Dalwin@123";
//		return objarr;
//		
//	}
//	
	

}
