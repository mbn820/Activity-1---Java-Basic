import java.util.*;

public class TestMain {


	public static void main(String[] args) {
		StringCounter counter = new StringCounter();
		ArrayPrinter print = new ArrayPrinter();

		String[][] test = {{"aa", "ba", "sa"}, {"ss", "da", "ss"}, {"qq", "ww", "ee"}, {"rr", "ds", "hj"}, {"sd", "dd", "dd"}};
		String[] test2 = {"aa", "ba", "sa", "aa"};

		Integer[] indices = counter.indexOf("a", test2);
		print.printArray(indices);

		System.out.println(counter.countOccurencesOf("a", test2[indices[0]]));

		System.out.println("The string was found in the following indices: ");
		for(int i = 0; i < indices.length; i++) {
			System.out.println("INDEX %d: %d occurences", indices[i], counter.countOccurencesOf("a", test2[indices[i]]));
		}
+





	}



	//Array

    //{{count},{rowIndex, colIndex}}

	//System.out.println();



}
