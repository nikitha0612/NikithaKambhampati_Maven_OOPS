package task.Maven_OOPS;
import java.util.Comparator;
public class chocos_sort implements Comparator<chocos> {
	int x;
	chocos_sort(int a){
		this.x = a;
	}
	
	public int compare(chocos m, chocos n) {
		// TODO Auto-generated method stub
		switch(x) {
		case 1:
			return m.cost-n.cost;
		case 2:
			return m.weight-n.weight;
		case 3:
			return m.num-n.num;

		}
		return 0;
	}

}
