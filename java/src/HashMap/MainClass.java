package HashMap;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        /*
         * (java)                                        web (json)
         * HashMap: 사전
         *
         *          사과: apple
         *          key  value   -> 한쌍 (pair)
         *          Tree 구조
         *
         * TreeMap: HashMap + sorting
         *
         * HashMap 과 TreeMap 은 서로 호환 가능
         * */

        HashMap<Integer, String> hMap = new HashMap<>();

        // 추가
        hMap.put(1001, "Tigers");
        hMap.put(1002, "Lions");
        hMap.put(1003, "Twins");

        String value = hMap.get(1002);
        System.out.println(value);

        System.out.println(hMap.size());

        hMap.put(1002, "Giants"); // 키 값은 중복 X, 원래 있던 데이터는 사라져

        // 출력
        // 이터레이터: 반복자 (= 포인터) == cursor (DB 에서 포인터 격)
        Iterator<Integer> it = hMap.keySet().iterator();
        while (it.hasNext()) {
            Integer k = it.next();
            String v = hMap.get(k);
            System.out.println(k + " : " + v);
        }

        // 삭제
        String delValue = hMap.remove(1003);
        System.out.println("삭제 데이터: " + delValue);

        // 검색
        boolean b = hMap.containsKey(delValue);
        System.out.println(b);

        // 수정

//        Map<String, Object> map = new HashMap<>();
        // instance of

        Map<String, String> map = new HashMap<>();

        map.put("apple", "사과");
        map.put("pear", "배");
        map.put("grape", "포도");
        map.put("banana", "바나나");
        map.put("orange", "오렌지");

        Iterator<String> it1 = map.keySet().iterator();
        while (it1.hasNext()) {
            String k = it1.next();
            String v = map.get(k);
            System.out.println("키: " + k + ",  값: " + v);
        }

        // TreeMap (sorting 가능)
        TreeMap<String, String> tMap = new TreeMap<>(map);

        // 오름차순
//        Iterator<String> itKey = tMap.keySet().iterator();

        // 내림차순
        Iterator<String> itKey = tMap.descendingKeySet().iterator();

        while (itKey.hasNext()) {
            String k = itKey.next();
            String v = map.get(k);
            System.out.println("키: " + k + ",  값: " + v);
        }

    }


}
