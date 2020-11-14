package Base;

import GUI.ProductList;

import javax.swing.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        JFrame frame = new ProductList("Product list");
        frame.pack();
        frame.setVisible(true);
    }
}
