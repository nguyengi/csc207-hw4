package math;

public class DivideByZeroException
    extends
      Exception
{
  public DivideByZeroException(String reason){
    super(reason);
  }
  
  public DivideByZeroException(){
    super();
  }
  
  public String printException(){
    return "Divide by zero!";
  }
}
