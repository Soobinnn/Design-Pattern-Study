package observer;

import java.util.Observable;

//예제2
public class WeatherData2 extends Observable
{	
	private float temperature;
	private float humidity;
	private float pressure;

	public void measurementsChanged()
	{ 
		this.setChanged();	//상태가 바뀌었다는 플래그값을 바꿔줌.
		this.notifyObservers(); //Pull 방식을 사용해서 알림
	}
	
	public void setMeasurementsChanged(float t, float h, float p)
	{	
		//값이 세팅된다고 가정.
		this.temperature = t;
		this.humidity = h;
		this.pressure = p;
		this.measurementsChanged();
	}
	
	public float getTemperature() 
	{
		return temperature;
	}

	public float getHumidity() 
	{
		return humidity;
	}

	public float getPressure() 
	{
		return pressure;
	}
}

	
