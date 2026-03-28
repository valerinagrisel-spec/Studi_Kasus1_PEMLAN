public class KendaraanSedang extends Kendaraan {
    public KendaraanSedang(String merk, String warna, String plat, int kapasitas, double hargaPerJam) {
        super(merk, warna, plat, kapasitas, hargaPerJam);
    }

    @Override
    public double totalHarga(int jam) {
        return hargaPerJam * jam;
    }

    @Override
    public String tipe() {
        return "TIPE KENDARAAN SEDANG";
    }

    @Override
    public String infoTransmisi() {
        return "Transmisi   : Manual/Matic";
    }

    @Override
    public boolean pilihTransmisi() {
        return true;
    }
}