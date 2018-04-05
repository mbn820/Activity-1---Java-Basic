public class MainProgram {
	private static RandomStringTable randTable = new RandomStringTable();
	private static ConsoleInputHandler input = new ConsoleInputHandler();
	private static ArrayPrinter printer = new ArrayPrinter();
	private static StringCounter counter = new StringCounter();

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		if(randTable.isEmpty()) {
			showCreateAndExitOnly();
		}
		else {
			showAllOptions();
		}
	}

	private static void createTable() {//display table after creation
		//error messages in case the user enters wrong input
		String errorMsgSize = "Minimum Size: " + randTable.MIN_SIZE + " Maximum Size: " + randTable.MAX_SIZE;
		//String errorMsgString = "Minimum String length: " + randTable.MIN_STR_LENGTH + " Maximum String length: " + randTable.MAX_STR_LENGTH;;

		System.out.println("-------------CREATE TABLE-------------");
		//get user input
		int row = input.getIntegerBetween("Enter number of rows: ", randTable.MIN_SIZE , randTable.MAX_SIZE, errorMsgSize);
		int col = input.getIntegerBetween("Enter number of columns: ", randTable.MIN_SIZE , randTable.MAX_SIZE, errorMsgSize);
		//int strLength = input.getIntegerBetween("Enter String length: ", randTable.MIN_STR_LENGTH, randTable.MAX_STR_LENGTH, errorMsgString);
		//create the table
		randTable.create(row, col, 3);
		//table created message
		System.out.println("\nTable Created!\n");

		randTable.display();

		menu();
	}

	private static void displayTable() {
		System.out.println("-------------DISPLAY TABLE-------------");

		checkIfTableIsEmpty();

		//print some table information
		System.out.println(showTableDetails());
		//print the table
		randTable.display();

		menu();
	}

	private static void editValue() {//display table after edit
		System.out.println("-------------EDIT VALUE-------------");

		checkIfTableIsEmpty();

		String errorMsg = "Invalid index: " + showTableDetails();

		//get user input
		int rowIndex = input.getIntegerBetween("Enter row index: ", 0, randTable.maxRowIndex(), errorMsg);
		int colIndex = input.getIntegerBetween("Enter column index: ", 0, randTable.maxColIndex(), errorMsg);
		String newValue = input.getFixedStringLength("Enter new value: ", 3);
		//save old value before editing for reference
		String oldValue = randTable.getElementValue(rowIndex, colIndex);
		//edit
		randTable.edit(rowIndex, colIndex, newValue);
		//after edit
		randTable.display();
		System.out.printf("\nThe value of table[%d, %d] has been changed from '%s' to '%s'\n\n", rowIndex, colIndex, oldValue, newValue);

		menu();
	}

	private static void resetTable() {
		System.out.println("-------------RESET TABLE-------------");
		//get user input
		String decision = input.getDesiredString("Are you sure? [y/n]: ", "y", "n");
		//process input
		switch(decision.toLowerCase()) {
			case "y" : randTable.reset(); break;
			case "n" : menu();
			default  : menu();
		}

		System.out.println("\nTable has been reset\n");
		menu();
	}

	private static void searchTable() {//display table after search, show indices of occurences
		System.out.println("-------------SEARCH TABLE-------------");

		checkIfTableIsEmpty();
		//get user input
		String query = input.getAnyString("Search for: ");
		//pass the input to the search method from RandomStringTable  class
		int numberOfOccurences = randTable.count(query);
		Integer[][] indices = randTable.search(query);
		//print results
		if(numberOfOccurences == 0) {
			System.out.println("Not Found");
		}
		else {
			System.out.println("Results: ");
			showResultsTable(query, numberOfOccurences, indices);
		}

		menu();
	}

	private static void exit() {
		System.out.println("-------------EXIT-------------");
		String choice = input.getDesiredString("Exit the program? [y/n]: ", "y", "n");

		switch(choice.toLowerCase()) {
			case "y" : System.exit(0);
			case "n" : break;
			default  : menu();
		}

		menu();
	}

	//////////////////////////////////////////////

	private static void emptyTableMessage() {
		System.out.println("\nNo Table found, create one first\n");
	}

	private static String showTableDetails() {
		return String.format("Current SIZE: %d X %d || STRING LENGTH: %d", randTable.rowSize(), randTable.colSize(), randTable.stringLength());
	}

	private static void checkIfTableIsEmpty() {
		if(randTable.isEmpty()) {
			emptyTableMessage();
			menu();
		}
	}

	///////////////////////////////////////////////

	private static void showAllOptions() {
		System.out.println("---OPTIONS---");
		System.out.println("[C]Create New Table");
		System.out.println("[D]Display Table");
		System.out.println("[E]Edit Value");
		System.out.println("[R]Reset");
		System.out.println("[S]Search");
		System.out.println("[X]Exit");
		System.out.println();

		String[] desiredInputs = {"c", "d", "e", "r", "s", "x"};
		//get user input using getDesiredString method from ConsoleInputHandler class
		String choice = input.getDesiredString("ENTER CHOICE: ", desiredInputs);
		//process the input
		switch(choice.toLowerCase()) {
			case "c" : createTable();
			case "d" : displayTable();
			case "e" : editValue();
			case "r" : resetTable();
			case "s" : searchTable();
			case "x" : exit();
			default  : menu();
		}
	}

	private static void showCreateAndExitOnly() {
		System.out.println("---OPTIONS---");
		System.out.println("[C]Create Table");
		System.out.println("[X]Exit");
		System.out.println();

		String[] desiredInputs = {"c", "x"};
		//get user input using getDesiredString method from ConsoleInputHandler class
		String choice = input.getDesiredString("ENTER CHOICE: ", desiredInputs);
		//process the input
		switch(choice.toLowerCase()) {
			case "c" : createTable();
			case "e" : exit();
			default  : menu();
		}
	}

	private static void showResultsTable(String query, int totalOccurences, Integer[][] indices) {

		System.out.println("INDICES\t\t\tVALUE\t\t\tOCCURENCES");
		for(Integer[] pair : indices) {
			int rowIndex = pair[0].intValue();
			int colIndex = pair[1].intValue();
			int occurencesInASingleElement = counter.countOccurencesOf(query, randTable.getElementValue(rowIndex, colIndex));
			System.out.printf("(%d, %d)", rowIndex, colIndex);
			System.out.print("\t\t\t" + randTable.getElementValue(rowIndex, colIndex));
			System.out.println("\t\t\t" + occurencesInASingleElement);
		}
		System.out.println("TOTAL\t: " + totalOccurences + " occurences\n");
	}

}//endClass
