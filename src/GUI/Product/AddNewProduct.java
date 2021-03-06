package GUI.Product;

import Base.DatabaseConnection;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddNewProduct extends JFrame{
    private JPanel addNewProductPanel;
    private JTextField product_code;
    private JTextField product_category;
    private JTextField product_name;
    private JTextField initial_stock;
    private JTextField company_provenience;
    private JButton add;

    public AddNewProduct(String titlu){
        super(titlu);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(addNewProductPanel);
        this.pack();

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("INSERT INTO stoc (provenienta_firma, cod_produs, categorie_produs, nume_produs, stoc_initial) VALUES (?, ?, ?, ?, ?)");
                    ps.setString(1, company_provenience.getText());
                    ps.setString(2, product_code.getText());
                    ps.setString(3, product_category.getText());
                    ps.setString(4, product_name.getText());
                    ps.setString(5, initial_stock.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(add, "Product added!");
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
