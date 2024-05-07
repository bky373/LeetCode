class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> pairs = Map.of('(', ')', '{', '}', '[', ']');
        
        for (int i=0; i<s.length(); i++) {
            if (pairs.containsKey(s.charAt(i))) {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                if (s.charAt(i) != pairs.get(st.pop())) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}