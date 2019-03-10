import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem5 {
    public static void main(String[] args) {
        int[] A = {1, 3, 5};
        int[] B = {2, 3};
        System.out.println(sumKthSmallest(A, 3, B, 2, 2));
    }
    public static class Cell {
        int x;
        int y;
        int value;

        public Cell(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public static int sumKthSmallest(int[] A, int m, int[] B, int n, int k) {
        if (A.length == 0 || B.length == 0 || k <= 0) {
            return -1;
        }
        PriorityQueue<Cell> maxHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.value == o2.value) {
                    return 0;
                } else if (o1.value > o2.value) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        maxHeap.offer(new Cell(0, 0, A[0] + B[0]));
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        for (int i = 1; i < k; i++) {
            Cell poll = maxHeap.poll();
            int x = poll.x;
            int y = poll.y;
            int val = poll.value;
            if (x + 1 < m && !visited[x + 1][y]) {
                maxHeap.offer(new Cell(x + 1, y, A[x + 1] + B[y]));
                visited[x + 1][y] = true;
            }
            if (y + 1 < n && !visited[x][y + 1]) {
                maxHeap.offer(new Cell(x, y + 1, A[x] + B[y + 1]));
                visited[x][y + 1] = true;
            }
        }
        return maxHeap.poll().value;
    }

}
