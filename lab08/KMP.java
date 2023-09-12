class KMP{
    public static void main(String[] args) {
        KMPHelper obj = new KMPHelper();
        String s1 = "abacabafdsfsagsdbgggsgacagfsbaabacaba";
        String s2 = "abacaba";
        obj.matcher(s1, s2);   
        // obj.piFinder(s2);   
    }
}
class KMPHelper{
    public int[] piFinder(String ptn){
        int m = ptn.length();
        int PI[] = new int[ptn.length()];
        PI[0] = 0;
        int k=0;
        for(int i=1;i<m;i++){
            while(k>0 && ptn.charAt(k) != ptn.charAt(i)){
                k = PI[k-1];
            }
            if(ptn.charAt(k) == ptn.charAt(i))
                k++;
            PI[i] = k;
        }
        for(int i=0;i<m;i++)
            System.out.println(PI[i]);
        return PI;
    }
    public void matcher(String str,String ptn){
        int n = str.length();
        int m = ptn.length();
        int PI[] = piFinder(ptn);
        int q =0;
        for(int i =0;i<n;i++){
            while(q>0 && ptn.charAt(q) != str.charAt(i)){
                q = PI[q];
            }
            if(ptn.charAt(q) == str.charAt(i)){
                q++;
            }
            if(q == m){
                System.out.println("Match found at : "+(i-m+1));
                q = PI[q-1];
            }
        }
    }
}