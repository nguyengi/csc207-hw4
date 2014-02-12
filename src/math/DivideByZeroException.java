package math;

public class DivideByZeroException
    extends
      Exception
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /*
   * @param String reason
   * @purpose calls super constructor of same param
   */ 
  public DivideByZeroException(String reason){
    super(reason);
  } // DivideByZeroException(String)
  
  /*
   * @purpose calls super constructor of same param
   */
  public DivideByZeroException(){
    super();
  }// DivideByZeroException()
  
  /*
   * @purpose returns customized message
   */
  public String printException(){
    return "Divide by zero!";
  } // printException()
} // class DivideByZeroException