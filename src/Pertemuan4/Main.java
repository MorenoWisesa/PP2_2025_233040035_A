package Pertemuan4;

// Penyesuaian Import
import Pertemuan4.controller.PersegiPanjangController;
import Pertemuan4.model.PersegiPanjangModel;
import Pertemuan4.view.PersegiPanjangView;

public class Main {

    public static void main(String[] args) {
        PersegiPanjangModel model = new PersegiPanjangModel();

        PersegiPanjangView view = new PersegiPanjangView();

        PersegiPanjangController controller = new PersegiPanjangController(model, view);

        // 4. Tampilkan View
        view.setVisible(true);
    }
}