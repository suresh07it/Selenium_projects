package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String sExcelfile, sSheet, sValue;

		sExcelfile = "C:\\Users\\Suresh M\\eclipse_workspace_oxygen\\Flipkart\\src\\main\\java\\testdata\\Products.xlsx";
		sSheet = "search";

		// sValue=Read_Cell_Value_From_Excel(sExcelfile,sSheet,0,0);

		// System.out.println(sValue);

		// Read_All_Values_From_Excel(sExcelfile, sSheet);

	}

	public static List<String> readAllValuesFromExcel(String sFile, String sSheet) {
		List<String> list = new ArrayList<String>();

		InputStream oFile;
		XSSFWorkbook oExcel;
		XSSFSheet oSheet;
		Row oRow;
		Cell oCell;
		int iRow, iTotalRow, iCell, iTotalCell, iCellType, iValue;

		// String sVal;
		try {

			oFile = new FileInputStream(sFile);
			oExcel = new XSSFWorkbook(oFile);

			oSheet = oExcel.getSheet(sSheet);

			iTotalRow = oSheet.getLastRowNum();
			System.out.println("Total Row is : " + iTotalRow);
			for (iRow = 0; iRow <= iTotalRow; iRow++) {
				oRow = oSheet.getRow(iRow);
				iTotalCell = oRow.getLastCellNum();

				for (iCell = 0; iCell < iTotalCell; iCell++) {
					oCell = oRow.getCell(iCell);

					iCellType = oCell.getCellType();

					switch (iCellType) {
					case 0:
						list.add(String.valueOf(oCell.getNumericCellValue()));
						break;
					case 1:
						list.add(oCell.getStringCellValue());
						break;
					case 4:
						list.add(String.valueOf(oCell.getBooleanCellValue()));
						break;

					default:
						break;
					}

				}

			}

			// oExcel
			oFile.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
