
/*
Merge(A[] , sol , orta , sag)

n1 <- orta - sol +1
n2 <- sag - orta

Sol[] <- A[sol ... orta ]
Sag[] <- A[orta + 1 ... sag ]

i <- 0
j <- 0
k <- sol

while( i <= n1 and j <= n2 )
    if( Sol[i] < Sag[j] )
        A[k] <- Sol [i]
        i <- i + 1
    else
        A[k] <- Sag[j]
        j <- j + 1
  k <- k + 1

while( i < n1 )
    A[k] <- Sol[i]
    i <- i + 1
    k <- k + 1

while( j < n2 )
    A[k] <- Sag[j]
    j <- j + 1
    k <- k + 1
 */

/*
MergeSort(A[] , sol , sag )
if(sol < sag ){
    MergeSort(A[] , sol , orta )
    MergeSort(A[] , orta + 1 , sag )
    Merge( A[] , sol , orta , sag )
}
 */

public class MergeSort {
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






