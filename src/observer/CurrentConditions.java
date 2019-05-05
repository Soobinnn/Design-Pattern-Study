package observer;


//예제3
public class CurrentConditions implements Observer, DisplayElement
{
	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditions(Subject weatherData) 
	{
		this.weatherData = weatherData;
		this.weatherData.registerobserver(this);	//옵저버 등록
	}

	@Override
	public void display() 
	{
		System.out.println("Current conditions : "+temperature+" , "+humidity);
	}

	@Override
	public void update(float temp, float humidity, float pressure) 
	{
		this.temperature = temp;
		this.humidity = humidity;
		this.display();
	}
}
