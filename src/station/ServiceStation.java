package station;

import transport.Bus;
import transport.Car;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ServiceStation {
    Queue<Car> carQueue=new LinkedList<>();

    public void addToQueue(Car car){
        if(car instanceof Bus){
            throw new IllegalArgumentException("Автобусы не нуждаются в проверке");
        }
        carQueue.offer(car);
    }

    public boolean carryOutTechnicalInspection(){
        if(!carQueue.isEmpty()){
            Car car=carQueue.element();
            car.runDiagnostic();
            return true;
        }
        return false;
    }
}
