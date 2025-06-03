public class MoveZerosToEnd {
    public static void moveZerosToEnd(int[] arr) {
        int endIndex = arr.length - 1;

        for (int i = 0; i < endIndex; i++) {
            if (arr[i] == 0 && i < endIndex) {
                while (arr[endIndex] == 0 && i < endIndex) {
                    endIndex--;
                }

                int temp = arr[i];
                arr[i] = arr[endIndex];
                arr[endIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 3, 0, 5, 0, 7};
        System.out.println("Before:");
        printArray(array);
        moveZerosToEnd(array);
        System.out.println("After:");
        printArray(array);
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

/*
PseudoCode
    MoveZerosToEnd(A[])
        endIndex ← n - 1

        for i ← 0 to endIndex - 1
            if A[i] == 0 and i < endIndex
                while A[endIndex] == 0 and i < endIndex
                    endIndex ← endIndex - 1

                // Swap A[i] and A[endIndex]
                temp ← A[i]
                A[i] ← A[endIndex]
                A[endIndex] ← temp

 */
