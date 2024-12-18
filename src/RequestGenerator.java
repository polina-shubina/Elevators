import java.util.Random;

class RequestGenerator {
    private final Random random = new Random();

    public Request generateRequest(String s, String f) {
        int start = 1, finish = 1;
        if (s.isEmpty() && f.isEmpty()) {
            start = random.nextInt(9) + 1;
            do {
                finish = random.nextInt(9) + 1;
            } while (finish == start);
        }
        else{
            try {
                start = Integer.parseInt(s);
                finish = Integer.parseInt(f);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка");
            }
        }
        return new Request(start, finish);
    }
}

