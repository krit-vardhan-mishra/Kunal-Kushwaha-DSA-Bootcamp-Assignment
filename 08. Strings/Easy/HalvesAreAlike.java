package Strings;

class HalvesAreAlike {

    public static boolean halvesAreAlike(String s) {
        int countVol1 = 0, countVol2 = 0;

        int mid = (s.length() + 0) / 2;
        String s1 = s.substring(0, mid).toLowerCase();
        String s2 = s.substring(mid, s.length()).toLowerCase();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'a' || s1.charAt(i) == 'e' || s1.charAt(i) == 'i' || s1.charAt(i) == 'o' || s1.charAt(i) == 'u') {
                countVol1++;
            }
            if (s2.charAt(i) == 'a' || s2.charAt(i) == 'e' || s2.charAt(i) == 'i' || s2.charAt(i) == 'o' || s2.charAt(i) == 'u') {
                countVol2++;
            }
        }

        return countVol1 == countVol2;
    }

    public static void main(String[] args) {
        String s = "bOok";
        System.out.println(halvesAreAlike(s));
    }

}
