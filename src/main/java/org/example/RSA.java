package org.example;

import java.math.BigInteger;

public class RSA {
    public static void main(String[] args) {
        // Generate two distinct prime numbers
        BigInteger p = new BigInteger("61");
        BigInteger q = new BigInteger("53");

        // Compute n = p*q
        BigInteger n = p.multiply(q);

        // Compute Euler's function φ(n) = (p-1)*(q-1)
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // Choose e such that 1 < e < φ(n) and gcd(e, φ(n)) = 1
        BigInteger e = new BigInteger("17");

        // Compute d such that (d*e) % φ(n) = 1
        BigInteger d = e.modInverse(phi);

        // Public key: (e, n)
        // Private key: (d, n)
        System.out.println("Public Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n): (" + d + ", " + n + ")");
    }
}
