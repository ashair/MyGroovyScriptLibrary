import com.eviware.soapui.model.testsuite.TestStepResult.TestStepStatus;
import java.util.regex.Pattern;
import java.util.regex.Matcher; 


Pattern myRegularExpression = ~'\\w{10}'; //Create regular expression to compare to testcase property
String myProperty = testRunner.testCase.getPropertyValue("MyProperty"); // get testcaseproperty
myTestStepResult = testRunner.runTestStepByName("CheckSdcAuthorisation[8.2]"); //allow testRunner object to run teststep
myStatus = myTestStepResult.status; // def teststep status 
boolean result = myProperty.matches(myRegularExpression); //assert that string property contain the regular expression
if(result == true)
{
	statusOK = myStatus.OK; //change test step status to OK
}
else
{
	statusFAILED = myStatus.FAILED; //change test step status to failed 
}
log.info(result)
