/**
 *
 */
package com.coding.crazy_rectangles;

import com.coding.crazy_rectangles.model.Level;
import com.coding.crazy_rectangles.model.Point;
import com.coding.crazy_rectangles.model.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author piyush
 */
public class Main {
	
/*
	

\
\
\                 3333|3333333333|333333
\                 3333|3333333333|333333
\                 3333|3333333333|333333
\                 3333|3333333333|333333
\                 3333|333333333322222222222222222222222
\                 3333|333333333322222222222222222222222
\          11111111111|333333333322222222222222222222222
\          11111111111|333333333322222222222222222222222
\          11111111111           22222222222222222222222
\          11111111111           22222222222222222222222
\
\
\
\________________________________________________________________

	
*/

    /**
     * @param args
     */
    public static void main(String[] args) {


        List<Level> levels = new ArrayList<Level>();

        Rectangle r1 = new Rectangle();
        r1.setLeftBottom(new Point(4, 4));
        r1.setRightTop(new Point(15, 15));
        Level l1 = new Level(3, r1);
        levels.add(l1);

        Rectangle r2 = new Rectangle();
        r2.setLeftBottom(new Point(2, 2));
        r2.setRightTop(new Point(8, 8));
        Level l2 = new Level(1, r2);
        levels.add(l2);

        Rectangle r3 = new Rectangle();
        r3.setLeftBottom(new Point(10, 2));
        r3.setRightTop(new Point(21, 13));
        Level l3 = new Level(2, r3);
        levels.add(l3);

        compute(levels);

        // Print Each Level
        for (Level l : levels) {
            System.out.println(l.getOrig());
            System.out.println("Resultant Rectangles : " + l.getResultantRectangles());
            System.out.println();
        }

    }

    public static void compute(List<Level> levels) {

        Collections.sort(levels);

        for (int i = 0; i < levels.size(); i++) {

            Level currentLevel = levels.get(i);
            if (i == 0) {
                // This is special case
                List<Rectangle> rectangles = new ArrayList<>();
                rectangles.add(currentLevel.getOrig());
                currentLevel.setResultantRectangles(rectangles);
            }

            boolean hasOrigProcessed = false;
            // Process current level with all the previous rectangles
            // to find remaining smaller rectangles after overlapping
            for (int j = i - 1; j >= 0; j--) {

                Level prevLevel = levels.get(j);

                List<Rectangle> innerRectangles = null;
                if (!hasOrigProcessed) {
                    innerRectangles = RectangleFinderUtil.carveOutInnerRectangles(currentLevel.getOrig(), prevLevel.getOrig());
                    if (innerRectangles.size() != 0) {
                        hasOrigProcessed = true;
                    }
                } else {
                    innerRectangles = currentLevel.getResultantRectangles();
                    int initialSize = innerRectangles.size();

                    for (int k = 0; k < initialSize; k++) {
                        Rectangle item = innerRectangles.remove(0); // Remove the front item

                        List<Rectangle> ir = RectangleFinderUtil.carveOutInnerRectangles(item, prevLevel.getOrig());
                        if (ir.size() != 0) {
                            innerRectangles.addAll(ir);
                        }
                    }

                }
                currentLevel.setResultantRectangles(innerRectangles);
            }
        }
    }
}
