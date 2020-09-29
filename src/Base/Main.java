package Base;

import GUI.ListaProduse;

import javax.swing.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        JFrame frame = new ListaProduse("Lista produse");
        frame.pack();
        frame.setVisible(true);
    }
}
