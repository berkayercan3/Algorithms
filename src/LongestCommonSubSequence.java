import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubSequence {

    public static List<Integer> findLongestCommonSubsequence(int[] A, int[] B) {
        List<Integer> longest = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int k = i;
                int l = j;
                List<Integer> temp = new ArrayList<>();

                while (k < A.length && l < B.length && A[k] == B[l]) {
                    temp.add(A[k]);
                    k++;
                    l++;
                }

                if (temp.size() > longest.size()) {
                    longest = temp;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] A = {5, 4, 3, 1, 2, -1, 6};
        int[] B = {1, 2, -1, 3, 0, 0};

        List<Integer> result = findLongestCommonSubsequence(A, B);
        System.out.println("Longest Common Subsequence: " + result);
    }
}


/*
Pseudo

    LongestCommonSubsequence(A[0..m-1], B[0..n-1]) {
        longest ← emptyList                          // En uzun ortak alt diziyi tutacak liste

        for i ← 0 to m - 1
            for j ← 0 to n - 1
                k ← i
                l ← j
                temp ← emptyList                      // Geçici olarak eşleşen elemanları tutar

                while (k < m and l < n and A[k] == B[l])  // Elemanlar eşleştiği ve sınır dışına çıkılmadığı sürece
                    append A[k] to temp               // Eşleşen elemanı geçici listeye ekle
                    k ← k + 1                         // A dizisinde bir sonraki elemana geç
                    l ← l + 1                         // B dizisinde bir sonraki elemana geç

                if length(temp) > length(longest)     // Eğer geçici eşleşme en uzun olandan uzunsa
                    longest ← temp                    // longest listesini güncelle

        return longest
    }
*/


