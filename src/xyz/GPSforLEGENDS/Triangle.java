package xyz.GPSforLEGENDS;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        Triangle t = new Triangle();

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3,4));
        triangle.add(List.of(6,5,7));
        triangle.add(List.of(4,1,8,3));

        t.minimumTotal(triangle);
    }

    class Node {
        int cost;
        Node successor = null;
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        Node[] nodeArray = new Node[sum(1, triangle.size())];

        for (int r = triangle.size() - 1; r >= 0; r--) {
            for (int c = 0; c < triangle.get(r).size(); c++) {
                Integer current = triangle.get(r).get(c);

                Node n = new Node();

                Node left = getNode(r + 1, c, nodeArray);
                Node right = getNode(r + 1, c + 1, nodeArray);

                if (left == null && right == null) {
                    n.cost = current;
                    n.successor = null;
                } else if (left == null || right.cost < left.cost) {
                    n.cost = current + right.cost;
                    n.successor = right;
                } else {
                    n.cost = current + left.cost;
                    n.successor = left;
                }

                nodeArray[getPos(r, c)] = n;
            }
        }

        return nodeArray[0].cost;
    }

    private Node getNode(int row, int column, Node[] nodeArray) {

        int pos = getPos(row, column);

        if (pos < nodeArray.length) {
            return nodeArray[pos];
        }

        return null;
    }

    private int getPos(int row, int column) {
        return sum(0, row) + column;
    }

    private int sum(int from, int to) {
        int result = 0;

        for (int i = from; i <= to; i++) {
            result += i;
        }

        return result;
    }
}
