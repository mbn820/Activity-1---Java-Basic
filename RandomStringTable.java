//-------------------------------------------------------SUMMARY------------------------------------------------------//
//void create(int rowSize, int colSize, int stringLength) - creates a table filled with random strings of the same length
//void display() - prints the table
//int search(String str) - returns the number of occurences of the str on the table
//void edit(int rowIndex, int colIndex, String replacement) - replaces a single value in the table
//void reset() - sets the table value to NULL
//String getElementValue(int rowIndex, int colIndex) - returns the value of the given indices

public class RandomStringTable {
      private String[][] randomTable;
      public final int MAX_SIZE = Integer.MAX_VALUE;//max table size 50 by 50
      public final int MIN_SIZE = 1;//min table size 1 by 1
      //public final int MAX_STR_LENGTH = 10;
      public final int MIN_STR_LENGTH = 1;

      //CONSTRUCTORS
      public RandomStringTable() {

      }

      public RandomStringTable(int rowSize, int colSize, int stringLength) {
          this.create(rowSize, colSize, stringLength);
      }

      //METHODS
      public void create(int rowSize, int colSize, int stringLength) {
          RandomText randText = new RandomText();
          //create a random String table using the nextStringTable method from the RandomText class
          this.randomTable = randText.nextStringTable(rowSize, colSize, stringLength);
      }

      public void display() {
          if(isEmpty()) {
              System.out.println("EMPTY");
              return;
          }
          //print the table using the printArray method from the ArrayPrinter class
          ArrayPrinter arrPrint = new ArrayPrinter();
          arrPrint.printArray(this.randomTable);
      }

      public int count(String str) {
          StringCounter sCounter = new StringCounter();
          int occurences = sCounter.countOccurencesOf(str, this.randomTable);
          return occurences;
      }

      public Integer[][] search(String str) {
          StringCounter sCounter = new StringCounter();
          Integer[][] indices = sCounter.indicesOf(str, this.randomTable);
          return indices;
      }

      public void edit(int rowIndex, int colIndex, String replacement) {
          this.randomTable[rowIndex][colIndex] = replacement;
      }

      public void reset() {
          this.randomTable = null;
      }

      public String getElementValue(int rowIndex, int colIndex) {
          return this.randomTable[rowIndex][colIndex];
      }

      //PROPERTIES
      public boolean isEmpty() {
          if(this.randomTable == null) return true;
          return false;
      }

      public int rowSize() {
          if(isEmpty()) return 0;
          return this.randomTable.length;
      }

      public int colSize() {
          if(isEmpty()) return 0;
          return this.randomTable[0].length;
      }

      public int stringLength() {
          if(isEmpty()) return 0;
          return this.randomTable[0][0].length();
      }

      public int maxRowIndex() {
          if(isEmpty()) return 0;
          return rowSize() - 1;
      }

      public int maxColIndex() {
          if(isEmpty()) return 0;
          return colSize() - 1;
      }

}//endClass
