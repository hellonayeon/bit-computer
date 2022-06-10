package Observer.cls;

import java.util.Observable;

public class MyClass extends Observable {

    private String password;
    private String preArg = null;

    @Override
    public void notifyObservers(Object arg) {
        String str = (String) arg;
        preArg = str;

        setChanged();

        super.notifyObservers(arg);
        clearChanged();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
