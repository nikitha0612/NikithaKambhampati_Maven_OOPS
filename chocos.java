package task.Maven_OOPS;

public class chocos extends sweets{
		String fl;
		chocos(int weight, int cost,  int num, String fl)
		{
			super(weight,cost,num);
			this.fl=fl;
		}
		public  String convert() {
			return "Cost = " + this.cost + "Weight = "+ this.weight + "Number = "+ this.num;
			}


	}


