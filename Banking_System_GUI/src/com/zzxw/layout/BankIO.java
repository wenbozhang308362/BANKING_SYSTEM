package com.zzxw.layout;
import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class BankIO {
	File file = new File("info.xls");
	Workbook wb=null;
	WritableWorkbook wwb=null;
	
//	Reading Method
	public String[][] readexcel() throws Exception{
		try {
			wb = Workbook.getWorkbook(file);
			Sheet st = wb.getSheet(0);
			int rows = st.getRows();
			String[][] info=new String[rows][];
			for(int i=0;i<rows;i++){
				Cell[] cells=st.getRow(i);
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
		} finally {
			wb.close();
		}
	}
	
//	Writing Method
	public void writeexcel(String[][] info) throws Exception{
		try {
			wwb = Workbook.createWorkbook(file);
			WritableSheet sheet = wwb.createSheet("test sheet 1", 0);
//			System.out.println(info.length);
			for(int i=0;i<info.length;i++){
				for(int j=0;j<info[i].length;j++){
//					System.out.println("j= "+j);
					System.out.println(info[i][j]);
					Label label = new Label(i,j,info[i][j]);
					sheet.addCell(label);
					
				}
			}
		} catch (Exception e) {
//			System.out.println(e);
			// TODO: handle exception
		} finally {
			wwb.write();
			wwb.close();
		}
	}
	
	
	
	public static void main(String[] args) {
		String[][] test={{"1","2"},{"asd","asdfgh"},{"123456","22222"},{"500","1000"}};
//		try {
//			new BankIO().readexcel();
//		} catch (Exception e) {
//			System.out.println(e);
//			// TODO: handle exception
//		}
		try {
			new BankIO().writeexcel(test);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
}
