package org.example;

import java.util.Arrays;
import java.util.HashSet;

//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
public class ContainsDuplicate216 {
    public boolean containsDuplicateTLE(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicateHashSet(int[] nums) {
        HashSet<Integer> duplicates = new HashSet<>();
        for (int num : nums) {
            if (duplicates.contains(num)) {
                return true;
            }
            duplicates.add(num);
        }
        return false;
    }
}
