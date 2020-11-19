package it.corsobackendtree.esercizi16.parallelsortpixels;

import java.awt.*;

public class MyColor implements Comparable<MyColor>{
    private Color color;

    public MyColor(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public int compareTo(MyColor o) {
        int s1 = this.color.getRed()+this.color.getGreen()+this.color.getBlue();
        int s2 = o.color.getRed()+o.color.getGreen()+o.color.getBlue();
        return Integer.compare(s1,s2);
    }

    @Override
    public String toString() {
        return ""+(this.color.getRed()+this.color.getGreen()+this.color.getBlue());
    }
}
