import java.util.*;
class Rand_Min_Cut{
    public static void main(String[] args) {
        int n =4;
        // int G[][] = {
        //     {1,2,2},{1,4,3},{2,1,2},{2,3,3},{2,4,3},{3,2,3},{3,4,2},{4,1,3},{4,2,3},{4,3,2},
        // };
        int G[][] = {
            {0,1,1,1},
            {1,0,0,1}, 
            {1,0,0,1},
            {1,1,1,0}
        };
        Rand_Min_Cut_Helper obj = new Rand_Min_Cut_Helper();
        obj.minCut(G);
    }
}

class Rand_Min_Cut_Helper{
    int nG[][]={};
    int cutValue =0;
    int cut=0;
    void minCut(int G[][]){
        int n = G.length;
        nG  = new int[n][n];
        Random rand = new Random();
        int v = rand.nextInt(n);
        int u = rand.nextInt(n);
        
        for(int i =0;i<n;i++){
            for(int j =i+1;j<n;j++){
                cut = 0;
                if(i==u && j == v){
                    nG[i][j] = 0;
                    nG[j][i] = 0;
                }
                else if(i == u || i == v){
                    if(G[u][j] > 0)
                        cut += G[u][j];
                    if(G[v][j] > 0)
                        cut += G[v][j];
                    nG[u][j] = nG[v][j] = cut;
                }
                else if(j == u || j == v){
                    if(G[u][i] > 0)
                        cut += G[u][i];
                    if(G[v][i] > 0)
                        cut += G[v][i];
                    nG[i][u] = nG[i][v] = cut;
                }
                else{
                    nG[i][i] = G[i][i];
                }
            }
        }
        for(int i =0 ;i<n;i++){
            for(int j =0;j<n;j++){
                if(i>=j){
                    nG[i][j] = nG[j][i];
                }
            }        
        }
        int tG[][] = new int[n-1][n-1];
        System.out.println(v);
        for(int i =0;i<G.length-1;i++){
            for(int j =0;j<G.length-1;j++){
                 if(j == v && i ==v && j+1 != G.length && i+1 != G.length){
                    tG[i][j] = G[i+1][j+1];
                    i++;
                    j++;       
                 }else if(j == v && j+1 != G.length){
                    tG[i][j] = G[i][j+1];
                    j++;
                 }else if(i == v && i+1 != G.length){
                    tG[i][j] = G[i+1][j];
                    i++;
                 }else{
                    tG[i][j] = G[i][j];
                 }
                 
            }
        }

        printArr(tG);
        
        if(tG.length>2){
            minCut(tG);
        }
        cutValue = tG[0][1];
        System.out.println("Cut Value"+cutValue);
    }
    void printArr(int G[][]){
        for (int i = 0; i < G.length; i++) {
                for (int j = 0; j < G.length; j++) {
                    System.out.print(" "+ G[i][j]+" ");
                }
                System.out.println("");
        }
    }
}