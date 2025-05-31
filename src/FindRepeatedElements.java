import java.util.ArrayList;
import java.util.List;

//example:find repeated elements in a array

public class FindRepeatedElements {
    public static List<Integer> findRepeated(int[] A) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j] && !result.contains(A[j])) {
                    result.add(A[j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = {2, 4, 6, 2, 4, 7, 9};
        System.out.println(findRepeated(arr));
    }
}

/*
PseudoCode
findRepeatedElements(A[0..n-1]):
    B ← []                        // Empty list to store repeated elements

    for i ← 0 to n - 2:
        for j ← i + 1 to n - 1:
            if A[i] == A[j] and A[j] not in B:
                append A[j] to B

    return B
 */