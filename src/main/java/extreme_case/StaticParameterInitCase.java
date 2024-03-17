package extreme_case;

import org.junit.Test;

public class StaticParameterInitCase {
    public static StaticParameterInitCase staticParameterInitCase = new StaticParameterInitCase();
    public static int i;
    public static int j = 3;
    public StaticParameterInitCase() {
        i++;
        j++;
    }

    @Test
    public void test() {
        // Output of this function is very different from the `main`. I thought it calls `StaticParameterInitCase()` at
        // the before the `sout`.
        System.out.println(i);
        System.out.println(j);
    }

    public static void main(String[] args) {
        System.out.println(i);
        System.out.println(j);
    }
}

