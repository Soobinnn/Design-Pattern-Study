package observer;

//예제3
public class WeatherStation 
{
	public static void main(String[] args) 
	{
		WeatherData weatherData = new WeatherData();
		CurrentConditions currentConditions = new CurrentConditions(weatherData);

		WeatherData2 weatherData2 = new WeatherData2();
		CurrentConditions2 currentConditions2 = new CurrentConditions2(weatherData2);

		weatherData.setMeasurementsChanged(85, 62, 36.7f);
		
		weatherData2.setMeasurementsChanged(83, 62, 36.7f);
	}
}
