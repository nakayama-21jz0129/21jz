import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] map = {
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int startX = 4;
        int startY = 4;
        int goalX = 15;
        int goalY = 19;

        String[][] vis = visualization(map, startX, startY, goalX, goalY);

        List<int[]> pathCoordinates = ShortestPath.findShortestPathCoordinates(map, startX, startY, goalX, goalY);
        if (!pathCoordinates.isEmpty()) {
            System.out.println("最短経路の長さは: " + pathCoordinates.size());
            System.out.println("最短経路の座標は:");
            for (int i = pathCoordinates.size() - 1; i >= 0; i--) {
                int[] coordinates = pathCoordinates.get(i);
                System.out.println("(" + coordinates[0] + ", " + coordinates[1] + ")");
            }
            visualization(vis, pathCoordinates);
        } else {
            System.out.println("ゴールに到達できませんでした。");
        }
    }

    static String[][] visualization (int[][] map, int startX, int startY, int goalX, int goalY) {
        String[][] new_map = new String[map.length][];
        for (int i = 0; i < map.length; i++) {
            new_map[i] = new String[map[i].length];
            for (int j = 0; j < map[i].length; j++) {
                if (i == startX && j == startY) {
                    new_map[i][j] = "ス";
                } else if (i == goalX && j == goalY) {
                    new_map[i][j] = "ゴ";
                } else if (map[i][j] == 0) {
                    new_map[i][j] = "口";
                } else if (map[i][j] == 1) {
                    new_map[i][j] = "国";
                }
                System.out.print(new_map[i][j]);
            }
            System.out.println();
        }
        return new_map;
    }

    static void visualization (String[][] vis, List<int[]> path) {
        for (int i = path.size() - 1; i >= 0; i--) {
            vis[path.get(i)[0]][path.get(i)[1]] = "十";
        }
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[i].length; j++) {
                System.out.print(vis[i][j]);
            }
            System.out.println();
        }
    }
}