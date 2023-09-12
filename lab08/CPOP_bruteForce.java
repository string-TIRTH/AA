import java.math.*;
import java.util.*;
class CPOP_bruteForce{
    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(2, 2));
        points.add(new Point(4, 4));
        points.add(new Point(5, 5));
        CPOP_bruteForceHelper obj = new CPOP_bruteForceHelper();
        obj.closestPoint(points);
    }
}
class Point{
    int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class CPOP_bruteForceHelper{
    public double distance(Point p1,Point p2){
        int d = (int) Math.pow((p1.x -p2.x),2) + (int) Math.pow((p1.y -p2.y),2) ;
        return Math.sqrt(d);
    }
    public void closestPoint(List<Point> points){
        double minDistance=Double.MAX_VALUE;
        double temp =0.0;
        Point closest1 = points.get(0);
        Point closest2 = points.get(1);
        for(int i=0;i<points.size()-1;i++){
            for (int j = i+1; j < points.size(); j++) {
                temp =  distance(points.get(i),points.get(j));
                if(minDistance > temp){
                    System.out.println("temp = "+temp);
                    minDistance = temp;
                    closest1 = points.get(i);
                    closest2 = points.get(j);
                }
            }
        }
        System.out.println("("+closest1.x+","+closest1.y+") and"+"("+closest2.x+","+closest2.y+") are closest points");
    }
}