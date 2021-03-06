

import java.util.*;
import java.io.*;
import java.lang.*;

public class TaskB {
    FastScanner in;


    public void solve() {
        String str = in.next();
        int[] answer = prefixFunction(str);
        StringBuilder builder = new StringBuilder();
        builder.append(answer[0]);
        for (int i = 1; i < answer.length; i++) {
            builder.append(" " + answer[i]);
        }
        System.out.println(builder.toString());
    }

    public int[] prefixFunction(String str) {
        int[] p = new int[str.length()];
        p[0] = 0;
        for (int i = 1; i < str.length(); ++i) {
            int j = p[i - 1];
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = p[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                ++j;
            }
            p[i] = j;
        }
        return p;
    }

    public void run() {
//          try {
        in = new FastScanner();
//        in = new FastScanner(new File("input.txt"));
        // out = new PrintWriter(new File("output.txt"));
        solve();

//            out.close();

//        } catch (IOException e) {
//              e.printStackTrace();
//          }
    }


    class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        String str;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {


                try {
                    str = br.readLine();
                    if (str == null) {
                        return "";
                    } else {
                        st = new StringTokenizer(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }


    public static void main(String[] args) {
        new TaskB().run();
    }
}

