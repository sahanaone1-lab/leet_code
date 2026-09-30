class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int c = 0;
        int a[] = new int[seq.length()];
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                c++;
                a[i]= c%2;
            }
            else{
             
                a[i]=c%2;
                   c--;
            }
        }
        return a;
    }
}