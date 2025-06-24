import java.util.Scanner;
public class SPBU06 {
    public static void main(String[] args) {
        AntrianLinkedList06 antrian = new AntrianLinkedList06();
        QueueTransaksi06 riwayat = new QueueTransaksi06(100);
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do { 
            System.out.println("\n--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraaan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("6. Lihat Total Kendaraan Berdasarkan Tipe");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch(pilihan) {
                case 1 -> {
                    String namaJenis;
                    System.out.print("Masukkan Plat Nomor         : ");
                    String plat = sc.nextLine();
                    System.out.println("Masukkan Jenis Kendaraan    : ");
                    System.out.println("1. Mobil");
                    System.out.println("2. Motor");
                    System.out.print("Pilih Jenis Kendaraan (1/2): ");
                    int jenis = sc.nextInt();
                    sc.nextLine(); 
                    if (jenis == 1) {
                        namaJenis = "Mobil";
                    } else if (jenis == 2) {
                        namaJenis = "Motor";
                    } else {
                        System.out.println("Jenis kendaraan tidak valid. Silakan coba lagi.");
                        continue;
                    }
                    System.out.print("Masukkan Merk Kendaraan     : ");
                    String merk  = sc.nextLine();
                    
                    Kendaraan06 kendaraan = new Kendaraan06(plat, namaJenis, merk);
                    antrian.enqueue(kendaraan);
                    System.out.println(">> Kendaraan masuk ke dalam antrian.");
                    break;
                }
                case 2 -> {
                    antrian.print();
                    break;
                }
                case 3 -> {
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + antrian.jumlahAntrian());
                    break;
                }
                case 4 -> {
                    if (antrian.isEmpty()) {
                        System.out.println(">> Tidak ada kendaraan dalam antrian.");
                        return;
                    }

                    int pilihanBBM;
                    Kendaraan06 kendaraan = antrian.layaniKendaraan();
                    System.out.println("Petugas melayani " + kendaraan.platNomor);
                    
                    do {
                        System.out.println("\n-- Pilih Jenis BBM --");
                        System.out.println("1. Pertalite - Rp 10.000/liter");
                        System.out.println("2. Pertamax - Rp 12.000/liter");
                        System.out.println("3. Solar - Rp 14.000/liter");
                        System.out.println("0. Kembali ke Menu Utama");
                        System.out.print("Pilihan BBM: ");
                        pilihanBBM = sc.nextInt();
                        
                        if (pilihanBBM == 0) {
                            return;
                        }
                        
                        if (pilihanBBM < 1 || pilihanBBM > 3) {
                            System.out.println(">> Pilihan tidak valid. Silakan pilih 1-3.");
                        }
                    } while (pilihanBBM < 1 || pilihanBBM > 3);

                    String namaBBM = "";
                    double hargaPerLiter = 0;
                    
                    switch(pilihanBBM) {
                        case 1:
                            namaBBM = "Pertalite";
                            hargaPerLiter = 10000;
                            break;
                        case 2:
                            namaBBM = "Pertamax";  
                            hargaPerLiter = 12000;
                            break;
                        case 3:
                            namaBBM = "Solar";
                            hargaPerLiter = 14000;
                            break;
                    }
                    
                    double liter = 0;
                    while (true) {
                        System.out.print("Masukkan jumlah liter: ");
                        liter = sc.nextDouble();

                        if (liter <= 0) {
                            System.out.println(">> Jumlah liter tidak valid. Silakan coba lagi.");
                        } else {
                            break;
                        }
                    }

                    BBM06 bbm = new BBM06(namaBBM, hargaPerLiter);
                    TransaksiPengisian06 transaksi = new TransaksiPengisian06(kendaraan, bbm, liter);
                    riwayat.inputTransaksi(transaksi);
                    System.out.println(">> Transaksi berhasil dilayani.");
                    break;
                }
                case 5 -> {
                    riwayat.tampilkanRiwayat();
                    break;
                }
                case 6 -> {
                    if (antrian.isEmpty()) {
                        System.out.println(">> Antrian kosong, tidak ada kendaraan untuk ditampilkan.");
                        break;
                    }
                    
                    System.out.println("\n--- Pilih Tipe Kendaraan ---");
                    System.out.println("1. Mobil");
                    System.out.println("2. Motor");
                    System.out.println("3. Tampilkan Semua Tipe");
                    System.out.print("Pilih tipe kendaraan (1/2/3): ");
                    int pilihanTipe = sc.nextInt();
                    sc.nextLine();
                    
                    switch(pilihanTipe) {
                        case 1:
                            int jumlahMobil = antrian.hitungKendaraanBerdasarkanTipe("Mobil");
                            System.out.println(">> Total kendaraan Mobil dalam antrian: " + jumlahMobil);
                            if (jumlahMobil > 0) {
                                antrian.tampilkanKendaraanBerdasarkanTipe("Mobil");
                            }
                            break;
                        case 2:
                            int jumlahMotor = antrian.hitungKendaraanBerdasarkanTipe("Motor");
                            System.out.println(">> Total kendaraan Motor dalam antrian: " + jumlahMotor);
                            if (jumlahMotor > 0) {
                                antrian.tampilkanKendaraanBerdasarkanTipe("Motor");
                            }
                            break;
                        case 3:
                            int jumlahMobil3 = antrian.hitungKendaraanBerdasarkanTipe("Mobil");
                            int jumlahMotor3 = antrian.hitungKendaraanBerdasarkanTipe("Motor");
                            System.out.println("\n--- Ringkasan Kendaraan Berdasarkan Tipe ---");
                            System.out.println("Total Mobil: " + jumlahMobil3);
                            System.out.println("Total Motor: " + jumlahMotor3);
                            System.out.println("Total Semua: " + antrian.jumlahAntrian());
                            
                            if (jumlahMobil3 > 0) {
                                antrian.tampilkanKendaraanBerdasarkanTipe("Mobil");
                            }
                            if (jumlahMotor3 > 0) {
                                antrian.tampilkanKendaraanBerdasarkanTipe("Motor");
                            }
                            break;
                        default:
                            System.out.println(">> Pilihan tidak valid.");
                            break;
                    }
                    break;
                }
                case 0 -> System.out.println("Terima kasih!");
                default -> System.out.println("Menu tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 0);
        sc.close();
    }
}