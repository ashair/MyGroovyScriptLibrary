import java.util.Date;
import java.text.SimpleDateFormat;

def date = new Date()
sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
context.testCase.setPropertyValue('GetDate', sdf.format(date))
