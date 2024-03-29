package model;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThreeDaysWeatherReport{
	public final String cityName;
	public final Coordinates coordinates;
	public final OneDayMaxMinTemp[] threeDaysWeatherList;
	
	public ThreeDaysWeatherReport(String cityName, Coordinates coordinates, OneDayMaxMinTemp[] threeDaysWeatherList) {
		super();
		this.cityName = cityName;
		this.coordinates = coordinates;
		this.threeDaysWeatherList = threeDaysWeatherList;
	}

	@Override
	public String toString() {
		return "ThreeDaysWeatherReport [cityName=" + cityName + ", coordinates=" + coordinates
				+ ", threeDaysWeatherList=" + Arrays.toString(threeDaysWeatherList) + "]";
	}
	
	public JSONObject toJSON() throws JSONException {

		JSONArray oneDayMaxMinTempJsonArray = new JSONArray(threeDaysWeatherList);
        JSONObject jsonObj = new JSONObject();        
        jsonObj.put("cityName", cityName);
        jsonObj.put("coordinates", coordinates.toJSON());
		jsonObj.put("threeDaysWeather", oneDayMaxMinTempJsonArray);
        return jsonObj;
    }
	
	
}
