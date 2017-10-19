import com.eviware.soapui.model.testsuite.TestStepResult.TestStepStatus;


myTestStepResult1 = testRunner.runTestStepByName("CheckSdcAuthorisation[8.2]");
myTestStepResult2 = testRunner.runTestStepByName("CheckSdcAuthorisation[9.7]");
myStatus1 = myTestStepResult1.getStatus();
myStatus2 = myTestStepResult2.getStatus();
if (myStatus1 == TestStepStatus.OK && myStatus2 == TestStepStatus.OK){
	log.info "The step status is: " + myStatus1.toString();
	log.info "The step status is: " + myStatus2.toString();
	context.testCase.setPropertyValue("Status", "OK")
}
else if (myStatus1 != TestStepStatus.OK || myStatus2 != TestStepStatus.OK){
	log.error "The step status is: " + myStatus1.toString();
	log.info "The step status is: " + myStatus2.toString();
	context.testCase.setPropertyValue("Status", "KO");
}

def logArea = com.eviware.soapui.SoapUI.logMonitor.getLogArea("Log Output");
def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context);
def projectPath = groovyUtils.projectPath;
def logFile = new File(projectPath + "\\soapUI-Logs-to-file.txt");
logFile.write("soapUI Logs In a file.\r\n")
   if( logArea !=null )
   {
      def model = logArea.model
      if( model.size > 0 )            
         for( c in 0..(model.size-1) )         
           logFile.append(model.getElementAt( c ))       
      
   }
