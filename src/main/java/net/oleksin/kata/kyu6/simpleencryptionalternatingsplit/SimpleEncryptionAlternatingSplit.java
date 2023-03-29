package net.oleksin.kata.kyu6.simpleencryptionalternatingsplit;

public class SimpleEncryptionAlternatingSplit {
    public static String encrypt(final String text, final int n) {
        if (n < 1) {
            return text;
        }
        String answer = text;
        int num = n;
        while (num >= 1) {
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            for (int i = 0; i < answer.length(); i++) {
                if (i % 2 == 0) {
                    even.append(answer.charAt(i));
                } else {
                    odd.append(answer.charAt(i));
                }
            }
            answer = odd.append(even).toString();
            num--;
        }
        return answer;
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (n < 1) {
            return encryptedText;
        }
        String answer = encryptedText;
        int num = n;
        while(num >= 1) {
            String first = answer.substring(0, encryptedText.length() / 2);
            String second = answer.substring(encryptedText.length() / 2);
            StringBuilder stringBuilder = new StringBuilder();
            int firstIndex = 0;
            int secondIndex = 0;
            while (stringBuilder.length() < encryptedText.length()) {
                if (stringBuilder.length() % 2 == 0) {
                    stringBuilder.append(second.charAt(secondIndex++));
                } else {
                    stringBuilder.append(first.charAt(firstIndex++));
                }
            }
            answer = stringBuilder.toString();
            num--;
        }
        return answer;
    }
}
