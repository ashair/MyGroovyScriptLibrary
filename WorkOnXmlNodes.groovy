import groovy.util.XmlSlurper;
import groovy.util.slurpersupport.*;
import groovy.util.XmlParser;

// create groovyUtils and XmlHolder for response of the request
def groovyUtils = new com.eviware.soapui.support.GroovyUtils(context);
def requestResponse = groovyUtils.expand('${CheckSdcAuthorisation[8.2]#Response}');
def holder = groovyUtils.getXmlHolder(requestResponse);
def parseResponse = new XmlSlurper().parseText(requestResponse);
def allNodeValues = holder.getNodeValues("//*");
def counter = 0;
allNodeValues.each {log.info it}

// loop item nodes in response message
/*for( item in allNodeValues){
	log.info(allNodeValues[counter])
    counter++;
}*/
/*for( item in parseResponse){
    log.info( "Item : $parseResponse");
}
/*
def retrieveContext = new com.eviware.soapui.support.GroovyUtils(context);
def reqFromResponse = retrieveContext.expand('${CheckSdcAuthorisation[8.2]#Response}');

//log.info("Code: ${parseResponse.Envelope}");

/*
log.info("Code: ${parseResponse.node.name}");
log.info("MessageException nil: ${parseResponse.MessageException.@nil}");
/*
def pers=new XmlSlurper().parse(new File("E://XmlFile.xml"))

pers.children().each { println it.Envelope }*/
