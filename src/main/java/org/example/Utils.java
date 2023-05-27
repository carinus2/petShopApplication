package org.example;
import javax.xml.bind.DatatypeConverter;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Utils {
    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();


        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount ; column++) {
                columnNames.add(metaData.getColumnName(column));
        }
        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(resultSet.getObject(columnIndex));
            }

            //byte[] imageBytes = resultSet.getBytes("poza");
            //ImageIcon imageIcon = new ImageIcon(imageBytes);
            //row.add(imageIcon);
            data.add(row);
        }


        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == columnCount) {
                    return ImageIcon.class; // Setează clasa coloanei de imagini ca ImageIcon
                }
                return super.getColumnClass(columnIndex);
            }
        };

        return tableModel;
    }
}
