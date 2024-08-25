package string;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
    //PAHNAPLSIIGYIR

    public static String convert(String s, int numRows) {
//        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += numRows + 1) {
                s.charAt(j);
//                str.append(s.charAt(j));
            }
        }

        return "";
//        return str.toString();
    }
}
