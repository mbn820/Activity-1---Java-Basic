import java.util.*;

public class ConsoleInputHandler {
	private static Scanner scan = new Scanner(System.in);
	public static final String DEFAULT_ERROR_MESSAGE = "Invalid Input";
	public static final String DEFAULT_MESSAGE = "";

	public String getAnyString(String message) {
		System.out.print(message);
		String input = scan.nextLine();
		return input;
	}

	public String getDesiredString(String message, String...desiredInput, String errorMessage) {
		ArrayList<String> desiredValues = new ArrayList<String>(Arrays.asList(desiredInput));
		String correctInput;

		do {
			correctInput = getString(message);
			if(!desiredValues.contains(correctInput)) System.out.println(errorMessage)
		}
		while(!desiredValues.contains(correctInput));

		return correctInput;
	}

	//no error message passed
	public String getDesiredString(String message, String...desiredInput) {
		getString(message, desiredInput, DEFAULT_ERROR_MESSAGE);
	}

	//any integer
	public int getAnyInteger(String message, String errorMessage) {
		String input;

		do {
			input = getString(message);
			if(!isInteger(input)) System.err.println(errorMessage);
		}
		while(!isInteger(input));

		int correctInput = Integer.parseInt(input);
		return correctInput;
	}

	//no error message passed
	public int getAnyInteger(String message) {
		return getAnyInteger(message, DEFAULT_ERROR_MESSAGE);
	}

	//desired minimum and maximum input
	public int getIntegerBetween(String message, int desiredMin, int desiredMax, String errorMessageMin, String errorMessageMax) {
		int input;

		do {
			input = getInteger(message);
			if(input < desiredMin) System.err.println(errorMessageMin);
			if(input > desiredMax) System.err.println(errorMessageMax);
		}
		while(input < desiredMin || input > desiredMax);

		return input;
	}

	public int getIntegerFrom

	//no error message passed
	public int getIntegerBetween(String message, int desiredMin, int desiredMax) {
		return getIntegerBetween(message, desiredMin, desiredMax, DEFAULT_ERROR_MESSAGE, DEFAULT_ERROR_MESSAGE);
	}

	public boolean isInteger(String str) {
		try {
			int test = Integer.parseInt(str);
		}
		catch(Exception e) {
			return false;
		}

		return true;
	}




}//endClass
