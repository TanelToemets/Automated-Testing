package repository;

import org.junit.Test;

import dummyFactory.ResponceDummy;
import model.CurrentWeatherReport;
import model.ThreeDaysWeatherReport;
import model.WeatherRequest;
import utility.Constants;
import utility.FileRequestFactory;
import utility.UpdateWeatherDataInFiles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;

public class UpdateWeatherTaskTest {

	@Test
	public void testForEveryCityInInputAReportIsWrittenToFile(){
		try{
			WeatherRepository repositoryMock = mock(WeatherRepository.class);
	        
			ResponceDummy responceDummy = new ResponceDummy();
			CurrentWeatherReport currentWeatherReportDummy = responceDummy.createCurrentWeatherDummy();
			ThreeDaysWeatherReport threeDaysWeatherReportDummy = responceDummy.createThreeDaysWeatherReportDummy();
	                
	        when(repositoryMock.getCurrentWeather(any(WeatherRequest.class))).thenReturn(currentWeatherReportDummy);
	        when(repositoryMock.getThreeDaysWeather(any(WeatherRequest.class))).thenReturn(threeDaysWeatherReportDummy);
	        
            FileRequestFactory requestFactory = new FileRequestFactory();
            WeatherRequest[] requestsList = requestFactory.createRequestsUsingInputFile();
            
	        UpdateWeatherDataInFiles fileUpdater = new UpdateWeatherDataInFiles();
	        fileUpdater.updateWeather(repositoryMock, requestsList);

	        int nrOfRequest  = requestsList.length;
	        System.out.println(nrOfRequest);
	        int nrOfOutputFilesCreated = new File(Constants.OUTPUT_PATH).listFiles().length;
	        System.out.println(nrOfOutputFilesCreated);
	        assertEquals(nrOfRequest, nrOfOutputFilesCreated);
	    }catch (Exception e){
	        fail("Failure cause " + e.getMessage());
	    }	        
	}
}



