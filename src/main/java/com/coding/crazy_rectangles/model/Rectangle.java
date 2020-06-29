/**
 *
 */
package com.coding.crazy_rectangles.model;

/**
 * @author piyush
 */
public class Rectangle {

    private Point leftBottom;
    private Point rightTop;

    public Point getLeftBottom() {
        return leftBottom;
    }

    public void setLeftBottom(Point leftBottom) {
        this.leftBottom = leftBottom;
    }

    public Point getRightTop() {
        return rightTop;
    }

    public void setRightTop(Point rightTop) {
        this.rightTop = rightTop;
    }

    public int area() {
        return (rightTop.getX() - leftBottom.getX()) * (rightTop.getY() - leftBottom.getY());
    }

    @Override
    public String toString() {
        return "Rectangle [leftBottom=" + leftBottom + ", rightTop=" + rightTop + "]";
    }


}
