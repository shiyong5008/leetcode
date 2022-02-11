import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        stack.push(0);
        int n = graph.length;
        dfs(graph, 0, n-1);
        return lists;

    }

    public void dfs(int[][] graph, int x, int y) {

        if (x == y) {
            lists.add(new ArrayList<>(stack));
            return;
        }

        for (int i: graph[x]) {
            stack.push(i);
            dfs(graph, i, y);
            stack.pop();
        }

    }

}

 */


class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        list.add(0);
        int n = graph.length;
        dfs(graph, 0, n-1);
        return lists;

    }

    public void dfs(int[][] graph, int x, int y) {

        if (x == y) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i: graph[x]) {
            list.add(i);
            dfs(graph, i, y);
            list.remove(list.size()-1);
        }

    }

}