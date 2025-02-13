package exercise;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class ParameterizeObject {

	class DateRange{
		private Date mulai;
		private Date stop;

		public DateRange(Date mulai, Date stop){
			this.mulai = mulai;
			this.stop = stop;
		}

		public boolean isWithinRange(Date date){
			return(date.compareTo(mulai) >= 0) && (date.compareTo(stop) <= 0);
		
	}}

	class Account{
		private Vector<Transaction> transactions = new Vector<>();

		public Account(){
			transactions.add(new Transaction(1000, new Date(1000)));
			transactions.add(new Transaction(1200, new Date(1100)));
			transactions.add(new Transaction(1500, new Date(1200)));
			transactions.add(new Transaction(1300, new Date(1300)));
		}

		public double getFlowBetween(DateRange dateRange){
			double totalFlow = 0;
			Enumeration<Transaction> elements = transactions.elements();
			while(elements.hasMoreElements()){
				Transaction currentTransaction = elements.nextElement();
				if(dateRange.isWithinRange(currentTransaction.getDate())){
					totalFlow += currentTransaction.getValue();
				}
			}
			return totalFlow;
		}
	}
	
	class Transaction {
		private Date chargeDate;
		private double value;

		public Transaction(double value, Date chargeDate) {
			this.value = value;
			this.chargeDate = chargeDate;
		}

		public Date getDate() {
			return chargeDate;
		}

		public double getValue() {
			return value;
		}
	}

	private void test() {
		Account account = new Account();
		DateRange range = new DateRange(new Date(1050), new Date(1250));
		double flow = account.getFlowBetween(range);
		System.out.println("Total Flow: " + flow);
	}

	public static void main(String[] args) {
		ParameterizeObject program = new ParameterizeObject();
		program.test();
	}
}
