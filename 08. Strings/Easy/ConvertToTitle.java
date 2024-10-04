package Strings;

class ConvertToTitle {

    public static String convertToTitle(int colNo) {
        StringBuilder res = new StringBuilder();

        while (colNo > 0) {
            colNo--;
            int remainder = colNo % 26;
            res.append((char)(remainder+65));
            colNo /= 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        int colNo = 28;
        System.out.println(convertToTitle(colNo));
    }
}
