import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FilkomTravelApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("=============================================================");
        System.out.println("                         FILKOMTRAVEL                        ");
        System.out.println("=============================================================");
        System.out.println("Selamat datang di FilkomTravel, silahkan isi data diri Anda.");
        System.out.print("Nama: ");
        String nama = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();
        System.out.print("No HP: ");
        String noHp = in.nextLine();
        boolean isMember = false;
        System.out.print("Apakah Anda member? (y/n): ");
        String jawab = in.nextLine();
        if (jawab.equalsIgnoreCase("y")) {
            isMember = true;
            System.out.println("Selamat datang kembali, " + nama + "!");
        } else {
            System.out.print("Apakah Anda ingin daftar menjadi member? (y/n): ");
            String regisMember = in.nextLine();
            if (regisMember.equalsIgnoreCase("y")) {
                isMember = true;
                System.out.println("Selamat! Anda telah menjadi member FilkomTravel.");
            } else {
                System.out.println("Baik, Anda tetap dapat menggunakan layanan kami sebagai non-member.");
            }
        }

        Customer customer = new Customer(nama, email, noHp, isMember, new ArrayList<>());

        System.out.println();
        System.out.println("Silahkan cek daftar kendaraan yang ingin disewa.");
        System.out.println();

        ArrayList<Kendaraan> kendaraan = new ArrayList<>();
        kendaraan.add(new KendaraanKecil("Daihatsu Ayla", "Merah", "N 1234 AB", 4, 35000));
        kendaraan.add(new KendaraanKecil("Honda Brio", "Kuning", "N 5678 DC", 4, 40000));
        kendaraan.add(new KendaraanKecil("Nissan March", "Putih", "N 9012 EF", 4, 40000));

        kendaraan.add(new KendaraanSedang("Toyota Avanza", "Abu-abu", "N 3456 GH", 7, 60000));
        kendaraan.add(new KendaraanSedang("Mitsubishi Xpander", "Hitam", "N 7890 IJ", 7, 65000));
        kendaraan.add(new KendaraanSedang("Daihatsu Xenia", "Biru", "N 2345 KL", 7, 65000));

        kendaraan.add(new KendaraanBesar("Toyota Hiace", "Putih", "N 4567 MN", 16, 100000));
        kendaraan.add(new KendaraanBesar("Isuzu Elf", "Putih", "N 6789 MN", 24, 150000));
        kendaraan.add(new KendaraanBesar("Big Bus HDD", "Putih", "N 8901 MN", 50, 400000));

        System.out.println("------PILIH KENDARAAN------");
        int nomor = 1;

        for (Kendaraan k : kendaraan) {
            if (k instanceof KendaraanKecil) {
                k.tampilkan(nomor);
            } else if (k instanceof KendaraanSedang) {
                k.tampilkan(nomor);
            } else if (k instanceof KendaraanBesar) {
                k.tampilkan(nomor);
            }
            nomor++;
        }

        System.out.println("----------------------------");
        System.out.println();
        System.out.print("Jumlah pesanan dan transaksi yang ingin dilakukan: ");
        int jumlahPesanan = in.nextInt();
        System.out.println();

        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.println("==================== PEMESANAN KENDARAAN " + (i + 1) + " ====================");
            System.out.print("Pilih nomor kendaraan yang ingin disewa : ");
            int pilihan = in.nextInt();
            in.nextLine();

            Kendaraan k = kendaraan.get(pilihan - 1);
            String transmisi;
            if (k.pilihTransmisi()) {
                while (true) {
                    System.out.print("Ingin transmisi Manual/Matic?           : ");
                    transmisi = in.nextLine();

                    if (transmisi.equalsIgnoreCase("matic") || transmisi.equalsIgnoreCase("manual")) {
                        break;
                    }

                    System.out.println("Input salah! Pilih Manual/Matic");
                }

                transmisi = transmisi.substring(0, 1).toUpperCase() + transmisi.substring(1).toLowerCase();

            } else {
                transmisi = "Manual";
                System.out.println("Transmisi otomatis                      : Manual");
            }

            System.out.print("Lama sewa dalam jam (Bus min. 12 jam)   : ");
            int jamSewa = in.nextInt();
            System.out.print("Tgl & waktu sewa (cont: 2026-12-30T10:00:00): ");
            String tanggalSewa = in.next();
            LocalDateTime tanggal = LocalDateTime.parse(tanggalSewa);
            System.out.println("===============================================================");
            System.out.println();

            Pemesanan p = new Pemesanan(customer, kendaraan.get(pilihan - 1), jamSewa, transmisi, tanggal,
                    tanggal.plusHours(jamSewa), LocalDateTime.now());

            p.cetakStruk(i + 1);
            System.out.println();
            LocalDateTime now = LocalDateTime.now();
            customer.tambahHistory("(" + now + ") " + kendaraan.get(pilihan - 1).getMerk() + " - Rp" + p.totalBiaya());
        }

        customer.cetakHistory();
        System.out.println("\nTerima kasih telah menggunakan layanan FilkomTravel, " + customer.getNama() + "!");
        System.out.println("=============================================================");
    }
}
