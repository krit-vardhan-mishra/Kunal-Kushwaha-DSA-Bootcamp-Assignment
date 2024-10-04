package Strings;

class FreqAlphabets {

    // public static String freqAlphabets(String s) {
    //     int n = s.length();
    //     StringBuilder sb = new StringBuilder();
    //     for(int i=n-1;i>=0;i--) {
    //         if(s.charAt(i) == '#') {
    //             char st1 = s.charAt(i-1);
    //             char st2 = s.charAt(i-2);
    //             String r = "" + st2 + st1;
    //             int k = Integer.valueOf(r);
    //             char ch = (char)(k + 96);
    //             sb.append(ch);
    //             i -= 2;
    //         } else {
    //             char st = s.charAt(i);
    //             String r = ""+st;
    //             int k = Integer.valueOf(r);
    //             char ch = (char)(k+96);
    //             sb.append(ch);
    //         }
    //     }
    //     sb.reverse();
    //     return sb.toString();
    // }

    public static String freqAlphabets(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i=n-1;i>=0;i--) {
            if (s.charAt(i) == '#') {
                int k = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                sb.append((char)(k + 96));
                i -= 2;
            } else {
                int k = s.charAt(i) - '0';
                sb.append((char)(k + 96));
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "10#11#12";
        System.out.println(freqAlphabets(s));

    }
}
