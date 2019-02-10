import java.util.ArrayList;
import java.util.List;

public class LaiCodeKClosestInSortedArray {
    //Method 1:先找到最接近的，然后左右开花
//Time: O((log n) + k)
//Space: O(k)
//如果k趋近于n，time: O（n）这个方法不是最优解

//public class Solution {
//  public int[] kClosest(int[] array, int target, int k) {
//    // Write your solution here
//    if (array == null || array.length == 0 || k == 0) {
//      return new int[0];
//    }
//    int mid = findClosest(array, 0, array.length - 1, target);
//    int left = mid - 1;
//    int right = mid + 1;
//    int[] result = new int[k];
//    result[0] = array[mid];
//    for (int i = 1; i < k; i++) {
//      if (left >= 0 && right < array.length) {
//        if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
//          result[i] = array[left--];
//        } else {
//          result[i] = array[right++];
//        }
//      } else if (left >= 0) {
//        result[i] = array[left--];
//      } else if (right < array.length) {
//        result[i] = array[right++];
//      }
//    }
//    return result;
//  }
//
//  private int findClosest(int[] array, int left, int right, int target) {
//    while (left + 1 < right) {
//      int mid = left + (right - left) / 2;
//      if (array[mid] == target) {
//        return mid;
//      } else if (array[mid] > target) {
//        right = mid;
//      } else {
//        left = mid;
//      }
//    }
//    if (array[left] == target) {
//      return left;
//    }
//    if (array[right] == target) {
//      return right;
//    }
//    if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
//      return left;
//    } else {
//      return right;
//    }
//  }
//
//}


//Method 2:找到 <= target的最大的index,没找到返回-1，然后左右开花
//Time: O(log n + k)
//Space: O(k)
//如果k趋近于n，time: O（n）这个方法不是最优解

//public class Solution {
//  public int[] kClosest(int[] array, int target, int k) {
//    // Write your solution here
//    if (array == null || array.length == 0 || k == 0) {
//      return new int[0];
//    }
//    int left = largestSmallerEquals(array, target);
//    int right = left + 1;
//    int[] result = new int[k];
//    for (int i = 0; i < k; i++) {
//      if (left >= 0 && right <= array.length - 1) {
//        if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
//          result[i] = array[left--];
//        } else {
//          result[i] = array[right++];
//        }
//      } else if (left >= 0) {
//        result[i] = array[left--];
//      } else {
//        result[i] = array[right++];
//      }
//    }
//    return result;
//  }
//
//  //找到 <= target的最大的index,没找到返回-1
//  private int largestSmallerEquals(int[] array, int target) {
//    int left = 0;
//    int right = array.length - 1;
//    while (left + 1 < right) {
//      int mid = left + (right - left) / 2;
//      if (array[mid] == target) {
//        left = mid;
//      } else if (array[mid] > target) {
//        right = mid;
//      } else {
//        left = mid;
//      }
//    }
//    if (array[right] <= target) {
//      return right;
//    }
//    if (array[left] <= target) {
//      return left;
//    }
//    return -1;
//  }
//
//}


    //Method 3: 先找到closest的index
    //          然后分成[left, index]和[index + 1, right]两个数组
    //          问题变成两个数组里面找最小的k个Math.abs(array[i] - target)
    //分析：这个方法不是按照要求排序的
    //Time: O(log n + log k) = O(log n)
    //Space:O(k)
    public class Solution {
        public int[] kClosest(int[] array, int target, int k) {
            // Write your solution here
            if (array == null || array.length == 0 || k == 0) {
                return new int[0];
            }
            int mid = findClosest(array, target);

            List<Integer> result = new ArrayList<>();
            findK(array, mid, mid + 1, result, k, target);

            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = result.get(i);
            }
            return res;
        }

        //return the closest index arbitrary
        private int findClosest(int[] array, int target) {
            int left = 0;
            int right = array.length - 1;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (array[mid] == target) {
                    return mid;
                } else if (array[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            //包含array只有一个元素的conner case
            if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
                return left;
            } else {
                return right;
            }
        }

        private void findK(int[] array, int aright, int bleft, List<Integer> result, int k, int target) {
            //base case
            if (aright < 0) {
                addResult(array, bleft, bleft + k - 1, result);
                return;
            }
            if (bleft >= array.length) {
                addResult(array, aright - k + 1, aright, result);
                return;
            }
            if (k == 1) {
                if (Math.abs(array[aright] - target) < Math.abs(array[bleft] - target)) {
                    result.add(array[aright]);
                    return;
                } else {
                    result.add(array[bleft]);
                    return;
                }
            }

            int amid = aright - k / 2 + 1;
            int bmid = bleft + k / 2 - 1;

            int aval = amid < 0 ? Integer.MAX_VALUE : Math.abs(array[amid] - target);
            int bval = bmid >= array.length ? Integer.MAX_VALUE : Math.abs(array[bmid] - target);

            if (aval > bval) {
                addResult(array, bleft, bleft + k / 2 - 1, result);
                findK(array, aright, bmid + 1, result, k - k / 2, target);
            } else {
                addResult(array, aright - k / 2 + 1, aright, result);
                findK(array, amid - 1, bleft, result, k - k / 2, target);
            }
        }

        private void addResult(int[] array, int left, int right, List<Integer> result) {
            for (int i = left; i <= right; i++) {
                result.add(array[i]);
            }
        }

    }

}
