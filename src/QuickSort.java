public class QuickSort {

    void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(A, low, high);
            quickSort(A, low, pivotIndex - 1);
            quickSort(A, pivotIndex + 1, high);
        }
    }

    int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (A[j] < pivot) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] dizi = {10, 7, 8, 9, 1, 5};

        QuickSort sorter = new QuickSort();
        sorter.quickSort(dizi, 0, dizi.length - 1);

        System.out.println("Sıralı dizi:");
        for (int num : dizi) {
            System.out.print(num + " ");
        }
    }
}

/*
QuickSort PseudoCode

    Partition(A, low, high){
    pivot ← A[high]         // Pivot: dizinin sonundaki eleman
    i ← low - 1             // i: küçük elemanları yerleştireceğimiz bölgeyi takip eder

    for j ← low to high - 1     // j: diziyi tarayan değişken
        if A[j] < pivot         // Eğer eleman pivottan küçükse:
            i ← i + 1
            swap A[i], A[j]     // Küçüğü i bölgesine taşı (önlere koy)

    swap A[i+1], A[high]        // Pivotu doğru yerine koy (i+1'e)
    return i + 1                // Yeni pivotun yeri
    }

    QuickSort(A, Low, High{
        if low < high
            pivotIndex <- Partition(A, Low, High)   //Pivotun DOĞRU olan yerini bulduk bu nedenle
            QuickSort(A, Low , pivotIndex -1)       //Dizinin sol tarafını sıralarken tekrardan doğru olan konumdaki bir indisi sıralamaya sokmamılıyız o nedenle ındex-1
            QuickSort(A, pivotIndex + 1, High)      //Aynı şekilde sağ tarafı sıralarken de uyguluyoruz
    }
 */