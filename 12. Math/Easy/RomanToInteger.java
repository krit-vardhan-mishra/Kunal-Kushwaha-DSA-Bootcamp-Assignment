public class RomanToInteger {
    public int romanToInt(String s) {
        int integer = 0, prev = 0;

        for(int i = s.length()-1; i >= 0; i--) {
            int val = integerValue(s.charAt(i));

            if(val < prev) integer -= val;
            else integer += val;

            prev = val;
        }
        return integer;
    }

    private int integerValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : return 0;
        }
    }
}
