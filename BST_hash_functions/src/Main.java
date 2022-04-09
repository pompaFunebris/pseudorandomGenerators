import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        double pi_approximation = Functions.pi_approximation_by_pseudorandom(10000);
        System.out.println("Approximated pi value using java Randint is: " + pi_approximation);
        System.out.println("Pi value is: " + Math.PI);

        String[] to_hash = {"J1h42n", "An31ne", "1c211", "Kr41ak6ow", "4AGH111", "Spag1set14ti", "S1n8", "K321a2ne", "ada", "dfwd", "dawd", "dawko"};
        byte[] hash1 = Functions.hashBasedRandom(to_hash[0]);
        byte[] hash2 = Functions.hashBasedRandom(to_hash[1]);
        byte[] hash3 = Functions.hashBasedRandom(to_hash[2]);
        byte[] hash4 = Functions.hashBasedRandom(to_hash[3]);
        byte[] hash5 = Functions.hashBasedRandom(to_hash[4]);
        byte[] hash6 = Functions.hashBasedRandom(to_hash[5]);
        byte[] hash7 = Functions.hashBasedRandom(to_hash[6]);
        byte[] hash8 = Functions.hashBasedRandom(to_hash[7]);
        byte[] hash9 = Functions.hashBasedRandom(to_hash[8]);
        byte[] hash10 = Functions.hashBasedRandom(to_hash[9]);
        byte[] hash11 = Functions.hashBasedRandom(to_hash[10]);
        byte[] hash12 = Functions.hashBasedRandom(to_hash[11]);

        byte[][] fullhash1 = {hash1, hash2, hash3, hash4, hash5, hash6};
        byte[][] fullhash2 = {hash7, hash8, hash9, hash10, hash11, hash12};

        double pi_approximation2 = Functions.pi_approximation_from_SHA256(fullhash1.length, fullhash1, fullhash2);
        System.out.println("Approximated pi value using SHA256 is: " + pi_approximation2);

    }
}
