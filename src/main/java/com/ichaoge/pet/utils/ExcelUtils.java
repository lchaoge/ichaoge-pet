package com.ichaoge.pet.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by HiboVan of Retail Technology co.,ltd on 2016/4/13.
 */
public class ExcelUtils {

    private static final Logger logger = LoggerFactory.getLogger("purchase-order");


    //TODO
    //resolve 解析excel   XLS
    public static List<List<String>> resolveExcel(InputStream in) {
        try {
//            InputStream in = Thread.currentThread().getContextClassLoader()
//                    .getResourceAsStream(excelName + ".xls");
//            File f = new File("D:/aaaa.xls");
//            InputStream in = new FileInputStream(f);

            HSSFWorkbook workbook = new HSSFWorkbook(in);// 创建一个Excel文件
            List<List<String>> listAll = new ArrayList<List<String>>();
//            int sheetNum = workbook.getNumberOfSheets();
            //页
            for (int j = 0; j < 1; j++) {

                HSSFSheet sheet = workbook.getSheetAt(j);
                int lastRowNum = sheet.getLastRowNum();
                HSSFRow row0 = sheet.getRow(0);//1=====key
                if(row0==null)
                    return null;
                int firstNum = row0.getLastCellNum();
                //行
                for (int k = 0; k <= lastRowNum; k++) {
//                    String sheetName = sheet.getSheetName();
                    HSSFRow row1 = sheet.getRow(k);//1=====key
                    int nu = row1.getLastCellNum();// 获取单元格中指定列对象
                    List<String> listRow = new ArrayList<String>();
                    //列
                    for (int i = 0; i < firstNum; i++) {
                        HSSFCell cell = row1.getCell(i);
                        if (cell != null ) {
                            if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (StringUtils.isNotBlank(cell.getStringCellValue())) {
                                    listRow.add(cell.getStringCellValue());
                                } else {
                                    listRow.add("");// place_hold
                                }
                            }
                            if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                if(HSSFDateUtil.isCellDateFormatted(cell)) {
                                    SimpleDateFormat sdf = new SimpleDateFormat(cell.getCellStyle().getDataFormatString());
                                    String cellDateStr = sdf.format(cell.getDateCellValue());
                                    listRow.add(cellDateStr);
                                } else {
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    listRow.add(cell.getStringCellValue());
                                }
                            }
                        }else {
                            listRow.add("");//  place_hold
                        }
                    }

                    Boolean blag = false;
                    for (Iterator<String> iterator = listRow.iterator(); iterator.hasNext(); ) {
                        String next = iterator.next();
                        if ( !"0".equals(next) || !"".equals(next))
                            blag = true;
                    }
                    //如果所有的值都为“”或者“0”，则不添加
                    if (nu > 0 && blag)
                        listAll.add(listRow);
                }
            }
//            System.out.println(listAll);
            return listAll;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return null;
        }

    }

    //TODO
    public static List<List<String>> resolveExcelXlsx(InputStream in) {
        try {
//            InputStream in = Thread.currentThread().getContextClassLoader()
//                    .getResourceAsStream(excelName + ".xls");
//            File f = new File("D:/aaaa.xls");
//            InputStream in = new FileInputStream(f);

            XSSFWorkbook workbook = new XSSFWorkbook(in);// 创建一个Excel文件
            List<List<String>> listAll = new ArrayList<List<String>>();
//            int sheetNum = workbook.getNumberOfSheets();
            //页
            for (int j = 0; j < 1; j++) {

                XSSFSheet sheet = workbook.getSheetAt(j);
                int lastRowNum = sheet.getLastRowNum();
                XSSFRow row0 = sheet.getRow(0);//1=====key
                if(row0==null)
                    return null;
                int firstNum = row0.getLastCellNum();
                //行
                for (int k = 0; k <= lastRowNum; k++) {
//                    String sheetName = sheet.getSheetName();
                    XSSFRow row1 = sheet.getRow(k);//1=====key
                    int nu = row1.getLastCellNum();// 获取单元格中指定列对象
                    List<String> listRow = new ArrayList<String>();
//                    if (nu > 0)
//                        listAll.add(listRow);
                    //列
                    for (int i = 0; i < firstNum; i++) {
                        XSSFCell cell = row1.getCell(i);
                        if (cell != null ) {
                            if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                if (StringUtils.isNotBlank(cell.getStringCellValue())) {
                                    listRow.add(cell.getStringCellValue());
                                }else {
                                    listRow.add("");// place_hold
                                }
                            }
                            if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                if(HSSFDateUtil.isCellDateFormatted(cell)) {
                                    SimpleDateFormat sdf = new SimpleDateFormat(cell.getCellStyle().getDataFormatString());
                                    String cellDateStr = sdf.format(cell.getDateCellValue());
                                    listRow.add(cellDateStr);
                                } else {
                                    listRow.add(cell.getRawValue());
                                }
                            }
                        }else {
                            listRow.add("");//  place_hold
                        }
                    }

                    Boolean blag = false;
                    for (Iterator<String> iterator = listRow.iterator(); iterator.hasNext(); ) {
                        String next = iterator.next();
                        if ( !"0".equals(next) || !"".equals(next))
                            blag = true;
                    }

                    //如果所有的值都为“”或者“0”，则不添加
                    if (nu > 0 && blag)
                        listAll.add(listRow);
                }
            }
