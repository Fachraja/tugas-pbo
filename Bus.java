import java.util.ArrayList;

public class Bus {

    private ArrayList<Penumpang> kursiBiasa = new ArrayList<>();
    private ArrayList<Penumpang> kursiPrioritas = new ArrayList<>();
    private ArrayList<Penumpang> berdiri = new ArrayList<>();

    public static final int KAPASITAS_BIASA = 16;
    public static final int KAPASITAS_PRIORITAS = 4;
    public static final int KAPASITAS_BERDIRI = 20;
    public static final int ONGKOS = 2000;

    private int pendapatan = 0;

    public boolean naik(Penumpang p) {

        if (!p.bayar(ONGKOS)) {
            System.out.println("Saldo penumpang tidak cukup!");
            return false;
        }

        pendapatan += ONGKOS;

        if (p.adalahPrioritas() && kursiPrioritas.size() < KAPASITAS_PRIORITAS) {
            kursiPrioritas.add(p);
            return true;
        }

        if (kursiBiasa.size() < KAPASITAS_BIASA) {
            kursiBiasa.add(p);
            return true;
        }

        if (berdiri.size() < KAPASITAS_BERDIRI) {
            berdiri.add(p);
            return true;
        }

        System.out.println("Bus penuh!");
        return false;
    }

    public boolean turunkan(int id) {
        for (Penumpang p : kursiBiasa) {
            if (p.getId() == id) {
                kursiBiasa.remove(p);
                return true;
            }
        }
        for (Penumpang p : kursiPrioritas) {
            if (p.getId() == id) {
                kursiPrioritas.remove(p);
                return true;
            }
        }
        for (Penumpang p : berdiri) {
            if (p.getId() == id) {
                berdiri.remove(p);
                return true;
            }
        }
        return false;
    }

    private String daftarPenumpang(ArrayList<Penumpang> list) {
        if (list.isEmpty()) return "<kosong>";
        String hasil = "";
        for (Penumpang p : list) {
            hasil += p.getId() + " ";
        }
        return hasil;
    }

    public String toString() {
        return "\n--- DATA BUS ---" +
               "\nKursi Biasa: " + daftarPenumpang(kursiBiasa) +
               "\nKursi Prioritas: " + daftarPenumpang(kursiPrioritas) +
               "\nBerdiri: " + daftarPenumpang(berdiri) +
               "\nTotal Penumpang: " + (kursiBiasa.size() + kursiPrioritas.size() + berdiri.size()) +
               "\nPendapatan: " + pendapatan +
               "\n---------------\n";
    }
}
