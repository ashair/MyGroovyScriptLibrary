import com.eviware.soapui.config.AuthEntryTypeConfig;

def project = testRunner.getTestCase().getTestSuite().getProject();
def testSuite = testRunner.getTestCase().getTestSuite();
log.info (testSuite.getName())
def authProfile = project.getAuthRepository().createEntry(AuthEntryTypeConfig.BASIC, "TestUser");
authProfile.setUsername("TestUser");
authProfile.setPassword("Password");
//authProfile.setDomain("NewDomain");
authProfile.setPreemptive(false);

//def request= testRunner.testCase.getTestStepByName("Name of the Step").getHttpRequest();
//request.setSelectedAuthProfile("Name of your profile");
