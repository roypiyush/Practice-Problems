/**
 *
 */
package com.personal.keypadproblem;


/**
 * @author piyush
 */

class MyPath {
    public int[][] arr = new int[10][10];
    public boolean isRepeated = false;
    public int count = 0;

    void visit(int source, int destination) {

        if (arr[source][destination] + 1 == 2 && isRepeated == true)
            return;

        if (arr[source][destination] + 1 == 2)
            isRepeated = true;
        count++;

        arr[source][destination] = arr[source][destination] + 1;
        arr[destination][source] = arr[destination][source] + 1;
    }

    void retract(int source, int destination) {

        if (arr[source][destination] == 0)
            return;

        if (arr[source][destination] == 2) {
            isRepeated = false;
        }
        arr[source][destination] = arr[source][destination] - 1;
        arr[destination][source] = arr[destination][source] - 1;
        count--;
    }
}

class Graph {
    public int[][] arr = new int[10][10];
    public boolean isRepeated = false;

    public Graph() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;
                arr[i][j] = 1;
            }
        }
    }
}


public class KeypadPattern {


    /**
     * Get count for all possible paths starting with i, j
     *
     * @param arr
     * @param i
     * @param j
     * @param edges
     * @return
     */
    private static int countPatternForPosition(MyPath myPath, Graph graph, int button) {

        int result = myPath.count >= 4 ? 1 : 0;

        for (int i = 1; i <= 9; i++) {
            if (graph.arr[button][i] == 1) {

                if (!(myPath.arr[button][i] + 1 >= 2 && myPath.isRepeated == true)) {
                    myPath.visit(button, i);
                    result += countPatternForPosition(myPath, graph, i);
                    myPath.retract(button, i);
                }
            }
        }


        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        MyPath myPath = new MyPath();
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            count += countPatternForPosition(myPath, new Graph(), i);
        }

        System.out.println("Total Count : " + count);
    }

}
