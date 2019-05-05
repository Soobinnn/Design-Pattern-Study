package observer;

import java.util.Observable;
import java.util.Observer;

//[예제1] java에서 제공하는 라이브러리를 이용한 예제
// Observer
public class ResponseHandler implements Observer
{
    private String resp;
    public void update (Observable obj, Object arg)
    {
        if (arg instanceof String)
        {
            resp = (String) arg;
            System.out.println("\nReceived Response: "+ resp );
        }
    }
}