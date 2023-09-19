package com.mattmattica.utils;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class CollectionUtility {
    private CollectionUtility() {}

    public static <T, U> boolean setSubcontains(Set<T> haystack, Function<T,U> function, U needle) {
        return haystack.stream().anyMatch(t -> function.apply(t).equals(needle));
    }

    /**
     * Reduces the {@code originalSet} of type X to new set of type X where the image of {@code function} F(X)=Y is unique for all X
     * @param originalSet Set to filter items from
     * @param function Function whose output with be used as the uniqueness constraint
     * @return A new {@link Set<X>} containing elements to which {@code function.apply(X)} would yield a unique set
     * @param <X> Type of objects in the set
     * @param <Y> Type of objects to compare uniqueness on
     */
    public static <X, Y> Set<X> filterSet(Set<X> originalSet, Function<X, Y> function) {
        Set<X> subset = new HashSet<>();
        Set<Y> images = new HashSet<>();
        for (X x : originalSet) {
            Y image = function.apply(x);
            if (images.add(image)) { // If f(x) \not\in images Then add it and include the x in the unique inputs
                subset.add(x);
            }
        }
        return subset;
    }

    public static <T, U> boolean listSubcontains(List<T> haystack, Function<T,U> function, U needle) {
        return haystack.stream().anyMatch(t -> function.apply(t).equals(needle));
    }

    public static int[] parseInt(String[] strings) {
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; ++i) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        return nums;
    }

    public static long[] parseLong(String[] strings) {
        long[] nums = new long[strings.length];
        for (int i = 0; i < strings.length; ++i) {
            nums[i] = Long.parseLong(strings[i]);
        }
        return nums;
    }

    /**
     * Return the asymmetric difference between setA and setB. These are the elements in setA that are NOT in setB.
     * <br> For example, {1, 2, 3} - {3, 4, 5} = {1, 2}
     * <br> This method does not mutate either set. It returns a deep copy (with shallow copied children)
     * @param setA set A
     * @param setB set B
     * @return set A - B
     * @param <X> type of set A and B
     */
    public static <X> Set<X> asymmetricDifference(Set<X> setA, Set<X> setB) {
        Set<X> aMinusB = new HashSet<>(setA);
        aMinusB.removeAll(setB);
        return aMinusB;
    }


    /**
     * Non-parallel stream
     */
    public static <X> Stream<X> streamOf(Iterable<X> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    public static <X> List<X> listOf(Iterable<X> iterable) {
        return streamOf(iterable).toList();
    }
}
