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

    Partition(A, Low , High ){      //Arayyi iki parçaya böleceğiz
        pivot <- A[High]            //Bu bölme sırasında son değeri pivot olarak seçeceğiz
        i <- Low -1                 //En düşük değerden bir öncesi yani aslında -1. indisi i değeri olarak seçeceğiz, i değeri bizim pivottan küçük oln low değerlerimiz için kalacak

    for ( j <- Low to High - 1 )    //j değerimiz de pivottan büyük olan high değerler için, ilk başta low indisten başlatıyoruz
        if A[j] < pivot             //Pivottan küçük olan değerleri kontrol ediyoruz
            i = i + 1               //Küçük olma durumunda i yi 1 arttırıyoruz ve yer açıyoruz ama 1. adımda i j ile aynı indise geleceği için bir değişiklik olmaz,
                                        // fakat sonraki adımlarda j her seferinde değeri pivot ile kontrol edeceğği için eğer pivottan küçük olma durumu varsa i bir artarak arttığı
            swap A[i] , A[j             //indisteki değer ile j yi swap eder bu sayede pivottan küçük olan ifadeleri low kısmına bölmüş oluruz


    swap A[i+1] , A[High]           //Bu yer değiştirmenin ardından artık array 2 ye bölündüğü için yen ipivot değerimiz Low arrayindan hemen sonra ilk boş olan yere geçer o nedenle i + 1
    return i + 1                    // pivotun olduğu konumu return ettik
    }

    QuickSort(A, Low, High{
        if low < high
            pivotIndex <- Partition(A, Low, High)   //Pivotun DOĞRU olan yerini bulduk bu nedenle
            QuickSort(A, Low , pivotIndex -1)       //Dizinin sol tarafını sıralarken tekrardan doğru olan konumdaki bir indisi sıralamaya sokmamılıyız o nedenle ındex-1
            QuickSort(A, pivotIndex + 1, High)      //Aynı şekilde sağ tarafı sıralarken de uyguluyoruz
    }
 */