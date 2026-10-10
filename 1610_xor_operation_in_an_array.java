class Solution {
    public int xorOperation(int n, int s) {
        int num =s;
        for(int i=1;i<n;i++){
            int x= s+2 *i;
            num = num^x;
        }
    return num;  
    }
}