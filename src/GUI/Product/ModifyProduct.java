package GUI.Product;

import Base.DatabaseConnection;
import GUI.ProductList;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ModifyProduct extends JFrame {
    private JPanel modificaProdusPanel;
    private JTextField product_code;
    private JTextField product_category;
    private JTextField product_name;
    private JTextField initial_stock;
    private JTextField company_provenience;
    private JButton modify;

    public ModifyProduct(String tittle){
        super(tittle);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(modificaProdusPanel);
        this.pack();

        String ok1 = new ProductList().getOk1();
        System.out.println("instance ok1 = " + ok1);

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("INSERT INTO table1 (company_provenience, product_code, product_category, product_name, initial_stock) VALUES (?, ?, ?, ?, ?)");
                    ps.setString(1, company_provenience.getText());
                    ps.setString(2, product_code.getText());
                    ps.setString(3, product_category.getText());
                    ps.setString(4, product_name.getText());
                    ps.setString(5, initial_stock.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(modify, "Product modified ok!");
                    setVisible(false);
                    ps.close();
                } catch (SQLException ee) {
                    System.out.println(ee.getMessage());
                }
            }
        });
    }

    public JTextField getCompany_provenience() { return company_provenience; }

    public JTextField getProduct_code(){
        return product_code;
    }

    public JTextField getProduct_category(){
        return product_category;
    }

    public JTextField getProduct_name(){
        return product_name;
    }

    public JTextField getInitial_stock(){
        return initial_stock;
    }
}
