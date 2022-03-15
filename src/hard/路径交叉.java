package hard;

import java.util.*;

/**
 * 给你一个整数数组 distance 。
 * <p>
 * 从 X-Y 平面上的点(0,0)开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 * <p>
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 *
 *
 * 暴力算法超时,遇见超大数组
 *
 * @Author wrobby
 * @Date 2021/10/29 21:18
 * @Version 1.0
 */
public class 路径交叉 {
    class xy {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            xy xy = (xy) o;
            return x == xy.x && y == xy.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public xy(int x, int y) {
            this.x = x;
            this.y = y;

        }

        public int x = 0;
        public int y = 0;
    }
    Set<xy> list = new LinkedHashSet<>();
    public boolean isSelfCrossing(int[] distance) {
       
        xy x = new xy(0, 0);
        list.add(new xy(0,0));
        int tag = 1;
        for (int i : distance) {

            try {
                add(tag % 4, x, i);
                tag+=1;
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }

    private void add(int tag, xy x, int d) throws Exception {
        if (tag == 1) {
            for (int i = 1; i <= d; i++) {
                boolean add = list.add(new xy(x.x, x.y + i));
                if (!add) {
                    throw new Exception();
                }
            }
            x.y+=d;
        } else if (tag == 2) {
            for (int i = 1; i <= d; i++) {
                boolean add = list.add(new xy(x.x - i, x.y));
                if (!add) {
                    throw new Exception();
                }
            }
            x.x-=d;
        } else if (tag == 3) {
            for (int i = 1; i <= d; i++) {
                boolean add = list.add(new xy(x.x, x.y - i));

                if (!add) {
                    throw new Exception();
                }
            }
            x.y-=d;
        } else {
            for (int i = 1; i <= d; i++) {
                boolean add = list.add(new xy(x.x + i, x.y));
                if (!add) {
                    throw new Exception();
                }
            }
            x.x+=d;
        }
    }

    public static void main(String[] args) {
        路径交叉 u=new 路径交叉();
        System.out.println(u.isSelfCrossing(new int[]{
                2,1,1,2
        }));
    }
}
