
// KODE SETELAH DI MODIFIKASI

package Pertemuan4.controller;

import Pertemuan4.model.PersegiPanjangModel;
import Pertemuan4.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PersegiPanjangController {

    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        // Menghubungkan tombol Hitung
        this.view.addHitungListener(new HitungListener());

        // Menghubungkan tombol Reset - Tambahan Latihan 3
        this.view.addResetListener(new ResetListener());
    }

    // Class untuk menangani event klik tombol Hitung
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);

                model.hitungLuas();
                model.hitungKeliling();

                double hasilLuas = model.getLuas();
                double hasilKeliling = model.getKeliling();

                view.setHasilLuas(hasilLuas);
                view.setHasilKeliling(hasilKeliling);

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    // Class untuk menangani event klik tombol Reset
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Memanggil method pembersihan di View
            view.clearInputs();
        }
    }
}