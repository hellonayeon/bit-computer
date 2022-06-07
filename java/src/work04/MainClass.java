package work04;

public class MainClass {

    static final char[] abcCode ={
            '`','~','!','@','#', '$','%','^','&','*',
            '(',')','-','_','+', '=','|','[',']','{',
            '}',';',':',',','.', '/'
    };

    static final char[] numCode = {'q','w','e','r','t', 'y','u','i','o','p'}; // 1, 2, ~ , 9, 0

    static final String abcStr = new String(abcCode);
    static final String numStr = new String(numCode);

    public static void main(String[] args) {
        String src = "bcd234";

        String dst = encode(src);
        System.out.println(dst);

        String rsrc = decode(dst);
        System.out.println(rsrc);
    }

    private static String encode(String src) {
        String dst = "";

        for (int i=0; i<src.length(); i++) {
            int ch = src.charAt(i);

            // 숫자인 경우
            if (ch >= 48 && ch <= 57) {
                dst += numCode[ch - 48];
            }
            // 문자인 경우 (소문자만 고려)
            else if (ch >= 97 && ch <= 122) {
                dst += abcCode[ch - 97];
            }

        }

        return dst;
    }

    private static String decode(String dst) {
        String src = "";

        for (int i=0; i<dst.length(); i++) {
            char ch = dst.charAt(i);

            int aIdx = abcStr.indexOf(ch);
            if (aIdx == -1) {
                int nIdx = numStr.indexOf(ch);
                src += nIdx;
            }
            else {
                src += (char) (aIdx + 97);
            }
        }

        return src;
    }
}
