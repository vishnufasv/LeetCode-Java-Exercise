package javaPrograms;


import java.util.*;

public class Isvaild {

//public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = Map.of(')', '(', '}', '{', ']', '[');

        for (char c : s.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                // Check if stack is not empty and the top matches the corresponding open bracket
                if (!stack.isEmpty() && stack.peek() == bracketMap.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                // Push open brackets onto the stack
                stack.push(c);
            }
        }

        // If stack is empty, all brackets were matched
        return stack.isEmpty();
    }

    public static void main(String[] args) 
    {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));       // true
        System.out.println(solution.isValid("()[]{}"));   // true
        System.out.println(solution.isValid("(]"));       // false
        System.out.println(solution.isValid("([])"));     // true
        System.out.println(solution.isValid("([)]"));     // false
        System.out.println(solution.isValid("{[]}"));     // true
    }
}
