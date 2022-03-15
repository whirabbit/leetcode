package medium;

import java.util.*;

/**
 * @Author wrobby
 * @Date 2021/11/28 21:36
 * @Version 1.0
 */
public class 找到字符串中所有字母异位词 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        int length = p.length();
        if (s.length() < length) {
            return list;
        }

        Map<Character, Integer> strings = new HashMap<>(length);
        Map<Character, Integer> diff=new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            strings.put(p.charAt(i), strings.getOrDefault(p.charAt(i), 0)+1);
            diff.put(p.charAt(i),0);
        }

        for (int i=0;i<length;i++){
            if (diff.containsKey(s.charAt(i))){
                diff.put(s.charAt(i),diff.get(s.charAt(i))+1);
            }
        }
        if (macth(strings,diff)){
            list.add(0);
        }

for (int i = 0; i<s.length()- length; i++){
    if (diff.containsKey(s.charAt(i))){
        Integer total = diff.get(s.charAt(i));
        diff.put(s.charAt(i),total>0?total-1:0);
    }
    if (diff.containsKey(s.charAt(i+length))){
        Integer total = diff.get(s.charAt(i+length));
        diff.put(s.charAt(i+length),total+1);
    }
    if (macth(strings,diff)){
        list.add(i+1);
    }
}

        return list;
    }

    private static boolean macth(Map<Character, Integer> a, Map<Character, Integer> b) {
        Set<Character> keySet = a.keySet();
        for (Character character : keySet) {
            if (!b.get(character).equals(a.get(character))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("abab", "ab");
        System.out.println(anagrams);
    }
}
