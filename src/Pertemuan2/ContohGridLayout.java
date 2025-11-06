package Pertemuan2;

import javax.swing.*;
import java.awt.*;

public class ContohGridLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2));

        frame.add(new JButton("Tombol 1"));
        frame.add(new JButton("Tombol 2"));
        frame.add(new JButton("Tombol 3"));
        frame.add(new JButton("Tombol 4"));
        frame.add(new JButton("Tombol 5"));
        frame.add(new JButton("Tombol 6"));

        frame.setVisible(true);
    }
}
