package lesson032interfaces;

public interface Transport {
    int interfaceVar = 11; // Has to be initialized in interface. Is final and static!

    void go();
    void stop();
}
