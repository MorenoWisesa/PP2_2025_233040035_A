package Pertemuan2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Latihan2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel labelC = new JLabel("Celcius:");
        JTextField inputC = new JTextField(10);
        JButton tombolKonversi = new JButton("Konversi");
        JLabel labelF = new JLabel("Fahrenheit:");
        JLabel hasilF = new JLabel();

        frame.add(labelC);
        frame.add(inputC);
        frame.add(tombolKonversi);
        frame.add(labelF);
        frame.add(hasilF);

        // Event Handling dasar (ActionListener)
        tombolKonversi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ambil nilai dari input
                String teksCelcius = inputC.getText();
                // Konversi ke double
                double celcius = Double.parseDouble(teksCelcius);
                // Hitung Fahrenheit
                double fahrenheit = (celcius * 9 / 5) + 32;
                // Tampilkan hasil
                hasilF.setText(fahrenheit + " °F");
            }
        });

        frame.setVisible(true);
    }
}
