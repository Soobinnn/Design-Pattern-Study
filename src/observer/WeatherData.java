package observer;

import java.util.ArrayList;
import java.util.List;

//예제3
public class WeatherData implements Subject
{
		private List<Observer> observers;
		private float temperature;
		private float humidity;
		private float pressure;
		
		{
			this.observers = new ArrayList<>();
		}

		public void measurementsChanged()
		{ 
			this.notifyObservers(); 
		}	

		public void setMeasurementsChanged(float t, float h, float p)
		{	//값이 세팅된다고 가정.
			this.temperature = t;
			this.humidity = h;
			this.pressure = p;
			this.measurementsChanged();
		}

		@Override
		public void notifyObservers() 
		{
			for (Observer observer : observers) 
			{
				observer.update(this.temperature, this.humidity, this.pressure);
			}
		}

		@Override
		public void registerobserver(Observer observer) 
		{
			this.observers.add(observer);
		}

		@Override
		public void removeObserver(Observer observer) 
		{
			if(observers.contains(observer)) observers.remove(observer);
		}
}
