import java.time.LocalDateTime;

public class Pemesanan {
    private Customer customer;
    private Kendaraan kendaraan;
    private int jamSewa;
    private String transmisi;
    private LocalDateTime tanggal;
    private LocalDateTime tanggalSelesai;
    private LocalDateTime waktuPemesanan;

    public Pemesanan(Customer customer, Kendaraan kendaraan, int jamSewa, String transmisi, LocalDateTime tanggal,
            LocalDateTime tanggalSelesai, LocalDateTime waktuPemesanan) {
        this.customer = customer;
        this.kendaraan = kendaraan;
        this.jamSewa = jamSewa;
        this.transmisi = transmisi;
        this.tanggal = tanggal;
        this.tanggalSelesai = tanggalSelesai;
        this.waktuPemesanan = waktuPemesanan;
    }

    public double totalBiaya() {
        double biaya = kendaraan.totalHarga(jamSewa);
        if (transmisi.equalsIgnoreCase("matic")) {
            biaya += 10000;
        }
        return biaya - (biaya * customer.getDiskon());
    }

    public LocalDateTime getWaktuPemesanan() {
        return waktuPemesanan;
    }

    public void cetakStruk(int nomor) {
        System.out.println("\n===============================");
        System.out.println("        NOTA PEMESANAN " + nomor + "      ");
        System.out.println("===============================");
        System.out.println("Nama        : " + customer.getNama() + " " + customer.getStatus());
        System.out.println("Email       : " + customer.getEmail());
        System.out.println("No HP       : " + customer.getNoHp());
        System.out.println("Diskon      : " + (int) (customer.getDiskon() * 100) + "%");
        System.out.println();
        System.out.println("Kendaraan   : " + kendaraan.getMerk());
        System.out.println("Warna       : " + kendaraan.getWarna());
        System.out.println("Plat        : " + kendaraan.getPlat());
        System.out.println("Kapasitas   : " + kendaraan.getKapasitas() + " orang");
        System.out.println("Harga/Jam   : Rp " + kendaraan.getHargaPerJam());
        System.out.println("Transmisi   : " + transmisi);
        System.out.println("Jam Sewa    : " + jamSewa + " jam");
        System.out.println();
        System.out.println("Tanggal Sewa: " + tanggal);
        System.out.println("Tanggal Selesai: " + tanggalSelesai);
        System.out.println("-------------------------------");
        System.out.println("Total Biaya: Rp" + totalBiaya());
        System.out.println("-------------------------------");
    }
}
