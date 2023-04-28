import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    AviaSouls manager = new AviaSouls();

    Ticket ticket1 = new Ticket("SVO", "LED", 2500, 13, 15);
    Ticket ticket2 = new Ticket("IST", "BER", 5400, 11, 14);
    Ticket ticket3 = new Ticket("TBI", "VNO", 5340, 2, 5);
    Ticket ticket4 = new Ticket("SAB", "HEL", 12230, 12, 18);//6
    Ticket ticket5 = new Ticket("SAB", "HEL", 10330, 8, 15);//7
    Ticket ticket6 = new Ticket("SAB", "HEL", 18231, 19, 23);//4


    @Test
    public void testSort() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {ticket5, ticket4, ticket6};
        Ticket[] actual = manager.search("SAB", "HEL");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTick() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("TBI", "VNO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTick() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] expected = {};
        Ticket[] actual = manager.search("VNO", "HEL");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortComparator() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] expected = {ticket6, ticket4, ticket5};
        Ticket[] actual = manager.searchAndSortBy("SAB", "HEL", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
