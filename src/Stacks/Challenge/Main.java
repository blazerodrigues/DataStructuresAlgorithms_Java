package Stacks.Challenge;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String inputString) {

        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder noPunctuationLowerCaseString = new StringBuilder(inputString.length());
        String lowerCaseString = inputString.toLowerCase();

        for(int i=0; i<lowerCaseString.length();i++){
            char c = lowerCaseString.charAt(i);
            if(c>='a' && c<='z'){
                noPunctuationLowerCaseString.append(c);
                stack.push(c);
            }
        }

        StringBuilder reversedString = new StringBuilder(inputString.length());
        while(!stack.isEmpty()){
            reversedString.append(stack.pop());
        }

        return reversedString.toString().equals(noPunctuationLowerCaseString.toString());


    }
}
