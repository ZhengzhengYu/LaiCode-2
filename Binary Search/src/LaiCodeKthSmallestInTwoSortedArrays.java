public class LaiCodeKthSmallestInTwoSortedArrays {
    //Method 1:谁小移谁
    //Time: O(n)
    //Space: O(1)
//    public class Solution {
//        public int kth(int[] a, int[] b, int k) {
//            // Write your solution here
//            if (a == null || a.length == 0) {
//                return b[k - 1];
//            }
//            if (b == null || b.length == 0) {
//                return a[k - 1];
//            }
//            int i = 0;
//            int j = 0;
//            int num = 0;
//            while (num < k - 1) {
//                if (i < a.length && j < b.length) {
//                    if (a[i] < b[j]) {
//                        i++;
//                    } else {
//                        j++;
//                    }
//                } else if (i < a.length) {
//                    i++;
//                } else if (j < b.length) {
//                    j++;
//                }
//                num++;
//            }
//
//            if (i < a.length && j < b.length) {
//                if (a[i] < b[j]) {
//                    return a[i];
//                } else {
//                    return b[j];
//                }
//            } else if (i < a.length) {
//                return a[i];
//            } else {
//                return b[j];
//            }
//        }
//    }

    //Method 2:Binary Search
    //Time: O(log k)
    //Space: O(k)
    public class Solution {
        public int kth(int[] a, int[] b, int k) {
            if (a == null || a.length == 0) {
                return b[k - 1];
            }
            if (b == null || b.length == 0) {
                return a[k - 1];
            }

            return helper(a, 0, b, 0, k);
        }

        //find the kth smallest from a starts with aleft and b starts with bleft
        private int helper(int[] a, int aleft, int[] b, int bleft, int k) {
            //base case
            //if one of two array is empty
            if (aleft >= a.length) {
                return b[bleft + k - 1];
            }
            if (bleft >= b.length) {
                return a[aleft + k - 1];
            }
            //two array are not empty
            if (k == 1) {
                return Math.min(a[aleft], b[bleft]);
            }

            int amid = aleft + k / 2 - 1;
            int bmid = bleft + k / 2 - 1;

            int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
            int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];

            if (aval > bval) {
                return helper(a, aleft, b, bmid + 1, k - k / 2);
            } else {
                return helper(a, amid + 1, b, bleft, k - k / 2);
            }
        }

    }

}
