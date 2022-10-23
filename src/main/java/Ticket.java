import java.util.Arrays;

public class Ticket implements Comparable<Ticket> {
    public Ticket(int id, int price, String departure, String arrival, int time) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.time = time;
        this.ticket1 = ticket1;
    }

    protected int id;
    protected int price;
    protected String departure;
    protected String arrival;
    protected int time;

    Ticket ticket1 = new Ticket(
            10,
            100,
            "MOW",
            "LED",
            40
    );
    Ticket ticket2 = new Ticket(
            11,
            200,
            "MOW",
            "GOJ",
            60
    );
    Ticket ticket3 = new Ticket(
            13,
            250,
            "GOJ",
            "LED",
            90
    );
    Ticket ticket4 = new Ticket(
            14,
            180,
            "MOW",
            "FRU",
            120
    );
    Ticket ticket5 = new Ticket(
            15,
            160,
            "FRU",
            "GOJ",
            140
    );

    Ticket[] tickets = { ticket1, ticket2, ticket3, ticket4, ticket5 };
    Arrays.sort(tickets);

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        }
        return 0;
    }


}
