package com.zzxw.layout;
import java.io.FileInputStream;
import java.io.InputStream;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class BankIO {
	String[][] allin;

	public String[][] readexcel(String filePath){
		try {
			InputStream is = new FileInputStream(filePath);
			Workbook wb = Workbook.getWorkbook(is);
			Sheet st = wb.getSheet(0);
			int rows = st.getRows();
			String[][] info=new String[rows][];
			for(int i=0;i<rows;i++){
				Cell[] cells=st.getRow(i);
//				System.out.println(cells[0].getContents().trim());
//				System.out.println(cells.length);
				info[i]=new String[4];
				for(int j=0;j<cells.length;j++){
					info[i][j]=cells[j].getContents().trim();
					System.out.println(info[i][j]);
				}
			}
			return info;
			
		} catch (Exception e) {
			System.out.println(e);
			String[][] info=new String[0][];
			return info;
			
		}	
	}
	
	public static void main(String[] args) {
		new BankIO().readexcel("info.xls");
	}
}
