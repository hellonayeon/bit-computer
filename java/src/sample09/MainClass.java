package sample09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        /*
         * Sorting: 정렬
         *           선택, 버블, 합병, *퀵
         *
         * 1. 몇 개를 정렬하시겠습니까?
         * >> 10
         * 2. 개수에 맞도록 배열 할당
         * >> new int[]
         * 3. 숫자들을 입력 받는다.
         * 4. 정렬 처리
         * 5. 결과 출력
         * */

        int number[] = {4, 3, 5, 2, 1};

        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                if (number[i] > number[j]) {
                    int tmp = number[i];
                    number[i] = number[j];
                    number[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(number));

        /* TODO WORK */
        Scanner sc = new Scanner(System.in);

        System.out.print("정렬 개수: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 입력을 스트림으로 처리 가능 ?
        System.out.print(n + "개의 숫자 입력: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("오름차순 또는 내림차순 입력: ");
        String order = sc.next();
        Comparator<Integer> comparator = (order.equals("오름차순")) ? Comparator.naturalOrder() : Comparator.reverseOrder();

        arr = Arrays.stream(arr).boxed().sorted(comparator).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));


        /* TODO ANSWER */
        int count;
        Integer[] nums;
        boolean updown = false;

        System.out.print("정렬 개수: ");
        count = sc.nextInt();

        nums = new Integer[count];

        int w = 0;
        while (w < count) {
            System.out.print((w + 1) + "번째 수 = ");
            String numStr = sc.next();

            boolean b = true;
            for (int i = 0; i < numStr.length(); i++) {
                int asc = (int) numStr.charAt(i);
                if (asc < 48 || asc > 57) {
                    b = false;
                    break;
                }
            }


            if (!b) {
                System.out.println("숫자만 입력해주세요.");
                continue;
            }

            nums[w] = Integer.parseInt(numStr);
            w++;
        }

        System.out.print("오름(1)/내림(2): ");
        String ud = sc.next();

        if (ud.equals("2")) {
            updown = true;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (updown) {
                    if (nums[i] < nums[j]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
                else {
                    if (nums[i] > nums[j]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
