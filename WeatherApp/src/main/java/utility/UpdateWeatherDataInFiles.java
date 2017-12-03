package utility;

import model.CurrentWeatherReport;
import model.ThreeDaysWeatherReport;
import model.WeatherRequest;
import repository.WeatherRepository;
import utility.OutputWriter;

public class UpdateWeatherDataInFiles {
    
    public void updateWeather(WeatherRepository repository, WeatherRequest[] requestsList){
        try{            
            for(WeatherRequest request:requestsList){       	
            	System.out.println(request.toString());
                CurrentWeatherReport currentWeatherReport = repository.getCurrentWeather(request);
                System.out.println(currentWeatherReport.toString());
                ThreeDaysWeatherReport threeDaysWeatherReport = repository.getThreeDaysWeather(request);
                OutputWriter writer = new OutputWriter();
                writer.writeToFile(currentWeatherReport, threeDaysWeatherReport, Constants.OUTPUT_PATH+request.cityName+".txt");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
