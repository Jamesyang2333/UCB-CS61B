import java.util.ArrayList;

public class Palindrome {
    public static Deque<Character> wordToDeque(String word){
        Deque<Character> result = new ArrayDeque<>();
        int len = word.length();
        for(int i = 0; i < len; i++){
            result.addLast(word.charAt(i));
        }
        return result;
    }
    public static boolean isPalindrome(String word, CharacterComparator cc){
        int len = word.length();
        if(len == 0 || len == 1)
            return true;
        for(int i = 0; i < len / 2; i++){
            if(word.charAt(i) != word.charAt(len - 1 - i))
                return false;
        }
        return true;
    }
}
