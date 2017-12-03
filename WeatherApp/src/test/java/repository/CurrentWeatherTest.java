package repository;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import model.CurrentWeatherReport;
import model.WeatherRequest;
import utility.RequestFactory;

import utility.UpdateWeatherDataInFiles;

public class CurrentWeatherTest {
    private static CurrentWeatherReport report;
    private static WeatherRequest request;
    
	@BeforeClass
	public static void setUp() throws Exception {
		try{			
			OpenWeatherRepository repository = new OpenWeatherRepository();
			RequestFactory requestFactory = new RequestFactory();
            WeatherRequest[] requestsList = requestFactory.askUserDecisionForRequest();
			
			UpdateWeatherDataInFiles updater = new UpdateWeatherDataInFiles();
			updater.updateWeather(repository, requestsList);			
            
            for(WeatherRequest request:requestsList){
            	report = repository.getCurrentWeather(request);
            	CurrentWeatherTest.request = request;
            }
		}catch (Exception e){
			fail("Cause of failure: " + e.getMessage());
		}
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCurrentTemperature(){
		assertTrue(report.currentTemperature < 70);
		assertTrue(report.currentTemperature > -100);
	}
	
	@Test
	public void testIfResponseAndRequestCityAreEqual(){
		assertEquals(request.cityName, report.cityName);
	}
	
	@Test
	public void testLatitude(){
		assertTrue(report.coordinates.latitude >-90);
		assertTrue(report.coordinates.latitude < 90);
	}
	
	@Test
	public void testLongitude(){
		assertTrue(report.coordinates.longitude > -180);
		assertTrue(report.coordinates.longitude < 180);
	}
	
}


