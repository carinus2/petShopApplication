package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ImageRenderer extends DefaultTableCellRenderer {
    private int cellSize;

    public ImageRenderer(int cellSize) {
        this.cellSize = cellSize;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof ImageIcon) {
            JLabel label = new JLabel((ImageIcon) value);
            label.setHorizontalAlignment(JLabel.CENTER);

            // Setează dimensiunile preferate ale label-ului pentru a fi pătrate
            label.setPreferredSize(new Dimension(cellSize, cellSize));

            return label;
        } else {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}
