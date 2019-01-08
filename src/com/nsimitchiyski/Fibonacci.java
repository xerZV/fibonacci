package com.nsimitchiyski;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Fibonacci {

    public static void main(String[] args) {
        //Get 10th Fibonacci number (element)
        System.out.println(getNthfibonacciElement(10));

        //Get 1st-10th Fibonacci numbers (elements)
        System.out.println(fibonacci(10));
    }

    public static List<BigInteger> fibonacci(int limit) {
        if (limit <= 0)
            return null;

        return Stream
                .iterate(new BigInteger[]{BigInteger.ONE, BigInteger.ONE}, bigIntArray -> new BigInteger[]{bigIntArray[1], bigIntArray[0].add(bigIntArray[1])})
                .limit(limit)
                .map(bigIntArray -> bigIntArray[0])
                .collect(Collectors.toList());
    }

    public static BigInteger getNthfibonacciElement(final int nTh) {
        if (nTh <= 0)
            return null;

        return Stream
                .iterate(new BigInteger[]{BigInteger.ONE, BigInteger.ONE}, bigIntArray -> new BigInteger[]{bigIntArray[1], bigIntArray[0].add(bigIntArray[1])})
                .skip(nTh - 1)
                .findFirst()
                .get()[0];
    }
}
