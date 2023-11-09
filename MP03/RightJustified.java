package MP03;

/**
 * Right justifying class for Textblocks
 * 
 * @author Seunghyeon (Hyeon) Kim
 * @version 1 of Sept. 2023
 */

public class RightJustified implements TextBlock{
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) When the given max is smaller than the width of the text block,
   * the row function returns the original text block rows
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Saves the original input TextBlock.
   */
  TextBlock inp;
  /**
   * Saves the maximum length of the center adjusted textblock.
   */
  int max;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Build a new TextBlock with right-justified input
   * 
   * @pre 0 < inp.width() < _max
   */

  public RightJustified(TextBlock _inp, int _max){
    this.max = _max;
    this.inp = (_inp == null) ? new TextLine(null): _inp;
  } // RightJustified(TextBlock, int)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * @pre 0 ≤ i < this.centered.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception{
    /* Catch errors for invalid index */
    if(i >= this.inp.height() || i < 0){
      throw new Exception("Invalid row " + i);
    } // if
    /* Exception for having this.max bigger than this.truncated.width() 
     */
    if((this.inp.width() > this.max)){
      return this.inp.row(i);
    } // if
    /* Exception for having this.max being invalid
     */
    if(this.max < 0){
      throw new Exception("Invalid maximum value!");
    } else{
      /* Under normal cases */
      /* return the result with valid spaced buffer */
      return TBUtils.spaces(this.max - this.inp.width()) + this.inp.row(i);
    } // if/else
  } // row(int)
  /**
   * Determine how many columns are in the block.
   * @post the function returns the wdith of the right justified textBlock
   */
  public int width(){   
    return Math.max(this.inp.width(), this.max);
  } // width()
  /**
   * Determine how many rows are in the block.
   * @post the function returns the height of the right justified textBlock
   */
  public int height(){
    return this.inp.height();
  } // row(int)

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
} // class RightJustified
