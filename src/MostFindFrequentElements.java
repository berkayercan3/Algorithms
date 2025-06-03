public class MostFindFrequentElements {

    public static int mostFrequentElement(int[] A) {
        int maxCount = 0;
        int mostFreq = A[0];

        for (int i = 0; i < A.length; i++) {
            int count = 0;

            for (int j = 0; j < A.length; j++) {
                if (A[i] == A[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostFreq = A[i];
            }
        }
        return mostFreq;
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 2, 3, 8, 5, 6, 5};
        int result = mostFrequentElement(array);
        System.out.println("En çok tekrar eden eleman: " + result);
    }
}


/*
PseudoCode

MostFrequentElement(A[0..n-1]):
    maxCount ← 0
    mostFreq ← A[0]

    for i ← 0 to n - 1:
        count ← 0

        for j ← 0 to n - 1:
            if A[i] == A[j]:
                count ← count + 1

        if count > maxCount:
            maxCount ← count
            mostFreq ← A[i]

    return mostFreq
*/
