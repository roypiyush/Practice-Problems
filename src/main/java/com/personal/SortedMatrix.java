/**
 *
 */
package com.personal;


class Node {
    int row;
    int col;
    int data;

    public Node(int row, int col, int data) {
        this.row = row;
        this.col = col;
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
    }

}

class Heap {

    Node[] arr;
    int currentSize = 0;

    public Heap(int size) {
        this.arr = new Node[size];
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return i / 2 - 1;
    }

    void minHeapify(int i) {

        int j = i;

        if (left(i) < currentSize && arr[j].data > arr[left(i)].data) {
            j = left(i);
        }

        if (right(i) < currentSize && arr[j].data > arr[right(i)].data) {
            j = right(i);
        }
		
		/*if(parent(i) >= 0 && arr[parent(i)].data > arr[j].data) {
			j = parent(i);
		}*/

        if (i != j) {
            // swap
            Node t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
            minHeapify(j);
        }
    }


    void insert(Node n) {
        if (currentSize == arr.length) {
            return;
        }
        currentSize++;
        arr[currentSize - 1] = n;
        minHeapify(currentSize - 1);

    }

    Node pop() {
        if (currentSize == 0)
            return null;

        Node t = arr[0];
        Node n = arr[currentSize - 1];
        currentSize--;
        arr[0] = n;
        minHeapify(0);
        return t;
    }


}

/**
 * @author piyush
 */
public class SortedMatrix {


    /**
     * @param args
     */
    public static void main(String[] args) {

        int[][] matrix = {{3, 6, 10}, {1, 4, 8}, {1, 3, 13}};
        Heap queue = new Heap(matrix.length);

        for (int i = 0; i < matrix.length; i++) {
            Node n = new Node(i, 0, matrix[i][0]);
            queue.arr[i] = n;
            queue.currentSize = queue.currentSize + 1;
        }

        for (int i = matrix.length / 2; i >= 0; i--) {
            queue.minHeapify(i);
        }


        while (queue.currentSize > 0) {
            Node n = queue.pop();
            if (n != null && n.col + 1 < matrix[n.row].length) {
                queue.insert(new Node(n.row, n.col + 1, matrix[n.row][n.col + 1]));
            }

            System.out.print(n.data + " ");
        }

    }

}
