import MP03.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TextBlockTests {
  @Test
  /* This method exists for testing the equality functions in TBUtils */
  public void testTBUtilsEqual(){
    TextBlock sample0 = new TextLine("");
    TextBlock sampleEq0 = new TextLine("");
    /* Empty String Case */
    assertTrue("Empty String Case equal()", TBUtils.equal(sample0, sampleEq0));
    assertTrue("Empty String Case eq()", TBUtils.eq(sample0, sample0));
    assertTrue("Empty String Case eqv()", TBUtils.eqv(sample0, sampleEq0));
    /* HComposition Equivalency Case */
    TextBlock HComp1 = new HComposition(sample0, sampleEq0);
    HComposition HComp1P = new HComposition(new TextLine("  "), new TextLine("Hello"));
    TextBlock sampleEq1 = new TextLine("");
    assertTrue("Empty String Composition Equivalency Case (equal contents)", TBUtils.equal(HComp1, sampleEq1));
    assertTrue("Empty String Composition Equivalency Case (equal address)", TBUtils.eq(HComp1, HComp1));
    assertTrue("Empty String Composition Equivalency Case (equal type, equal address)", TBUtils.eqv(HComp1, HComp1));
    assertTrue("Empty String Composition Equivalency Case (equal type)", TBUtils.eqv(HComp1, HComp1P));
    assertFalse("Empty String Composition Non-Equivalency Case (Not equal address)", TBUtils.eq(HComp1, sampleEq1));
    assertFalse("Empty String Composition Non-Equivalency Case (Not equal contents)", TBUtils.equal(HComp1, HComp1P));
    /* Though same text block, different types, HComposition and TextLine */
    assertFalse("Empty String Composition Non-Equivalency Case (Not equal type)", TBUtils.eqv(HComp1, sampleEq1));
    /* Note that the equality methods in all the TextBlock methods are based on the equality methods in
     * TBUtils class. Thus, validity of TBUtils' equality methods prove that equality methods in other
     * TextBlock classes are valid.
     */
  } // testTBUtilsEqual()
  
  @Test
  /* This method exists for testing the DiagonalizedFlip class */
  public void testDiagonalizedFlip(){
    /* Normal Case */
    TextBlock sample0 = new TextLine("Hello");
    TextBlock test0 = new DiagonalizedFlip(sample0);
    TextBlock sampleEq0 = new TextLine("olleH");
    assertTrue("Normal Case", test0.equal(sampleEq0));
    /* Vertically Composed Case */
    TextBlock testest1 = new DiagonalizedFlip(new VComposition(new TextLine("Hello"), new TextLine("World!")));
    TextBlock sampleEq1 = new VComposition(new TextLine("!dlroW"), new TextLine(" olleH"));
    assertTrue("Vertically Composed Case", testest1.equal(sampleEq1));
    /* Empty String Case */
    TextBlock sample2 = new TextLine("");
    TextBlock testest2 = new Centered(sample2, 20);
    TextBlock sampleEq2 = new TextLine("                    ");
    assertTrue("Empty String Case", testest2.equal(sampleEq2));
    /* null Pointer Case */
    TextBlock sample3 = new TextLine(null);
    TextBlock testest3 = new DiagonalizedFlip(sample3);
    TextBlock sampleEq3 = new TextLine("");
    assertTrue("null Pointer Case", testest3.equal(sampleEq3));
    /* Horizontally Composed Case */
    TextBlock sample4 = new HComposition(new TextLine("Life "), new TextLine("is awesome"));
    TextBlock testest4 = new DiagonalizedFlip(sample4);
    TextBlock sampleEq4 = new TextLine("emosewa si efiL");
    assertTrue("Horizontally Composed Case", testest4.equal(sampleEq4));
  }// testDiagonalizedFlip()

  @Test
  /* This method exists for testing the HorizontallyFlipped Class */
  public void testHorizontallyFlipped(){
    /* Normal Case */
    TextBlock sample0 = new TextLine("Hello");
    TextBlock test0 = new HorizontallyFlipped(sample0);
    TextBlock sampleEq0 = new TextLine("olleH");
    assertTrue("Normal Case", test0.equal(sampleEq0));
    /* Vertically Composed Case */
    TextBlock test1 = new HorizontallyFlipped(new VComposition(new TextLine("Hello"), new TextLine("World!")));
    TextBlock sampleEq1 = new VComposition(new TextLine(" olleH"), new TextLine("!dlroW"));
    assertTrue("Vertically Composed Case", test1.equal(sampleEq1));
    /* Empty String Case */
    TextBlock sample2 = new TextLine("");
    TextBlock test2 = new HorizontallyFlipped(sample2);
    TextBlock sampleEq2 = new TextLine("");
    assertTrue("Empty String Case", test2.equal(sampleEq2));
    /* null Pointer Case */
    TextBlock sample3 = new TextLine(null);
    TextBlock test3 = new HorizontallyFlipped(sample3);
    TextBlock sampleEq3 = new TextLine("");
    assertTrue("null Pointer Case", test3.equal(sampleEq3));
    /* Horizontally Composed Case */
    TextBlock sample4 = new HComposition(new TextLine("Life "), new TextLine("is awesome"));
    TextBlock test4 = new HorizontallyFlipped(sample4);
    TextBlock sampleEq4 = new TextLine("emosewa si efiL");
    assertTrue("Horizontally Composed Case", test4.equal(sampleEq4));
  } // testHorizontallyFlipped()

  @Test
  /* This method exists for testing the VerticallyFlipped Class */
  public void testVerticallyFlipped(){
    /* Normal Case */
    TextBlock sample0 = new TextLine("Hello");
    TextBlock test0 = new VerticallyFlipped(sample0);
    TextBlock sampleEq0 = new TextLine("Hello");
    assertTrue("Normal Case", test0.equal(sampleEq0));
    /* Vertically Composed Case */
    TextBlock test1 = new VerticallyFlipped(new VComposition(new TextLine("Hello"), new TextLine("World!")));
    TextBlock sampleEq1 = new VComposition(new TextLine("World!"), new TextLine("Hello"));
    assertTrue("Vertically Composed Case", test1.equal(sampleEq1));
    /* Empty String Case */
    TextBlock sample2 = new TextLine("");
    TextBlock test2 = new VerticallyFlipped(sample2);
    TextBlock sampleEq2 = new TextLine("");
    assertTrue("Empty String Case", test2.equal(sampleEq2));
    /* null Pointer Case */
    TextBlock sample3 = new TextLine(null);
    TextBlock test3 = new VerticallyFlipped(sample3);
    TextBlock sampleEq3 = new TextLine("");
    assertTrue("null Pointer Case", test3.equal(sampleEq3));
    /* Horizontally Composed Case */
    TextBlock sample4 = new HComposition(new TextLine("Life "), new TextLine("is awesome"));
    TextBlock test4 = new VerticallyFlipped(sample4);
    TextBlock sampleEq4 = new TextLine("Life is awesome");
    assertTrue("Horizontally Composed Case", test4.equal(sampleEq4));
  } // testVerticallyFlipped()

  @Test
  /* This method exists for testing the RightJustified class */
  public void testRightJustified(){
    /* Normal Case */
    TextBlock sample0 = new TextLine("Hello");
    TextBlock test0 = new RightJustified(sample0, 20);
    TextBlock sampleEq0 = new TextLine("               Hello");
    assertTrue("Normal Case", test0.equal(sampleEq0));
    /* Vertically Composed Case */
    TextBlock sample1 = new VComposition(new TextLine("Hello"), new TextLine("World!"));
    TextBlock test1 = new RightJustified(sample1, 20);
    TextBlock sampleEq1 = new VComposition(new TextLine("              Hello "), new TextLine("              World!"));
    assertTrue("Vertically Composed Case", test1.equal(sampleEq1));
    /* Empty String Case */
    TextBlock sample2 = new TextLine("");
    TextBlock test2 = new RightJustified(sample2, 20);
    TextBlock sampleEq2 = new TextLine("                    ");
    assertTrue("Empty String Case", test2.equal(sampleEq2));
    /* null Pointer Case */
    TextBlock sample3 = new TextLine(null);
    TextBlock test3 = new RightJustified(sample3, 20);
    TextBlock sampleEq3 = new TextLine("                    ");
    assertTrue("null Pointer Case", test3.equal(sampleEq3));
    /* Horizontally Composed Case */
    TextBlock sample4 = new HComposition(new TextLine("Life "), new TextLine("is awesome"));
    TextBlock test4 = new RightJustified(sample4, 20);
    TextBlock sampleEq4 = new TextLine("     Life is awesome");
    assertTrue("Horizontally Composed Case", test4.equal(sampleEq4));
    /* Big Max */
    TextBlock sample5 = new TextLine("Life is awesome");
    TextBlock test5 = new RightJustified(sample5, 100);
    String expectedBuff = "";
    for(int i = 0; i < (100-sample5.width());i++){
      expectedBuff += " ";
    } // for
    TextBlock sampleEq5 = new TextLine(
      expectedBuff
      +"Life is awesome");
    assertTrue("Huge Maximum Value", test5.equal(sampleEq5));
    /* Invalid Max */
    TextBlock sample6 = new TextLine("Life is awesome");
    TextBlock test6 = new RightJustified(sample6, -1);
    boolean rightJustificationFailed = false;
    /* Due to invalid input, truncated class will fail, 
     * so falls into the catch phrase 
     */
    try{
      for(int i = 0; i < test6.width(); i++){
        test6.row(i);
      } // for
    }catch(Exception e){
      rightJustificationFailed = true; // When failed, the truncation failure is reported as true.
    } // try/catch
    System.out.println(rightJustificationFailed);
    assertTrue("Invalid input sample", rightJustificationFailed);
  } // testRightJustified()

  @Test
  /* This method exists for testing the Truncated class */
  public void testTruncated(){
    /* Normal Case */
    TextBlock sample0 = new TextLine("Hello World!");
    TextBlock test0 = new Truncated(sample0, 5);
    TextBlock sampleEq0 = new TextLine("Hello");
    assertTrue("Normal Case", test0.equal(sampleEq0));
    /* Vertically Composed Case */
    TextBlock sample1 = new VComposition(new TextLine("Hello"), new TextLine("World!"));
    TextBlock test1 = new Truncated(sample1, 3);
    TextBlock sampleEq1 = new VComposition(new TextLine("Hel"), new TextLine("Wor"));
    assertTrue("Vertically Composed Case", test1.equal(sampleEq1));
    /* Empty String Case */
    TextBlock sample2 = new TextLine("");
    TextBlock test2 = new Truncated(sample2, 20);
    TextBlock sampleEq2 = new TextLine("");
    assertTrue("Empty String Case", test2.equal(sampleEq2));
    /* null Pointer Case */
    TextBlock sample3 = new TextLine(null);
    TextBlock test3 = new Truncated(sample3, 20);
    TextBlock sampleEq3 = new TextLine("");
    assertTrue("null Pointer Case", test3.equal(sampleEq3));
    /* Horizontally Composed Case */
    TextBlock sample4 = new HComposition(new TextLine("Life "), new TextLine("is awesome"));
    TextBlock test4 = new Truncated(sample4, 11);
    TextBlock sampleEq4 = new TextLine("Life is awe");
    assertTrue("Horizontally Composed Case", test4.equal(sampleEq4));
    /* Big Max */
    TextBlock sample5 = new TextLine("Life is awesome");
    TextBlock test5 = new Truncated(sample5, 100);
    TextBlock sampleEq5 = new TextLine("Life is awesome");
    assertTrue("Huge Maximum Value", test5.equal(sampleEq5));
    /* Invalid Max */
    TextBlock sample6 = new TextLine("Life is awesome");
    TextBlock test6 = new Truncated(sample6, -1);
    boolean truncFailed = false;
    /* Due to invalid input, truncated class will fail, 
     * so falls into the catch phrase 
     */
    try{
      for(int i = 0; i < test6.height(); i++){
        test6.row(i);
      } // for
    }catch(Exception e){
      truncFailed = true; // When failed, the truncation failure is reported as true.
    } // try/catch
    System.out.println(truncFailed);
    assertTrue("Invalid input sample", truncFailed);
    /* Same max length as teh string */
    TextBlock sample7 = new TextLine("Life is awesome");
    TextBlock test7 = new Truncated(sample7, 15);
    TextBlock sampleEq7 = new TextLine("Life is awesome");
    assertTrue("Huge Maximum Value", test7.equal(sampleEq7));
  } // testTruncated()

  @Test
  /* This method exists for testing the Centered class */
  public void testCentered(){
    /* Normal Case */
    TextBlock sample0 = new TextLine("Hello");
    TextBlock test0 = new Centered(sample0, 20);
    TextBlock sampleEq0 = new TextLine("       Hello        ");
    assertTrue("Normal Case", test0.equal(sampleEq0));
    /* Vertically Composed Case */
    TextBlock sample1 = new VComposition(new TextLine("Hello"), new TextLine("World!"));
    TextBlock test1 = new Centered(sample1, 20);
    TextBlock sampleEq1 = new VComposition(new TextLine("       Hello        "), new TextLine("       World!       "));
    assertTrue("Vertically Composed Case", test1.equal(sampleEq1));
    /* Empty String Case */
    TextBlock sample2 = new TextLine("");
    TextBlock test2 = new Centered(sample2, 20);
    TextBlock sampleEq2 = new TextLine("                    ");
    assertTrue("Empty String Case", test2.equal(sampleEq2));
    /* null Pointer Case */
    TextBlock sample3 = new TextLine(null);
    TextBlock test3 = new Centered(sample3, 20);
    TextBlock sampleEq3 = new TextLine("                    ");
    assertTrue("null Pointer Case", test3.equal(sampleEq3));
    /* Horizontally Composed Case */
    TextBlock sample4 = new HComposition(new TextLine("Life "), new TextLine("is awesome"));
    TextBlock test4 = new Centered(sample4, 20);
    TextBlock sampleEq4 = new TextLine("  Life is awesome   ");
    assertTrue("Horizontally Composed Case", test4.equal(sampleEq4));
    /* Big Max */
    TextBlock sample5 = new TextLine("Life is awesome");
    TextBlock test5 = new Centered(sample5, 100);
    String expectedBuff = "";
    for(int i = 0; i < ((100-sample5.width())/2);i++){
      expectedBuff += " ";
    } // for
    TextBlock sampleEq5 = new TextLine(
      expectedBuff
      +"Life is awesome" + expectedBuff + " ");
    assertTrue("Huge Maximum Value", test5.equal(sampleEq5));
    /* Max smaller than the input box */
    TextBlock sample6 = new HComposition(new TextLine("Life "), new TextLine("is awesome"));
    TextBlock test6 = new Centered(sample6, 2);
    TextBlock sampleEq6 = new TextLine("Li");
    assertTrue("Horizontally Composed Case with max smaller than input", test6.equal(sampleEq6));
  } // testCentered()

  @Test
  /* This method exists for testing the Truncated class */
  public void testCombinations(){
    /* Normal Case, Composition of Boxed Sample and Truncated */
    TextBlock sample0 = new TextLine("Hello");
    TextBlock bxdSmpl = new BoxedBlock(sample0);
    TextBlock test0 = new Truncated(bxdSmpl, 5);
    TextBlock[] sampleEq0_compArr = {new TextLine("+----"), new TextLine("|Hell"), new TextLine("+----")};
    try{
      TextBlock sampleEq0 = new VComposition(sampleEq0_compArr);
      assertTrue("Normal Case declaration", true);
      assertTrue("Normal Case", test0.equal(sampleEq0));
    }catch(Exception e){
      assertTrue("Normal Case declaration", false);
    } // try/catch
    TextBlock diagonalizedBlock = new DiagonalizedFlip(bxdSmpl);
    TextBlock test1 = new RightJustified(diagonalizedBlock, 10);
    TextBlock[] sampleEq1_compArr = {new TextLine("   +-----+"), new TextLine("   |olleH|"), new TextLine("   +-----+")};
    boolean varDeclaration = true;
    try{
      TextBlock sampleEq1 = new VComposition(sampleEq1_compArr);
      assertTrue("Normal Case", test1.equal(sampleEq1));
    }catch(Exception e){
      varDeclaration = false;
    } // try/catch
    assertTrue("Normal Case declaration", varDeclaration);
    TextBlock horizontallyFlippedBlock = new HorizontallyFlipped(bxdSmpl);
    TextBlock horizontallyAndVerticallyFlippedBlock = new VerticallyFlipped(horizontallyFlippedBlock);
    TextBlock[] sampleEq2_compArr = {new TextLine("+-----+"), new TextLine("|olleH|"), new TextLine("+-----+")};
    try{
      TextBlock sampleEq1 = new VComposition(sampleEq2_compArr);
      assertTrue("Normal Case", horizontallyAndVerticallyFlippedBlock.equal(sampleEq1));
    }catch(Exception e){
      varDeclaration = false;
    } // try/catch
    /* Normal Case, DiagonalizedFlip = HorizontallyFlipped & VerticallyFlipped = VerticallyFlipped & HorizontallyFlipped */
    TextBlock[] sampleEq3_compArrTot = {new TextLine("+-----+"), new TextLine("|olleH|"), new TextLine("+-----+"), new TextLine("+-----+"), new TextLine("|Hello|"), new TextLine("+-----+")}; 
    TextBlock test3 = new VComposition(horizontallyAndVerticallyFlippedBlock, bxdSmpl);
    try {
      TextBlock sampleEq3 = new VComposition(sampleEq3_compArrTot);
      assertTrue("Normal Case", test3.equal(sampleEq3));
    } catch (Exception e) {
      varDeclaration = false;
    } // try/catch
  } // testCombinations()
} // class TestBlockTests
