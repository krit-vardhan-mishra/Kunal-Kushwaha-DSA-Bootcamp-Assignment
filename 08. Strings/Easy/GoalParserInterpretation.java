package Strings;

class GoalParserInterpretation {
    
    // O(3N)
    // public static String interpret(String cmd) {
    //     String res = new String(cmd.replace("()", "o"));
    //     res = res.replace("(", "");
    //     res = res.replace(")","");
    //     return res;
    // }

    public static String interpret(String cmd) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cmd.length(); i++) {
            if (cmd.charAt(i) == '(') {
                if (i + 1 < cmd.length() && cmd.charAt(i + 1) == ')') {
                    res.append('o');
                    i++;
                }
            } else if (cmd.charAt(i) != ')') {
                res.append(cmd.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String cmd = "(al)G(al)()()G";
        System.out.println(interpret(cmd));
    }

}
