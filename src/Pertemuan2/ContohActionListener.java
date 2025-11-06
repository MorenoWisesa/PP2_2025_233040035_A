package Pertemuan2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContohActionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh ActionListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Belum diklik");
        JButton tombol = new JButton("Klik Saya!");

        tombol.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol telah diklik!");
            }
        });

        frame.add(tombol);
        frame.add(label);
        frame.setVisible(true);
    }
}

