public interface ITerninalObservable {
        void registerObserver(Observer var);

        void removeObserver(Observer var);

        void notifyObservers();
}
