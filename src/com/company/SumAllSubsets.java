package com.company;

class Solution {
    /*
     * @param : the given number
     * @return: Sum of elements in subsets
     */
    public static void main(String[] args) {
        System.out.println(new Solution().subSum(3));
    }

    public int subSum(int n) {
        // write your code here
        return subSum(0, n - 1, 0);
    }

    public int subSum(int l, int r, int sum) {
        // write your code here
        int tSum = 0;
        if (l > r)
            return sum;
        tSum += subSum(l + 1, r, sum + l + 1);
        tSum += subSum(l + 1, r, sum);
        return tSum;
    }
}