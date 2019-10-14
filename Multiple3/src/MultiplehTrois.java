public class MultiplehTrois {

	public static void main(String[] args) {

		SolMath sm = new SolMath();
		sm.multiple();

	}

}

class SolMath {
	String multiple() {
		int N = 3;
		for (int i = 1; i <= 100; i++) {
			String multiple = (i % N == 0) ? "Multiple !" : String.valueOf(i);
			return multiple;
		}

	}

}
