package MP03;

import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    if (len <= 0){
      return "";
    }
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    if (len <= 0){
      return "";
    }
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /**
   * Return whether the contents of the textblocks are equal.
   * 
   * @pre valid, initiated TextBlock s are required.
   */
  public static boolean equal(TextBlock t1, TextBlock t2){
    try{
      for(int i = 0; i < t1.height(); i++){
        if(!t1.row(i).equals(t2.row(i))){
          return false;
        }
      }
      return true;
    }catch(Exception e){
      return false;
    }
  } // equal(TextBlock, TextBlock)

  /**
   * Return whether the class types of t1 and t2 are equal
   * 
   * @pre valid, initiated TextBlock s are required.
   */
  public static boolean eqv(TextBlock t1, TextBlock t2){
    return (t1.getClass() == t2.getClass());
  } // eqv(TextBlock, TextBlock)

  /**
   * Return whether t1 and t2 occupy the same space in memory.
   * 
   * @pre valid, initiated TextBlock s are required.
   */
  public static boolean eq(Object t1, Object t2){
    return (t1 == t2);
  } // eq(TextBlock, TextBlock)
} // class TBUtils
