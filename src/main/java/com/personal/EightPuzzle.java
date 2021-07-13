package com.personal;

import java.util.*;
import java.util.LinkedList;

class PuzzleNode {
    private int emptySquare;
    private int[] puzzle;
    private PuzzleNode parentNode;

    public PuzzleNode(final int[] puzzle, final PuzzleNode parentNode) {
        this.parentNode = parentNode;
        this.puzzle = puzzle;
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == 0) {
                emptySquare = i;
            }
        }
    }

    public int[] getPuzzle() {
        return puzzle;
    }

    public int getEmptySquare() {
        return emptySquare;
    }

    public PuzzleNode getParentNode() {
        return parentNode;
    }

    public boolean hasParent() {
        return this.getParentNode() != null;
    }

    public int depth() {
        PuzzleNode currentNode = this;
        int depth = 0;
        while (currentNode != null) {
            currentNode = currentNode.parentNode;
            depth++;
        }
        return depth;
    }

    public int estimatedCost() {
        int cost = 0;
        for (int i = 0; i < getPuzzle().length; i++) {
            final int finalPosition = getPuzzle()[i] - 1;
            final int currentPosition = i;
            final int diff = Math.abs(finalPosition - currentPosition);
            cost += diff%3 + diff/3;
        }
        return cost;
    }

    public int heuristic() {
        return depth() + estimatedCost();
    }

    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getPuzzle().length; i++) {
            final int value = getPuzzle()[i];
            builder.append(value == 0 ? " " : value);
            if ((i + 1) % 3 == 0) {
                builder.append("\n");
            } else {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}

class Action {
    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    public static final int UP = -3;
    public static final int DOWN = 3;

    public PuzzleNode doAction(final PuzzleNode puzzleNode, final int action)
            throws IllegalArgumentException {
        switch (action) {
            case LEFT:
            case RIGHT:
            case UP:
            case DOWN:
                final int[] newState = Utility.getNewState(puzzleNode.getPuzzle(), puzzleNode.getEmptySquare(), puzzleNode.getEmptySquare() + action);
                final PuzzleNode newPuzzleNode = new PuzzleNode(newState, puzzleNode);
                return newPuzzleNode;
            default:
                throw new IllegalArgumentException("Invalid Action");
        }
    }

    public boolean isValidAction(final PuzzleNode newNode) {
        if (newNode == null) {
            return false;
        }
        if (newNode.getParentNode() != null && newNode.getParentNode().getParentNode() != null
                && Arrays.deepEquals(new Object[] {newNode.getParentNode().getParentNode().getPuzzle()}, new Object[] {newNode.getPuzzle()})) {
            return false;
        }
        return true;
    }

    public int[] getNeighbors(final int indexPosition) throws IllegalArgumentException {
        switch (indexPosition) {
            case 0: return new int[] {1, 3};
            case 1: return new int[] {0, 2, 4};
            case 2: return new int[] {1, 5};
            case 3: return new int[] {0, 4, 6};
            case 4: return new int[] {1, 3, 5, 7};
            case 5: return new int[] {2, 4, 8};
            case 6: return new int[] {3, 7};
            case 7: return new int[] {4, 6, 8};
            case 8: return new int[] {5, 7};
            default: throw new IllegalArgumentException("Invalid Index Position");
        }
    }
}

class Utility {
    public static int[] GOAL_STATE = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 0};

    public static void printSolution(PuzzleNode solutionNode) {
        if (solutionNode.hasParent()) {
            printSolution(solutionNode.getParentNode());
        }
        System.out.println(solutionNode);
    }

    public static int[] getNewState(final int[] currentState, final int source, final int destination) {
        final int[] clone = Arrays.copyOf(currentState, currentState.length);
        final int temp = clone[destination];
        clone[destination] = clone[source];
        clone[source] = temp;
        return clone;
    }

    public static boolean isGoalReached(final PuzzleNode currentNode) {
        return Arrays.deepEquals(new Object[] {GOAL_STATE}, new Object[] {currentNode.getPuzzle()});
    }

    public static PuzzleNode search(final PuzzleNode currentNode) {
        if (Utility.isGoalReached(currentNode)) {
            return currentNode;
        }
        final List<PuzzleNode> queue = new LinkedList<>();
        final List<PuzzleNode> nextStates = getNextStates(currentNode);
        if (!nextStates.isEmpty()) {
            queue.addAll(nextStates);
        }
        while (!queue.isEmpty()) {
            final PuzzleNode current = queue.remove(0);
            if (Utility.isGoalReached(current)) {
                return current;
            }
            final List<PuzzleNode> nodes = getNextStates(current);
            for (PuzzleNode p : nodes) {
                if (p == null) {
                    continue;
                }
                queue.add(p);
            }
        }
        return null;
    }

    private static List<PuzzleNode> getNextStates(final PuzzleNode currentNode) {
        final List<PuzzleNode> nextStates = new LinkedList<>();
        final Action action = new Action();
        final int[] neighbors = action.getNeighbors(currentNode.getEmptySquare());
        for (int i = 0; i < neighbors.length; i++) {
            final int a = neighbors[i] - currentNode.getEmptySquare();
            final PuzzleNode e = action.doAction(currentNode, a);
            if (action.isValidAction(e)) {
                nextStates.add(e);
            }
        }
        Collections.sort(nextStates, new Comparator<PuzzleNode>() {
            @Override
            public int compare(PuzzleNode o1, PuzzleNode o2) {
                return o2.heuristic() - o1.heuristic();
            }
        });
        return nextStates;
    }
}

public class EightPuzzle {
    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        final PuzzleNode initialPuzzleNode = new PuzzleNode(new int[] {3, 0, 6, 7, 8, 1, 2, 4, 5}, null);
        PuzzleNode current = Utility.search(initialPuzzleNode);
        if (current == null) {
            System.out.println("No solution found");
            return;
        }
        Utility.printSolution(current);
        System.out.printf("Solution found in %s ms\n", System.currentTimeMillis() - start);
    }
}
