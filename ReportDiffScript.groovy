import org.custommonkey.xmlunit.*;

XMLUnit.setIgnoreWhitespace(true)
XMLUnit.setIgnoreComments(true)
XMLUnit.setIgnoreDiffBetweenTextAndCDATA(false)
XMLUnit.setNormalizeWhitespace(true)

def currentStepInd = context.currentStepIndex;
def step1 = testRunner.testCase.getTestStepAt(0);
def step1Name = step1.name;
def step2 = testRunner.testCase.getTestStepAt(currentStepInd - 1);
def step2Name = step2.name;
def request1Xml = context.expand( '${' + step1Name + '#Response}' );
def request2Xml = context.expand( '${' + step2Name + '#Response}' );

Diff diff = new Diff (request1Xml, request2Xml);
DetailedDiff myDiff = new DetailedDiff (diff);

//Create an object for GroovyUtils
def groovyUtils=new  com.eviware.soapui.support.GroovyUtils(context);
// Using the method projectPath you can get the project path which you are working
def projectPath = groovyUtils.projectPath;
def testCaseName = testRunner.testCase.name;
def fileOut = new File (projectPath+'/Reporting'+'/diffOutput'+testCaseName+'.log');
//Convert myDiff to a string to write to a file. It keeps the formating as far as I can tell. 
fileOut.write (myDiff.toString());
