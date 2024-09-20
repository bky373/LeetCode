/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 *
 * Approach 1.
 * addWord
 * - TC: O(n), where n is the length of word.
 * - SC: O(n), where n is the length of word.
 *
 * search
 * - TC: O(n*26^d), where n is the length of word and d is the number of dot(.)
 * - SC: O(1)
 */
public class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.subNodes.containsKey(ch)) {
                node.subNodes.put(ch, new Node());
            }
            node = node.subNodes.get(ch);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return helper(root, word);
    }

    public boolean helper(Node node, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.subNodes.containsKey(ch)) {
                if (ch == '.') {
                    for (char x : node.subNodes.keySet()) {
                        Node child = node.subNodes.get(x);
                        if (helper(child, word.substring(i + 1))) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.subNodes.get(ch);
            }
        }
        return node.isEndOfWord;
    }

    private class Node {
        Map<Character, Node> subNodes = new HashMap<>();
        boolean isEndOfWord;
    }

}


/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 *
 * Approach 2.
 * addWord
 * - TC: O(n), where n is the length of word.
 * - SC: O(n), where n is the length of word.
 *
 * search
 * - TC: O(n*26^d), where n is the length of word and d is the number of dot(.)
 * - SC: O(1) for the search of "well-defined" words without dots, and up to O(M) for the "undefined" words, to keep the recursion stack.
 */
public class WordDictionary {
    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int i, Node curr) {
        if (curr == null) {
            return false;
        }
        if (i == word.length()) {
            return curr.isEndOfWord;
        }
        char c = word.charAt(i);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (search(word, i + 1, curr.children[j])) {
                    return true;
                }
            }
            return false;
        }
        return search(word, i + 1, curr.children[c - 'a']);
    }

    private class Node {
        private Node[] children;
        private boolean isEndOfWord;

        public Node() {
            this.children = new Node[26];
        }
    }
}
