public class Design_Add_Search_Words_Data_Structure {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    }

    static class WordDictionary {

        class Node {
            char c;
            Node[] children;
            boolean endOfWord;

            public Node(char c) {
                this.c = c;
            }
        }

        Node root;

        public WordDictionary() {
            root = new Node((char) 0);
        }

        public void addWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children == null)
                    curr.children = new Node[26];
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new Node(c);
                curr = curr.children[c - 'a'];
            }
            curr.endOfWord = true;
        }

        private boolean search(String word, Node curr, int index) {
            if (index == word.length())
                return curr.endOfWord;
            if (curr.children == null)
                return false;
            char c = word.charAt(index);
            if (c == '.') {
                for (Node n : curr.children)
                    if (n != null && search(word, n, index + 1))
                        return true;
                return false;
            }
            if (curr.children[c - 'a'] == null)
                return false;
            return search(word, curr.children[c - 'a'], index + 1);
        }

        public boolean search(String word) {
            return search(word, root, 0);
        }
    }
}
