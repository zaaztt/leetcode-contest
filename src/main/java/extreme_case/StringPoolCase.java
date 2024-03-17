package extreme_case;

import org.junit.Test;

public class StringPoolCase {
    @Test
    public void test() {
        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        String s4 = "a" + "b" + "c";
        String s5 = "ab" + "c";
        String s6 = new String("abc");
        System.out.println(s2 == s3);
        System.out.println(s2 == s4);
        System.out.println(s2 == s5);
        System.out.println(s2 == s6);
    }
}
