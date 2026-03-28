public abstract class Kendaraan {
    protected String merk, warna, plat;
    protected int kapasitas;
    protected double hargaPerJam;

    public Kendaraan(String merk, String warna, String plat, int kapasitas, double hargaPerJam) {
        this.merk = merk;
        this.warna = warna;
        this.plat = plat;
        this.kapasitas = kapasitas;
        this.hargaPerJam = hargaPerJam;
    }

    public String getMerk() {
        return merk;
    }

    public String getWarna() {
        return warna;
    }

    public String getPlat() {
        return plat;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public double getHargaPerJam() {
        return hargaPerJam;
    }

    public abstract double totalHarga(int jam);

    public abstract String tipe();

    public abstract String infoTransmisi();

    public abstract boolean pilihTransmisi();

    public void pilihanSpek() {
        System.out.println("Warna       : " + warna);
        System.out.println("No. Plat    : " + plat);
        System.out.println("Kapasitas   : " + kapasitas);
        System.out.println("Harga/Jam   : Rp " + hargaPerJam);
    }
}