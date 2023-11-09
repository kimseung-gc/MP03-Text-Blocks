package MP03;

/**
 * Vertically flipped class for Textblocks
 * 
 * @author Seunghyeon (Hyeon) Kim
 * @version 1 of Sept. 2023
 */

public class VerticallyFlipped implements TextBlock{
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) 
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Saves the original input TextBlock.
   */
  TextBlock inp;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * @pre 0 < inp.width() < _max
   */

  public VerticallyFlipped(TextBlock _inp){
    this.inp = (_inp == null) ? new TextLine(null): _inp;
  } // VerticallyFlipped(TextBlock)

  /**
   * Build a new TextBlock vertically flipped
   * 
   * @pre 0 ≤ i < this.centered.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception{
    /* Catch errors for invalid index */
    if(i >= this.inp.height() || i < 0){
      throw new Exception("Invalid row " + i);
    } else{
      /* Under normal cases */
      /* return the reverse row order. */
      return this.inp.row(this.inp.height()-1-i);
    } // if/else
  } // row(int)
  /**
   * Determine how many columns are in the block.
   * @post the function returns the wdith of the centered textBlock
   */
  public int width(){
    return this.inp.width();
  } // width()
  /**
   * Determine how many rows are in the block.
   * @post the function returns the height of the centered textBlock
   */
  public int height(){
    return this.inp.height();
  } // height()

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
} // class VerticallyFlipped
