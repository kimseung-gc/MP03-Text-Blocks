package MP03;

/**
 * One line of text.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of February 2019
 */
public class TextLine implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The contents of the line.
   */
  String line;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new line with the specified contents.
   */
  public TextLine(String line) {
    /* Exception case when null input */
    this.line = (line == null) ? "": line;
  } // TextLine(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre i == 0
   * @exception Exception if i != 0
   */
  public String row(int i) throws Exception {
    if (i != 0) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid
    return this.line;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return 1;
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.line.length();
  } // width()

  /**
   * Return whether t2 is equal in terms of the rows of this
   * 
   * @pre valid, initiated TextBlock is required.
   */
  public boolean equal(TextBlock t2){
    return TBUtils.equal(this, t2);
  } // equal(TextBlock)

  /**
   * Return whether t2 is equal in terms of the type of this
   * 
   * @pre valid, initiated TextBlock is required.
   */
  public boolean eqv(TextBlock t2){
    return TBUtils.eqv(this, t2);
  } // eqv(TextBlock)

  /**
   * Return whether t2 occupy the same space in memory as this.
   * 
   * @pre valid, initiated TextBlock is required.
   */
  public boolean eq(TextBlock t2){
    return TBUtils.eq(this, t2);
  } // eq(TextBlock)
} // class TextLine
