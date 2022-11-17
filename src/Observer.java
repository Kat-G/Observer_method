import java.util.ArrayList;
import java.util.Iterator;

public class Observer implements IObserver {
    private String ID;

    public Observer(String id, TerminalObservable tObservable) {
        this.ID = id;
        tObservable.registerObserver(this);
    }
    @Override
    public void update(ArrayList<Vars> var) {
        System.out.print("Обозреватель с id " + this.ID + " заметил изменение данных с датчиков: \n");

        Vars item = (Vars) var.get(var.size()-1);
        System.out.println("Давление: " + item.GetPress() + " МПа\nТемпература: " + item.GetTemp() + " С\nВращения: " + item.GetRot()+" об/мин");
        warning(item);
        System.out.println();
    }

    private void warning(Vars var){
        if (var.GetTemp()<360 || var.GetTemp()>500){
            System.out.println("Критическое значение температуры!");
        }
        if (var.GetPress()<4.8f || var.GetPress()>5.5f){
            System.out.println("Критическое значение давления!");
        }
        if (var.GetRot()<2999 || var.GetRot()>3001){
            System.out.println("Критическое значение вращения!");
        }
    }
}
