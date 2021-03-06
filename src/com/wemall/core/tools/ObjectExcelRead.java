package com.wemall.core.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ObjectExcelRead {

	/**
	 *
	 * @param startrow
	 * @param startcol
	 * @param sheetnum
	 * @return
	 */
	public static List<Object> readExcel(MultipartFile mFile, int startrow, int startcol, int sheetnum) {
		return readExcelFile(mFile, startrow, startcol, sheetnum);
	}

	/**
	 * @param startrow
	 *            开始行号
	 * @param startcol
	 *            开始列号
	 * @param sheetnum
	 *            sheet
	 * @return
	 */
	private static List<Object> readExcelFile(MultipartFile mFile, int startrow, int startcol, int sheetnum) {
		List<Object> varList = new ArrayList<Object>();
		Workbook wb = null;
		try {

			wb = new HSSFWorkbook(mFile.getInputStream());
		} catch (Exception ex) {
	       try {
			wb  =  new  XSSFWorkbook(mFile.getInputStream());
		} catch (Exception e) {
		
		}
		}
		Sheet sheet = wb.getSheetAt(sheetnum);
		int rowNum = sheet.getLastRowNum() + 1; // 取得最后一行的行号
		for (int i = startrow; i < rowNum; i++) { // 行循环开始
            Map<String, String> varpd = new HashMap<String, String>();
			Row row = sheet.getRow(i); // 行
			int cellNum = row.getLastCellNum(); // 每行的最后一个单元格位置
			for (int j = startcol; j < cellNum; j++) { // 列循环开始
				Cell cell = row.getCell(Short.parseShort(j + ""));
				String cellValue = null;
				if (null != cell) {
                    switch (cell.getCellTypeEnum()) { // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
                    case NUMERIC:// 0
                        cellValue = Double.toString(cell.getNumericCellValue());
						break;
                    case STRING:// 1
						cellValue = cell.getStringCellValue();
						break;
                    // case FORMULA:
                    // cellValue = cell.getNumericCellValue() + "";
                    // // cellValue = String.valueOf(cell.getDateCellValue());
                    // break;
                    case BLANK:// 3
						cellValue = "";
						break;
                    case BOOLEAN:// 4
						cellValue = String.valueOf(cell.getBooleanCellValue());
                    case ERROR:// 5
						cellValue = String.valueOf(cell.getErrorCellValue());
						break;
                    default:
                        cellValue = null;
					}
				} else {
					cellValue = "";
				}
				varpd.put("var" + j, cellValue);
			}
			varList.add(varpd);
		}
		return varList;
	}
}
