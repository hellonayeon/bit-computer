package sample04;

public class MainClass {

    public static void main(String[] args) {
        /*
         * Wrapper Class: 일반 자료형을 클래스화 한 것
         *
         * [ Primitive ]		[ Wrapper ]
         * boolean				Boolean
         * byte					Byte
         * short				Short
         * int					Integer		V
         * long					Long
         * float				Float
         * double				Double		V
         * char					Character
         * char[]				String		V
         *
         * */

        int i = 123;
        Integer in = 234;
        Integer cin = new Integer(345);

        System.out.println(cin);

        double d = 123.456;
        Double do1 = 1234.5678;

        System.out.println(do1);


        // 중요시 하는 부분
        // Integer, Double
        // String

        // 문자열 to 숫자
        String str = "1234";
        int num = Integer.parseInt(str);
        System.out.println("num = " + num);

        str = "234.5678";
        double dnum = Double.parseDouble(str); // 바꾸기 전에는 입력 값이 모두 숫자인지 확인하는 코드 필요


        // 숫자 to 문자열
        Integer num1 = 234;
//		String str1 = num1 + "";
        String str1 = num1.toString();

        double do2 = 234.5678;
        String str2 = do2 + "";
        System.out.println("str2 = " + str2);

        // String
        // 문자열의 저장, 편집, 정보취득

        String str3 = "";
//		System.out.println(str3);
        str3 = "안녕하세요";

        String str4 = new String("반갑습니다");
        String str5 = str3 + str4;
        System.out.println(str5);

        str3 = str3.concat(str4);
        System.out.println(str3);


        // equals (비교함수)
        String str6 = "world";
        String str7 = "worl";

        str7 = str7 + "d";

        System.out.println(str6 == str7);
        System.out.println(str6.equals(str7));


        // 문자위치
        // indexOf, lastIndexOf
        // JSON 사용 시 마지막 콤마(,) 지워야 하는 경우 이런 인덱스 관련 함수 사용
        String str8 = "abcabcabc";
        int index = str8.indexOf("c");
        int lindex = str8.lastIndexOf("c");
        System.out.println("index = " + index);
        System.out.println("lindex = " + lindex);


        // 문자열의 길이
        // String length() (func),  array length (element)
        System.out.println(str8.length());


        // replace (수정 함수)
        String str9 = "A*B*C*D";
        String replaceStr = str9.replace("*", "-");
        System.out.println(replaceStr);


        // split (문자열 자르기)
        /*
         * 홍길동-24-2001//03/16-서울시		'-' token
         * 성춘향-16-2011/07/28-남원시
         *
         * 홍길동-24-2001//03/16-23-서울시 (24? 23?)
         * 데이터의 의미를 파악하기 어려워 XML, JSON과 같은 형식 사용
         *
         */

        String str10 = "홍길동-24-2001//03/16-서울시";
        String[] split = str10.split("-");
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[2]);
        System.out.println(split[3]);


        // 문자열을 자르는 함수
        // 이전에는 '토큰'을 기준으로 자르기 **split
        // 이번에는 '범위'를 기준으로 자르기 **substring
        String subStr = str10.substring(4);
        System.out.println(subStr);

        subStr = str10.substring(4, 6);
        System.out.println(subStr);


        // 앞뒤의 공백 제거
        // trim()
        String str11 = "    java java  java            ";
        System.out.println(str11.trim());

        // index 숫자를 입력하면 문자를 리턴
        // charAt
        String str12 = "가나다라마";
        char c = str12.charAt(2);
        System.out.println(c);

        // 문자열 탐색
        // contains
        String str13 = "서울시 마포구 서교동"; // 문자열을 조사할 때 공백 제거하고 contains 하는 경우 有
        boolean b = str13.contains("서교");
        System.out.println(b);
    }

}