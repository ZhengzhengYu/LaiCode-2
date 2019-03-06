import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.*;

public class isBipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        if (graph == null || graph.size() == 0) {
            return false;
        }
        Map<GraphNode, Integer> visited = new HashMap<>();
        for (GraphNode graphNode : graph) {
            if (!visited.containsKey(graphNode)) {
                visited.put(graphNode, 0);
                Queue<GraphNode> queue = new LinkedList<>();
                queue.offer(graphNode);
                while (!queue.isEmpty()) {
                    GraphNode poll = queue.poll();
                    for (GraphNode nei : poll.neighbors) {
                        if (!visited.containsKey(nei)) {
                            int color = visited.get(poll) == 0 ? 1 : 0;
                            visited.put(nei, color);
                            queue.offer(nei);
                        } else {
                            if (visited.get(nei) == visited.get(poll)) {
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
