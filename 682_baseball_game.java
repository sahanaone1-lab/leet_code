class Solution {
    public int calPoints(String[] op) {
    int[] total= new int[op.length];
    int j=0;
        for(int i=0;i<op.length;i++){
            if(!op[i].equals("C") && !op[i].equals("D") && !op[i].equals("+")) {
                total[j] = Integer.parseInt(op[i]);
                    j++;
            }
            
            else if(op[i].equals("C")){
                j--;
            }
            else if(op[i].equals("D")){
                total[j] = 2*total[j-1];
                j++;
            }
            else if(op[i].equals("+")){
                total[j] = total[j-1]+total[j-2];
                j++;
            }
        }
        int sum=0;
        for(int i=0;i<j;i++){
            sum +=total[i];
        }
        return sum;
    }
}