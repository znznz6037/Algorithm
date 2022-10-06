import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int root = 0;
        int[] parents = new int[N];
        boolean[][] map = new boolean[N][N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            parents[i] = Integer.parseInt(input[i]);
            if(parents[i] != - 1) map[parents[i]][i] = true;
            else root = i;
        }

        int deleteNode = Integer.parseInt(br.readLine());
        br.close();

        if(deleteNode == root) {
            System.out.println(0);
            return;
        }

        for(int i = 0; i < N; i++) {
            map[i][deleteNode] = false;
        }
        delete(deleteNode, map);
        int answer = bfs(root, map);

        System.out.println(answer);
    }

    public static void delete(int node, boolean[][] map) {
        for(int i = 0; i < map.length; i++) {
            if(map[node][i]) {
                map[node][i] = false;
                delete(i, map);
            }
        }
    }

    public static int bfs(int root, boolean[][] map) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int cur = q.poll();
            boolean hasChild = false;
            for(int i = 0; i < map.length; i++) {
                if(map[cur][i]) {
                    q.add(i);
                    hasChild = true;
                }
            }
            if(!hasChild) answer++;
        }

        return answer;
    }
}
