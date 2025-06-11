public class MergeSort {
    public static void mergeSort(int[] dizi, int sol, int sag) {
        if (sol < sag) {
            int orta = (sol + sag) / 2;
            mergeSort(dizi, sol, orta);
            mergeSort(dizi, orta + 1, sag);
            merge(dizi, sol, orta, sag);
        }
    }

    public static void merge(int[] dizi, int sol, int orta, int sag) {
        int n1 = orta - sol + 1;
        int n2 = sag - orta;

        int[] SOL = new int[n1];
        int[] SAG = new int[n2];

        for (int i = 0; i < n1; i++)
            SOL[i] = dizi[sol + i];

        for (int j = 0; j < n2; j++)
            SAG[j] = dizi[orta + 1 + j];

        int i = 0, j = 0;
        int k = sol;

        while (i < n1 && j < n2) {
            if (SOL[i] <= SAG[j]) {
                dizi[k++] = SOL[i++];
            } else {
                dizi[k++] = SAG[j++];
            }
        }

        while (i < n1) {
            dizi[k++] = SOL[i++];
        }

        while (j < n2) {
            dizi[k++] = SAG[j++];
        }
    }

    public static void yazdir(int[] dizi) {
        for (int eleman : dizi) {
            System.out.print(eleman + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] sayilar = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Başlangıç dizisi:");
        yazdir(sayilar);
        mergeSort(sayilar, 0, sayilar.length - 1);
        System.out.println("Sıralanmış dizi:");
        yazdir(sayilar);
    }
}


/*
Merge(A[] , sol , orta , sag)

n1 <- orta - sol +1                 // Sol alt dizinin uzunluğu
n2 <- sag - orta                   // Sağ alt dizinin uzunluğu

Sol[] <- A[sol ... orta ]          // Sol diziyi kopyala
Sag[] <- A[orta + 1 ... sag ]      // Sağ diziyi kopyala

i <- 0                             // Sol diziyi gezmek için indeks
j <- 0                             // Sağ diziyi gezmek için indeks
k <- sol                           // Ana dizi için başlangıç indeks

while( i <= n1 and j <= n2 )       // Her iki alt dizi de bitene kadar devam et
    if( Sol[i] < Sag[j] )          // Küçük olan elemanı al
        A[k] <- Sol [i]
        i <- i + 1
    else
        A[k] <- Sag[j]
        j <- j + 1
    k <- k + 1

while( i < n1 )                    // Sol dizide kalan varsa kopyala
    A[k] <- Sol[i]
    i <- i + 1
    k <- k + 1

while( j < n2 )                    // Sağ dizide kalan varsa kopyala
    A[k] <- Sag[j]
    j <- j + 1
    k <- k + 1
 */

/*
MergeSort(A[] , sol , sag )
if(sol < sag ){                                       // Dizi tek elemanlı değilse
    MergeSort(A[] , sol , orta )                      // Sol yarıyı sırala
    MergeSort(A[] , orta + 1 , sag )                  // Sağ yarıyı sırala
    Merge( A[] , sol , orta , sag )                   // İki yarıyı birleştir
}
 */




