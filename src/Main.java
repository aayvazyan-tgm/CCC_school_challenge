import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(initFile("in.1"));
        System.out.println(initFile("in.2"));
        System.out.println(initFile("in.3"));
        System.out.println(initFile("in.4"));
        System.out.println(initFile("in.5"));
        System.out.println(initFile("in.6"));
    }

    public static long initFile(String filePath) {
        HashMap<Integer, LinkedList<Point>> myMapSystemX = new HashMap<Integer, LinkedList<Point>>();
        HashMap<Integer, LinkedList<Point>> myMapSystemY = new HashMap<Integer, LinkedList<Point>>();

        File f = new File(filePath);
        if (f.exists()) {
            Scanner scanner = null;
            try {
                scanner = new Scanner(f);
                int totalValues = scanner.nextInt();//Total number
                while (scanner.hasNextInt()) {
                    Point cur = new Point(scanner.nextInt(), scanner.nextInt());
                    LinkedList<Point> mapxV = myMapSystemX.get(cur.x);
                    if (mapxV == null) {
                        LinkedList<Point> nL = new LinkedList<Point>();
                        nL.add(cur);
                        myMapSystemX.put(cur.x, nL);
                    } else {
                        mapxV.add(cur);
                    }
                    LinkedList<Point> mapyV = myMapSystemY.get(cur.y);
                    if (mapyV == null) {
                        LinkedList<Point> nL = new LinkedList<Point>();
                        nL.add(cur);
                        myMapSystemY.put(cur.y, nL);
                    } else {
                        mapyV.add(cur);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found!");
        }
        //do the processing
        long result = 0;
        for (LinkedList<Point> curPoint : myMapSystemX.values()) {
            for (Point myP : curPoint) {
                if (myMapSystemY.get(myP.y).size() == 0) continue;
                if (myMapSystemY.get(myP.y).size() == 0) continue;
                result += ((long) (myMapSystemX.get(myP.x).size() - 1)) * ((long) myMapSystemY.get(myP.y).size() - 1);
            }
        }
        return result;
    }

    public static Point[] pointsCast(int... points) {
        Point[] result = new Point[points.length / 2];
        for (int i = 1; i < points.length; i += 2) {//=1 because value 1 is the number of xy pairs
            result[i / 2] = new Point(points[i], points[i + 1]);
        }
        return result;
    }

    public static int areTheySpecial(Point... p) {
        int result = 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                for (int k = 0; k < p.length; k++) {
                    if (i == k || i == j || j == k) continue;
                    if (isSpecial(p[i], p[j], p[k])) {
                        result++;
                    }
                }
            }
        }
        return result / 6;
    }

    public static boolean isSpecial(Point... p) {
        Point p1 = p[0];//Meh dirty ... but quick
        Point p2 = p[1];
        Point p3 = p[2];

        boolean result = false;
        int parl = 0;
        if (p1.x == p2.x) parl++;
        if (p1.x == p3.x) parl++;
        if (p2.x == p3.x) parl++;
        if (parl >= 3) return false;

        int parl2 = 0;
        if (p1.y == p2.y) parl2++;
        if (p1.y == p3.y) parl2++;
        if (p2.y == p3.y) parl2++;
        if (parl2 >= 3) return false;

        if (parl + parl2 >= 2) return true;
        return result;
    }

    public static String isParallelTo(Point... points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].x == points[i + 1].x) return "y-axis";
            if (points[i].y == points[i + 1].y) return "x-axis";
        }
        return "none";
    }
}
