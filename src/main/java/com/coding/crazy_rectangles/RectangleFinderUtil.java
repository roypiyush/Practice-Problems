/**
 *
 */
package com.coding.crazy_rectangles;

import com.coding.crazy_rectangles.model.Point;
import com.coding.crazy_rectangles.model.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * This class with take two rectangles as input and will process them to find out the remaining rectangles that will be formed after
 * removing the overlapping area.
 *
 * @author piyush
 */
public class RectangleFinderUtil {


    /**
     * Utility method to carve out remaining rectangles from target rectangle
     *
     * @param targetRect Target Rectangle to be processed
     * @param sourceRect Source Rectangle which will carve out area from Target Rectangle
     * @return List of carved out rectangle from Target Rectangle. Empty list if no rectangle can be formed.
     */
    public static List<Rectangle> carveOutInnerRectangles(Rectangle targetRect, Rectangle sourceRect) {

        List<Rectangle> rectangles = new ArrayList<>();

        // Check if the rectangle are overlapping
        if (!checkIfOverlap(targetRect, sourceRect)) {
            // Returns target rectangle in case non-overlapping
            rectangles.add(targetRect);
            return rectangles;
        }


        Point overlapLeftBottom = new Point(Math.max(targetRect.getLeftBottom().getX(), sourceRect.getLeftBottom().getX()),
                Math.max(targetRect.getLeftBottom().getY(), sourceRect.getLeftBottom().getY()));
        Point overlapRightTop = new Point(Math.min(targetRect.getRightTop().getX(), sourceRect.getRightTop().getX()),
                Math.min(targetRect.getRightTop().getY(), sourceRect.getRightTop().getY()));


        // Find four rectangles that can be formed when overlapping rectangle is inside targetRect


        Point rectOneLeftBottom = new Point(targetRect.getLeftBottom().getX(), targetRect.getLeftBottom().getY());
        Point rectOneRightTop = new Point(overlapLeftBottom.getX(), targetRect.getRightTop().getY());
        Rectangle rectOne = new Rectangle();
        rectOne.setLeftBottom(rectOneLeftBottom);
        rectOne.setRightTop(rectOneRightTop);

        if (rectOne.area() > 0) rectangles.add(rectOne);

        Point rectTwoLeftBottom = new Point(overlapLeftBottom.getX(), overlapRightTop.getY());
        Point rectTwoRightTop = new Point(overlapRightTop.getX(), targetRect.getRightTop().getY());
        Rectangle rectTwo = new Rectangle();
        rectTwo.setLeftBottom(rectTwoLeftBottom);
        rectTwo.setRightTop(rectTwoRightTop);
        if (rectTwo.area() > 0) rectangles.add(rectTwo);


        Point rectThreeLeftBottom = new Point(overlapLeftBottom.getX(), targetRect.getLeftBottom().getY());
        Point rectThreeRightTop = new Point(overlapRightTop.getX(), overlapLeftBottom.getY());
        Rectangle rectThree = new Rectangle();
        rectThree.setLeftBottom(rectThreeLeftBottom);
        rectThree.setRightTop(rectThreeRightTop);
        if (rectThree.area() > 0) rectangles.add(rectThree);


        Point rectFourLeftBottom = new Point(overlapRightTop.getX(), targetRect.getLeftBottom().getY());
        Point rectFourRightTop = new Point(targetRect.getRightTop().getX(), targetRect.getRightTop().getY());
        Rectangle rectFour = new Rectangle();
        rectFour.setLeftBottom(rectFourLeftBottom);
        rectFour.setRightTop(rectFourRightTop);
        if (rectFour.area() > 0) rectangles.add(rectFour);


        return rectangles;
    }

    public static boolean checkIfOverlap(Rectangle targetRect, Rectangle sourceRect) {

        // Checks if two rectangles exactly overlap each other
        if (targetRect.getLeftBottom().equals(sourceRect.getLeftBottom()) && targetRect.getRightTop().equals(sourceRect.getRightTop()))
            return true;

        // Below equation checks for exclusion
        boolean result = targetRect.getLeftBottom().getX() >= sourceRect.getRightTop().getX()
                || targetRect.getRightTop().getX() <= sourceRect.getLeftBottom().getX()
                || targetRect.getLeftBottom().getY() >= sourceRect.getRightTop().getY()
                || targetRect.getRightTop().getY() <= sourceRect.getLeftBottom().getY();

        // Need to negate to comply with method name
        return !result;
    }

}
