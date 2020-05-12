package com.company.topinterview.easycollection.math;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimesUsingSieveOfEratosthenes(2));
    }

    private static int isPrime(int n) {
        for (int i = 2; i * i <= n; i++) // Do not use the time intensive Math.sqrt function
        {
            if (n % i == 0)
                return 0;
        }
        return 1;
    }

    public int countPrimesUsingSieveOfEratosthenes(int n) {
        n--;
        int count = 0;
        int[] primes = new int[n - 1];
        long num;
        int i;
        for (i = 2; i * i <= n; i++) {
            if (primes[i - 2] == 0) {
                count++;
                num = i * i;
                while (num <= n) {
                    primes[(int) num - 2] = 1;
                    num += i;
                }
            }
        }
        /* The below loop can actually be avoided because the above loop has already marked all non primes,n-nonprimes will be primes!*/
        for (i = n; (long) i * i > n; i--) {
            if (primes[i - 2] == 0)
                count++;
        }
        return count;
    }

    //O(n^1.5) time O(1) space
    public int countPrimesUsingSqrt(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i);
        }
        return count;
    }
}
