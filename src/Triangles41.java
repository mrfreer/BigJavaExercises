import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dfreer on 2/22/2017.
 */
class Coordinate{
    double x, y;

    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }
}
public class Triangles41 {
    DecimalFormat df = new DecimalFormat("#.00");
    double sides[] = new double[3];
    Coordinate threeSides[] = new Coordinate[3];
    public Triangles41(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            double x, y;
            System.out.println("Enter the x coordinate:");
            x = scanner.nextDouble();
            System.out.println("Enter the y coordinate:");
            y = scanner.nextDouble();
            threeSides[i] = new Coordinate(x, y);
        }
        this.setSides();
        this.findPerimeter();

        this.angles();
        this.findArea();
    }
    public void setSides(){
        sides[0] = Math.sqrt(Math.pow(threeSides[0].x- threeSides[1].x, 2.0) +
                        Math.pow(threeSides[0].y - threeSides[1].y, 2.0));
        sides[1] = Math.sqrt(Math.pow(threeSides[1].x- threeSides[2].x, 2.0) +
                Math.pow(threeSides[1].y - threeSides[2].y, 2.0));
        sides[2] = Math.sqrt(Math.pow(threeSides[2].x- threeSides[0].x, 2.0) +
                Math.pow(threeSides[2].y - threeSides[0].y, 2.0));
        System.out.println("Lengths:");
        Arrays.sort(sides);
        System.out.println("Side 1: " + df.format(sides[0]));
        System.out.println("Side 2: " + df.format(sides[1]));
        System.out.println("Side 3: " + df.format(sides[2]));
    }

    public void findPerimeter(){
        System.out.println("Perimeter = " + df.format(sides[0] + sides[1] + sides[2]));
    }

    public void findArea(){
        double height, length;
        Arrays.sort(sides);
        System.out.println("Area : " + df.format((sides[0] * sides[1])/2.0));
    }

    public void angles(){
        double angle3 = Math.toDegrees(Math.acos((((Math.pow(sides[0], 2) + Math.pow(sides[1], 2) -
                                Math.pow(sides[2], 2)) / (2 * sides[0] * sides[1])))));
        System.out.println(df.format(angle3) + " angle");
        double angle2 = Math.toDegrees(Math.acos((((Math.pow(sides[1], 2) + Math.pow(sides[2], 2) -
                Math.pow(sides[0], 2)) / (2 * sides[1] * sides[2])))));
        System.out.println(df.format(angle2) + " angle");
        double angle1 = (180 - (angle3 + angle2));
        System.out.println(df.format(angle1) + " angle");
        System.out.println("The three angles equal " + (angle1 + angle2 + angle3));
    }

    public static void main(String[] args) {
        Triangles41 t = new Triangles41();

    }
}
