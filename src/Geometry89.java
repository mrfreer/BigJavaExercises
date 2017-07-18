import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * Created by dfreer on 7/18/2017.
 */
public class Geometry89 {

    public static boolean isInside(Point2D.Double p, Ellipse2D.Double e){
        System.out.println(p.x + " is x " + p.y + " is y");
        System.out.println(e.getCenterX() + " is center x " + e.getCenterY() + " center y");
        if(e.contains(p.x, p.y))
            return true;
        else
            return false;
    }

    public static boolean isOnBoundary(Point2D.Double p, Ellipse2D.Double e){

        if(e.intersects(p.getX(), p.getY(), 1, 1))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Point2D.Double point = new Point2D.Double(25,50);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0,0,50,100);
        System.out.println(isInside(point, ellipse));
        System.out.println(isOnBoundary(point, ellipse));
    }
}

