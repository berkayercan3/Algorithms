public class HeapSort {
    void heapify(int[] A, int n, int i) {
        int largest = i;            // Şu anki kök
        int left = 2 * i + 1;       // Sol çocuk
        int right = 2 * i + 2;      // Sağ çocuk

        if (left < n && A[left] > A[largest])
            largest = left;

        if (right < n && A[right] > A[largest])
            largest = right;

        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            heapify(A, n, largest);
        }
    }

    void buildHeap(int[] A, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }
    }

    void heapSort(int[] A) {
        int n = A.length;
        buildHeap(A, n);
        for (int i = n - 1; i >= 1; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            heapify(A, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] A = {12, 11, 13, 5, 6, 7};
        HeapSort sorter = new HeapSort();
        sorter.heapSort(A);
        System.out.println("Sıralı dizi:");
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}

/*
HeapSortPseudeo

   HeapSort(A){
       n <- lenght(A)               //dizi uzunluğunu aldık
       BuildHeap(A,n)               //diziyi maxHeap yapısına çevirdik artık bir heap oluşmuş oldu elimizde
       for i <- n-1 to 1            //build heap kısmında yapılan heapta kök A[0] da idi
            A[0] swap A[i]          //burada kökü son eleman ile yer değiştirerek ilerliyoruz,her seferinde sondan bir önce ile A[0] yer değiştirmiş olur
            Heapify(A, i, 0)        //kalan kısmı tekrar heap yapıyoruz ve büyük değer A[0] ın yerine gidiyor
   }

   BuildHeap(A, n){
        for i <- n/2 -1 to 0        //yaprak olmayan son düğümden köke kadar,
            Heapify(A, n, i)        //alt ağaçları heap'e çevir tekrar
   }

   Heapify(A, n, i){
        largest <- i                //şu anki kök düğüm (i)
        left <- 2*i + 1             //sol çocuk indeksi
        right <- 2*i+2              //sağ çocuk indeksi

        if left < n and A[Left] > A[largest]    //sol çocuk büyükse
            largest <- left

        if right < n and A[right] > A[largest]  //sağ çocuk büyükse
            largest <- right

        if largest != i                         //en büyük çocuk kök değilse
            swap A[i], A[largest]               //kök ile yer değiş
            Heapify(A, n, largest)              //yer değiştirmeden sonra tekrar heapify
   }

 */

