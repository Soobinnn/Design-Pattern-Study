package observer;

import java.util.Observable; // 이 부분이 옵저버에게 신호를 보내는 주체입니다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [예제1] java에서 제공하는 라이브러리를 이용한 예제
// Subject
public class EventSource extends Observable implements Runnable
{
    public void run()
    {
        try
        {
            final InputStreamReader isr = new InputStreamReader( System.in );
            final BufferedReader br = new BufferedReader( isr );
            while( true )
            {
                final String response = br.readLine();
                setChanged();
                notifyObservers( response );
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
