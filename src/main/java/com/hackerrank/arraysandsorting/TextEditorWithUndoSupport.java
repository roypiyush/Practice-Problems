/**
 *
 */
package com.hackerrank.arraysandsorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author piyush
 */

interface Operation {
    public void perform(List<Character> chars, LinkedList<Operation> stack);
}

class InsertOperation implements Operation {
    private String str;

    public InsertOperation(String str) {
        this.str = str;
    }

    public void perform(List<Character> chars, LinkedList<Operation> stack) {

        if (stack != null) {
            DeleteOperation dop = new DeleteOperation(str.length());
            stack.push(dop);
        }

        for (int j = 0; j < str.length(); j++)
            chars.add(str.charAt(j));
    }

}

class DeleteOperation implements Operation {
    private int lastK;

    public DeleteOperation(int lastK) {
        this.lastK = lastK;
    }

    public void perform(List<Character> chars, LinkedList<Operation> stack) {
        int j = 0;
        int last = chars.size() - 1;
        StringBuilder builder = new StringBuilder();
        while (j < lastK) {
            Character c = chars.remove(last);
            builder.append(c);
            j++;
            last--;
        }

        if (stack != null) {
            InsertOperation io = new InsertOperation(builder.reverse().toString());
            stack.push(io);
        }
    }

}

/*

Test Case
---------
8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1
  
  
 */
public class TextEditorWithUndoSupport {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int Q = s.nextInt();

        List<Character> chars = new ArrayList<>();

        LinkedList<Operation> stack = new LinkedList<>();

        for (int i = 0; i < Q; i++) {
            int k;
            int type = s.nextInt();

            switch (type) {
                case 1:
                    String str = s.next();
                    InsertOperation uo = new InsertOperation(str);
                    uo.perform(chars, stack);
                    break;
                case 2:
                    k = s.nextInt();
                    DeleteOperation deleteOperation = new DeleteOperation(k);
                    deleteOperation.perform(chars, stack);
                    break;
                case 3:
                    k = s.nextInt();
                    System.out.println(chars.get(k - 1));
                    break;
                case 4:
                    Operation o = stack.pop();
                    o.perform(chars, null);
                    break;

            }

        }

        s.close();
    }
}