//            System.out.println(listAll);
            return listAll;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return null;
        }

    }

    //TODO
    public static OutputStream exportExcel(Map<String,String> headersMap, List<Map<String,Object>> values ,OutputStream os,String[] sheetName,String listName) {

        String[] headers = new String[]{};


        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        int length = sheetName.length;
        for (int i = 0; i < length; i++) {
            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet(sheetName[i]);
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth(15);
            // 生成一个样式

            // 声明一个画图的顶级管理器
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

            //产生表格标题行
            HSSFRow row = sheet.createRow(0);
            //-------------------------------
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth(15);
            // 生成一个样式
            HSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
            HSSFFont font = workbook.createFont();
            font.setColor(HSSFColor.VIOLET.index);
            font.setFontHeightInPoints((short) 15);
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setFontName("宋体");
            // 把字体应用到当前的样式
            style.setFont(font);
            // 生成并设置另一个样式
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
            // 生成另一个字体
            HSSFFont font2 = workbook.createFont();
            font2.setFontName("宋体");
            font2.setFontHeightInPoints((short) 14);
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            // 把字体应用到当前的样式
            style2.setFont(font2);

            if (headers.length == 0){
                Map<String, Object> dataset = values.get(0);
                int k = 0;
                for (Map.Entry<String, Object> entry:dataset.entrySet() ){
                    String key = entry.getKey();
                    String headValue = headersMap.get(key);
                    Object value = entry.getValue();
                    if (!(value instanceof  List)){
//                        System.out.println(headValue);
                        HSSFCell cell = row.createCell(k);
//                        HSSFRichTextString text = new HSSFRichTextString(headValue);
//                        cell.setCellStyle(style);
                        cell.setCellValue(headValue +"");
//                        cell.setCellValue(headValue +":"+key);
                        k++;
                    }
                }
                Map<String,Object> odsRepZvekpos =((List<Map<String,Object>>)dataset.get(listName)).get(0);
                for (Map.Entry<String, Object> subentry:odsRepZvekpos.entrySet() ){
                    String key = subentry.getKey();
                    Object value = subentry.getValue();
                    if (!(value instanceof  List)){
                        String headValue = headersMap.get(key);
                        HSSFCell cell = row.createCell(k);
//                        HSSFRichTextString text = new HSSFRichTextString(headValue);
//                        System.out.println(headValue);
//                        cell.setCellStyle(style);
                        cell.setCellValue(headValue );
//                        cell.setCellValue(headValue +":"+key);
                        k++;
                    }
                }
            }
//====================================
            Map<String, Object> singleValues = values.get(i);

//            System.out.println(singleValues);
            List<Map<String, Object>> mapList = (List<Map<String, Object>>) singleValues.get(listName);
            int mapListSize = mapList.size();
            for (int j = 0; j < mapListSize; j++) {
                HSSFRow row1 = sheet.createRow(j+1);
                int m = 0;
                for (Map.Entry<String, Object>  singleValueEntry :  singleValues.entrySet() ){
                    String key = singleValueEntry.getKey();
                    String valueKey = singleValueEntry.getKey();
                    Object valueValue = singleValueEntry.getValue();
                    if (!(valueValue instanceof  List)){
                        HSSFCell valueCell = row1.createCell(m);
//                        valueCell.setCellValue(valueValue +":"+key);
                        valueCell.setCellValue(valueValue+"" );
                        m++;
                    }
                }

                for (Map.Entry<String, Object>  subMapEntry :  mapList.get(j).entrySet() ){
                    String key = subMapEntry.getKey();
                    Object subValue = subMapEntry.getValue();
                    if (!(subValue instanceof  List)){
                        HSSFCell subCell = row1.createCell(m);
//                    subCell.setCellType(Cell.CELL_TYPE_STRING);
//                        subCell.setCellValue(subValue +":"+key);
                        subCell.setCellValue(subValue +"");
                        m++;
                    }
                }
            }

        }








        try {
//            OutputStream out = new FileOutputStream("E://a.xls");
            workbook.write(os);
            return os;
//            out.flush();
//            out.close();
        } catch (Exception e) {

        }
    return os;

    }

    //TODO
    public static OutputStream exportExcel(List<Map<String,Object>> values ,OutputStream os) {

        String[] headers = new String[]{};


        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet("订单详情");
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth(15);
            // 生成一个样式

            // 声明一个画图的顶级管理器
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

            //产生表格标题行
            HSSFRow row = sheet.createRow(0);
            //-------------------------------
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth(15);
            // 生成一个样式
            HSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
            HSSFFont font = workbook.createFont();
            font.setColor(HSSFColor.VIOLET.index);
            font.setFontHeightInPoints((short) 15);
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setFontName("宋体");
            // 把字体应用到当前的样式
            style.setFont(font);
            // 生成并设置另一个样式
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
            // 生成另一个字体
            HSSFFont font2 = workbook.createFont();
            font2.setFontName("宋体");
            font2.setFontHeightInPoints((short) 14);
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            // 把字体应用到当前的样式
            style2.setFont(font2);

            row.createCell(0).setCellValue("序号");
            row.createCell(1).setCellValue("订单号");
            row.createCell(2).setCellValue("订货地点");
            row.createCell(3).setCellValue("采购组");
            row.createCell(4).setCellValue("供商编码");
            row.createCell(5).setCellValue("商品编码");
            row.createCell(6).setCellValue("商品名称");
            row.createCell(7).setCellValue("产地");
            row.createCell(8).setCellValue("订货数");
            row.createCell(9).setCellValue("含税进价");
            row.createCell(10).setCellValue("单位");
            row.createCell(11).setCellValue("商品数");
            row.createCell(12).setCellValue("含税金额");
            row.createCell(13).setCellValue("发货量");
            row.createCell(14).setCellValue("商品国码");
            row.createCell(15).setCellValue("库存地");
            row.createCell(16).setCellValue("促销");


//====================================
            int size = values.size();
            for (int j = 0; j < size; j++) {
                HSSFRow row1 = sheet.createRow(j+1);
                if (headers.length == 0 && values != null && values.get(j) != null){
                    int k = 0;
                    Map<String,Object> odsRepZvekpos =values.get(j);

                    //==================
//                    序号		0
//                    订单号	ebeln	1
//                    订货地点	name1_s	2
//                    采购组	ekgrp	3
//                    供商编码	lifnr	4
//                    商品编码	ematn	5
//                    商品名称	matnr	6
//                    产地	cd	7
//                    订货数	menge	8
//                    含税进价	brtpr	9
//                    单位	peinh	10
//                    商品数	bpmng	11
//                    含税金额	brtwr	12
//                    发货量		13
//                    商品国码	ematn	14
//                    库存地	lgort	15
//                    促销	aktnr	16

                    //==================
                    row1.createCell(0).setCellValue(j);
                    row1.createCell(1).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos, "ebeln"));
                    row1.createCell(2).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"name1S"));
                    row1.createCell(3).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"ekgrp"));
                    row1.createCell(4).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"lifnr"));
                    row1.createCell(5).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"ematn"));
                    row1.createCell(6).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"matnr"));
                    row1.createCell(7).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"cd"));
                    row1.createCell(8).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"menge"));
                    row1.createCell(9).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"brtpr"));
                    row1.createCell(10).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"peinh"));
                    row1.createCell(11).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"bpmng"));
                    row1.createCell(12).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"brtwr"));
                    row1.createCell(14).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"ematn"));
                    row1.createCell(15).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"lgort"));
                    row1.createCell(16).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"aktnr"));
                }

            }


        try {
//            OutputStream out = new FileOutputStream("E://a.xls");
            workbook.write(os);
            return os;
        } catch (Exception e) {

        }
    return os;

    }

    //TODO
    public static OutputStream exportExcelOrder(List<Map<String,Object>> values ,OutputStream os) {

        String[] headers = new String[]{};


        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet("订单详情");
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        // 生成一个样式

        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

        //产生表格标题行
        HSSFRow row1 = sheet.createRow(0);
        //-------------------------------
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 15);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setFontName("宋体");
        font2.setFontHeightInPoints((short) 14);
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);

