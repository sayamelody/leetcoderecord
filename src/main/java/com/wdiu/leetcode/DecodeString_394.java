package com.wdiu.leetcode;

import java.util.Stack;

public class DecodeString_394 {
    public static void main(String[] args) {
        System.out.println(new DecodeString_394().decodeString("3[a2[c]]"));
    }

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                strStack.push(sb);
                sb = new StringBuilder();
                numStack.push(num);
                num = 0;
            } else if (ch == ']') {
                int repeatTimes = numStack.pop();
                StringBuilder temp = sb;
                sb = strStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    sb.append(temp.toString());
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
