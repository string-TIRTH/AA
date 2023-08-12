import java.util.*;

class RandQS{
    public static void main(String args[]){
        QuickSort obj = new QuickSort();
        int test_count = 1;
        
        //[]
        for(int i=1;i<=test_count;i++){
            int arr[] = {4, 3, 6, 8, 5, 9, 20, 50, 12, 30, 432, 12, 69, 29, 40, 50, 10, 4, 23, 34, 45, 45, 24,
                     89, 799, 45, 80, 50, 10, 30, 43,54,65,76,87, 98, 21, 32, 43, 78, 98, 57, 29, 
                     91, 34,54, 64, 19, 82, 87, 65};
                    //   int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,12,13,14,15,16,18}; //sorted
        //  int arr[] = {81,61,51,41,31,21,9 ,8 ,7 ,6 ,5 ,4 ,3 ,2 ,1 ,0}; //reverse
            // int arr[] = {1,61,51,4,231,21,90 ,84 ,72 ,64 ,15 ,40 ,33 ,112 ,21 ,10}; //Random
            obj.quicksort(arr,0,arr.length-1);
            obj.printArr(arr);
            // System.out.println(i+"th Iteration : "+"Comps = "+obj.count);
            obj.count = 0;
        }
    }
}
class QuickSort{
    static int count;
    Random rand = new Random();
    public void quicksort(int arr[],int p,int r)
    {
        if(p<r){
            int n = rand.nextInt(r-p+1) + p;
            swap(arr,n,r);
            int q = partition(arr,p,r);
            quicksort(arr,p,q-1);
            quicksort(arr,q+1,r);
        }
    }
    public int partition(int arr[],int p,int r){
        
        int pivot = arr[r];
        int i = (p-1); 
        for (int j=p; j<r; j++)
        {
            count++;
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
    public void printArr(int arr[]){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}