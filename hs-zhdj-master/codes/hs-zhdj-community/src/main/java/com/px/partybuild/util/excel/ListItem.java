package com.px.partybuild.util.excel;

import lombok.Data;

@Data
public class ListItem {
    public int startRow;
    public int startColumn;
    public int endColumn;
    public String[][] values;
}
