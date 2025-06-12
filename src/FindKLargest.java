public class FindKLargest {
}

/*
Dizinin en büyük k adet elemanını Quick Sort kullanarak büyükten küçüğe sıralayıp yazdıran algoritma

FindKLargest(A[], k){

    InsertionSort(A)

    for ( i = 0 to k )
        print A[i]
}

InsertionSort(A[]){
    n <- lenght(A)

    for(i=1 to n-1)
    {
        key = A[i]
        j= i - 1

        while j>= 0 and A[j] < key{
            A[j+1] = A[j]
            j = j -1
        }
      A[j+1] = key
    }
}

 */