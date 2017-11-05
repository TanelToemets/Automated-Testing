package repository;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.CurrentWeatherReport;
import model.WeatherRequest;
import utility.CityNameScanner;
import utility.OutputWriter;

public class CurrentWeatherTest {
    private static CurrentWeatherReport report;
    private static WeatherRequest request;
    private static CityNameScanner scanner;
    private static OutputWriter writer;
    
	@Before
	public void setUp() throws Exception {
		try{
			scanner = new CityNameScanner();
			writer = new OutputWriter();
			
			request = new WeatherRequest(scanner.getCityNameFromScanner(), "metric");
			OpenWeatherRepository repository = new OpenWeatherRepository();
			report = repository.getCurrentWeather(request);		
			writer.writeToFile(report);
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


