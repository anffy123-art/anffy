package com.px.partybuild.util;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.px.partybuild.util.excel.CellItem;
import com.px.partybuild.util.excel.ListItem;
import com.px.partybuild.util.excel.PageItem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

@Component
public class ExcelHelper {

    public class ExcelData implements Serializable {

        private static final long serialVersionUID = 4444017239100620999L;

        // 表头
        private List<String> titles;
        // 合并列表头
        private List<Map<String, CellRangeAddress>> colspanTitles;
        // 数据
        private List<List<Object>> rows;

        // 页签名称
        private String name;

        //合并行列
        private List<CellRangeAddress> cellRangeList;

        private List<List<XSSFCellStyle>> styleList;

        public List<String> getTitles() {
            return titles;
        }

        public void setTitles(List<String> titles) {
            this.titles = titles;
        }

        public List<Map<String, CellRangeAddress>> getColspanTitles() {
            return colspanTitles;
        }

        public void setColspanTitles(List<Map<String, CellRangeAddress>> colspanTitles) {
            this.colspanTitles = colspanTitles;
        }

        public List<List<Object>> getRows() {
            return rows;
        }

        public void setRows(List<List<Object>> rows) {
            this.rows = rows;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<CellRangeAddress> getCellRangeList() {
            return cellRangeList;
        }

        public void setCellRangeList(List<CellRangeAddress> cellRangeList) {
            this.cellRangeList = cellRangeList;
        }

        public List<List<XSSFCellStyle>> getStyleList() {
            return styleList;
        }

        public void setStyleList(List<List<XSSFCellStyle>> styleList) {
            this.styleList = styleList;
        }
    }

    public ArrayList<Map<String, String>> readExcel(InputStream is, String fileName, Map<String, Object> columns) throws IOException {
        ArrayList<Map<String, String>> mapList = new ArrayList<>();

        //判断文件是否存在
        if (is != null) {
            //获取文件的后缀名 \\ .是特殊字符
            String[] split = fileName.split("\\.");
            Workbook wb;
            //根据文件后缀（xls/xlsx）进行判断
            if ("xls".equals(split[1])) {
                //获取文件流对象
                wb = new HSSFWorkbook(is);
            } else if ("xlsx".equals(split[1])) {
                wb = new XSSFWorkbook(is);
            } else {
                System.out.println("文件类型错误");
                return null;
            }

            //开始解析
            Sheet sheet = wb.getSheetAt(0);
            //第一行是列名，所以从第二行开始遍历
            int firstRowNum = sheet.getFirstRowNum() + 1;
            int lastRowNum = sheet.getLastRowNum();

            //遍历行
            for (int rIndex = firstRowNum; rIndex <= lastRowNum; rIndex++) {
                Map map = new HashMap();
                //获取当前行的内容
                Row row = sheet.getRow(rIndex);
                if (row != null) {
                    int firstCellNum = row.getFirstCellNum();
                    int lastCellNum = row.getLastCellNum();
                    for (int cIndex = firstCellNum; cIndex < lastCellNum; cIndex++) {
                        String value = "";
                        if (row.getCell(cIndex) != null) {
                            row.getCell(cIndex).setCellType(CellType.STRING);
                            //获取单元格的值
                            value = row.getCell(cIndex).getStringCellValue();
                        }
                        //获取此单元格对应第一行的值
                        String key = sheet.getRow(0).getCell(cIndex).getStringCellValue();
                        //第一行中的作为键，第n行的作为值
                        if (columns.get(key) != null) {
                            map.put(columns.get(key), value);
                        } else {
                            map.put("c" + cIndex, value);
                        }
                    }
                }
                mapList.add(map);
            }
            //获取excel列名
            if (columns.size() == 0) {
                Row row = sheet.getRow(0);
                int firstCellNum = row.getFirstCellNum();
                int lastCellNum = row.getLastCellNum();
                for (int cIndex = firstCellNum; cIndex < lastCellNum; cIndex++) {
                    row.getCell(cIndex).setCellType(CellType.STRING);
                    String key = sheet.getRow(0).getCell(cIndex).getStringCellValue();
                    columns.put("c" + cIndex, key);
                }
            }
        }

        return mapList;
    }

    public void exportExcel(HttpServletResponse response, String fileName, ExcelData data) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        //response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(fileName, "utf-8"));
        exportExcel(data, response.getOutputStream());
    }

