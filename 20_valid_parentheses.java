class Solution {
    public boolean isValid(String s) {
    char[] arr = new char[s.length()];
    int top=-1;
    for (char ch : s.toCharArray()) {
       if (ch == '(' || ch == '{' || ch == '[') {
            arr[++top] = ch;
        }else {
            if (top ==-1) return false;
            char prev = arr[top--];

                if ((ch == ')' && prev != '(') ||
                    (ch == '}' && prev != '{') ||
                    (ch == ']' && prev != '[')) {
                    return false;
                }
                  
            }
        }

        return top == -1;
    }
}