import java.util.*;//specify

public class StringCounter {//<-----------change class name to StringUtil
      //String
      public int countOccurencesOf(String text, String target) {
          if(text.length() > target.length()) return 0;

          int numberOfCompares = target.length() - text.length() + 1;
          int count = 0;

          for(int i = 0; i < numberOfCompares; i++) {
              String sub = target.substring(i, i + text.length());
              if(text.equals(sub)) count++;
          }

          return count;
      }

      //Array
      public int countOccurencesOf(String text, String[] targetArray) {
          int count = 0;
          for(String str : targetArray) {
              count += countOccurencesOf(text, str);
          }
          return count;
      }

      //Two Dimensional Array
      public int countOccurencesOf(String text, String[][] targetTable) {
          int count = 0;
          for(String[] arr : targetTable) {
              count += countOccurencesOf(text, arr);
          }
          return count;
      }

     //search indices in a 1 dimensional array
     public Integer[] indicesOf(String text, String[] targetArray) {
          List<Integer> indices = new ArrayList<Integer>();

          for(int i = 0; i < targetArray.length; i++ ) {
              if(targetArray[i].contains(text)) {
                  indices.add(i);
              }
          }
          //convert list to array
          return indices.toArray(new Integer[indices.size()]);
     }

     //search indices in a 2 dimensional array
     public Integer[][] indicesOf(String text, String[][] targetTable) {
         List<Integer[]> indices = new ArrayList<Integer[]>();

         for(int i = 0; i < targetTable.length; i++) {
             Integer[] colIndices = indicesOf(text, targetTable[i]);
             Integer rowIndex = i;
             if(colIndices != null) {
                 for(Integer colIndex : colIndices) {
                     Integer[] pair = {rowIndex, colIndex};
                     indices.add(pair);
                 }
             }
         }

         if(indices.size() == 0) return null;

         return indices.toArray(new Integer[indices.size()][indices.get(0).length]);
     }




}//endClass
