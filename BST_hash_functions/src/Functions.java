import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class Functions {

    static double pi_approximation_by_pseudorandom(int N){
        ArrayList<Integer> list1 = new ArrayList<Integer>(N);
        ArrayList<Integer> list2 = new ArrayList<Integer>(N);
        Random random = new Random();

        int coprime_counter = 0;
        for(int i = 0; i < N; i++){
            list1.add(random.nextInt(N));
            list2.add(random.nextInt(N));

            if (Functions.isCoPrime(list1.get(i), list2.get(i))){
                coprime_counter ++;
            }
        }
        double P = coprime_counter/ (double) N;
        return Math.sqrt(6/P);
    }

    static boolean isCoPrime(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        if(gcd(a, b) == 1){
            return true;
        } else {
            return false;
        }
    }

    static int gcd(int a, int b){
        if(a == b){
            return a;
        } else if (a > b){
            return gcd(a-b, a);
        } else {
            return gcd(b-a, a);
        }
    }

    static byte[] hashBasedRandom(String string) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] data1 = string.getBytes(StandardCharsets.UTF_8);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(data1);
    }

    static double pi_approximation_from_SHA256(int length, byte[][] a, byte[][] b){
        int coprime_counter = 0;
        int a_1[] = new int[a[0].length];
        int b_1[] = new int[a[0].length];

        for (int j = 0; j<length; j++){
            for(int i = 0; i<a[0].length; i++){

                a_1[i] = a[j][i] + a[j][i%3] + a[j][i%11] + a[j][i%2];
                b_1[i] = b[j][i] + b[j][i%3] + b[j][i%11] +  b[j][i%2];

                if(isCoPrime(a_1[i], b_1[i])){
                    coprime_counter ++;
                }
            }
        }
        double P = coprime_counter/((double)(length*a[0].length));
        return Math.sqrt(6/P);
    }
}
