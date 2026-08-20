class Solution {
    public int numWaterBottles(int n, int m) {  
    int full = n;  
    int emp = full;
    int dr = full;
    while(emp >=m){
        full = emp /m;
        emp = emp%m;
        dr+=full;
        emp+=full;
    }    
    return dr;  
    }
}