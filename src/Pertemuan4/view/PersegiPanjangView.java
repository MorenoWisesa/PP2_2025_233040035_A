
// KODE SETELAH DI MODIFIKASI

package Pertemuan4.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {

    // Komponen UI sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasilLuas = new JLabel("-");
    private JLabel lblHasilKeliling = new JLabel("-");
    private JButton btnHitung = new JButton("Hitung");
    private JButton btnReset = new JButton("Reset");

    public PersegiPanjangView() {
        // Inisialisasi UI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 250);
        this.setLayout(new GridLayout(5, 3, 10, 10));
        this.setTitle("MVC Kalkulator");

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel(""));

        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel(""));

        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasilLuas);
        this.add(new JLabel(""));

        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblHasilKeliling);
        this.add(new JLabel(""));

        this.add(btnHitung);
        this.add(btnReset);
    }

    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    // Menampilkan hasil Luas
    public void setHasilLuas(double hasil) {
        lblHasilLuas.setText(String.valueOf(hasil));
    }

    // Menampilkan hasil Keliling
    public void setHasilKeliling(double hasil) {
        lblHasilKeliling.setText(String.valueOf(hasil));
    }

    public void clearInputs() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasilLuas.setText("-");
        lblHasilKeliling.setText("-");
    }

    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }

    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}
