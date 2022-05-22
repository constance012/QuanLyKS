package Data;

import java.util.Calendar;
import java.util.Scanner;

public interface Constants {
	int DATE = Calendar.getInstance().get(Calendar.DATE);
	int MONTH = Calendar.getInstance().get(Calendar.MONTH);
	int YEAR = Calendar.getInstance().get(Calendar.YEAR);
	Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
}
