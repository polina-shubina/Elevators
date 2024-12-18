import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevatorSystem {
    private final List<Elevator> elevators = new ArrayList<>();
    private final RequestGenerator requestGenerator = new RequestGenerator();

    public ElevatorSystem(int elevatorCount) {
        for (int i = 0; i < elevatorCount; i++) {
            elevators.add(new Elevator(i + 1));
        }
    }

    public void simulate() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Нажмите Enter для генерации новой заявки или создайте сами:\nФормат зявки:с какого эатажа забрать !пробел! на какой отвезти");
            String line = scanner.nextLine();
            String start, finish;
            if (line.isEmpty()) {
                start = "";
                finish = "";
            }
            else{
                String[] parts = line.split(" ");
                start = parts[0];
                finish = parts[1];
            }
            Request request = requestGenerator.generateRequest(start, finish);
            System.out.println("Новая заявка: С этажа " + request.start + " на этаж " + request.finish);
            Elevator bestElevator = findBestElevator(request.start);
            if (bestElevator != null) {
                bestElevator.moveToFloor(request.start);
                bestElevator.moveToFloor(request.finish);
                System.out.println("Лифт " + bestElevator.id + " ожидает новую заявку на этаже " + request.finish);
            }
            System.out.println();
        }
    }

    private Elevator findBestElevator(int requestFloor) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.currentFloor - requestFloor);
            if (distance < minDistance) {
                minDistance = distance;
                bestElevator = elevator;
            }
        }

        return bestElevator;
    }
}