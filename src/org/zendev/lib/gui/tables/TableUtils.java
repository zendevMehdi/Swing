package org.zendev.lib.gui.tables;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableUtils {

    public static void setColumnWidth(JTable table, int columnIndex, int width) {
        table.getColumnModel().getColumn(columnIndex).setPreferredWidth(width);
    }

    public static void clear(JTable table, boolean clearColumns) {
        if (clearColumns) {
            table.setModel(new DefaultTableModel());
        } else {
            DefaultTableModel dm = (DefaultTableModel) table.getModel();

            while (dm.getRowCount() > 0) {
                dm.removeRow(0);
            }
        }
    }

    public static void sort(JTable table, SortOrder sortOrder, int columnIndex) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(columnIndex, sortOrder));

        sorter.setSortKeys(sortKeys);
    }
}
