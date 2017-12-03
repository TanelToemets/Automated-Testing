package repository;

import static org.mockito.Mockito.*;

import org.json.JSONException;
import org.junit.Test;

import dummyFactory.ResponceDummy;
import model.CurrentWeatherReport;
import model.ThreeDaysWeatherReport;
import utility.Constants;
import utility.OutputWriter;

public class OutputWriterTaskTest {
	
	@Test
	public void testOutputWriter() throws JSONException{		
		OutputWriter outputWriterMock = mock(OutputWriter.class);		
		ResponceDummy responceDummy = new ResponceDummy();
		CurrentWeatherReport currentWeatherReportDummy = responceDummy.createCurrentWeatherDummy();
		ThreeDaysWeatherReport threeDaysWeatherReportDummy = responceDummy.createThreeDaysWeatherReportDummy();
		outputWriterMock.writeToFile(currentWeatherReportDummy, threeDaysWeatherReportDummy, Constants.OUTPUT_PATH+responceDummy.getCityName());
		verify(outputWriterMock).writeToFile(currentWeatherReportDummy, threeDaysWeatherReportDummy, Constants.OUTPUT_PATH+responceDummy.getCityName());
	}
}
