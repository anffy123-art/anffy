package com.px.partybuild.util.excel;

import lombok.Data;

@Data
public class CellItem {
    private int row;
    private int col;
    private String value;

    public CellItem(int row, int col, String value){
        this.row = row;
        this.col = col;
        this.value = value;
    }
}
