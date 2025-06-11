import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubSequence {

    public static int enbuyukAltToplam(int[] A) {
        int globalMaxToplam = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            int toplam = A[i];
            int maxToplamI = A[i];

            for (int j = i + 1; j < A.length; j++) {
                toplam += A[j];
                if (toplam > maxToplamI) {
                    maxToplamI = toplam;
                }
            }

            if (maxToplamI > globalMaxToplam) {
                globalMaxToplam = maxToplamI;
            }
        }

        return globalMaxToplam;
    }

    public static void main(String[] args) {
        int[] dizi = {4, -1, 2, 1, -5, 4};
        int sonuc = enbuyukAltToplam(dizi);
        System.out.println("En büyük alt toplam: " + sonuc);
    }
}



/*
enbuyuk_alt_toplam(A[0..n-1])
Girdi : n uzunluğunda bir A dizisi
Çıktı : A’nın ardışık alt dizileri içinde toplamı en büyük olan alt dizinin toplamı

    global_max_toplam ← -∞

    for i ← 0 to n - 1
        toplam ← A[i]
        max_toplam_i ← A[i]

        for j ← i + 1 to n - 1
            toplam ← toplam + A[j]
            if toplam > max_toplam_i
                max_toplam_i ← toplam

        if max_toplam_i > global_max_toplam
            global_max_toplam ← max_toplam_i

    return global_max_toplam

*/


