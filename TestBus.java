import java.util.Scanner;

public class TestBus {

    public static void main(String[] args) {

        Bus bus = new Bus();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("==== MENU BUS ====");
            System.out.println("1. Naikkan Penumpang");
            System.out.println("2. Turunkan Penumpang");
            System.out.println("3. Lihat Data Bus");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            int pilih = sc.nextInt();

            if (pilih == 1) {
                System.out.print("Masukkan ID: ");
                int id = sc.nextInt();

                System.out.print("Masukkan umur: ");
                int umur = sc.nextInt();

                System.out.print("Hamil (y/n): ");
                boolean hamil = sc.next().equalsIgnoreCase("y");

                Penumpang p = new Penumpang(id, umur, hamil);

                if (bus.naik(p)) {
                    System.out.println("Penumpang berhasil naik.");
                } else {
                    System.out.println("Penumpang gagal naik.");
                }

            } else if (pilih == 2) {
                System.out.print("Masukkan ID penumpang yang turun: ");
                int id = sc.nextInt();

                if (bus.turunkan(id)) {
                    System.out.println("Penumpang berhasil diturunkan.");
                } else {
                    System.out.println("Penumpang tidak ditemukan.");
                }

            } else if (pilih == 3) {
                System.out.println(bus.toString());

            } else if (pilih == 4) {
                System.out.println("Program selesai.");
                break;

            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
