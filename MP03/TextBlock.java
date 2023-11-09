package MP03;

/**
 * Simple blocks of text for a lab on polymorphism
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of February 2019
 */
public interface TextBlock {
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception;

  /**
   * Determine how many rows are in the block.
   */
  public int height();

  /**
   * Determine how many columns are in the block.
   */
  public int width();

  /**
   * Return whether t2 is equal in terms of the rows of this
   * 
   * @pre valid, initiated TextBlock is required.
   */
  public boolean equal(TextBlock t2);

  /**
   * Return whether t2 is equal in terms of the type of this
   * 
   * @pre valid, initiated TextBlock is required.
   */
  public boolean eqv(TextBlock t2);

  /**
   * Return whether t2 occupy the same space in memory as this.
   * 
   * @pre valid, initiated TextBlock is required.
   */
  public boolean eq(TextBlock t2);
} // interface TextBlock
