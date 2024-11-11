package stack_queue;

import java.util.Stack;

public class SymbolStructureCheck {
    public static void main(String[] args) {
        System.out.println(isCorrectStructure(new Character[]{'(','[',']',')','}'}));
    }

    static boolean isCorrectStructure(Character[] chars) {
        Stack<Character> characters = new Stack<>();

        if (chars.length % 2 != 0) {
            return false;
        }

        for (Character ch: chars) {
            if (ch == '{' || ch == '(' || ch == '[') {
                characters.push(ch);
            } else {
                if (characters.isEmpty()) {
                    return false;
                }
                if (ch == '}' && characters.peek() == '{') {
                    characters.pop();
                } else if (ch == ')' && characters.peek() == '(') {
                    characters.pop();
                } else if (ch == ']' && characters.peek() == '[') {
                    characters.pop();
                } else {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }
}