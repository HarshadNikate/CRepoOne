package temp;

import java.util.Date;

public class EmailWithTimeStamp {

	public static String main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();
		String datestring = date.toString();
	    String dateStringWithoutSpace = datestring.replaceAll(" ", "");
	    String dateStringWithoutSpaceAndColon = dateStringWithoutSpace.replaceAll(":", "");
	    String emailWithTimeStamp = dateStringWithoutSpaceAndColon+"@gmail.com";
	    return emailWithTimeStamp;
	}

}
