package Strings;

class CheckOnesSegment {

    public static boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
    
    public static void main(String[] args) {
        String s = "110";
        System.out.println(checkOnesSegment(s));
    }

}
