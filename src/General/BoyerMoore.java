package General;


//    @Override
//    public boolean findPattern(String toSearchString, String pattern) {
//        return false;
//        //todo implement
//    }


public class BoyerMoore implements ISearchAlgorithm {
    private static int[] makeOffsetTable(char[] pattern) {
        int[] table = new int[pattern.length];
        int lastPrefixPosition = pattern.length;

        for (int i = pattern.length - 1; i >= 0; --i) {
            if (isPrefix(pattern, i + 1)) {
                lastPrefixPosition = i + 1;
            }
            table[pattern.length - 1 - i] = lastPrefixPosition - i + pattern.length - 1;
        }

        for (int i = 0; i < pattern.length - 1; ++i) {
            int suffixLength = suffixLength(pattern, i);
            table[suffixLength] = pattern.length - 1 - i + suffixLength;
        }

        return table;
    }

    private static boolean isPrefix(char[] pattern, int p) {
        for (int i = p, j = 0; i < pattern.length; ++i, ++j) {
            if (pattern[i] != pattern[j]) {
                return false;
            }
        }
        return true;
    }

    private static int suffixLength(char[] pattern, int p) {
        int length = 0;

        for (int i = p, j = pattern.length - 1; i >= 0 && pattern[i] == pattern[j]; --i, --j) {
            length += 1;
        }

        return length;
    }

    public boolean findPattern(String inputText, String searchPattern) {
        boolean isFound;
        char[] text = inputText.toCharArray();
        char[] pattern = searchPattern.toCharArray();

        int position = search(text, pattern);
        isFound = position != -1;

        return isFound;
    }

    public int search(char[] text, char[] pattern) {
        if (pattern.length == 0) {
            return 0;
        }

        int[] charTable = makeCharTable(pattern);
        int[] offsetTable = makeOffsetTable(pattern);

        for (int i = pattern.length - 1, j; i < text.length; ) {
            for (j = pattern.length - 1; pattern[j] == text[i]; --i, --j) {
                if (j == 0) {
                    return i;
                }
            }
            i += Math.max(offsetTable[pattern.length - 1 - j], charTable[text[i]]);
        }

        return -1;
    }

    private int[] makeCharTable(char[] pattern) {
        final int ALPHABET_SIZE = 256;
        int[] table = new int[ALPHABET_SIZE];

        for (int i = 0; i < table.length; ++i) {
            table[i] = pattern.length;
        }

        for (int i = 0; i < pattern.length - 1; ++i) {
            table[pattern[i]] = pattern.length - 1 - i;
        }

        return table;
    }
}

