import java.awt.*;

/**
 * Created by dfreer on 7/19/2017.
 */

class Data {
    public static Measurable largest(Measurable [] arr){
        Measurable max = arr[0];
        for(Measurable obj: arr){
            if(obj.getMeasure() > max.getMeasure()){
                max = obj;
            }
        }
        return max;
    }

    public static Object largest(Object [] objects, Measurer meas){
        if(objects == null){
            throw new NullPointerException("Can't handle null arrays");
        }
        if(objects.length == 0){
            throw new IllegalArgumentException("Can't handle zero-length arrays.");
        }

        Object largest = objects[0];
        for(Object o : objects){
            if(meas.measure(o) > meas.measure(largest)){
                largest = o;
            }
        }
        return  largest;
    }
}

interface Measurer{
    double measure(Object anObject);
}

interface Measurable{
    double getMeasure();
}

public class RectangleTester96 implements Measurer{

    public double measure(Object anObject){
        Rectangle rect = (Rectangle)(anObject);
        return rect.getHeight() * 2 + rect.getWidth() * 2;
    }

    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[]{
                new Rectangle(10,10),
                new Rectangle(15,15)
        };
        RectangleTester96 rt = new RectangleTester96();
        Rectangle largest = (Rectangle)Data.largest(rectangles, rt);
        System.out.println(largest.getSize());
        //This problem gave me a bit of trouble.  It seems so convoluted that I
        //had a bit of trouble with it...
        //I needed :
        //https://github.com/ifqthenp/big-java/blob/master/early-objects/10-interfaces/src/main/java/e_10_09_RectanglePerimeterMeasurer/Data.java
        //The main thing I was missing was the max method that takes in the array of
        //Objects and the Measurer interface...

    }

}
