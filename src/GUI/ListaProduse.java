package GUI;

import Base.DatabaseConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class ListaProduse extends JFrame {
    private JPanel listaProdusePanel;
    private JButton add;
    private JTable table;

    public ListaProduse(String titlu) throws SQLException {
        super(titlu);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(listaProdusePanel);
        this.pack();

        Statement ps = DatabaseConnection.getConnection().createStatement();
        ResultSet rs = ps.executeQuery("SELECT * from stoc");
        table.setModel(buildTableModel(rs));
        ps.close();

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new AdaugaProdusNou("Adauga produs nou");
                frame.setVisible(true);
            }
        });
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // name of columns
        int columnCount = metaData.getColumnCount();
        Vector<String> header = new Vector<>();
        header.add("Cod produs");
        header.add("Categorie produs");
        header.add("Nume produs");
        header.add("Stoc initial");
        header.add("Provenienta firma");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, header);
    }

}
