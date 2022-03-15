package medium;

import java.util.PriorityQueue;

/**
 * @Author wrobby
 * @Date 2021/12/24 21:26
 * @Version 1.0
 */
public class 吃苹果的最大数目 {
    static class Apple implements Comparable<Apple> {
        int day;//过期时间
        int num;

        public Apple(int day, int num) {
            this.day = day;
            this.num = num;
        }

        @Override
        public int compareTo(Apple o) {
            return day - o.day;
        }
    }

    public static int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Apple> queue = new PriorityQueue();
        int now_day = 0;
        int res = 0;
        while (now_day <apples.length) {
            queue.add(new Apple( days[now_day]+now_day,apples[now_day]));
            while (!queue.isEmpty()) {
                Apple peek = queue.peek();
                if (peek.day <= now_day || peek.num < 1) {
                    //不可使用
                    queue.poll();
                } else {
                    //吃一个
                    peek.num--;
                    res++;
                    break;
                }
            }
            now_day++;
        }

        if (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                Apple peek = queue.peek();
                if (peek.day <=now_day || peek.num < 1) {
                    //不可使用
                    queue.poll();
                } else {
                    //吃一个
                    peek.num--;
                    res++;
                    now_day++;
                }

            }
        }

        return res;
    }

    /**
     * [1,2,3,5,2]
     * [3,2,1,4,2]
     * @param args
     */
    public static void main(String[] args) {


        System.out.println(eatenApples(
                new int[]{1,2,3,5,2},
                new int[]{3,2,1,4,2}
        ));

    }
}
