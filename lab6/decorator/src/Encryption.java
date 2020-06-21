public class Encryption {
    private static final String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final int len = letters.length;
    private static String encodeChar(String sign, int step) {
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (sign.equalsIgnoreCase(letters[i])) {
                index = (i + step) % len;
                break;
            }
            if (sign.equals(" ") | sign.equals(",")) {
                return sign;
            }
        }
        return letters[index];
    }
    private static String decodeChar(String sign, int step) {
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (sign.equalsIgnoreCase(letters[i])) {
                index = i - step;
                if (index < 0) {
                    index = len + index;
                }
                break;
            }
            if (sign.equals(" ") | sign.equals(",")) {
                return sign;
            }
        }
        return letters[index];
    }
    public static String encodeMessage(String message, int step) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append(encodeChar(message.substring(i, i + 1), step));
        }
        return sb.toString();
    }
    public static String decodeMessage(String message, int step) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append(decodeChar(message.substring(i, i + 1), step));
        }
        return sb.toString();
    }
}
