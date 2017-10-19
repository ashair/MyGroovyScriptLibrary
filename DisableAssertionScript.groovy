def assertSdcAuthorizationTrue = context.expand( '${CheckSdcAuthorisation[8.2]#Response#declare namespace a=\'urn:axa.CEV.ws.com/servicecontract/2009/08/\'; declare namespace ns1=\'http://axa.CEV.com/servicecontract/2009/08/\'; //ns1:CheckSdcAuthorisationResponse[1]/ns1:CheckSdcAuthorisationResult[1]/a:SdcAuthorization[1]}' )
if(assertSdcAuthorizationTrue == "true"){
	testRunner.testCase.testSteps["CheckSdcAuthorisation[9.7]"].assertions["XpathAssertionOnError"].disabled = true;
	testRunner.testCase.testSteps["CheckSdcAuthorisation[9.7]"].assertions["EqualAssertionFromRequest"].disabled = true;
	testRunner.testCase.testSteps["CheckSdcAuthorisation[9.7]"].assertions["EqualAssertionFromTestCaseProperty"].disabled = true;
	testRunner.testCase.testSteps["CheckSdcAuthorisation[9.7]"].assertions["MessageContentAssertionOnSuccess"].disabled = false;
}
else{
	testRunner.testCase.testSteps["CheckSdcAuthorisation[9.7]"].assertions["XpathAssertionOnError"].disabled = false;
	testRunner.testCase.testSteps["CheckSdcAuthorisation[9.7]"].assertions["EqualAssertionFromRequest"].disabled = false;
	testRunner.testCase.testSteps["CheckSdcAuthorisation[9.7]"].assertions["EqualAssertionFromTestCaseProperty"].disabled = false;
	testRunner.testCase.testSteps["CheckSdcAuthorisation[9.7]"].assertions["MessageContentAssertionOnSuccess"].disabled = true;
}
