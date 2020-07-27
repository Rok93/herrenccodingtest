package problem1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution2 { // 병합 정렬 알고리즘을 직접 구현한 풀이
    private static final String SEPARATION_STANDARD = ",";

    private int[] tempArr;

    public void mergeSortReverseOrder(int[] numbers) {
        int length = numbers.length;
        tempArr = new int[length];

        mergeSortReverseOrder(numbers, 0, length - 1);

        tempArr = numbers;
    }

    private void mergeSortReverseOrder(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }

        int center = (left + right) / 2;

        mergeSortReverseOrder(numbers, left, center);
        mergeSortReverseOrder(numbers, center + 1, right);

        int i;
        int p = 0;
        for (i = left; i <= center; i++) {
            tempArr[p++] = numbers[i];
        }

        int j = 0;
        int k = left;
        while (i <= right && j < p) {
            numbers[k++] = (tempArr[j] >= numbers[i]) ? tempArr[j++] : numbers[i++];
        }

        while (j < p) {
            numbers[k++] = tempArr[j++];
        }
    }


    public void printArray(int[] numbers) {
        String stringNumbers = Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(stringNumbers);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputNumbersLength = Integer.parseInt(input.nextLine());
        String inputNumbers = input.nextLine();

        int[] answer = new int[inputNumbersLength];

        String[] numbers = inputNumbers.split(SEPARATION_STANDARD);

        for (int i = 0; i < inputNumbersLength; i++) {
            answer[i] = Integer.parseInt(numbers[i]);
        }

        Solution2 sol = new Solution2();
        sol.mergeSortReverseOrder(answer);
        sol.printArray(answer);
    }
}
