class HorsepollStringMatching {
    public static void main(String[] args) {
        String str = "JIM_SAW_ME_IN_A_BARBER_SHOP_BARBERBARBERBARBER";
        String ptn = "UMBRELLA";
        HorsepollStringMatchingHelper obj = new HorsepollStringMatchingHelper();
        obj.matcher(str, ptn);
        System.out.println("");
        obj.printArr(obj.shift); 
        
        // System.out.println(str.length());      
        // System.out.println(obj.shift[17]);
    }    
}

class HorsepollStringMatchingHelper{
    int shift[] = new int[26];
    void matcher(String str,    String ptn){
        for (int i = 0; i < shift.length; i++) {
            shift[i] = ptn.length();
        }
        for(int i=0;i<ptn.length()-1;i++){
            shift[ptn.charAt(i)-'A'] = ptn.length()-1-i;
        }
        int j=ptn.length()-1;
        for(int s=ptn.length()-1;s<str.length()-1;){
            
            int i=s; 
            j=ptn.length()-1;
            while(j>0  && j<ptn.length()&& s<str.length()-1){
                // System.out.println(s);
                
                if(str.charAt(i) != ptn.charAt(j))
                {   
                    // System.out.println("s = "+s);
                    // System.out.println();
                    if(str.charAt(i) == '_'){
                        s= s+ptn.length();
                    }
                    else{
                        // System.out.println(ptn.charAt(j) - 'A');
                        // System.out.println("x = "+(shift[str.charAt(s) - 'A']));
                        s = s+(shift[str.charAt(s) - 'A']);
                        // System.out.println("s = "+s);
                    }
                    break;
                }
                else{
                    i--;
                    j--;
                    // System.out.println(s+" - "+i);
                    if(j==0){
                        System.out.println("match found  :"+(s-ptn.length()));
                        s = s+(shift[str.charAt(s) - 'A']);
                    }
                    
                }   
            }
            
        }
    }
    void printArr(int arr[]){
        for (int i = 97; i < 123; i++) {
            // if(arr[i]!=6)
            System.out.print(" "+(char)i);
        }
        System.out.println("");
        for (int i = 97; i < 123; i++) {
            // if(arr[i]!=6)
            System.out.print(" "+arr[i-97]);
        }
    }
}
