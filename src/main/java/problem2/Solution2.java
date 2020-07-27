package problem2;

import java.util.Scanner;

public class Solution2 {
    private static final int HANGEUL_BASE = 0xAC00; // '가'
    private static final int HANGEUL_END = 0xD7AF; // '힣'
    private static final int CHOSUNG_BASE = 0x1100; // 'ㄱ'
    private static final int CONSONANT_BASE = 0x3131; // 'ㄱ' 단독으로 입력된 자음
    private static final int VOWEL_BASE = 0x314F; // 'ㅏ' 단독으로 입력된 모음에 대해 적용
    private static final int JOONGSUNG_NUMBER = 21; // 중성 갯수
    private static final int JONGSUNG_NUMBER = 28; // 종성 갯수 (받침)
    public static final int CONSONANT_NUMBER = 30; // 자음 갯수

    public String extractConsonants(String inputString) {
        StringBuilder result = new StringBuilder();

        char[] phonemes = inputString.toCharArray();
        for (char phoneme : phonemes) {
            if (isOnlyVowel(phoneme)) { // 모음만 받을 때
                continue;
            }

            if (isOnlyConsonant(phoneme)) { // 자음만 받을 때
                result.append(phoneme);
                continue;
            }

            if (isOneLetter(phoneme)) { // 한 글자를 받을 때
                char initialPhoneme = extractConsonant(phoneme);
                result.append(initialPhoneme);
                continue;
            }

            result.append(phoneme);
        }
        return result.toString();
    }

    private char extractConsonant(char phoneme) {
        int chosungValue = (phoneme - HANGEUL_BASE) / JOONGSUNG_NUMBER / JONGSUNG_NUMBER;
        return (char) (CHOSUNG_BASE + chosungValue);
    }

    private boolean isOneLetter(char phoneme) {
        return HANGEUL_BASE <= phoneme && phoneme <= HANGEUL_END;
    }

    private boolean isOnlyConsonant(char phoneme) {
        return CONSONANT_BASE <= phoneme && phoneme < CONSONANT_BASE + CONSONANT_NUMBER;
    }

    private boolean isOnlyVowel(char phoneme) {
        return VOWEL_BASE <= phoneme && phoneme < VOWEL_BASE + JOONGSUNG_NUMBER;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();

        Solution2 sol = new Solution2();
        String consonants = sol.extractConsonants(inputString);
        System.out.println(consonants);
    }
}
