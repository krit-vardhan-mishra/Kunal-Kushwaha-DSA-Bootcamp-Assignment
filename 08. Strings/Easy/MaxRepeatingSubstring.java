package Strings;

class MaxRepeatingSubstring {

    public static int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder repeat = new StringBuilder(word);
        while (sequence.contains(repeat)) {
            count++;
            repeat.append(word);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc","ba"));
        System.out.println(maxRepeating("ababc","ab"));
        System.out.println(maxRepeating("ababc","ac"));
    }
}