//        row.createCell(0).setCellValue("PO_NO");
//        row.createCell(1).setCellValue("OrderSite");
//        row.createCell(2).setCellValue("SiteAddress");
//        row.createCell(3).setCellValue("OrderDT");
//        row.createCell(4).setCellValue("OrderType");
//        row.createCell(5).setCellValue("Sup_NO");
//        row.createCell(6).setCellValue("Sup_Name");
//        row.createCell(7).setCellValue("Sup_Tel");
//        row.createCell(8).setCellValue("Sup_Fax");
//        row.createCell(9).setCellValue("DeliveryDT");
//        row.createCell(10).setCellValue("Pur_Group");
//        row.createCell(11).setCellValue("Item_NO");
//        row.createCell(12).setCellValue("SKU");
//        row.createCell(13).setCellValue("Item_Name");
//        row.createCell(14).setCellValue("BarCode");
//        row.createCell(15).setCellValue("FreeGoods");
//        row.createCell(16).setCellValue("IsReturn");
//        row.createCell(17).setCellValue("Price");
//        row.createCell(18).setCellValue("Amount");
//        row.createCell(19).setCellValue("Piece_Qty");
//        row.createCell(20).setCellValue("UOM");
//        row.createCell(21).setCellValue("Order_Qty");
//        row.createCell(22).setCellValue("DeliveryDT_Qty");
//        row.createCell(23).setCellValue("StorageLoc");
//        row.createCell(24).setCellValue("Promo_NO");
//        row.createCell(25).setCellValue("POS_NO");
//        row.createCell(26).setCellValue("CustomerName");
//        row.createCell(27).setCellValue("CustomerTel");
//        row.createCell(28).setCellValue("CustomerAddress");
//        row.createCell(29).setCellValue("Memo");
//        row.createCell(30).setCellValue("fund");
//        row.createCell(31).setCellValue("funds_ctr");
//        row.createCell(32).setCellValue("ZStore_NO");
//        row.createCell(33).setCellValue("ZCDID");
//        row.createCell(34).setCellValue("ZPO_NO");
//        row.createCell(35).setCellValue("ZPiece_Qty");
//        row.createCell(36).setCellValue("ZUOM");
//        row.createCell(37).setCellValue("ZPlan_Qty");
//        row.createCell(38).setCellValue("ZAmount");
//        row.createCell(39).setCellValue("INCOTERMS2");

