import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    public static void main(String[] args) {

        TerminalObservable terminalObservable = new TerminalObservable();
        new Observer("1", terminalObservable);;
        Observer observerToDelete = new Observer("2", terminalObservable);
        terminalObservable.removeObserver(observerToDelete);

        terminalObservable.updateVars();


    }
}
