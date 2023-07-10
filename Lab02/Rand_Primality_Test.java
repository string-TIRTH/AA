import java.util.*;
class Rand_Primality_Test{
    public static void main(String[] args) {
        int test_count = 1000000;
        Rand_Primality_Test_Helper obj = new Rand_Primality_Test_Helper();
        for(int i = 1 ;i<test_count+1;i++){
            //  System.out.println(i+"th iteration = "+obj.isPrime(2614150 , 1));
            if(obj.isPrime(16 , 100) == true){
                System.out.println("Error at "+i+"th iteration");
            }
        }
       
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