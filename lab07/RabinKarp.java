import java.util.*;

class RabinKarp{
    public static void main(String[] args) {
        // String T = "2359023141526739921";
        String T = "31415314153141531415314153141531415";
        String P = "31415";
        int d = 10;
        int q = 13;
        RabinKarpHelper obj = new RabinKarpHelper();
        obj.matcher(T,P,d,q);
        // System.out.println("exited");
    }
}
class RabinKarpHelper{
    void matcher(String T,String P,int d,int q){
        int n = T.length();
        int m = P.length();
        int h = power(d, m, q);
        int p = 0;
        int t=0;
        for(int i=0;i<m;i++){
            p = (d*p + ((P.charAt(i))-'0') );
            t = (d*t + ((T.charAt(i))-'0') );
        }
        p = p%q;
        t = t%q;
        for(int s= 0;s<=n-m;s++){
            if(p == t){
                boolean flag = true;
                for(int i=0;i<m;i++){
                    if(P.charAt(i) != T.charAt(s+i)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                        System.out.println("Match Found At s :"+s);        
                }
            }
            if(s< n-m){
                t = (d*(t-((T.charAt(s)-'0')*h))+(T.charAt(s+m)-'0'))%q;
                while(t<0)
                    t = t+q;
            }
            
        }
    }
    int power(int a,int x,int y){
        int res = 1;
        while(x>0){
            a= (a*a)%y;
            if(x % 2 ==1){
                res = (res*a)%y;
            }
            x=x/2;
        }
        return res;
    }
}