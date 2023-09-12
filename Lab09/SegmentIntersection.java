import java.util.*;

class Point{
    double x,y;
    Point(double x,double y){
        this.x = x;
        this.y = y;
    }
}

class SegmentIntersection{
    public static void main(String[] args) {
        // Point p1 = new Point(1, 1);
        // Point p2 = new Point(3, 3);
        // Point p3 = new Point(5, 5);
        // Point p4 = new Point(8, 8);
        Point p1 = new Point(2, 2);
        Point p2 = new Point(8, 3);
        Point p3 = new Point(1, 4);
        Point p4 = new Point(6, 5);
        SegmentIntersectionHelper obj = new SegmentIntersectionHelper();
        System.out.println(obj.intersectCheck(p1,p2,p3,p4));
    }
}
class SegmentIntersectionHelper{
    boolean intersectCheck(Point p1,Point p2,Point p3,Point p4){
        double d[] = new double[4];
        d[0] = direciton(p3, p4, p1);
        d[1] = direciton(p3, p4, p2);
        d[2] = direciton(p1, p2, p3);
        d[3] = direciton(p1, p2, p4);

        if((d[0]>0 && d[1]<0) || (d[0]<0 && d[1]>0) && (d[2]>0 && d[3]<0) || (d[2]<0 && d[3]>0)){
            return true;
        }else if( d[0] == 0 && onSegment(p3, p4, p1)){
            return true;
        }else if( d[1] == 0 && onSegment(p3, p4, p2)){
            return true;
        }else if( d[2] == 0 && onSegment(p1, p2, p3)){
            return true;
        }else if( d[3] == 0 && onSegment(p1, p2, p4)){
            return true;
        }else{
            return false;
        }
    }
    double direciton(Point p1,Point p2,Point p3){
        return (p3.x - p1.x)*(p2.x - p1.x);
    }
    boolean onSegment(Point p1,Point p2,Point p3){
        if(Math.min(p1.x,p2.x) <= p3.x && p3.x <= Math.max(p1.x,p2.x) && Math.min(p1.y,p2.y) <= p3.y && p3.y <= Math.max(p1.y,p2.y)){
            return true;
        }
        return false;
    }
}