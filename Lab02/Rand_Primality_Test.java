import java.util.*;
class Rand_Primality_Test{
    public static void main(String[] args) {
        int test_count = 1;
        // int f_liars = 0;
        // long n =1000000000;
        Rand_Primality_Test_Helper obj = new Rand_Primality_Test_Helper();
        for(int i = 1 ;i<test_count+1;i++){
            // //  System.out.println(i+"th iteration = "+obj.isPrime(2614150 , 1));
            // if(obj.isPrime( , 100) == true){
            //     System.out.println("Error at "+i+"th iteration");
            if(obj.isPrime(4, 100)){
                System.out.println("given number is Prime");
            }else{
                System.out.println("given number is composite");
            }
            // System.out.println(obj.isPrime(1000000008 , 1));
        }
        
        // long exp = n/6000000;
        // System.out.println("expected waiting time : "+exp+" Seconds");
        // for(long i=2;i<n-2;i++){
        //     // System.out.println(i+"th iteration");
        //     if(obj.mod_exp(i,n-1,n) == 1){
        //         System.out.println(i+" is F-Liar");
        //         f_liars++;
        //     }   
        // }

        // float  prob = ((float )(f_liars)/(n-3));
        // System.out.println(f_liars);
        // System.out.println(n-3);
        // System.out.println("Probablity : "+((float )(f_liars)/(n-3)));
    }
}
class Rand_Primality_Test_Helper{
    long mod_exp(long a,long x,long y){
        long res = 1;
        while(x>0){
            a= (a*a)%y;
            if(x % 2 ==1){
                res = (res*a)%y;
            }
            x=x/2;
            
        }
        return res;
    }
    long gcd(long x,long y){
        long r=0;
        while(y!=0){
            r = x%y;
            x = y;
            y=r;
        }
        return x;
    }
    boolean isPrime(long n,long k){
        if( n == 1 ){
            return false;
        }else if(n==2 || n==3){
            return true;
        }
        Random rand = new Random();
        long i=0;
        while(i<k){
            long a = 2+ rand.nextLong(n-3);
            if(gcd(a,n) != 1){
                return false;
            }
            if(mod_exp(a, n-1, n) != 1){
                return false;
            }
            i++;
        }

        return true;
    }
}