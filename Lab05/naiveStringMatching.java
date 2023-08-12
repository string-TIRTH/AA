class naiveStringMatching{
    public static void main(String[] args) {
        String str = "hhow hhhow world im tirth hhow are you?";
        String ptn = "how";
        naiveStringMatchingHelper obj = new naiveStringMatchingHelper();
        obj.naiveMatcher(str, ptn);
    }

}
class naiveStringMatchingHelper{
    int naiveMatcher(String str,String ptn){
        boolean matchFound = true;
        for (int s = 0; s < str.length()-ptn.length()+1; s++) {
            int i=0,j=0;
            while(j< ptn.length() && str.charAt(s+i)==ptn.charAt(j)){
                i++;
                j++;
            }    
            if(j==ptn.length()){
                System.out.println(s);
            }
        }
        return 0;
    }
}