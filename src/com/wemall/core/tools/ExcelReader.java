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

/**
 * Excel鏂囦欢瀵煎叆澶勭悊镄勫伐鍏风被(鏆备笉鏀寔Excel 2007镙煎纺镄勬枃浠?.
 *
 * @author Kanine
 */
public class ExcelReader {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 瑙ｆ瀽澶勭悊鎸囧畾璺缎镄别xcel鏂囦欢
     *
     * @param excelFilePath
     *            - excel鏂囦欢镓€鍦ㄨ矾寰?
     * @param firstLineIncluded
     *            - 瑙ｆ瀽鏁版嵁镞舵槸鍚﹀寘鍚琛?
     */
    @SuppressWarnings("unchecked")
    public List<List<Entry>> parse(String excelFilePath, boolean firstLineIncluded) throws FileNotFoundException, IOException {
        final List<String> keys = new ArrayList<String>();
        List<List<Entry>> dataList = new ArrayList<List<Entry>>();

        POIFSFileSystem pss = new POIFSFileSystem(new FileInputStream(excelFilePath));
        HSSFWorkbook workbook = new HSSFWorkbook(pss);
        HSSFSheet sheet = workbook.getSheetAt(0);
        int indexOfFieldName = 0;
        int physicalNumberOfCells = 0;
        /** 棣栬浣滀负镙囬镞讹紝璇诲彇鍒楀悕闇€璺宠绷璇ヨ */
        if (!firstLineIncluded)
            indexOfFieldName = 1;

        HSSFRow rowOfFieldName = sheet.getRow(indexOfFieldName);
        Iterator cit = rowOfFieldName.cellIterator();
        // 璇诲彇鍒楀悕
        while (cit.hasNext()){
            HSSFCell cell = (HSSFCell) cit.next();
            keys.add(cell.getRichStringCellValue().toString());
            physicalNumberOfCells++;
        }

        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        // 阆嶅巻姣忚鏁版嵁
        for (int i = indexOfFieldName + 1; i < physicalNumberOfRows; i++){
            HSSFRow row = sheet.getRow(i);
            Map<String, String> map = new HashMap<String, String>();
            for (int m = 0; m < physicalNumberOfCells; m++){
                HSSFCell cell = row.getCell(m);
                map.put(keys.get(m), match(row, cell, m));
            }
            /**
             * 鐢变簬Map瀛樻斁镄勫璞℃槸镞犲簭镄勶紝闇€閲嶆柊灏嗙粨鏋滈泦鎺掑簭
             */
            List<Entry> data = new ArrayList<Entry>(map.entrySet());
            Collections.sort(data, new Comparator<Entry>(){
                public int compare(Entry o1, Entry o2){
                    return keys.indexOf(o1.getKey()) - keys.indexOf(o2.getKey());
                }
            });
            dataList.add(data);
        }

        return dataList;
    }

    /**
     * 镙规嵁鍗曞厓镙兼牸寮忚繑锲炴纭殑缁撴灉
     *
     * @param row
     *            - 鍗曞厓镙兼墍鍦ㄨ
     * @param cell
     *            - 鍗曞厓镙?
     * @param columnNo
     *            - 鍗曞厓镙兼墍鍦ㄥ垪
     */
    private String match(HSSFRow row, HSSFCell cell, int columnNo){
        String value = "";
        if (cell != null)
            switch (cell.getCellType()){
            case HSSFCell.CELL_TYPE_BLANK:
                value = "";
                break;
            case HSSFCell.CELL_TYPE_ERROR:
                value = "";
                break;
            case HSSFCell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().toString();
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                value = cell.getCellFormula().toString();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                value = Boolean.toString(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)){ // 鏄惁涓烘棩链熷瀷
                    value = sdf.format(cell.getDateCellValue());
                }else{ // 鏄惁涓烘暟链煎瀷
                    double d = cell.getNumericCellValue();
                    if (d - (int) d < Double.MIN_VALUE){ // 鏄惁涓篿nt鍨?
                        value = Integer.toString((int) d);
                    }else{ // 鏄惁涓篸ouble鍨?
                        value = Double.toString(cell.getNumericCellValue());
                    }
                }
                break;
            }

        return value;
    }
}