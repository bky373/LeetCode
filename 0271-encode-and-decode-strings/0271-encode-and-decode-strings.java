public class Codec {
    private static final String EMPTY = ">EmPty<";
    private static final String DELIMITER = ">>,<<";

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            if (s.isEmpty()) {
                s = EMPTY;
            }
            sb.append(s);
            if (i != strs.size() - 1) {
                sb.append(DELIMITER);
            }
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        return Arrays.stream(s.split(DELIMITER))
                     .map(str -> str.replaceAll(EMPTY, ""))
                     .toList();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));