//        HSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("订单号");
        row1.createCell(1).setCellValue("订货地");
        row1.createCell(2).setCellValue("收货地址");
        row1.createCell(3).setCellValue("订单日期");
        row1.createCell(4).setCellValue("订单类型");
        row1.createCell(5).setCellValue("供商卡号");
        row1.createCell(6).setCellValue("供商名称");
//        row1.createCell(7).setCellValue("供商电话sss");
//        row1.createCell(8).setCellValue("供商传真sss");
        row1.createCell(7).setCellValue("预计到货日");
        row1.createCell(8).setCellValue("U课编号以及名称  ");
//        row1.createCell(11).setCellValue("sss");
        row1.createCell(9).setCellValue("商品编号");
        row1.createCell(10).setCellValue("商品名称");
        row1.createCell(11).setCellValue("商品条码");
//        row1.createCell(15).setCellValue("sss");
//        row1.createCell(16).setCellValue("sss");
        row1.createCell(12).setCellValue("价格");
//        row1.createCell(18).setCellValue("sss");
        row1.createCell(13).setCellValue("订货量");
        row1.createCell(14).setCellValue("包装单位");
//        row1.createCell(21).setCellValue("sss");
//        row1.createCell(22).setCellValue("sss");
//        row1.createCell(23).setCellValue("sss");
//        row1.createCell(24).setCellValue("促销号sss");
//        row1.createCell(25).setCellValue("ssss");
//        row1.createCell(26).setCellValue("ssss");
//        row1.createCell(27).setCellValue("ssss");
//        row1.createCell(28).setCellValue("ssss");
//        row1.createCell(29).setCellValue("ssss");
//        row1.createCell(30).setCellValue("ssss");
//        row1.createCell(31).setCellValue("ssss");
//        row1.createCell(32).setCellValue("ssss");
//        row1.createCell(33).setCellValue("ssss");
//        row1.createCell(34).setCellValue("ssss");
//        row1.createCell(35).setCellValue("ssss");
//        row1.createCell(36).setCellValue("ssss");
//        row1.createCell(37).setCellValue("ssss");
//        row1.createCell(38).setCellValue("ssss");
        row1.createCell(15).setCellValue("产地");

