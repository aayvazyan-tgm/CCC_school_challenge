import java.awt.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(isSpecial(pointsCast(15,10,14,9,15,9)));
        System.out.println(isSpecial(pointsCast(17032,18764,17033,18764,65513,35035 )));
        System.out.println(isSpecial(pointsCast(17681,13421,17681,17681,13421,17681 )));
        System.out.println(isSpecial(pointsCast(96812,46581,96812,65135,96812,34561 )));
        System.out.println(isSpecial(pointsCast(65132,15153,65431,51315,65413,65134 )));
        System.out.println(isSpecial(pointsCast(25315,25315,25315,35135,35135,35135 )));

    }
    public static Point[] pointsCast(int ...points){
        Point[] result= new Point[points.length/2];
        for(int i=0;i<points.length;i+=2){
            result[i/2]=new Point(points[i],points[i+1]);
        }
        return result;
    }
    public static boolean isSpecial(Point ...p){
        Point p1=p[0];//Meh dirty ... but quick
        Point p2=p[1];
        Point p3=p[2];

        boolean result=false;
        int parl=0;
        if(p1.x==p2.x)parl++;
        if(p1.x==p3.x)parl++;
        if(p2.x==p3.x)parl++;
        if(parl>=3)return false;

        int parl2=0;
        if(p1.y==p2.y)parl2++;
        if(p1.y==p3.y)parl2++;
        if(p2.y==p3.y)parl2++;
        if(parl2>=3)return false;

        if(parl+parl2>=2)return true;
        return result;
    }
    public static String isParallelTo(Point ...points){
        for(int i=0;i<points.length-1;i++){
            if(points[i].x==points[i+1].x)return "y-axis";
            if(points[i].y==points[i+1].y)return "x-axis";
        }
        return "none";
    }
}
