import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Timer;
import java.util.TimerTask;

public class TerminalObservable implements ITerninalObservable{
    private List<Observer> observerList = new ArrayList();
    private ArrayList<Vars> vars = new ArrayList();
    private float press;
    private int temp;
    private int rot;

    public TerminalObservable() { }

    public void updateVars() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new RepeatedTask(), 500, 5000);
    }
    public void generateVars(){
        press = (float) ThreadLocalRandom.current().nextDouble(4.7, 5.6);
        temp = ThreadLocalRandom.current().nextInt(359, 502 + 1);
        rot = ThreadLocalRandom.current().nextInt(2999, 3002 + 1);
        vars.add(new Vars(press, temp, rot));
        this.notifyObservers();
    }

    @Override
    public void registerObserver(Observer obj) {
        this.observerList.add(obj);
    }

    @Override
    public void removeObserver(Observer obj) {
        this.observerList.remove(obj);
    }

    @Override
    public void notifyObservers() {
        Iterator var1 = this.observerList.iterator();

        while(var1.hasNext()) {
            Observer obj = (Observer)var1.next();
            obj.update(this.vars);
        }
    }

    class RepeatedTask extends TimerTask {
        public void run() {
            generateVars();
        }
    }
}
