public class LaiCodeKthSmallestInTwoSortedArrays {
    //Method 1:谁小移谁
    //Time: O(n)
    //Space: O(1)
    public class Solution {
        public int kth(int[] a, int[] b, int k) {
            // Write your solution here
            if (a == null || a.length == 0) {
                return b[k - 1];
            }
            if (b == null || b.length == 0) {
                return a[k - 1];
            }
            int i = 0;
            int j = 0;
            int num = 0;
            while (num < k - 1) {
                if (i < a.length && j < b.length) {
                    if (a[i] < b[j]) {
                        i++;
                    } else {
                        j++;
                    }
                } else if (i < a.length) {
                    i++;
                } else if (j < b.length) {
                    j++;
                }
                num++;
            }

            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    return a[i];
                } else {
                    return b[j];
                }
            } else if (i < a.length) {
                return a[i];
            } else {
                return b[j];
            }
        }
    }

}
