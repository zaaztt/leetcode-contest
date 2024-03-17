package leetcode.contest.weekly.week388;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public String[] shortestSubstrings(String[] arr) {
        Set<String>[] substrings = new Set[arr.length];
        String[] results = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            substrings[i] = generateAllSubstrings(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            Set<String> curSet = substrings[i];
            Set<String> comparedSet = new HashSet<>();
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    comparedSet.addAll(substrings[j]);
                }
            }
            String shortestStr = arr[i];
            boolean isFound = false;
            for (String s : curSet) {
                if (comparedSet.contains(s)) {
                    continue;
                } else {
                    isFound = true;
                    if (s.length() < shortestStr.length()) {
                        shortestStr = s;
                    } else if (s.length() == shortestStr.length()) {
                        shortestStr = s.compareTo(shortestStr) < 0 ? s : shortestStr;
                    }
                }
            }
            if (!isFound) {
                shortestStr = "";
            }
            results[i] = shortestStr;

        }
        return results;
    }

    public Set<String> generateAllSubstrings(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder strb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                strb.append(s.charAt(j));
                set.add(strb.toString());
            }
        }
        return set;
    }
}
