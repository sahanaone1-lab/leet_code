class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int start = 0;
        int res = 0;
        for (int i =0;i<s.length();i++){
            int idx = s.charAt(i) - 'a';
            while(freq[idx] >= 2){
                freq[s.charAt(start) - 'a']--;
                start++;

            }
            freq[idx]++;
            res = Math.max(res, i - start +1);
    }
    return res;
}
}