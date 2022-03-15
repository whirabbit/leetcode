package hard;

import java.util.regex.Pattern;

/**
 * @Author wrobby
 * @Date 2021/11/10 19:47
 * @Version 1.0
 */
public class 正则表达式匹配 {



    public static boolean isMatch(String s, String p) {
        Match match = new Match(p);
        for (int i = s.length()-1; i>=0; i--) {
            boolean b = match.match(s.charAt(i));
            if (!b) {
                return false;
            }
        }
        while (match.f>=0){
            //p未完,自查
            if (match.f==0){
                match.result=false;
            }

            if (p.charAt(match.f)=='*'){
                match.f-=2;
            }else {
                match.result=false;
            }
        }

MatchB matchB=new MatchB(p);
        for (int i = 0; i < s.length(); i++) {
            boolean b = match.match(s.charAt(i));
            if (!b) {
                return false;
            }
        }
        while (p.length()> match.f){
            //p未完,自查
            if (match.f+1==p.length()){
                return false;
            }

            if (p.charAt(match.f+1)=='*'){
                match.f+=2;
            }else {
                return false;
            }
        }








        return true;
    }


    static class Match {
        int f ;
        int num = 0; //星号计数
        String p;
        boolean result = true;

        public Match(String p) {
            this.p = p;
            f=p.length()-1;
        }
        public boolean match(char ch) {

            if (f <0) {
                //已匹配完
                result = false;
            } else if (f ==0) {
                //最后一个
                if (p.charAt(f) == '.' || p.charAt(f) == ch) {
                    result = true;
                } else {
                    result = false;
                }
                f--;
            } else {
                //中间
                if (p.charAt(f) == '*') {
                    matchA(ch);
                } else if (p.charAt(f) == '.') {
                    matchB();
                    f--;
                }else {
                    result=   (p.charAt(f)==ch);
                    f--;
                }


            }


            return result;
        }

        // *
        private void matchA(char ch) {
            if (p.charAt(f-1) == ch||p.charAt(f-1)=='.') {
                result = true;
            }else {
                f-=2;
              result= match(ch);
            }
        }

        // .
        private void matchB() {
            result = true;
        }
    }

    static class MatchB{
        int f = 0;
        int num = 0; //星号计数
        String p;
        boolean result = true;

        public MatchB(String p) {
            this.p = p;
        }

        public boolean match(char ch) {

            if (f >= p.length()) {
                //已匹配完
                result = false;
            } else if (f + 1 >= p.length()) {
                //最后一个
                if (p.charAt(f) == '.' || p.charAt(f) == ch) {
                    result = true;
                } else {
                    result = false;
                }
                f++;
            } else {
                //中间
                if (p.charAt(f + 1) == '*') {
                    matchA(ch);
                } else if (p.charAt(f) == '.') {
                    matchB();
                    f++;
                }else {
                    result=   (p.charAt(f)==ch);
                    f++;
                }


            }


            return result;
        }

        // *
        private void matchA(char ch) {
            if (p.charAt(f) == ch||p.charAt(f)=='.') {
                result = true;
            }else {
                f+=2;
                result= match(ch);
            }
        }

        // .
        private void matchB() {
            result = true;
        }
    }

    public static void main(String[] args) {
        /**
         *
         * aaaab
         * a*aaab
         */
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(Pattern.matches("ab*a*c*a","aaa"));

    }
}
