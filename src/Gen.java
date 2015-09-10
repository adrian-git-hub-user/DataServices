import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import common.Constants;

public class Gen {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormat.forPattern(Constants.DATE_FORMAT);

		DateTime dt = new DateTime();
		System.out.println("Current datetime : " + dtf.print(dt));

		int minutesInPast = 10;
		DateTime pastDateTime = dt.plus(-(minutesInPast * 1000 * 60));

		System.out.println("datetime in past : " + dtf.print(pastDateTime));

	}

	private DateTime getTimeInPast(int minutesInPast, DateTime dt) {

		return dt.plus(-(minutesInPast * 1000 * 60));

	}

}
