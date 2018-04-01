package com.wemall.core.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

/**
 * Excel文件导入处理的工具类(暂不支持Excel 2007格式的文件).
 *
 * @author Kanine
 */
public class ExcelReader {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 解析处理指定路径的excel文件
     *
     * @param excelFilePath - excel文件所在路径
     * @param firstLineIncluded - 解析数据时是否包含首行
     */
    public List<List<Entry<String, String>>> parse(String excelFilePath, boolean firstLineIncluded)
            throws FileNotFoundException, IOException {
        final List<String> keys = new ArrayList<String>();
        List<List<Entry<String, String>>> dataList = new ArrayList<List<Entry<String, String>>>();

        POIFSFileSystem pss = new POIFSFileSystem(new FileInputStream(excelFilePath));
        HSSFWorkbook workbook = null;
        try {
            workbook = new HSSFWorkbook(pss);
            HSSFSheet sheet = workbook.getSheetAt(0);
            int indexOfFieldName = 0;
            int physicalNumberOfCells = 0;
            /** 首行作为标题时，读取列名需跳过该行 */
            if (!firstLineIncluded)
                indexOfFieldName = 1;

            HSSFRow rowOfFieldName = sheet.getRow(indexOfFieldName);
            Iterator<Cell> cit = rowOfFieldName.cellIterator();
            // 读取列名
            while (cit.hasNext()) {
                HSSFCell cell = (HSSFCell) cit.next();
                keys.add(cell.getRichStringCellValue().toString());
                physicalNumberOfCells++;
            }

            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            // 遍历每行数据
            for (int i = indexOfFieldName + 1; i < physicalNumberOfRows; i++) {
                HSSFRow row = sheet.getRow(i);
                Map<String, String> map = new HashMap<String, String>();
                for (int m = 0; m < physicalNumberOfCells; m++) {
                    HSSFCell cell = row.getCell(m);
                    map.put(keys.get(m), match(row, cell, m));
                }
                /**
                 * 由于Map存放的对象是无序的，需重新将结果集排序
                 */
                List<Entry<String, String>> data = new ArrayList<Entry<String, String>>(map.entrySet());
                Collections.sort(data, new Comparator<Entry<String, String>>() {
                    public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                        return keys.indexOf(o1.getKey()) - keys.indexOf(o2.getKey());
                    }
                });
                dataList.add(data);
            }
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
        return dataList;
    }

    /**
     * 根据单元格格式返回正确的结果
     *
     * @param row - 单元格所在行
     * @param cell - 单元格
     * @param columnNo - 单元格所在列
     */
    private String match(HSSFRow row, HSSFCell cell, int columnNo) {
        String value = "";
        if (cell != null)
            switch (cell.getCellTypeEnum()) {
            case BLANK:
                value = "";
                break;
            case ERROR:
                value = "";
                break;
            case STRING:
                value = cell.getRichStringCellValue().toString();
                break;
            case FORMULA:
                value = cell.getCellFormula().toString();
                break;
            case BOOLEAN:
                value = Boolean.toString(cell.getBooleanCellValue());
                break;
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) { // 是否为日期型
                    value = sdf.format(cell.getDateCellValue());
                } else { // 是否为数值型
                    double d = cell.getNumericCellValue();
                    if (d - (int) d < Double.MIN_VALUE) { // 是否为int型
                        value = Integer.toString((int) d);
                    } else { // 是否为double型
                        value = Double.toString(cell.getNumericCellValue());
                    }
                }
                break;
            default:

            }

        return value;
    }
}