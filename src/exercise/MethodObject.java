package exercise;

public class MethodObject{

	class Account{
		private static int delta(){
		return 10;
		}

		public int gamma(int inputVal, int quantity, int yearToDate) {
			return new GammaLogic(inputVal, quantity, yearToDate).compute();
		}}

	class GammaLogic{
		private final int inputVal;
		private final int quantity;
		private final int yearToDate;
		private int importantValue1;
		private int importantValue2;
		private int importantValue3;

		public GammaLogic(int inputVal, int quantity, int yearToDate) {
			this.inputVal = inputVal;
			this.quantity = quantity;
			this.yearToDate = yearToDate;
		}

		public int compute(){
			importantValue1 = computeImportantValue1();
			importantValue2 = computeImportantValue2();
			importantValue3 = computeImportantValue3();
			return importantValue3 - 2 * importantValue1;
		}

		private int computeImportantValue1(){
			return (inputVal * quantity) + Account.delta();
		}

		private int computeImportantValue2(){
			int result = (inputVal * yearToDate) + 100;
			if ((yearToDate - importantValue1) > 100) {
				result -= 20;
			}
			return result;
		}

		private int computeImportantValue3(){
			return importantValue2 * 7;
		}
	}
	private void test(){
		Account account = new Account();
		System.out.println(account.gamma(15, 10, 2010));
	}

	public static void main(String[] args){
		MethodObject p = new MethodObject();
		p.test();
	}
}
