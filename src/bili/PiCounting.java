package bili;

public class PiCounting {

	public static void main(String[] args) {
		// double pi = pi(100000000);
		// System.out.println(pi);

		long time = System.currentTimeMillis();
		double result = piDomi();
		System.out.println(result);
		long newTime = System.currentTimeMillis();
		System.out.println(newTime - time);
	}

	public static double pi(int n) {
		double pi = 0.0;
		while (n > 0) {
			if (n % 2 == 0) {
				pi -= 1.0 / (2 * n - 1);
			} else {
				pi += 1.0 / (2 * n - 1);
			}
			n--;
		}
		return 4 * pi;
	}

	public static double piDomi() {
		double pi = 0;
		int i = 1;
		double item;

		do {
			item = (i % 2 == 0 ? -1 : 1) * 1.0 / (2 * i - 1);
			pi += item;
			i++;
		} while (Math.abs(item) > 1e-9);
		System.out.println(i);
		return 4 * pi;
	}

}
