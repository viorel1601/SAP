package GUI;

import Base.DatabaseConnection;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AdaugaProdusNou extends JFrame{
    private JPanel adaugaProdusNouPanel;
    private JTextField cod_produs;
    private JTextField categorie_produs;
    private JTextField nume_produs;
    private JTextField stoc_initial;
    private JTextField provenienta_firma;
    private JButton adauga;

    public AdaugaProdusNou(String titlu){
        super(titlu);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(adaugaProdusNouPanel);
        this.pack();

        adauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("INSERT INTO stoc (provenienta_firma, cod_produs, categorie_produs, nume_produs, stoc_initial) VALUES (?, ?, ?, ?, ?)");
                    ps.setString(1, provenienta_firma.getText());
                    ps.setString(2, cod_produs.getText());
                    ps.setString(3, categorie_produs.getText());
                    ps.setString(4, nume_produs.getText());
                    ps.setString(5, stoc_initial.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(adauga, "Produs adaugat cu succes!");
                    setVisible(false);
                    ps.close();
                } catch (SQLException ee) {
                    System.out.println(ee.getMessage());
                }
            }
        });
    }
    public JTextField getProvenienta_firma() { return provenienta_firma; }

    public JTextField getCod_produs(){
        return cod_produs;
    }

    public JTextField getCategorie_produs(){
        return categorie_produs;
    }

    public JTextField getNume_produs(){
        return nume_produs;
    }

    public JTextField getStoc_initial(){
        return stoc_initial;
    }
}
