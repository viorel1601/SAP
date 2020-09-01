package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdaugaProdusNou extends JFrame{
    private JPanel adaugaProdusNouPanel;
    private JTextField cod_produs;
    private JTextField categorie_produs;
    private JTextField nume_produs;
    private JTextField stoc_initial;
    private JButton adauga;

    public AdaugaProdusNou(String titlu){
        super(titlu);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(adaugaProdusNouPanel);
        this.pack();

        adauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(cod_produs.getText());
                System.out.println(categorie_produs.getText());
                System.out.println(nume_produs.getText());
                System.out.println(stoc_initial.getText());

            }

        });
    }

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
