package leetcode.editor.script;

import java.util.*;

public class FindPath {
    private void computeVariables(List<List<Integer>> graph, int[][] result, int vertexCount) {
        // result[0][i]: length of the longest path passing through the vertex i
        // result[1][i]: length of the longest cycle passing through the vertex i

        // Whether vertex i has finished dfs. Cycle length update could be bypassed when vertex has
        // finished.
        boolean[] finish = new boolean[vertexCount];
        int[] visited = new int[vertexCount];
        Arrays.fill(visited, -1);

        for (int v = 0; v < vertexCount; v++) {
            // vertex -> index in the path
            visited[v] = 0;
            List<Integer> path = new ArrayList<>(vertexCount);
            path.add(v);
            dfs(graph, v, visited, result, path, finish);
            visited[v] = -1;
            finish[v] = true;
        }
    }

    private void dfs(
            List<List<Integer>> graph,
            int v,
            int[] visited,
            int[][] result,
            List<Integer> path,
            boolean[] finish) {

        List<Integer> targetVertices = graph.get(v);
        if (targetVertices == null || targetVertices.isEmpty()) {
            // update path len
            for (int vertex : path) {
                if (result[0][vertex] < path.size() - 1) {
                    result[0][vertex] = path.size() - 1;
                }
            }
            return;
        }

        for (int t : targetVertices) {
            if (visited[t] != -1) {
                // find cycle. No need to update cycle length if v/t has been traversed
                if (!finish[v] && !finish[t]) {
                    int cycleLen = visited[v] - visited[t] + 1;
                    for (int i = visited[t]; i < path.size(); i++) {
                        int vertex = path.get(i);
                        if (result[1][vertex] < cycleLen) {
                            result[1][vertex] = cycleLen;
                        }
                    }
                }

                // update path len
                for (int vertex : path) {
                    if (result[0][vertex] < path.size() - 1) {
                        result[0][vertex] = path.size() - 1;
                    }
                }
                // end of dfs
            } else {
                visited[t] = path.size();
                path.add(t);
                dfs(graph, t, visited, result, path, finish);
                path.remove(path.size() - 1);
                visited[t] = -1;
            }
        }
    }

    List<List<Integer>> buildDirectGraph(
            int vertexCount, int[][] edgeList, StringBuilder sb) {
        // build graph with set and dedupe edges
        Set<Integer>[] graphInSet = new HashSet[vertexCount];
        Arrays.setAll(graphInSet, k -> new HashSet<>());
        for (int i = 0; i < edgeList[0].length; i++) {
            int from = edgeList[0][i];
            int to = edgeList[1][i];
            graphInSet[from].add(to);
        }

        // build graph in ArrayList for better read perf
        int edgeCount = 0;
        List<List<Integer>> graphInList = new ArrayList<>(vertexCount);
        for (int i = 0; i < vertexCount; i++) {
            graphInList.add(new ArrayList<>(graphInSet[i]));
            edgeCount += graphInSet[i].size();
        }

        if (sb != null) {
            double graphDensity =
                    vertexCount <= 1 ? -1 : edgeCount * 1.0 / (vertexCount * (vertexCount - 1));
            sb.append(String.format("VertexCount:%d,EdgeCount%d,Density:%.2f", vertexCount, edgeCount, graphDensity));
        }
        return graphInList;
    }
}
