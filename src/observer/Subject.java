package observer;

//예제3 
// Push방식
public interface Subject 
{
    void registerobserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
} 
