package MP03;

/**
 * Centering class for Textblocks
 * 
 * @author Seunghyeon (Hyeon) Kim
 * @version 1 of Sept. 2023
 */

public class Centered implements TextBlock {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) The block will be padded with [(this.max - 
   * this.centered.width())/2] where [x] is the Gaussian integer 
   * function, meaning the number will be rounded down if the length of
   * padding required is rational number. When (this.max - 
   * this.centered.width())%2 == 1, add space at the end of the return.
   * 
   * (2) When the given max is smaller than the width of the text block,
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
   * Build a new TextBlock with centered input
   * 
   * @pre 0 < inp.width() < _max
   */

  public Centered(TextBlock _inp, int _max){
    this.max = _max;
    this.inp = (_inp == null) ? new TextLine(null) : _inp;
  } // Centered(TextBlock, int)

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
    /* Exception for having this.max smaller than this.centered.width() 
     */
    if((this.inp.width() > this.max)){
      return this.inp.row(i);
    } // if
    /* Exception for having this.max being invalid
     */
    if(this.max < 0){
      throw new Exception("Invalid maximum value!");
    } // if
    /* Under normal cases */
    else{
      /* Divide the maximum - this.centered.width() by 2 for padding
       */
      int div2 = (this.max - this.inp.width())/2;
      if((this.max - this.inp.width())%2 == 1){
        return TBUtils.spaces(div2) + this.inp.row(i) + TBUtils.spaces(div2) + " ";
      } // if
      /* Add them with according spaces to adjust centering. */
      return TBUtils.spaces(div2) + this.inp.row(i) + TBUtils.spaces(div2);
    } // if/else
  } // row(int)
  /**
   * Determine how many columns are in the block.
   * @post the function returns the wdith of the centered textBlock
   */
  public int width(){
    return Math.max(this.max, this.inp.width());
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
} // class Centered
