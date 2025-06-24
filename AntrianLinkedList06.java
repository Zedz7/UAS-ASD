public class AntrianLinkedList06 {
    NodeKendaraan06 head;
    NodeKendaraan06 tail;
    int size;

    public AntrianLinkedList06(){
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void enqueue(Kendaraan06 kendaraan){
        NodeKendaraan06 data = new NodeKendaraan06(kendaraan, null);
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        size++;
    }

    public void print(){
        if (!isEmpty()) {
            NodeKendaraan06 tmp = head;
            System.out.println("\n--- Antrian Kendaraan ---");
            System.out.println("Antrian Kendaraan:");
            while (tmp != null) {
                tmp.data.tampilkanInformasi();
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Antrian masih kosong");
        }
    }

    public int jumlahAntrian(){
        return size;
    }
    public Kendaraan06 layaniKendaraan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada kendaraan untuk dilayani.");
            return null;
        }
        Kendaraan06 kendaraan = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return kendaraan;
    }
    public int hitungKendaraanBerdasarkanTipe(String tipe) {
        int count = 0;
        NodeKendaraan06 tmp = head;
        while (tmp != null) {
            if (tmp.data.tipe.equalsIgnoreCase(tipe)) {
                count++;
            }
            tmp = tmp.next;
        }
        return count;
    }
    public void tampilkanKendaraanBerdasarkanTipe(String tipe) {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong");
            return;
        }

        NodeKendaraan06 tmp = head;
        int count = 0;
        System.out.println("\n--- Daftar Kendaraan Tipe " + tipe + " ---");
        
        while (tmp != null) {
            if (tmp.data.tipe.equalsIgnoreCase(tipe)) {
                count++;
                System.out.println("Kendaraan ke-" + count + ":");
                tmp.data.tampilkanInformasi();
                System.out.println("---");
            }
            tmp = tmp.next;
        }
        
        if (count == 0) {
            System.out.println("Tidak ada kendaraan dengan tipe " + tipe + " dalam antrian.");
        } else {
            System.out.println("Total kendaraan " + tipe + ": " + count);
        }
    }
}
