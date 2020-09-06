package com.skillip.java;

import java.util.*;

public class Solution {
    private int[] tmp;
    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return tmp;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if(l < r) {
            int m = (l + r) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            int i = l;
            int j = m + 1;
            int cnt = 0;
            while(i <= m && j <= r) {
                if(nums[i] < nums[j]) {
                    tmp[cnt++] = nums[i++];
                }else {
                    tmp[cnt++] = nums[j++];
                }
            }
            while(i <= m) tmp[cnt++] = nums[i++];
            while(j <= r) tmp[cnt++] = nums[j++];

            int n = 0;
            while(n < r - l + 1) {
                nums[n + l] = tmp[n];
                n++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,6,2};
        System.out.println(Arrays.toString(new Solution().sortArray(arr)));
    }
}
