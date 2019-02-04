public class LaiCodeSearchInUnknownSizedSortedArray {
    interface Dictionary {
        public Integer get(int index);
    }

    // You do not need to implement the Dictionary interface.
    // You can use it directly, the implementation is provided when testing your solution.
    //Time: O(log n)
    //Space: O(1)
    public class Solution {
        public int search(Dictionary dict, int target) {
            // Write your solution here
            if (dict == null) {
                return -1;
            }
            int left = 0;
            int right = 1;
            while (dict.get(right) != null && dict.get(right) < target) {
                left = right;
                right = 2 * right;
            }

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (dict.get(mid) == null) {
                    right = mid - 1;
                } else if (dict.get(mid) == target) {
                    return mid;
                } else if (dict.get(mid) > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

/*
public class Solution {
  public int search(Dictionary dict, int target) {
    // Write your solution here
    if (dict == null) {
      return -1;
    }
    int left = 0;
    int right = 1;
    while (dict.get(right) != null && dict.get(right) < target) {
      left = right;
      right = 2 * right;
    }

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (dict.get(mid) == null) {
        right = mid;
      } else if (dict.get(mid) == target) {
        return mid;
      } else if (dict.get(mid) > target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    if (dict.get(left) == null) {
      return -1;
    } else if (dict.get(left) == target) {
      return left;
    }
    if (dict.get(right) == null) {
      return -1;
    } else if (dict.get(right) == target) {
      return right;
    }
    return -1;
  }
}
*/

}
