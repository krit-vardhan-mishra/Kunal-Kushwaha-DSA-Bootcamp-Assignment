public class HappyNumber {

	public static boolean isHappy(int num) {
		int slow = num;
		int fast = num;

		do {
			slow = findSquare(slow);
			fast = findSquare(findSquare(fast));
		} while(slow != fast);
		
		if(slow == 1) return true;
		else return false;
	}

	private static int findSquare(int number) {
		int ans = 0;
		while(number > 0) {
			int ld = number % 10;
			ans += ld * ld;
			number /= 10;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

}