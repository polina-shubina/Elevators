import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {
    int id;
    int currentFloor = 1;

    public Elevator(int id) {
        this.id = id;
    }

    public void moveToFloor(int targetFloor) {
        if (currentFloor != targetFloor) {
            System.out.println("Лифт " + id + " движется с этажа " + currentFloor + " на этаж " + targetFloor);
            currentFloor = targetFloor;
            System.out.println("Лифт " + id + " останавливается на этаже " + currentFloor);
        }
    }
}