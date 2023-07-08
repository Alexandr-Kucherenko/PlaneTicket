import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void ticketSortTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("ATH", "ZRH", 150, 10, 14);//    1
        Ticket ticket2 = new Ticket("ATH", "ZRH", 500, 12, 16);//    6
        Ticket ticket3 = new Ticket("ZRH", "PRG", 100, 9, 11);//
        Ticket ticket4 = new Ticket("ATH", "ZRH", 300, 11, 15);//    4
        Ticket ticket5 = new Ticket("MAD", "ZRH", 200, 10, 13);//
        Ticket ticket6 = new Ticket("ATH", "ZRH", 200, 8, 12);//     3
        Ticket ticket7 = new Ticket("ATH", "ZRH", 400, 7, 11);//     5
        Ticket ticket8 = new Ticket("ATH", "ZRH", 180, 6, 10);//     2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1, ticket8, ticket6, ticket4, ticket7, ticket2};
        Ticket[] actual = manager.search("ATH", "ZRH");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void noTicketSortTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("ATH", "ZRH", 150, 10, 14);//    1
        Ticket ticket2 = new Ticket("ATH", "ZRH", 500, 12, 16);//    6
        Ticket ticket3 = new Ticket("ZRH", "PRG", 100, 9, 11);//
        Ticket ticket4 = new Ticket("ATH", "ZRH", 300, 11, 15);//    4
        Ticket ticket5 = new Ticket("MAD", "ZRH", 200, 10, 13);//
        Ticket ticket6 = new Ticket("ATH", "ZRH", 200, 8, 12);//     3
        Ticket ticket7 = new Ticket("ATH", "ZRH", 400, 7, 11);//     5
        Ticket ticket8 = new Ticket("ATH", "ZRH", 180, 6, 10);//     2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void boundaryValueTicketSortTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("ATH", "ZRH", 150, 10, 14);//    1
        Ticket ticket2 = new Ticket("ATH", "ZRH", 500, 12, 16);//    6
        Ticket ticket3 = new Ticket("ZRH", "PRG", 100, 9, 11);//
        Ticket ticket4 = new Ticket("ATH", "ZRH", 300, 11, 15);//    4
        Ticket ticket5 = new Ticket("MAD", "ZRH", 200, 10, 13);//
        Ticket ticket6 = new Ticket("ATH", "ZRH", 200, 8, 12);//     3
        Ticket ticket7 = new Ticket("ATH", "ZRH", 400, 7, 11);//     5
        Ticket ticket8 = new Ticket("ATH", "ZRH", 180, 6, 10);//     2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("MAD", "ZRH");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testSoftTicketsByComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("ATH", "ZRH", 150, 10, 15);// 5 - 4
        Ticket ticket2 = new Ticket("ATH", "ZRH", 500, 12, 16);// 4 - 3
        Ticket ticket3 = new Ticket("ZRH", "PRG", 100, 9, 17);//
        Ticket ticket4 = new Ticket("ATH", "ZRH", 300, 11, 13);// 2 - 1
        Ticket ticket5 = new Ticket("MAD", "ZRH", 200, 10, 13);//
        Ticket ticket6 = new Ticket("ATH", "ZRH", 200, 8, 11);//  3 - 2
        Ticket ticket7 = new Ticket("ATH", "ZRH", 400, 7, 15);//  8 - 6
        Ticket ticket8 = new Ticket("ATH", "ZRH", 180, 6, 12);//  6 - 5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket6, ticket2, ticket1, ticket8, ticket7};
        Ticket[] actual = manager.search("ATH", "ZRH", comparator);

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testSoftNoTicketsByComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("ATH", "ZRH", 150, 10, 15);// 5 - 4
        Ticket ticket2 = new Ticket("ATH", "ZRH", 500, 12, 16);// 4 - 3
        Ticket ticket3 = new Ticket("ZRH", "PRG", 100, 9, 17);//
        Ticket ticket4 = new Ticket("ATH", "ZRH", 300, 11, 13);// 2 - 1
        Ticket ticket5 = new Ticket("MAD", "ZRH", 200, 10, 13);//
        Ticket ticket6 = new Ticket("ATH", "ZRH", 200, 8, 11);//  3 - 2
        Ticket ticket7 = new Ticket("ATH", "ZRH", 400, 7, 15);//  8 - 6
        Ticket ticket8 = new Ticket("ATH", "ZRH", 180, 6, 12);//  6 - 5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("SCH", "IST", comparator);

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void testBoundaryValueTicketsByComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("ATH", "ZRH", 150, 10, 15);// 5 - 4
        Ticket ticket2 = new Ticket("ATH", "ZRH", 500, 12, 16);// 4 - 3
        Ticket ticket3 = new Ticket("ZRH", "PRG", 100, 9, 17);//
        Ticket ticket4 = new Ticket("ATH", "ZRH", 300, 11, 13);// 2 - 1
        Ticket ticket5 = new Ticket("MAD", "ZRH", 200, 10, 13);//
        Ticket ticket6 = new Ticket("ATH", "ZRH", 200, 8, 11);//  3 - 2
        Ticket ticket7 = new Ticket("ATH", "ZRH", 400, 7, 15);//  8 - 6
        Ticket ticket8 = new Ticket("ATH", "ZRH", 180, 6, 12);//  6 - 5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("ZRH", "PRG", comparator);

        Assertions.assertArrayEquals(expected, actual);


    }


}
