import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Latihan4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout dengan Aksi");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());

                // Label utama untuk menampilkan pesan
                JLabel label = new JLabel("Silakan klik tombol di sekitar jendela.", JLabel.CENTER);

                // Membuat tombol-tombol
                JButton buttonNorth = new JButton("NORTH");
                JButton buttonSouth = new JButton("SOUTH");
                JButton buttonEast = new JButton("EAST");
                JButton buttonWest = new JButton("WEST");
                JButton buttonCenter = new JButton("CENTER");

                // Menambahkan aksi pada setiap tombol
                buttonNorth.addActionListener(e -> label.setText("Tombol NORTH diklik!"));
                buttonSouth.addActionListener(e -> label.setText("Tombol SOUTH diklik!"));
                buttonEast.addActionListener(e -> label.setText("Tombol EAST diklik!"));
                buttonWest.addActionListener(e -> label.setText("Tombol WEST diklik!"));
                buttonCenter.addActionListener(e -> label.setText("Tombol CENTER diklik!"));

                // Menambahkan komponen ke posisi BorderLayout
                frame.add(label, BorderLayout.NORTH);
                frame.add(buttonSouth, BorderLayout.SOUTH);
                frame.add(buttonWest, BorderLayout.WEST);
                frame.add(buttonEast, BorderLayout.EAST);
                frame.add(buttonCenter, BorderLayout.CENTER);

                // Menampilkan jendela
                frame.setVisible(true);
            }
        });
    }
}
