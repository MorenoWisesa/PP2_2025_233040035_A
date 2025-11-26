package Pertemuan3.Tugas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManajemenNilaiSiswaApp extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Komponen Nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // Komponen Mata Pelajaran (ComboBox)
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {"Matematika Dasar", "Bahasa Indonesia",
                "Algoritma dan Pemrograman I", "Praktikum Pemrograman II"};
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // Komponen Nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // Panel khusus untuk menampung dua tombol
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));

        // Tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");

        // Tombol Reset
        JButton btnReset = new JButton("Reset Input");

        buttonPanel.add(btnReset);
        buttonPanel.add(btnSimpan);

        panel.add(new JLabel(""));
        panel.add(buttonPanel);

        // Event Handling Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        // Event Handling Tombol Reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtNilai.setText("");
                cmbMatkul.setSelectedIndex(0);
            }
        });

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = {"Nama Siswa", "Mata Kuliah", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        //    Tambah tombol hapus data
        JButton btnHapus = new JButton("Hapus Data");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        bottomPanel.add(btnHapus);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Event Tombol Hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableData.getSelectedRow();

                if (selectedRow > -1) {
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(ManajemenNilaiSiswaApp.this,
                            "Data berhasil dihapus.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ManajemenNilaiSiswaApp.this,
                            "Pilih baris data yang ingin dihapus terlebih dahulu.",
                            "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        return panel;
    }

    private void prosesSimpan() {
        // 1. Ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();


        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama harus minimal 3 karakter!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);

            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0-100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) { // Menangkap error jika bukan angka
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String grade;

        int nilaiPuluhan = nilai / 10;

        switch (nilaiPuluhan) {
            case 10:
            case 9:
            case 8: grade = "A"; break;
            case 7: grade = "AB"; break;
            case 6: grade = "B"; break;
            case 5: grade = "BC"; break;
            case 4: grade = "C"; break;
            case 3: grade = "D"; break;
            default: grade = "E"; break; // Untuk nilai 0 sampai 29
        }

        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1); // Otomatis pindah ke tab tabel
    }

    // Konstruktor tanpa parameter
    public ManajemenNilaiSiswaApp() {
        // 1. Konfigurasi Frame Utama
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 2. Inisialisasi Tabbed Pane
        tabbedPane = new JTabbedPane();

        // 3. Membuat Panel untuk Tab 1 (Form Input)
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        // 4. Membuat Panel untuk Tab 2 (Tabel Data)
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        // Menambahkan TabbedPane ke Frame
        add(tabbedPane);
    }

    // Method main untuk menjalankan kelas
    public static void main(String[] args) {
        // Menjalankan GUI di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new ManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}