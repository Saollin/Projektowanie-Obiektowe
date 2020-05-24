package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static final String name = "Grzegorz";
    private static final String surname = "Janosz";

    @Test
    public void testName() {
        // when
        User user = new User(name, surname);

        // then
        assertEquals(name, user.getName());
    }

    @Test
    public void testSurnme() {
        // when
        User user = new User(name, surname);

        // then
        assertEquals(surname, user.getSurname());
    }
}