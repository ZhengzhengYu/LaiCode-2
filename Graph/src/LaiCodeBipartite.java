import java.util.*;

//Time: O(n)
//Space: O(n)
public class LaiCodeBipartite {

     public class GraphNode {
         public int key;
         public List<GraphNode> neighbors;
         public GraphNode(int key) {
             this.key = key;
             this.neighbors = new ArrayList<GraphNode>();
         }
     }

    public class Solution {
        public boolean isBipartite(List<GraphNode> graph) {
            if (graph == null || graph.size() == 0) {
                return false;
            }
            Map<GraphNode, Integer> visited = new HashMap<>();
            for (GraphNode node : graph) {
                if (!visited.containsKey(node)) {
                    visited.put(node, 0);
                    Queue<GraphNode> queue = new LinkedList<>();
                    queue.offer(node);
                    while (!queue.isEmpty()) {
                        GraphNode cur = queue.poll();
                        for (GraphNode nei : cur.neighbors) {
                            if (!visited.containsKey(nei)) {
                                int color = (visited.get(cur) == 0) ? 1 : 0;
                                visited.put(nei, color);
                                queue.offer(nei);
                            } else {
                                if (visited.get(cur) == visited.get(nei)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

}
