import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketTest {
    Ticket ticket1 = new Ticket(
            12,
            300,
            "LED",
            "GOJ",
            90

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
            "GOJ",
            120
    );
    Ticket ticket5 = new Ticket(
            15,
            160,
            "FRU",
            "GOJ",
            140
    );
    Ticket ticket6 = new Ticket(
            16,
            170,
            "MOW",
            "GOJ",
            140
    );
    Ticket ticket7 = new Ticket(
            17,
            190,
            "MOW",
            "GOJ",
            140
    );

    @Test
    public void shouldFindDefTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll("MOW", "GOJ");
        Ticket[] expected = {ticket6, ticket4, ticket7, ticket2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFind() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll("LED", "FRU");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldDeleteById() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        repo.deleteById(ticket7.getId());

        Ticket[] actual = manager.findAll();

    }
}

