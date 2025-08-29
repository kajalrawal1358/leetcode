import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if(c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if(c == '(') {
                stk.push(result);
                stk.push(sign);
                result = 0;
                sign = 1; 
            } else if(c == ')') {
                result += sign * number; 
                number = 0; 
                int prevSign = stk.pop(); 
                int prevResult = stk.pop(); 
                result = prevResult + (prevSign * result);
            }
        }

        if(number != 0) {
            result += sign * number;
        }

        return result;
    }
}