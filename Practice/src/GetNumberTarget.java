public class GetNumberTarget {
    public static void main(String[] args) {
        int[] number1 = new int[] {3,4,5,6,6,9,16};
        int[] number2 = new int[] {3,4,5,6,6,9,16};
        int[] number3 = new int[] {};
        int[] number4 = new int[] {3};
        System.out.println(getTimes(number1, 6));
        System.out.println(getTimes(number2, 3));
        System.out.println(getTimes(number3, 6));
        System.out.println(getTimes(number3, 6));
    }
    public static int getTimes(int[] number, int target) {
        if (number == null || number.length == 0) {
            return 0;
        }
        int first = getFirstOccurence(number, target);
        if (first == -1) {
            return 0;
        }
        int last = getLastOccurence(number, target);
        if (last == -1) {
            return 0;
        }
        return last - first + 1;
    }

    private static int getFirstOccurence(int[] number, int target) {
        int left = 0;
        int right = number.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (number[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (number[left] == target) {
            return left;
        }
        if (number[right] == target) {
            return right;
        }
        return -1;
    }

    private static int getLastOccurence(int[] number, int target) {
        int left = 0;
        int right = number.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (number[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (number[right] == target) {
            return right;
        }
        if (number[left] == target) {
            return left;
        }
        return -1;
    }

}
