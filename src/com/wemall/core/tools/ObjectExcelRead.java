package com.wemall.core.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class ObjectExcelRead {

    private static Logger logger = LoggerFactory.getLogger(ObjectExcelRead.class);

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
	 *            寮€濮嬭鍙?
	 * @param startcol
	 *            寮€濮嫔垪鍙?
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
		int rowNum = sheet.getLastRowNum() + 1; // 鍙栧缑链€鍚庝竴琛岀殑琛屽佛
		for (int i = startrow; i < rowNum; i++) { // 琛屽惊鐜紑濮?
			HashMap varpd = new HashMap();
			Row row = sheet.getRow(i); // 琛?
			int cellNum = row.getLastCellNum(); // 姣忚镄勬渶鍚庝竴涓崟鍏冩牸浣岖疆
			for (int j = startcol; j < cellNum; j++) { // 鍒楀惊鐜紑濮?
				Cell cell = row.getCell(Short.parseShort(j + ""));
				String cellValue = null;
				if (null != cell) {
					switch (cell.getCellType()) { // 鍒ゆ柇excel鍗曞厓镙煎唴瀹圭殑镙煎纺锛屽苟瀵瑰叾杩涜杞崲锛屼互渚挎彃鍏ユ暟鎹簱
					case 0:
						cellValue = String.valueOf((int) cell.getNumericCellValue());
						break;
					case 1:
						cellValue = cell.getStringCellValue();
						break;
					case 2:
						cellValue = cell.getNumericCellValue() + "";
						// cellValue = String.valueOf(cell.getDateCellValue());
						break;
					case 3:
						cellValue = "";
						break;
					case 4:
						cellValue = String.valueOf(cell.getBooleanCellValue());
						break;
					case 5:
						cellValue = String.valueOf(cell.getErrorCellValue());
						break;
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
