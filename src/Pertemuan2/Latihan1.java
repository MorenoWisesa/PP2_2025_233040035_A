package Pertemuan2;

import javax.swing.*;
import java.awt.*;

public class Latihan1 {
    public static void main(String[] args) {
        // Membuat jendela utama
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout(10, 10));

        // Bagian atas: layar kalkulator
        JTextField layar = new JTextField();
        layar.setEditable(false);
        layar.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(layar, BorderLayout.NORTH);

        // Bagian tengah: tombol-tombol
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(4, 4, 5, 5));

        // Tombol-tombol kalkulator
        panelTombol.add(new JButton("7"));
        panelTombol.add(new JButton("8"));
        panelTombol.add(new JButton("9"));
        panelTombol.add(new JButton("/"));
        panelTombol.add(new JButton("4"));
        panelTombol.add(new JButton("5"));
        panelTombol.add(new JButton("6"));
        panelTombol.add(new JButton("*"));
        panelTombol.add(new JButton("1"));
        panelTombol.add(new JButton("2"));
        panelTombol.add(new JButton("3"));
        panelTombol.add(new JButton("-"));
        panelTombol.add(new JButton("0"));
        panelTombol.add(new JButton("."));
        panelTombol.add(new JButton("="));
        panelTombol.add(new JButton("+"));

        // Menambahkan panel tombol ke frame
        frame.add(panelTombol, BorderLayout.CENTER);

        // Tampilkan frame
        frame.setVisible(true);
    }
}
