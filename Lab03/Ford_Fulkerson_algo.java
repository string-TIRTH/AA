import java.util.LinkedList;
import java.util.Queue;

class Ford_Fulkerson_algo{
    public static void main(String[] args) {
        int G[][] = {
            {0,8,0,0,4,0}, // 0
            {0,0,5,0,0,0}, // 1 
            {0,0,0,4,0,0},  // 2
            {0,0,0,0,0,0},  // 2
            {0,0,7,0,0,2}, // 3
            {0,0,0,3,0,0}, // 4
        };
        // int G[][] = {
            // {0,16,13,0,0,0}, // 0
            // {0,0,10,12,0,0}, // 1 
            // {0,4,0,0,14,0},  // 2
            // {0,0,9,0,0,20}, //  3
            // {0,0,0,7,0,4}, //   4
            // {0,0,0,0,0,0}  //   5
        // };
        Ford_Fulkerson_algo_helper obj = new Ford_Fulkerson_algo_helper();
        System.out.println("Max Flow ="+obj.fordFlukerson(G, 0, 3));
    }
}
class Ford_Fulkerson_algo_helper{
    int X[][];
    int P[];
    int fordFlukerson(int G[][],int s,int t){
        X= new int[G.length][G.length];
        P = new int [G.length];
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G.length; j++) {
                X[i][j] = G[i][j];
            }
        }
        int max_flow = 0;
        while(bfs(X,s,t,P)){
            int pathFlow = Integer.MAX_VALUE;
            for(int v = t;v!=s;v = P[v]){
                int u = P[v];
                pathFlow = Math.min(pathFlow, X[u][v]);
            }
            for(int v = t;v!=s;v = P[v]){
                int u =  P[v];
                X[u][v] -= pathFlow;
                X[v][u] += pathFlow;

            }
            max_flow +=pathFlow;
        }
        return max_flow;
        // printArr(X);    
        
    }
    void printArr(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+",");       
            }
            System.out.println("");
        }
    }
    boolean bfs(int G[][],int s ,int t, int P[]){
        int visited [] =  new int[G.length];    
        Queue<Integer> queue= new LinkedList<>();
        for (int i = 0; i < visited.length-1; i++) {
            visited[i] =0 ;
        }
        queue.add(s);
        visited[s] = 1;
        P[s] = -1;
        while(!queue.isEmpty()){
            int u = queue.remove();
            for(int v = 0;v<G.length;v++){
                if(visited[v]== 0 && X[u][v]>0){
                    if(v == t){
                        P[v] = u;
                        return true;
                    }
                    queue.add(v);
                    visited[v] = 1;
                    P[v]= u;
                }
            }
        }
        return false;
    }
}