//====================================
        int size = values.size();
        for (int j = 0; j < size; j++) {
            HSSFRow row2 = sheet.createRow(j+1);
            if (headers.length == 0 && values != null && values.get(j) != null){
                int k = 0;
                Map<String,Object> odsRepZvekpos =values.get(j);

                //==================
//                    序号		0
//                    订单号	ebeln	1
//                    订货地点	name1_s	2
//                    采购组	ekgrp	3
//                    供商编码	lifnr	4
//                    商品编码	ematn	5
//                    商品名称	matnr	6
//                    产地	cd	7
//                    订货数	menge	8
//                    含税进价	brtpr	9
//                    单位	peinh	10
//                    商品数	bpmng	11
//                    含税金额	brtwr	12
//                    发货量		13
//                    商品国码	ematn	14
//                    库存地	lgort	15
//                    促销	aktnr	16

                //==================
                row2.createCell(0).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"ebeln"));
                row2.createCell(1).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"name1S"));
                row2.createCell(2).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"stras"));
                row2.createCell(3).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"eadat"));
                row2.createCell(4).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"bsart"));
                row2.createCell(5).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"lifnr"));
                row2.createCell(6).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"name1V"));
//                row2.createCell(7).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(8).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
                row2.createCell(7).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"eindt"));
                row2.createCell(8).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"ekgrp"));
//                row2.createCell(11).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
                row2.createCell(9).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"ematn"));
                row2.createCell(10).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"matnr"));
                row2.createCell(11).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"ean11"));
//                row2.createCell(15).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(16).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
                row2.createCell(12).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"brtpr"));
//                row2.createCell(18).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
                row2.createCell(13).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"menge"));
                row2.createCell(14).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"meins"));
