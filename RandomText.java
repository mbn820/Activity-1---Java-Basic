//-------------------------------------------------------SUMMARY------------------------------------------------------//
//nextChar();
//nextString(int length);
//nextStringArray(int arrayLength, int stringLength);
//nextStringTable(int rowSize, int colSize, int stringLength);

import java.util.Random;

public class RandomText {
      private static final String ASCII_CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      private static Random rand = new Random();

      public char nextChar() {
          int randomIndex = rand.nextInt(ASCII_CHARACTERS.length());
          char randomChar = ASCII_CHARACTERS.charAt(randomIndex);
          return randomChar;
      }

      /*public char nextChar() {
          Random rand = new Random();
          //32-255 - decimal form of printable ASCII characters
          //int randomAsciiInDecimal = 32 + rand.nextInt(255 - 32);
          int randomAsciiInDecimal = 32 + rand.nextInt(80 - 32);
          char randomAsciiInChar = (char) randomAsciiInDecimal;
          return randomAsciiInChar;
	  }*/

      public String nextString(int length) {
            //create char array
            char[] randomChars = new char[length];
            //fill the char array with random chars using the nextChar() method
            for(int i = 0; i < length; i++) {
                randomChars[i]= nextChar();
            }
            //convert char array to String
            String randomString = new String(randomChars);
            return randomString;
      }

      public String[] nextStringArray(int arrayLength, int stringLength) {
            String[] randomStringArray = new String[arrayLength];
            //fill array with random strings using the nextString() method
            for(int i = 0; i < arrayLength; i++) {
                randomStringArray[i] = nextString(stringLength);
            }
            return randomStringArray;
      }

      public String[][] nextStringTable(int rowSize, int colSize, int stringLength) {
            String[][] randomStringTable = new String[rowSize][colSize];
            //fill the two dimensional array with random string arrays using the nextStringArray() method
            for(int i = 0; i < rowSize; i++) {
                randomStringTable[i] = nextStringArray(colSize, stringLength);
            }
            return randomStringTable;
      }

}//endClass
