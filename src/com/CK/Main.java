package com.CK;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        char[] a = new char[]{'1', '1', '0', '0', '0'};
        char[] b = new char[]{'1', '1', '0', '0', '0'};
        char[] c = new char[]{'0', '0', '1', '0', '0'};
        char[] d = new char[]{'0', '0', '0', '1', '1'};

        char[][] graph = new char[4][5];
        graph[0] = a;
        graph[1] = b;
        graph[2] = c;
        graph[3] = d;
        Solution solution = new Solution();
        System.out.println(solution.numIslands(graph));

    }
}

// DFS 把所有邻接点从‘1’变成‘0’
class Solution {
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}