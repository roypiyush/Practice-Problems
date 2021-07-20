package com.personal;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    /**
     * Number of displaced items
     * @return
     */
    public int hammingDistance() {
        int cost = 0;
        for (int i = 0; i < getPuzzle().length; i++) {
            if (getPuzzle()[i] != i + 1) {
                cost++;
            }
        }
        return cost;
    }

    public int manhattanDistance() {
        int cost = 0;
        for (int i = 0; i < getPuzzle().length; i++) {
            final int finalPosition = getPuzzle()[i] - 1;
            final int currentPosition = i;
            final int diff = Math.abs(finalPosition - currentPosition);
            final double size = Math.sqrt(getPuzzle().length);
            cost += Math.ceil(Math.sqrt(Math.pow(diff % size, 2) + Math.pow(diff / size, 2)));
            // cost += diff%3 + diff/3; // Doesn't perform better
        }
        return cost;
    }

    public int heuristic() {
        return hammingDistance() + manhattanDistance();
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
        for (int i = 0; i < currentNode.getPuzzle().length; i++) {
            if (i + 1 == currentNode.getPuzzle().length) {
                continue;
            }
            if (currentNode.getPuzzle()[i] != (i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static PuzzleNode search(final PuzzleNode currentNode, final AtomicInteger statesGenerated, final Comparator<PuzzleNode> comparator) {
        if (Utility.isGoalReached(currentNode)) {
            return currentNode;
        }
        final TreeSet<PuzzleNode> states = new TreeSet<>(comparator);
        states.add(currentNode);

        while (!states.isEmpty()) {
            final PuzzleNode current = states.pollFirst();
            if (Utility.isGoalReached(current)) {
                return current;
            }
            populateNextStates(current, states);
            statesGenerated.addAndGet(states.size());
            states.addAll(states);
        }
        return null;
    }

    private static void populateNextStates(final PuzzleNode currentNode, final TreeSet<PuzzleNode> nextStates) {
        final Action action = new Action();
        final int[] neighbors = action.getNeighbors(currentNode.getEmptySquare());
        for (int i = 0; i < neighbors.length; i++) {
            final int a = neighbors[i] - currentNode.getEmptySquare();
            final PuzzleNode e = action.doAction(currentNode, a);
            if (currentNode.hasParent() && Arrays.deepEquals(new Object[] {currentNode.getParentNode().getPuzzle()}, new Object[] {e.getPuzzle()})) {
                continue;
            }
            if (action.isValidAction(e)) {
                nextStates.add(e);
            }
        }
    }
}

public class EightPuzzle {
    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        final int[] puzzle = new int[] {3, 0, 6, 7, 8, 1, 2, 4, 5};
        final PuzzleNode initialPuzzleNode = new PuzzleNode(puzzle, null);
        AtomicInteger statesGenerated = new AtomicInteger(0);
        final Comparator<PuzzleNode> aStar = Comparator.comparingInt(PuzzleNode::heuristic);
        PuzzleNode current = Utility.search(initialPuzzleNode, statesGenerated, aStar);
        if (current == null) {
            System.out.println("No solution found");
            return;
        }
        Utility.printSolution(current);
        System.out.println("States generated " + statesGenerated.get());
        System.out.printf("Solution found in %s ms\n", System.currentTimeMillis() - start);
    }
}
