package observer;

import java.util.Observable;
import java.util.Observer;

//예제2
public class CurrentConditions2 implements Observer, DisplayElement
{	

    private Observable observable;
    private float temperature;
	private float humidity;

	public CurrentConditions2(Observable observable) 
	{
		this.observable = observable;
		this.observable.addObserver(this);
	}

	@Override
	public void display() 
	{
		System.out.println("Current conditions : "+temperature+" , "+humidity);
	}


	@Override
	public void update(Observable o, Object arg) 
	{
		if(o instanceof WeatherData2)
		{
			WeatherData2 weatherData = (WeatherData2) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.display();
		}
	}

}
