package medium;

import java.util.*;

/**
 * 0 zero，1 one，2 two，3 three，4 four，
 * 5 five，6 six，7 seven，8 eight，9 nine
 * <p>
 * ，1 one，，3 three，
 * 5 five，7 seven，9 nine
 * <p>
 * ，1 one，，9 nine
 *
 * @Author wrobby
 * @Date 2021/11/25 21:12
 * @Version 1.0
 */
public class 从英文中重建数字 {
    static class Word {
        public Character head;
        public String body;

        public Word(Character head, String body) {
            this.head = head;
            this.body = body;
        }
    }

    /**
     * 先检索 0 - z - zero  2-w-two   4-u-four  6-x-six 8-g-eight
     * 然后3- r-three  5-f-five  7- s-seven
     * 1 -o -one 9 -i-nine
     * 问题:不需要进行删除,只用统计字母个数
     * @param s
     * @return
     */
    public static String originalDigits(String s) {
        int MAX=10;
        Map<Integer, Word> wordMap = new HashMap<>();
        wordMap.put(0, new Word('z', "zero"));
        wordMap.put(2, new Word('w', "two"));
        wordMap.put(4, new Word('u', "four"));
        wordMap.put(6, new Word('x', "six"));
        wordMap.put(8, new Word('g', "eight"));

        wordMap.put(3, new Word('r', "three"));
        wordMap.put(5, new Word('f', "five"));
        wordMap.put(7, new Word('s', "seven"));

        wordMap.put(1, new Word('o', "one"));
        wordMap.put(9, new Word('i', "nine"));
        char[] chars = s.toCharArray();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Integer::compareTo);

        StringBuilder re = new StringBuilder();
        List<Character> sc = new LinkedList<>();
        for (char aChar : chars) {
            sc.add(aChar);
        }
        int i = 0;

        while (sc.size() > 0 && i < MAX) {
            Word word = wordMap.get(i);
            if (sc.contains(word.head)) {
                priorityQueue.add(i);
                remove(sc,word.body);
            } else {
                i += 2;
            }
            if (i==10){
                i=3;
            }

        }
i=1;
        while (s.length() > 0 && i < MAX) {
            Word word = wordMap.get(i);
            if (sc.contains(word.head)) {
                priorityQueue.add(i);
                remove(sc,word.body);
            } else {
                i += 8;
            }
        }


        while (!priorityQueue.isEmpty()) {
            re.append(priorityQueue.poll());
        }
        return re.toString();
    }

    private static void remove(List<Character> sc, String body) {
        char[] chars = body.toCharArray();
        for (char c : chars) {

            sc.remove((Character) c);
        }
    }

    public static void main(String[] args) {
        System.out.println(originalDigits("fviefuro"));

    }
    /**
     * z w u x g
     * r f s
     * o i
     */
    public static String originalDigit(String s) {
        return null;
    }

}
