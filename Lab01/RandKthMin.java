import java.net.Inet4Address;
import java.util.*;
public class RandKthMin {
    public static void main(String[] args) {
        RandKthMinHelper obj = new RandKthMinHelper();
        int arr[] = {
            4, 3, 6, 8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65,8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65,8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65,8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65,8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65,8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65,8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65,8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65,8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65,8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65,8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65};
        obj.findKth(arr,1);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(0,2);
        list3.add(1,3);
        list3.add(2,1);
        list2.add(0,1);
        list2.add(1,2);
        list2.add(2,3);
        list.add(0,list3);
        // list.add(1,list2);
        if(list.contains(list2)){
            System.out.println(list2);
        }
        // System.out.println(list);
        
        // System.out.println(arr.length);
    }

    
}
class RandKthMinHelper{
    public void findKth(int arr[],int k){
        k--;
        quicksort(arr,0,arr.length-1,k);
    }
    public void quicksort(int arr[],int p,int r,int k)
    {
        Random rand = new Random();
        if(p<r){
            int n = rand.nextInt(r-p+1) + p;
            swap(arr,n,r);
            int q = partition(arr,p,r);
            if( q == k){
                System.out.println(arr[q]);
                return ;
            }
            if(q < k)
                quicksort(arr,q+1,r,k);
            else
                quicksort(arr,p,q-1,k);
            
            }
    }
    public int partition(int arr[],int p,int r){
        
        int pivot = arr[r];
        int i = (p-1); 
        for (int j=p; j<r; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                // int temp = arr[i];
                // arr[i] = arr[j];
                // arr[j] = temp;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,r);
        
        return i+1;
    }
    public void swap(int arr[],int p,int r){
        int temp = arr[p];
        arr[p] = arr[r];
        arr[r] = temp;
    }
}
