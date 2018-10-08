package first.sample.pgm;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class excel {
	
		public static void main(String[] args) {
			
			String sExcelfile,sSheet,sValue;
			
			sExcelfile = "C:\\Users\\Suresh M\\Desktop\\Book1.xlsx";
			sSheet = "Sheet1";
			
			
			//sValue=Read_Cell_Value_From_Excel(sExcelfile,sSheet,0,0);
			
			
			
			//System.out.println(sValue);
		
			
			
			Read_All_Values_From_Excel(sExcelfile, sSheet);

		}
		
		public static String Read_Cell_Value_From_Excel(String sFile,String sSheet,int iRow,int iCell){
			
			InputStream oFile;
			XSSFWorkbook oExcel ;
			XSSFSheet oSheet ;
			Row oRow ;
			Cell oCell ;
			
			String sVal;
			try 
			{
				
				 oFile = new FileInputStream(sFile);
				 oExcel = new XSSFWorkbook(oFile);
				 oSheet = oExcel.getSheet(sSheet);
				 oRow = oSheet.getRow(iRow);
				 oCell = oRow.getCell(iCell);
				
				sVal =oCell.getStringCellValue();
				oExcel.close();
				oFile.close();
				return sVal;
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return "Pass";
		}
		
	@SuppressWarnings("deprecation")
	public static void Read_All_Values_From_Excel(String sFile,String sSheet){
			
			InputStream oFile;
			XSSFWorkbook oExcel ;
			XSSFSheet oSheet ;
			Row oRow ;
			Cell oCell ;
			int iRow,iTotalRow,iCell,iTotalCell,iCellType,iValue;
					
			//String sVal;
			try 
			{
				
				 oFile = new FileInputStream(sFile);
				 oExcel = new XSSFWorkbook(oFile);
				 
				 oSheet = oExcel.getSheet(sSheet);
				 
				 iTotalRow = oSheet .getLastRowNum();
				 System.out.println("Total Row is : "+iTotalRow);
				 for(iRow =0 ;iRow<=iTotalRow;iRow++)
				 {
					 oRow =oSheet.getRow(iRow);
					 iTotalCell = oRow.getLastCellNum();
					 
					 System.out.println(iTotalCell);
					 
					 for(iCell=0;iCell<iTotalCell;iCell++)
					 {
						 oCell = oRow.getCell(iCell);
					
						 iCellType = oCell.getCellType();
						 
						 switch (iCellType) {
						case 0:
							System.out.print(oCell.getNumericCellValue());
							break;
						case 1:
							System.out.print(oCell.getStringCellValue());
							break;
						case 4:
							System.out.print(oCell.getBooleanCellValue());
							break;

						default:
							System.out.print("----");
							
							break;
						}
						 
						 System.out.print(" ");
					 }
				
				System.out.println("\n");
					 
					 
				 }
				 
				
				oExcel.close();
				oFile.close();
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	



	}


