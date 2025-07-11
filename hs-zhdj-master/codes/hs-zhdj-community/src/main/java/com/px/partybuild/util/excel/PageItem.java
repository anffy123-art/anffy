package com.px.partybuild.util.excel;

import lombok.Data;

import java.util.List;

@Data
public class PageItem {
    public List<CellItem> CellItemList;
    public List<ListItem> ListItem;
}