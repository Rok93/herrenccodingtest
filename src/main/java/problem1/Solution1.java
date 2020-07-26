package problem1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution1 { // 자바8 라이브러리 함수를 활용한 풀이
    private static final String SEPARATION_STANDARD = ",";

    public List<Integer> getReverseSortedNumbers(String inputNumbers) {
        String[] numbers = inputNumbers.split(SEPARATION_STANDARD);
        return Arrays.stream(numbers)
                .map(Integer::new)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();
        String inputNumbers = input.nextLine();

        Solution1 sol = new Solution1();
        List<Integer> answer = sol.getReverseSortedNumbers(inputNumbers);
        System.out.println(answer);
    }
}
