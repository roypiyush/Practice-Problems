/**
 *
 */
package com.coding.crazy_rectangles.model;

import java.util.List;

/**
 * @author piyush
 */
public class Level implements Comparable<Level> {

    private int priority;
    private Rectangle orig;
    private List<Rectangle> resultantRectangles;

    public Level(int priority, Rectangle orig) {
        super();
        this.priority = priority;
        this.orig = orig;
    }

    public int getPriority() {
        return priority;
    }

    public Rectangle getOrig() {
        return orig;
    }

    public List<Rectangle> getResultantRectangles() {
        return resultantRectangles;
    }

    public void setResultantRectangles(List<Rectangle> resultantRectangles) {
        this.resultantRectangles = resultantRectangles;
    }

    @Override
    public String toString() {
        return "Level [priority=" + priority + ", orig=" + orig + "]";
    }

    @Override
    public int compareTo(Level o) {
        return this.priority - o.priority;
    }


}
