public class Penumpang {

    private int id;
    private int umur;
    private boolean hamil;
    private int saldo;
  
git add
git commit -m "Menambahkan constructor dan inisialisasi saldo awal"
    public Penumpang(int id, int umur, boolean hamil) {
        this.id = id;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = 10000; // saldo awal
    }

    public int getId() {
        return id;
    }

    public int getUmur() {
        return umur;
    }

    public boolean isHamil() {
        return hamil;
    }

    public int getSaldo() {
        return saldo;
    }

    public void tambahSaldo(int jumlah) {
        saldo += jumlah;
    }

    public boolean bayar(int ongkos) {
        if (saldo >= ongkos) {
            saldo -= ongkos;
            return true;
        }
        return false;
    }

    public boolean adalahPrioritas() {
        return umur > 60 || umur < 10 || hamil;
    }

    public String info() {
        return "ID=" + id + ", Umur=" + umur + ", Hamil=" + hamil + ", Saldo=" + saldo;
    }
}
