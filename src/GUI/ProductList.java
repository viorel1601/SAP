package GUI;

import Base.DatabaseConnection;
import GUI.Product.AddNewProduct;
import GUI.Product.ModifyProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class ProductList extends JFrame {
    private JPanel productListPanel;
    private JButton add;
    private JTable table;
    private JButton modifyProduct;
    private String ok1;

    public ProductList(String tittle) throws SQLException {
        super(tittle);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(productListPanel);
        this.pack();

        Statement ps = DatabaseConnection.getConnection().createStatement();
        ResultSet rs = ps.executeQuery("SELECT * from stoc");
        getTable().setModel(buildTableModel(rs));
        ps.close();

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new AddNewProduct("Adauga produs nou");
                frame1.setVisible(true);
            }
        });

        getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                modifyProduct.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame frame2 = new ModifyProduct("Modify product");
                        frame2.setVisible(true);
                        System.out.println("randul = " + getTable().getSelectedRow());
                        int column = 0;

                        ok1 = (String) getTable().getValueAt(getTable().getSelectedRow(), 1);
                        System.out.println("ok1 = " + ok1);

                        while(column <= 4) {
                            String element = (String) getTable().getValueAt(getTable().getSelectedRow(), column);
                            System.out.println(element);
                            column++;
                        }
                    }
                });
            }
        });
    }

    public ProductList(){}

    public String getOk1(){
        System.out.println("getter ok1 = " + this.ok1);
        return this.ok1;
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // name of columns
        int columnCount = metaData.getColumnCount();
        Vector<String> header = new Vector<>();
        header.add("Product code");
        header.add("Product category");
        header.add("Product name");
        header.add("Initial stock");
        header.add("Company Provenience");

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

    public JTable getTable() {
        return table;
    }

}
