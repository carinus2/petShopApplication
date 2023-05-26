package org.example;
import javax.xml.bind.DatatypeConverter;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;


public class Utils {
    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        // Obține numărul de coloane din ResultSet
        int columnCount = metaData.getColumnCount();

        // Creați un vector de nume de coloane, inclusiv coloana de imagini
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount ; column++) {
                columnNames.add(metaData.getColumnName(column));
        }

        // Creați un vector de rânduri, inclusiv calea către fiecare imagine
        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(resultSet.getObject(columnIndex));
            }

            //String imagePath = resultSet.getString("poza");

            //ImageIcon imageIcon = new ImageIcon(imagePath);
            //Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            //ImageIcon scaledImageIcon = new ImageIcon(image);

            // Convertiți codul hexazecimal în șir de octeți
            byte[] imageBytes = resultSet.getBytes("poza");

            // Creați un obiect ImageIcon din șirul de octeți
            ImageIcon imageIcon = new ImageIcon(imageBytes);
            row.add(imageIcon);
            data.add(row);
        }

        // Construiți un DefaultTableModel cu datele și numele de coloane
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
