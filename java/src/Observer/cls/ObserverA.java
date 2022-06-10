package Observer.cls;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        String str = (String) arg;
        System.out.println("감시자 A 통지 수신 : " + str);
    }
}
