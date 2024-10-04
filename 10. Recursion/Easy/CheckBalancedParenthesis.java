package Recursion.Easy;

class CheckBalancedParenthesis {

  // By Looping
  public static boolean check(String str) {
    if (str.length() == 0)
      return true;

    if (str.length() == 1)
      return false;

    char[] exp = str.toCharArray();

    if (exp[0] == ']' || exp[0] == '}' || exp[0] == ')')
      return false;

    int openCurly = 0, openParen = 0, openSquare = 0;
    for (int i = 0; i < exp.length; i++) {
      switch (exp[i]) {
        case '(':
          openParen++;
          break;
        case ')':
          if (openParen == 0)
            return false;
          openParen--;
          break;
        case '{':
          openCurly++;
          break;
        case '}':
          if (openCurly == 0)
            return false;
          openCurly--;
          break;
        case '[':
          openSquare++;
          break;
        case ']':
          if (openSquare == 0)
            return false;
          openSquare--;
          break;
      }
    }
    return openCurly == 0 && openSquare == 0 && openParen == 0;
  }

  // By Recursion
  // public static boolean check(String str) {
  //   if (str.length() == 0)
  //     return true;

  //   if (str.length() == 1)
  //     return false;

  //   char[] exp = str.toCharArray();

  //   if (exp[0] == ']' || exp[0] == '}' || exp[0] == ')')
  //     return false;

  //   return checkHelper(exp, 0, 0, 0, 0);
  // }

  // private static boolean checkHelper(char[] exp, int index, int openParen, int openCurly, int openSquare) {
  //   if (index == exp.length) {
  //     return openParen == 0 && openCurly == 0 && openSquare == 0;
  //   }

  //   char ch = exp[index];

  //   switch (ch) {
  //     case '(':
  //       return checkHelper(exp, index + 1, openParen + 1, openCurly, openSquare);
  //     case ')':
  //       if (openParen == 0)
  //         return false;
  //       return checkHelper(exp, index + 1, openParen - 1, openCurly, openSquare);
  //     case '{':
  //       return checkHelper(exp, index + 1, openParen, openCurly + 1, openSquare);
  //     case '}':
  //       if (openCurly == 0)
  //         return false;
  //       return checkHelper(exp, index + 1, openParen, openCurly - 1, openSquare);
  //     case '[':
  //       return checkHelper(exp, index + 1, openParen, openCurly, openSquare + 1);
  //     case ']':
  //       if (openSquare == 0)
  //         return false;
  //       return checkHelper(exp, index + 1, openParen, openCurly, openSquare - 1);
  //     default:
  //       return checkHelper(exp, index + 1, openParen, openCurly, openSquare);
  //   }
  // }

  public static void main(String[] args) {
    String exp = "[()]{}{[()()]()}";
    System.out.println(check(exp) ? "Balanced" : "Unbalanced");
  }
}
