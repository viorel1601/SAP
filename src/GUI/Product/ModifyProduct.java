package GUI.Product;

import Base.DatabaseConnection;
import GUI.ProductObj;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ModifyProduct extends JFrame {
    private JPanel modifyProductPanel;
    private JTextField product_code;
    private JTextField product_category;
    private JTextField product_name;
    private JTextField initial_stock;
    private JTextField company_provenience;
    private JButton modify;

    public ModifyProduct(String tittle){
        super(tittle);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(modifyProductPanel);
        this.pack();

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("INSERT INTO stoc (company_provenience, product_code, product_category, product_name, initial_stock) VALUES (?, ?, ?, ?, ?)");
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

    public void setProduct_code(JTextField product_code) {
        this.product_code = product_code;
    }

    public void setProduct_category(JTextField product_category) {
        this.product_category = product_category;
    }

    public void setProduct_name(JTextField product_name) {
        this.product_name = product_name;
    }

    public void setInitial_stock(JTextField initial_stock) {
        this.initial_stock = initial_stock;
    }

    public void setCompany_provenience(JTextField company_provenience) {
        this.company_provenience = company_provenience;
    }

    public void setProduct(ProductObj prod){
        product_code.setText(prod.getProduct_code());
        product_category.setText(prod.getProduct_category());
        product_name.setText(prod.getProduct_name());
        initial_stock.setText(prod.getInitial_stock());
        company_provenience.setText(prod.getCompany_provenience());
    }
}
