package Pertemuan2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContohMouseListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh MouseListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        panel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e) {
                panel.setBackground(Color.LIGHT_GRAY);
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}

