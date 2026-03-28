public class KendaraanBesar extends Kendaraan {
    public KendaraanBesar(String merk, String warna, String plat, int kapasitas, double hargaPerJam) {
        super(merk, warna, plat, kapasitas, hargaPerJam);
    }

    @Override
    public double totalHarga(int jam) {
        return hargaPerJam * jam;
    }

    @Override
    public String tipe() {
        return "TIPE KENDARAAN BESAR";
    }

    @Override
    public String infoTransmisi() {
        return "Transmisi   : Manual";
    }

    @Override
    public boolean pilihTransmisi() {
        return false;
    }
}
