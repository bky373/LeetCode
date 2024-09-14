/**
 * insert
 * - TC: O(n), where n is the length of word.
 * - SC: O(n), where n is the length of word.
 *
 * search
 * - TC: O(n), where n is the length of word.
 * - SC: O(1)
 *
 * startWith
 * - TC: O(n), where n is the length of word.
 * - SC: O(1)
 */
class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = findPrefixNode(word);
        return node != null && node.endOfWord;
    }

    public boolean startsWith(String prefix) {
        return findPrefixNode(prefix) != null;
    }

    private TrieNode findPrefixNode(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return null;
            }
            cur = cur.children[c - 'a'];
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