//                row2.createCell(21).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(22).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(23).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(24).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(25).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(26).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(27).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(28).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(29).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(30).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(31).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(32).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(33).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(34).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(35).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(36).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(37).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
//                row2.createCell(38).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"sss"));
                row2.createCell(15).setCellValue(AppUtils.getStrOfMap4Excel(odsRepZvekpos,"cd"));
            }

        }


        try {
//            OutputStream out = new FileOutputStream("E://a.xls");
            workbook.write(os);
            return os;
        } catch (Exception e) {

        }
        return os;

    }

    //TODO
    public static OutputStream exportExcelModel(List<String> heads,OutputStream os,String sheetName) {



        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet(sheetName);
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth(15);
            // 生成一个样式

            // 声明一个画图的顶级管理器
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

            //产生表格标题行
            HSSFRow row = sheet.createRow(0);
            //-------------------------------
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth(15);
            // 生成一个样式
            HSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
            HSSFFont font = workbook.createFont();
            font.setColor(HSSFColor.VIOLET.index);
            font.setFontHeightInPoints((short) 15);
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setFontName("宋体");
            // 把字体应用到当前的样式
            style.setFont(font);
            // 生成并设置另一个样式
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
            // 生成另一个字体
            HSSFFont font2 = workbook.createFont();
            font2.setFontName("宋体");
            font2.setFontHeightInPoints((short) 14);
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            // 把字体应用到当前的样式
            style2.setFont(font2);

        int size = heads.size();
        for (int i = 0; i < size; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(heads.get(i));
        }

//====================================
        try {
//            OutputStream out = new FileOutputStream("E://a.xls");
            workbook.write(os);
//            workbook.write(out);
//            os.flush();
//            os.close();
            return os;
//            out.flush();
//            out.close();
        } catch (Exception e) {

        }
        return os;

    }

    //TODO
    //有序号的excel
    public static OutputStream exportExcelSerial(Map<String,String> headersMap, List<List<Map<String,Object>>> values ,OutputStream os,String[] sheetName) {

        String[] headers = new String[]{};


        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        int length = sheetName.length;
        for (int i = 0; i < length; i++) {
            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet(sheetName[i]);
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth(15);
            // 生成一个样式

            // 声明一个画图的顶级管理器
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

            //产生表格标题行
            HSSFRow row = sheet.createRow(0);
            //-------------------------------
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth(15);
            // 生成一个样式
            HSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
            HSSFFont font = workbook.createFont();
            font.setColor(HSSFColor.VIOLET.index);
            font.setFontHeightInPoints((short) 15);
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setFontName("宋体");
            // 把字体应用到当前的样式
            style.setFont(font);
            // 生成并设置另一个样式
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
            // 生成另一个字体
            HSSFFont font2 = workbook.createFont();
            font2.setFontName("宋体");
            font2.setFontHeightInPoints((short) 14);
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            // 把字体应用到当前的样式
            style2.setFont(font2);

            if (headers.length == 0 && values != null && values.get(0) != null && values.get(0).size() != 0){
                List<Map<String, Object>> mapDataList = values.get(0);
                HSSFCell cell0 = row.createCell(0);
                cell0.setCellValue("序号"  );
                int k = 1;
                Map<String,Object> odsRepZvekpos =mapDataList.get(0);
                for (Map.Entry<String, Object>  subentry: odsRepZvekpos.entrySet() ){
                    String key = subentry.getKey();
                    Object value = subentry.getValue();
                    if (!(value instanceof  List)){
                        String headValue = headersMap.get(key);
                        HSSFCell cell = row.createCell(k);
                        cell.setCellValue(headValue  );
//                        cell.setCellValue(headValue +":"+key);
                        k++;
                    }
                }
            }
//====================================
            List<Map<String, Object>> mapDataList = values.get(i);
            int size = mapDataList.size();
            for (int j = 0; j < size; j++) {
                HSSFRow row1 = sheet.createRow(j+1);
                //序号
                HSSFCell cell0 = row1.createCell(0);
                cell0.setCellValue(j+1);
                if (headers.length == 0 && mapDataList != null && mapDataList.get(j) != null){
                    int k = 1;
                    Map<String,Object> odsRepZvekpos =mapDataList.get(j);
                    for (Map.Entry<String, Object>  subentry: odsRepZvekpos.entrySet() ){
                        String key = subentry.getKey();
                        Object value = subentry.getValue();

                        if (!(value instanceof  List)){
                            HSSFCell cell = row1.createCell(k);
                            if (value ==null ){
                                cell.setCellValue("" );
                            }else {
                                cell.setCellValue(value +"" );
                            }
                            k++;
                        }
                    }
                }

            }

        }
//-------------------------------



//-------------------------------
//        for (short i = 0; i < headers.size(); i++) {
//            HSSFCell cell = row.createCell(i);
//            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
//            cell.setCellStyle(style);
//            cell.setCellValue(text);
//        }
        //遍历集合数据，产生数据行




//        int length = dataset.length;
//        HSSFCell cell;
//        for (int j = 0; j < length; j++) {
//            String[] strings = dataset[j];
//            int length1 = strings.length;
//            row = sheet.createRow(j + 1);
//
//
//            for (int i = 0; i < length1; i++) {
//                cell = row.createCell(i);
//                cell.setCellType(Cell.CELL_TYPE_STRING);
//                cell.setCellStyle(style2);
//                cell.setCellValue(strings[i]);
//            }
//
//        }





        try {
//            OutputStream out = new FileOutputStream("E://a.xls");
            workbook.write(os);
//            workbook.write(out);
//            os.flush();
//            os.close();
            return os;
//            out.flush();
//            out.close();
        } catch (Exception e) {

        }
        return os;

    }


}
