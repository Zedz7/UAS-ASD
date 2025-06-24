public class TransaksiPengisian06 {
    Kendaraan06 kendaraan;
    BBM06 bbm;
    double liter;
    double totalBayar;

    public TransaksiPengisian06(Kendaraan06 kendaraan, BBM06 bbm, double liter){
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.liter = liter;
        totalBayar = bbm.hargaPerliter * liter;
    }
}
