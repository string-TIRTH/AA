class Point{
    double x,y;
    Point(double x,double y){
        this.x = x;
        this.y = y;
    }
}
class GrahamScan {

}
class GrahamScanHelper{
    Point getLeftMostPoint(Point[] points){
        double min = Integer.MAX_VALUE;
        Point leftPoint = points[0];
        for(int i=0;i<points.length;i++){
            if(min >= points[i].y){
                if(min == points[i].y){
                    if(leftPoint.x > points[i].x){
                        leftPoint = points[i];
                    } 
                }else{
                    min = points[i].y;
                    leftPoint = points[i];
                }
            }
        }
        return leftPoint;
    }
}
