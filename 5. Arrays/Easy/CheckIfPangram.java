package Easy;
public class CheckIfPangram {
    public static boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        int[] map = new int[26];

        for (char ch : sentence.toCharArray()) {
            map[ch-'a']++;
        }

        for (int i : map) {
            if(i < 1) return false;
        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }
}