    public void exportExcel(ExcelData data, OutputStream out) throws Exception {

        XSSFWorkbook wb = new XSSFWorkbook();
        try {
            String sheetName = data.getName();
            if (null == sheetName) {
                sheetName = "Sheet1";
            }
            XSSFSheet sheet = wb.createSheet(sheetName);
            writeExcel(wb, sheet, data);

            wb.write(out);
        } finally {
            wb.close();
        }
    }

    public void exportExcelNew(XSSFWorkbook wb,HttpServletResponse response, String fileName, ExcelData data) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        //response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(fileName, "utf-8"));
        exportExcelNew(wb,data, response.getOutputStream());
    }
    public void exportExcelNew(XSSFWorkbook wb,ExcelData data, OutputStream out) throws Exception {
        try {
            String sheetName = data.getName();
            if (null == sheetName) {
                sheetName = "Sheet1";
            }
            XSSFSheet sheet = wb.getSheetAt(0) != null ? wb.getSheetAt(0) : wb.createSheet(sheetName);
            writeExcel(wb, sheet, data);

            wb.write(out);
        } finally {
            wb.close();
        }
    }

    private void writeExcel(XSSFWorkbook wb, Sheet sheet, ExcelData data) {

        int rowIndex = 0;

        //rowIndex = writeTitlesToExcel(wb, sheet, data.getTitles());
        if (data.getColspanTitles() == null) {
            data.setColspanTitles(new ArrayList<>());
        }
        rowIndex = writeColspanTitlesToExcel(wb, sheet, data.getColspanTitles(), data.getTitles());
        writeRowsToExcel(wb, sheet, data.getRows(), rowIndex,data.getStyleList());
        //autoSizeColumns(sheet, data.getTitles().size() + 1);

        //合并行
        if (data.getCellRangeList() != null && data.getCellRangeList().size() > 0) {
            setCellRange(sheet, data.getCellRangeList());
        }

    }

    private int writeTitlesToExcel(XSSFWorkbook wb, Sheet sheet, List<String> titles) {
        int rowIndex = 0;
        int colIndex = 0;

        Font titleFont = wb.createFont();
        titleFont.setFontName("simsun");
        titleFont.setBold(true);
        // titleFont.setFontHeightInPoints((short) 14);
        titleFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(182, 184, 192), new DefaultIndexedColorMap()));
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setFont(titleFont);
        setBorder(titleStyle, BorderStyle.THIN, new XSSFColor(new java.awt.Color(0, 0, 0), new DefaultIndexedColorMap()));

        Row titleRow = sheet.createRow(rowIndex);
        // titleRow.setHeightInPoints(25);
        colIndex = 0;

        for (String field : titles) {
            Cell cell = titleRow.createCell(colIndex);
            cell.setCellValue(field);
            cell.setCellStyle(titleStyle);
            colIndex++;
        }
        //sheet.addMergedRegion(new CellRangeAddress(start, j + 1, cell, cell));
        rowIndex++;
        return rowIndex;
    }

    private int writeColspanTitlesToExcel(XSSFWorkbook wb, Sheet sheet, List<Map<String, CellRangeAddress>> colspanTitles, List<String> titles) {
        int rowIndex = 0;
        int colIndex = 0;

        Font titleFont = wb.createFont();
        titleFont.setFontName("simsun");
        titleFont.setBold(true);
        // titleFont.setFontHeightInPoints((short) 14);
        titleFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(182, 184, 192), new DefaultIndexedColorMap()));
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setFont(titleFont);
        setBorder(titleStyle, BorderStyle.THIN, new XSSFColor(new java.awt.Color(0, 0, 0), new DefaultIndexedColorMap()));

        for (Map<String, CellRangeAddress> cols : colspanTitles) {
            for (String colName : cols.keySet()) {
                if (cols.get(colName) != null) {
                    sheet.addMergedRegion(cols.get(colName));
                }
            }
        }
        for (Map<String, CellRangeAddress> cols : colspanTitles) {
            colIndex = 0;
            Row titleRow = sheet.createRow(rowIndex);
            for (String colName : cols.keySet()) {
                Cell cell = titleRow.createCell(cols.get(colName) != null ? cols.get(colName).getFirstColumn() : colIndex);
                cell.setCellValue(colName);
                cell.setCellStyle(titleStyle);
                colIndex++;
            }
            rowIndex++;
        }
        colIndex = 0;
        Row titleRow = sheet.createRow(rowIndex);
        for (String field : titles) {
            sheet.autoSizeColumn(colIndex);
            Cell cell = titleRow.createCell(colIndex);
            cell.setCellValue(field);
            cell.setCellStyle(titleStyle);
            colIndex++;
        }

        return ++rowIndex;
    }

    private int writeRowsToExcel(XSSFWorkbook wb, Sheet sheet, List<List<Object>> rows, int rowIndex,List<List<XSSFCellStyle>> styleList) {
        int colIndex = 0;
        int index = 0;

        Font dataFont = wb.createFont();
        dataFont.setFontName("simsun");
        // dataFont.setFontHeightInPoints((short) 14);
        dataFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle defaultStyle = wb.createCellStyle();
        //dataStyle.setAlignment(HorizontalAlignment.CENTER);
        //dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        defaultStyle.setFont(dataFont);
        setBorder(defaultStyle, BorderStyle.THIN, new XSSFColor(new java.awt.Color(188, 188, 188), new DefaultIndexedColorMap()));

        for (List<Object> rowData : rows) {
            Row dataRow = sheet.createRow(rowIndex);
            // dataRow.setHeightInPoints(25);
            colIndex = 0;

            for (Object cellData : rowData) {


                Cell cell = dataRow.createCell(colIndex);
                if (cellData != null) {
//                    cell.setCellValue(cellData.toString());
                    setCellValue(cell, cellData);
                } else {
                    cell.setCellValue("");
                }
                if (styleList != null && styleList.size() > index && styleList.get(index).size() > colIndex) {
                    cell.setCellStyle(styleList.get(index).get(colIndex));
                } else {
                    cell.setCellStyle(defaultStyle);
                }


                colIndex++;
            }
            rowIndex++;
            index++;
        }
        return rowIndex;
    }

    private void autoSizeColumns(Sheet sheet, int columnNumber) {
        for (int i = 0; i < columnNumber; i++) {
            int orgWidth = sheet.getColumnWidth(i);
            sheet.autoSizeColumn(i, true);
            int newWidth = (int) (sheet.getColumnWidth(i) + 100);
            if (newWidth > orgWidth) {
                sheet.setColumnWidth(i, newWidth);
            } else {
                sheet.setColumnWidth(i, orgWidth);
            }
        }
    }

    public void setBorder(XSSFCellStyle style, BorderStyle border, XSSFColor color) {
        style.setBorderTop(border);
        style.setBorderLeft(border);
        style.setBorderRight(border);
        style.setBorderBottom(border);
        style.setBorderColor(XSSFCellBorder.BorderSide.TOP, color);
        style.setBorderColor(XSSFCellBorder.BorderSide.LEFT, color);
        style.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, color);
        style.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, color);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
    }

    public XSSFCellStyle setDefaultBorder(XSSFWorkbook wb) {
        Font dataFont = wb.createFont();
        dataFont.setFontName("simsun");
        dataFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE, new DefaultIndexedColorMap()));
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(dataFont);
        style.setWrapText(true);

        BorderStyle borderStyle = BorderStyle.THIN;
        XSSFColor borderColor = new XSSFColor(java.awt.Color.BLACK, new DefaultIndexedColorMap());
        style.setBorderTop(borderStyle);
        style.setBorderLeft(borderStyle);
        style.setBorderRight(borderStyle);
        style.setBorderBottom(borderStyle);
        style.setBorderColor(XSSFCellBorder.BorderSide.TOP, borderColor);
        style.setBorderColor(XSSFCellBorder.BorderSide.LEFT, borderColor);
        style.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, borderColor);
        style.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, borderColor);

        return style;
    }

    private void setCellRange(Sheet sheet, List<CellRangeAddress> cellRangeList) {
        for (CellRangeAddress item : cellRangeList) {
            sheet.addMergedRegion(item);
        }
    }

    public void setCellValue(Cell cell, Object value) {
        if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } // Add more types as needed
    }

    public void exportExcelToTemp(HttpServletResponse response, InputStream is, List<PageItem> pageList, String fileName, PaperSize paperSize, Boolean landscape) throws IOException {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        //response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(fileName, "utf-8"));
        //判断文件是否存在
        if (is != null) {
            XSSFWorkbook wb = new XSSFWorkbook(is);
            ;
            for (Integer i = 0; i < pageList.size(); i++) {
                XSSFSheet sheet = null;
                if (i == 0) {
                    sheet = wb.getSheetAt(i);
                    if (paperSize == null)
                        paperSize = sheet.getPrintSetup().getPaperSizeEnum();
                    if (landscape == null)
                        landscape = sheet.getPrintSetup().getLandscape();
                } else
                    sheet = wb.cloneSheet(0, "page" + i.toString());

                XSSFPrintSetup ps = sheet.getPrintSetup();
                ps.setPaperSize(paperSize);
                ps.setLandscape(landscape);//纸张方向
                PageItem item = pageList.get(i);

                if (item.getCellItemList() != null) {
                    for (int j = 0; j < item.getCellItemList().size(); j++) {
                        CellItem cellItem = item.getCellItemList().get(j);
                        XSSFRow row = sheet.getRow(cellItem.getRow());
                        XSSFCell cell = row.getCell(cellItem.getCol());
                        cell.setCellValue(cellItem.getValue());
                    }
                }

                int addRows = 0;

                if (item.getListItem() != null) {
                    for (int listIndex = 0; listIndex < item.getListItem().size(); listIndex++) {
                        ListItem listItem = item.getListItem().get(listIndex);
                        int startRow = listItem.startRow + addRows;

                        insertRow(sheet, startRow + 1, listItem.values.length - 1, true);

                        for (int r = 0; r < listItem.values.length; r++) {
                            XSSFRow thisRow = sheet.getRow(startRow + r);

                            String[] valueItem = listItem.values[r];
                            for (int m = 0; m < valueItem.length; m++) {
                                int col = listItem.startColumn + m;
                                if (col > listItem.endColumn) {
                                    break;
                                }
                                String value = valueItem[m];
                                XSSFCell cell = thisRow.getCell(col);
                                cell.setCellValue(value);
                            }

                            addRows++;
                        }
                    }

                }
            }

            try {
                wb.write(response.getOutputStream());
            } catch (Exception e) {

            } finally {
                is.close();
            }
        }
    }

    /**
     * @param startRow  插入行的行标,即在哪一行下插入
     * @param rows      插入多少行
     * @param sheet     XSSFSheet
     * @param copyvalue 新行复制(startRow-1)行的样式,而且在拷贝行的时候可以指定是否需要拷贝值
     */
    private static void insertRow(XSSFSheet sheet, int startRow, int rows, Boolean copyvalue) {
        if(rows<=0)
            return;
        //先获取原始的合并单元格address集合
        List<CellRangeAddress> originMerged = sheet.getMergedRegions();

        for (int i = sheet.getNumMergedRegions() - 1; i >= 0; i--) {
            CellRangeAddress region = sheet.getMergedRegion(i);
            //判断移动的行数后重新拆分
            if (region.getFirstRow() > startRow) {
                sheet.removeMergedRegion(i);
            }
        }

        sheet.shiftRows(startRow, sheet.getLastRowNum(), rows, true, false);
        sheet.createRow(startRow);

        for (CellRangeAddress cellRangeAddress : originMerged) {
            //这里的8是插入行的index，表示这行之后才重新合并
            if (cellRangeAddress.getFirstRow() > startRow) {
                //你插入了几行就加几，我这里插入了一行，加1
                int firstRow = cellRangeAddress.getFirstRow() + rows;
                CellRangeAddress newCellRangeAddress = new CellRangeAddress(firstRow, (firstRow + (cellRangeAddress
                        .getLastRow() - cellRangeAddress.getFirstRow())), cellRangeAddress.getFirstColumn(),
                        cellRangeAddress.getLastColumn());
                sheet.addMergedRegion(newCellRangeAddress);
            }
        }
        CellCopyPolicy cellCopyPolicy = new CellCopyPolicy();
        cellCopyPolicy.setCopyCellValue(copyvalue);
        cellCopyPolicy.isCopyCellValue();
        for (int i = 0; i < rows; i++) {
            sheet.copyRows(startRow - 1, startRow - 1, startRow + i, cellCopyPolicy);
        }
    }


}
