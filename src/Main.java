import java.awt.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(areTheySpecial(pointsCast(4,1,1,3,2,3,3,3,1)));
        System.out.println(areTheySpecial(pointsCast(10, 9, 6, 7, 8, 3, 1, 6, 9, 2, 2, 10, 3, 3, 10, 8, 1, 6, 10, 4, 3)));
        System.out.println(areTheySpecial(pointsCast(25, 14, 8, 14, 5, 13, 25, 1, 5, 13, 7, 16, 7, 9, 21, 11, 13, 5, 24, 9, 1, 10, 23, 1, 14, 18, 3, 20, 7, 4, 6, 22, 14, 2, 23, 18, 11, 3, 5, 14, 3, 23, 10, 7, 14, 17, 2, 8, 16, 5, 17)));
        System.out.println(areTheySpecial(pointsCast(50, 7, 4, 8, 9, 2, 5, 2, 9, 3, 10, 5, 9, 5, 3, 10, 7, 1, 9, 4, 5, 4, 4, 3, 3, 8, 2, 4, 2, 4, 3, 8, 4, 6, 8, 2, 6, 9, 6, 8, 5, 9, 7, 7, 8, 6, 9, 10, 5, 9, 3, 3, 9, 8, 8, 3, 5, 3, 7, 6, 10, 10, 9, 9, 10, 3, 1, 7, 3, 5, 2, 9, 2, 7, 9, 8, 1, 10, 2, 4, 1, 5, 6, 5, 7, 7, 10, 1, 3, 2, 4, 1, 7, 9, 1, 10, 3, 2, 2, 5, 5)));
        System.out.println(areTheySpecial(pointsCast(99, 8, 17, 9, 16, 17, 14, 2, 4, 17, 9, 7, 14, 4, 10, 10, 1, 10, 9, 4, 3, 9, 4, 7, 12, 7, 10, 15, 19, 16, 20, 18, 16, 19, 10, 1, 9, 15, 16, 19, 11, 1, 1, 19, 7, 1, 8, 7, 4, 4, 13, 16, 19, 19, 16, 14, 20, 7, 3, 18, 2, 4, 15, 8, 11, 9, 12, 20, 7, 15, 9, 13, 9, 4, 11, 8, 3, 20, 2, 17, 19, 10, 19, 2, 18, 12, 2, 2, 15, 11, 7, 15, 7, 5, 13, 14, 19, 17, 20, 2, 13, 2, 16, 17, 8, 8, 13, 3, 8, 15, 12, 2, 2, 9, 3, 1, 7, 7, 11, 2, 14, 16, 14, 6, 4, 18, 9, 11, 3, 13, 3, 17, 5, 1, 2, 18, 11, 3, 2, 16, 11, 9, 1, 1, 16, 4, 4, 3, 1, 12, 9, 8, 8, 1, 19, 19, 17, 10, 2, 8, 4, 16, 8, 3, 7, 3, 10, 13, 10, 20, 15, 19, 2, 3, 15, 6, 19, 19, 6, 15, 6, 1, 20, 20, 13, 17, 12, 11, 11, 10, 7, 7, 20, 8, 15, 15, 5, 4, 12)));

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
                    if (isSpecial(p[i], p[j], p[k])){
                        result++;
                    }
                }
            }
        }
        return result/6;
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
