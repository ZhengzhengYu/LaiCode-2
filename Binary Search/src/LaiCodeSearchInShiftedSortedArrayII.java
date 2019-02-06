public class LaiCodeSearchInShiftedSortedArrayII {
    //Time: O(n) duplicates
    //Space: O(1)
//    public class Solution {
//      public int search(int[] array, int target) {
//        // Write your solution here
//        if (array == null || array.length == 0) {
//          return -1;
//        }
//        int left = 0;
//        int right = array.length - 1;
//        while (left + 1 < right) {
//          int mid = left + (right - left) / 2;
//          if (array[mid] == target) {
//            return mid;
//          }
//          //left = mid = right不能确定在哪一边
//          if (array[mid] == array[left] && array[mid] == array[right]) {
//            left++;
//            right--;
//          } else if (array[mid] >= array[left]) {//left side
//            if (target >= array[left] && target <= array[mid]) {
//              right = mid;
//            } else {
//              left = mid;
//            }
//          } else { //right side
//            if (target >= array[mid] && target <= array[right]) {
//              left = mid;
//            } else {
//              right = mid;
//            }
//          }
//        }
//        if (target == array[left]) {
//          return left;
//        }
//        if (target == array[right]) {
//          return right;
//        }
//        return -1;
//      }
//    }


    //Time: O(n)
    //Space: O(1)
    //这个问题在面试中不会让实现完整程序
    //只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
    //在这种情况下是无法使用二分法的，复杂度是O(n)
    //因此写个for循环最坏也是O(n)，那就写个for循环就好了
    //如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
    //反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
    public class Solution {
        public int search(int[] array, int target) {
            // Write your solution here
            if (array == null || array.length == 0) {
                return -1;
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }


}
