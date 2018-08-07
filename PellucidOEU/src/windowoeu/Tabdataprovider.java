package windowoeu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Tabdataprovider {
	public Object[][] data=null;
	public Object[][] lockdata=null;
	public Object[][] notinterdata=null;
	
	//Input data read data
	@DataProvider(name="headf")
	public Object[][] readheaddata() throws IOException
	{
		FileInputStream fi=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"Tabendinput"+File.separator+"Mobilityhead.xlsx"));
		XSSFWorkbook work=new XSSFWorkbook(fi);
		XSSFSheet sheet=work.getSheet("Head");
		int r=sheet.getLastRowNum()+1;
		System.out.println(r);
		int c=sheet.getRow(1).getLastCellNum();
		System.out.println(c);
		data=new Object[r-1][c];
		for(int i=1;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				int ce=sheet.getRow(i).getCell(j).getCellType();
				if(ce==Cell.CELL_TYPE_STRING)
				{
					data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}else if (ce==Cell.CELL_TYPE_NUMERIC) {
					DataFormatter form=new DataFormatter();
					Cell cel=sheet.getRow(i).getCell(j);
					data[i-1][j]=form.formatCellValue(cel).toString();
				}
			}
		}		
		return data;	
	}
	@DataProvider(name="members")
	public Object[][] membersfamilydata() throws IOException
	{
		FileInputStream fi=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"Tabendinput"+File.separator+"Mobilityhead.xlsx"));
		XSSFWorkbook work=new XSSFWorkbook(fi);
		XSSFSheet sheet=work.getSheet("Familydetails");
		int r=sheet.getLastRowNum()+1;
		System.out.println(r);
		int c=sheet.getRow(2).getLastCellNum();
		System.out.println(c);
		data=new Object[r-1][c];
		for(int i=1;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				int ce=sheet.getRow(i).getCell(j).getCellType();
				if(ce==Cell.CELL_TYPE_STRING)
				{
					data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}else if (ce==Cell.CELL_TYPE_NUMERIC) {
					DataFormatter form=new DataFormatter();
					Cell cel=sheet.getRow(i).getCell(j);
					data[i-1][j]=form.formatCellValue(cel).toString();
				}
			}
		}		
		return data;	
	}

	@DataProvider(name="lockreg")
	public Object[][] readlockeddata() throws IOException
	{
		FileInputStream fi=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"Tabendinput"+File.separator+"Mobilityhead.xlsx"));
		XSSFWorkbook work=new XSSFWorkbook(fi);
		XSSFSheet sheet=work.getSheet("Locked");
		int r=sheet.getLastRowNum()+1;
		System.out.println(r);
		int c=sheet.getRow(1).getLastCellNum();
		System.out.println(c);
		lockdata=new Object[r-1][c];
		for(int i=1;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				int ce=sheet.getRow(i).getCell(j).getCellType();
				if(ce==Cell.CELL_TYPE_STRING)
				{
					lockdata[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}else if (ce==Cell.CELL_TYPE_NUMERIC) {
					DataFormatter form=new DataFormatter();
					Cell cel=sheet.getRow(i).getCell(j);
					lockdata[i-1][j]=form.formatCellValue(cel).toString();
				}
			}
		}		
		return lockdata;	
	}
	@DataProvider(name="notinerest")
	public Object[][] readnotinteresteddata() throws IOException
	{
		FileInputStream fi=new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"Tabendinput"+File.separator+"Mobilityhead.xlsx"));
		XSSFWorkbook work=new XSSFWorkbook(fi);
		XSSFSheet sheet=work.getSheet("Not interested");
		int r=sheet.getLastRowNum()+1;
		System.out.println(r);
		int c=sheet.getRow(1).getLastCellNum();
		System.out.println(c);
		notinterdata=new Object[r-1][c];
		for(int i=1;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				int ce=sheet.getRow(i).getCell(j).getCellType();
				if(ce==Cell.CELL_TYPE_STRING)
				{
					notinterdata[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}else if (ce==Cell.CELL_TYPE_NUMERIC) {
					DataFormatter form=new DataFormatter();
					Cell cel=sheet.getRow(i).getCell(j);
					notinterdata[i-1][j]=form.formatCellValue(cel).toString();
				}
			}
		}		
		return notinterdata;	
	}
}
