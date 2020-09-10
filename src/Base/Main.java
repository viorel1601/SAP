package Base;

import GUI.AdaugaProdusNou;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new AdaugaProdusNou("Adauga produs nou");
        frame.setVisible(true);
    }
}
