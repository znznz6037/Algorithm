import java.util.*;

class Solution {

    class Node implements Comparable<Node> {
        int v;
        int intensity;

        public Node(int v, int intensity) {
            this.v = v;
            this.intensity = intensity;
        }

        public int compareTo(Node node) {
            return this.intensity - node.intensity;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        //HashMap<Integer, Boolean> gatesMap = new HashMap<>();
        //for(int gate: gates) gatesMap.put(gate, true);

        HashMap<Integer, Boolean> summitsMap = new HashMap<>();
        for(int summit: summits) summitsMap.put(summit, true);

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] path: paths) {
            graph.get(path[0]).add(new Node(path[1], path[2]));
            graph.get(path[1]).add(new Node(path[0], path[2]));
        }

        int[] intensities = new int[n + 1];
        for(int i = 0; i <= n; i++) intensities[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        for(int gate: gates) {
            pQueue.add(new Node(gate, 0));
            intensities[gate] = 0;
        }

        while(!pQueue.isEmpty()) {
            Node curNode = pQueue.poll();

            //if(gatesMap.containsKey(curNode.v) || summitsMap.containsKey(curNode.v)) continue;
            if(summitsMap.containsKey(curNode.v)) continue;
            if(intensities[curNode.v] < curNode.intensity) continue;

            for(Node nextNode: graph.get(curNode.v)) {
                int intensity = (nextNode.intensity == Integer.MAX_VALUE) ? curNode.intensity : Math.max(nextNode.intensity, curNode.intensity);
                if(intensity < intensities[nextNode.v]) {
                    intensities[nextNode.v] = intensity;
                    pQueue.add(new Node(nextNode.v, intensity));
                }
            }
        }

        int vertex = 0;
        int minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);

        for(int summit: summits) {
            if(minIntensity > intensities[summit]) {
                vertex = summit;
                minIntensity = intensities[summit];
            }
        }

        return new int[]{vertex, minIntensity};
    }
}