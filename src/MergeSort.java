public class MergeSort {
    /*
    pseudocode
    Merge(A[] , sol , orta , sag) {       // A dizisinin sol..orta ve orta+1..sag aralığını birleştir

    n1 <- orta - sol + 1             // Sol alt dizinin uzunluğu
    n2 <- sag - orta                 // Sağ alt dizinin uzunluğu

    SOL[] <- A[sol .. orta]          // Sol alt diziyi A dizisinden kopyala
    SAG[] <- A[orta+1 .. sag]        // Sağ alt diziyi A dizisinden kopyala

    i <- 0                           // SOL dizisi için başlangıç indisi
    j <- 0                           // SAG dizisi için başlangıç indisi
    k <- sol                         // A dizisinde sıralı elemanların yazılacağı yerin indisi

    while (i < n1 and j < n2)        // Her iki dizide de eleman varken devam et
        if SOL[i] <= SAG[j]          // Hangisi küçükse onu al
            A[k] <- SOL[i]           // SOL'deki eleman küçükse A dizisine yaz
            i <- i + 1               // SOL dizisinde bir sonraki elemana geç
        else
            A[k] <- SAG[j]           // Aksi halde SAG'deki eleman A dizisine yazılır
            j <- j + 1               // SAG dizisinde bir sonraki elemana geç

        k <- k + 1                   // A dizisinde bir sonraki boş yere geç

    while ( i < n1 )                 // SOL dizisinde kalan elemanlar varsa (SAG bitti)
        A[k] <- SOL[i]               // Kalan elemanları A dizisine kopyala
        i <- i + 1
        k <- k + 1

    while ( j < n2 )                 // SAG dizisinde kalan elemanlar varsa (SOL bitti)
        A[k] <- SAG[j]               // Kalan elemanları A dizisine kopyala
        j <- j + 1
        k <- k + 1
 }
    */
    /*
    pseudecode
    MergeSort(A , Sol , Sağ){

    if sol >= sağ
        dur

    orta <- (sag+sol) / 2

    MergeSort(A, Sol , orta )
    MergeSort(A , orta+1 , sağ )
    Merge(A, Sol ,orta, Sag)
    }

    */

    // Merge Sort algoritması: diziyi böl ve sırala
    public static void mergeSort(int[] dizi, int sol, int sag) {
        if (sol < sag) {
            // Ortayı bul
            int orta = (sol + sag) / 2;

            // Sol yarıyı sırala
            mergeSort(dizi, sol, orta);

            // Sağ yarıyı sırala
            mergeSort(dizi, orta + 1, sag);

            // Sıralı iki yarıyı birleştir
            merge(dizi, sol, orta, sag);
        }
    }

    // Merge işlemi: iki sıralı parçayı tek bir sıralı hale getir
    public static void merge(int[] dizi, int sol, int orta, int sag) {
        // Sol ve sağ alt dizilerin uzunlukları
        int n1 = orta - sol + 1;
        int n2 = sag - orta;

        // Geçici diziler
        int[] SOL = new int[n1];
        int[] SAG = new int[n2];

        // Sol diziyi kopyala
        for (int i = 0; i < n1; i++)
            SOL[i] = dizi[sol + i];

        // Sağ diziyi kopyala
        for (int j = 0; j < n2; j++)
            SAG[j] = dizi[orta + 1 + j];

        // İndisler
        int i = 0, j = 0;
        int k = sol;

        // Karşılaştırarak ana diziyi güncelle
        while (i < n1 && j < n2) {
            if (SOL[i] <= SAG[j]) {
                dizi[k++] = SOL[i++];
            } else {
                dizi[k++] = SAG[j++];
            }
        }

        // SOL dizisinde kalanları kopyala
        while (i < n1) {
            dizi[k++] = SOL[i++];
        }

        // SAG dizisinde kalanları kopyala
        while (j < n2) {
            dizi[k++] = SAG[j++];
        }
    }

    // Yardımcı: diziyi yazdır
    public static void yazdir(int[] dizi) {
        for (int eleman : dizi) {
            System.out.print(eleman + " ");
        }
        System.out.println();
    }

    // main fonksiyonu: programın başlangıcı
    public static void main(String[] args) {
        int[] sayilar = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Başlangıç dizisi:");
        yazdir(sayilar);

        // Merge Sort'u uygula
        mergeSort(sayilar, 0, sayilar.length - 1);

        System.out.println("Sıralanmış dizi:");
        yazdir(sayilar);
    }
}
