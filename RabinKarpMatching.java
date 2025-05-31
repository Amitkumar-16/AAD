public class RabinKarpMatching {
    static final int d = 256; // Number of characters in the input alphabet
    static final int q = 101; // A prime number for modulo operations

    public static void rabinKarpSearch(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        // The value of h would be "pow(d, m-1) % q"
        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // Calculate initial hash values for pattern and first window of text
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text
        for (int i = 0; i <= n - m; i++) {
            // If hash values match, check characters one by one
            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) break;
                }
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash for next window
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) t = (t + q);
            }
        }
    }

    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";
        rabinKarpSearch(text, pattern); // Output: Pattern found at index 10
    }
}
