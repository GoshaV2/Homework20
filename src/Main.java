import driver.DriverCategoryA;
import driver.DriverCategoryB;
import driver.DriverCategoryD;
import mechanic.Mechanic;
import sponsor.Sponsor;
import sponsor.TypeSponsor;
import station.ServiceStation;
import transport.Bus;
import transport.Car;
import transport.PassengerCar;
import transport.Truck;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        task1();
//        task2();
        task3();
    }

    private static void task1() throws Exception {
        PassengerCar passengerCar = new PassengerCar("bmw", "b2");
        Bus bus = new Bus("bus", "t1");
        Truck truck = new Truck("truck", "d2");

        Sponsor sponsor1 = new Sponsor("Sponsor1", TypeSponsor.COMPANY, 313131);
        Sponsor sponsor2 = new Sponsor("Sponsor2", TypeSponsor.HUMAN, 13141);
        Sponsor sponsor3 = new Sponsor("Sponsor3", TypeSponsor.COMPANY, 1454);
        Sponsor sponsor4 = new Sponsor("Sponsor4", TypeSponsor.COMPANY, 39);

        passengerCar.getSponsorList().add(sponsor1);
        passengerCar.getSponsorList().add(sponsor2);
        passengerCar.getSponsorList().add(sponsor3);

        bus.getSponsorList().add(sponsor4);

        truck.getSponsorList().add(sponsor1);
        truck.getSponsorList().add(sponsor4);

        DriverCategoryA driverCategoryA = new DriverCategoryA("Водитель легковужки", true, 31);
        DriverCategoryB driverCategoryB = new DriverCategoryB("Водитель грузовика", true, 3);
        DriverCategoryD driverCategoryD = new DriverCategoryD("Водитель автобуса", true, 123);

        passengerCar.setDriverCategoryA(driverCategoryA);
        truck.setDriverCategoryB(driverCategoryB);
        bus.setDriverCategoryD(driverCategoryD);

        Mechanic<Car> mechanic = new Mechanic<Car>("test", "test", "test");
        Mechanic<Bus> mechanic1 = new Mechanic<>("bus", "bus", "BIG BUS");
        passengerCar.getMechanicList().add(mechanic);
        bus.getMechanicList().add(mechanic1);
        bus.getMechanicList().add(mechanic);

        List<Car> listCar = new ArrayList<>();
        listCar.add(passengerCar);
        listCar.add(bus);
        listCar.add(truck);

        for (Car car : listCar
        ) {
            car.printInfo();
        }

        ServiceStation station = new ServiceStation();
        station.addToQueue(passengerCar);
        station.addToQueue(truck);
        station.carryOutTechnicalInspection();
        station.carryOutTechnicalInspection();
        station.carryOutTechnicalInspection();

    }

    private static void task2() {
        Queue<String> stringQueue1 = new ArrayDeque<>(5);
        Queue<String> stringQueue2 = new ArrayDeque<>(5);
        Queue<String> stringQueue3 = new ArrayDeque<>(5);
        setRandomQueue(5, stringQueue1);
        setRandomQueue(5, stringQueue2);
        setRandomQueue(5, stringQueue3);
        addHumanToQueue("Новый человек", new Queue[]{stringQueue1, stringQueue2, stringQueue3});
        System.out.println(stringQueue1);
        System.out.println(stringQueue2);
        System.out.println(stringQueue3);
        try {
            System.out.println("Извлекли " + getPeopleFromQueue(new Queue[]{stringQueue1, stringQueue2, stringQueue3}));
            System.out.println("Извлекли " + getPeopleFromQueue(new Queue[]{stringQueue1, stringQueue2, stringQueue3}));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(stringQueue1);
        System.out.println(stringQueue2);
        System.out.println(stringQueue3);

    }

    private static void setRandomQueue(int maxCount, Queue<String> queue) {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(maxCount); i++) {
            queue.add("Человек " + i);
        }
    }

    private static void addHumanToQueue(String name, Queue<String>[] queues) {
        Queue<String> queueWithMinSize = null;
        int k = 0; //счётчик очереди
        int size = Integer.MAX_VALUE;
        for (int i = 0; i < queues.length; i++) {
            if (queues[i].size() != 5 && queues[i].size() <= size) {
                k = i + 1;
                size = queues[i].size();
                queueWithMinSize = queues[i];
            }
        }
        if (queueWithMinSize == null) {
            System.out.println("Галя открой кассу");
            return;
        }
        queueWithMinSize.add(name);
        System.out.println(name + " добавлен в очередь в " + k);
    }

    private static String getPeopleFromQueue(Queue<String>[] queues) throws Exception {
        List<Integer> notEmptyQueueIndexes = new ArrayList<>(queues.length);
        for (int i = 0; i < queues.length; i++) {
            if (!queues[i].isEmpty()) {
                notEmptyQueueIndexes.add(i);
            }
        }
        if (notEmptyQueueIndexes.size() == 0) {
            throw new Exception("Очереди все пустые");
        }
        Random random = new Random();
        return queues[notEmptyQueueIndexes.get(random.nextInt(notEmptyQueueIndexes.size()))].poll();
    }

    private static void task3(){
        example();
    }

    private static void example() {
        List<List<String>> biDemArrList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                char symbol;
                if(i%2==j%2){
                    symbol='◯';
                }else{
                    symbol='●';
                }
                biDemArrList.get(i).add(j, symbol+"");
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(biDemArrList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}