package Strings;

class JudgeCircle {

    public static boolean judgeCircle(String moves) {
        int posH = 0, posV = 0;
        for(int i=0;i<moves.length();i++) {
            char ch = moves.charAt(i);
            if (ch == 'U') posV++;
            else if (ch == 'D') posV--;
            else if (ch == 'R') posH++;
            else posH--;
        }
        return posV == 0 && posH == 0;
    }

    public static void main(String[] args) {
        String moves = "RRDD";
        System.out.println(judgeCircle(moves));
    }
}
