import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class ShortestPath {
    private static boolean isValidMove(int x, int y, int numRows, int numCols) {
        return x >= 0 && x < numRows && y >= 0 && y < numCols;
    }

    static class Node {
        int x;
        int y;
        int distance;
        Node parent;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static List<int[]> findShortestPathCoordinates(int[][] map, int startX, int startY, int goalX, int goalY) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右に移動するための方向ベクトル

        int numRows = map.length;
        int numCols = map[0].length;
        boolean[][] visited = new boolean[numRows][numCols];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == goalX && current.y == goalY) {
                List<int[]> pathCoordinates = new ArrayList<>();
                while (current != null) {
                    pathCoordinates.add(new int[]{current.x, current.y});
                    current = current.parent;
                }
                return pathCoordinates;
            }

            for (int[] direction : directions) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                if (isValidMove(newX, newY, numRows, numCols) && map[newX][newY] == 0 && !visited[newX][newY]) {
                    Node nextNode = new Node(newX, newY, current.distance + 1);
                    nextNode.parent = current;
                    queue.add(nextNode);
                    visited[newX][newY] = true;
                }
            }
        }

        return new ArrayList<>();
    }
}
