package com.topcoder.greedy;

import java.util.Collections;
import java.util.LinkedList;

/*
Problem Statement
=================
There are N boxes numbered from 0 to N-1, inclusive. 
For each i, box i contains red[i] red balls, green[i] green balls, and blue[i] blue balls. 

Fox Ciel wants to separate the balls by colors. In each operation, she can pick a single ball from some box 
and put it into another box. She considers the balls to be separated if no box contains balls of more than one color. 

Return the minimal number of operations required to separate the balls. If this is impossible, return -1.

Constraints
-	red, green and blue will each contain between 1 and 50 elements, inclusive.
-	red, green and blue will contain the same number of elements.
-	Each element of red, green and blue will be between 1 and 1,000,000, inclusive.
*/

class Item implements Comparable<Item> {

    private int index;
    private int value;
    private int color;

    public Item(int index, int value, int color) {
        super();
        this.index = index;
        this.value = value;
        this.color = color;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Item [i=" + index + ", v=" + value + ", c=" + color + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if (!(obj instanceof Item))
            return false;
        Item other = (Item) obj;
        if (index != other.index)
            return false;
        if (value != other.value)
            return false;
        return true;
    }

    public int compareTo(Item item) {
        return this.value - item.getValue();
    }

}

public class BallsSeparating {

    public static void main(String[] args) {

        int red[] = {593633, 211316, 46137, 237279, 341207, 383572, 32736, 39339, 457733, 976647, 936427, 370527, 663144, 523038, 55546, 45875, 384421, 930620, 92741, 806460, 614363, 851389, 157524, 782148, 791526, 621541, 229605, 792784, 674698, 453232, 339522, 206915, 911094, 498363, 67339, 73740, 720783, 604107, 315456, 296207, 767669, 327099, 82766, 297005, 481234, 868477, 232044, 811528, 386635, 116589};
        int green[] = {581606, 344355, 539392, 107584, 6247, 476731, 283909, 192119, 536154, 112385, 518864, 419309, 103608, 240114, 174019, 417338, 546623, 255782, 616012, 821750, 811090, 130300, 411073, 849526, 915036, 874752, 315333, 991465, 11545, 892774, 86677, 864862, 477402, 695379, 52258, 302661, 871685, 20473, 343326, 563033, 885263, 562211, 924155, 605257, 476478, 206575, 852290, 914024, 301077, 818675};
        int blue[] = {356079, 486648, 225494, 523195, 986436, 821025, 738039, 205869, 861592, 931534, 276083, 834584, 105338, 818044, 866221, 468466, 417944, 42253, 197656, 702004, 865723, 487838, 669021, 833309, 745388, 853227, 123547, 638191, 117769, 918374, 401330, 565617, 94498, 998787, 110890, 336896, 293902, 342820, 448302, 647186, 788734, 981589, 429579, 908541, 359347, 610617, 689037, 682546, 762716, 903090};

        System.out.println(new BallsSeparating().minOperations(red, green, blue));

    }

    public int minOperations(int[] red, int[] green, int[] blue) {

        if (red.length < 3)
            return -1;


        LinkedList<Item> balls = new LinkedList<Item>();

        for (int i = 0; i < blue.length; i++) {
            balls.add(new Item(i, red[i], 0));
            balls.add(new Item(i, green[i], 1));
            balls.add(new Item(i, blue[i], 2));
        }

        Item r = null;
        Item g = null;
        Item b = null;

        Collections.sort(balls);


        int j = balls.size() - 1;
        do {

            Item x = balls.get(j);

            if (x.getColor() == 0 && r == null) {
                if ((g != null && g.getIndex() != x.getIndex())
                        && (b != null && b.getIndex() != x.getIndex())
                        ) {
                    r = balls.remove(j);
                } else if (g == null && (b != null && b.getIndex() != x.getIndex())) {
                    r = balls.remove(j);
                } else if ((g != null && g.getIndex() != x.getIndex()) && (b == null)) {
                    r = balls.remove(j);
                } else if (g == null && b == null) {
                    r = balls.remove(j);
                }
            } else if (x.getColor() == 1 && g == null) {
                if ((r != null && r.getIndex() != x.getIndex())
                        && (b != null && b.getIndex() != x.getIndex())
                        ) {
                    g = balls.remove(j);
                } else if (r == null && (b != null && b.getIndex() != x.getIndex())) {
                    g = balls.remove(j);
                } else if ((r != null && r.getIndex() != x.getIndex()) && (b == null)) {
                    g = balls.remove(j);
                } else if (r == null && b == null) {
                    g = balls.remove(j);
                }
            } else if (x.getColor() == 2 && b == null) {
                if ((g != null && g.getIndex() != x.getIndex())
                        && (r != null && r.getIndex() != x.getIndex())
                        ) {
                    b = balls.remove(j);
                } else if (g == null && (r != null && r.getIndex() != x.getIndex())) {
                    b = balls.remove(j);
                } else if ((g != null && g.getIndex() != x.getIndex()) && (r == null)) {
                    b = balls.remove(j);
                } else if (g == null && r == null) {
                    b = balls.remove(j);
                }
            }

            j--;

        } while (j >= 0 && (r == null || g == null || b == null));


        int movement = 0;
        for (int i = 0; i < balls.size(); i++) {

            Item item = balls.get(i);

            if (item.getColor() == 0 && (green[item.getIndex()] > 0 || blue[item.getIndex()] > 0)) {
                movement = movement + red[item.getIndex()];
                red[item.getIndex()] = 0;
            } else if (item.getColor() == 1 && (red[item.getIndex()] > 0 || blue[item.getIndex()] > 0)) {
                movement = movement + green[item.getIndex()];
                green[item.getIndex()] = 0;
            } else if (item.getColor() == 2 && (red[item.getIndex()] > 0 || green[item.getIndex()] > 0)) {
                movement = movement + blue[item.getIndex()];
                blue[item.getIndex()] = 0;
            }
        }

        return movement;
    }

}
