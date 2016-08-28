import java.io.*;
import java.util.*;
import java.util.stream.*;

public class ShortestReach {

    private static final int DISTANCE = 6;
    
    static class TestCaseGraph {
        private int source;
        private Map<Integer, List<Integer>> adj = new HashMap<>();
        private List<Integer> nodeList = new ArrayList<>();
        
        public TestCaseGraph(int source, int vertexCount, List<int[]> pairs) {
            this.source = source;
            // process the pairs and populate the adjacency matrix for this graph
            pairs.forEach(pair -> {
                    int val_1 = pair[0];
                    int val_2 = pair[1];
                    List<Integer> value_1 = adj
                        .getOrDefault(val_1, new ArrayList<Integer>());
                    value_1.add(val_2);
                    adj.putIfAbsent(val_1, value_1);

                    List<Integer> value_2 = adj
                        .getOrDefault(val_2, new ArrayList<Integer>());
                    value_2.add(val_1);
                    adj.putIfAbsent(val_2, value_2);
                });
            // sort the values of the adj map
            adj.forEach((k, v) -> Collections.sort(v));
            for (int  i = 1; i <= vertexCount; i++) {
                if (i != source)
                    nodeList.add(i);
            }
        }

        public int getSource() {
            return source;
        }

        public List<Integer> getAdjacencyList(int node) {
            if (this.adj.containsKey(node)) 
                return Collections.unmodifiableList(this.adj.get(node));
            else
                return Collections.emptyList();
        }

        public List<Integer> getNodeList() {
            return Collections.unmodifiableList(this.nodeList);
        }
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int q = in.nextInt();
        
        List<TestCaseGraph> graphs = new ArrayList<>();
        
        while (q-- > 0) {
            List<int[]> tmpList = new ArrayList<>();
            int n = in.nextInt();
            int m = in.nextInt();
            while (m-- > 0) {
                int[] tmpArray = new int[] {in.nextInt(), in.nextInt()};
                tmpList.add(tmpArray);
            }
            graphs.add(new TestCaseGraph(in.nextInt(), n, tmpList));
        }

        graphs.forEach (graph -> process(graph));
    }

    static void process(TestCaseGraph graph) {
        Map<Integer, Integer> distanceMapping = new HashMap<>();
        Deque<Integer> Q = new ArrayDeque<>();
        Set<Integer> processedSet = new HashSet<>();
        Q.add(graph.getSource());
        distanceMapping.put(graph.getSource(), 0);
        processedSet.add(graph.getSource());
        
        while (!Q.isEmpty()) {
            Integer node = Q.remove();
            Integer parentVal = distanceMapping.get(node);
            graph.getAdjacencyList(node).forEach(elem -> {
                    if (!processedSet.contains(elem)) {
                        Q.add(elem);
                        processedSet.add(elem);
                        distanceMapping.put(elem, parentVal+DISTANCE);
                    }
                });
        }

        // print
        graph.getNodeList().forEach(elem -> {
                if (distanceMapping.containsKey(elem)) {
                    System.out.print(distanceMapping.get(elem));
                } else {
                    System.out.print(-1);
                }
                System.out.print(" ");
            });
        
        System.out.println();
    }
}
