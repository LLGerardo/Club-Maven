package Tests;

import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;
import Creation.Member;

class MemberTest {

    @Test
    void calculateAge_ValidDateOfBirth_CorrectAge() {
        Member member = new Member("John", "Doe", "johndoe", LocalDate.of(1990, 1, 1),
                "Address", "123456789", "john@example.com", "Email",
                LocalDate.now(), true, "Basic");

        assertEquals(32, member.getAge());
    }

    @Test
    void verifyAge_Under18_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Member member = new Member("Jane", "Doe", "janedoe", LocalDate.of(2010, 1, 1),
                    "Address", "123456789", "jane@example.com", "Email",
                    LocalDate.now(), true, "Basic");
            member.verifyAge();
        });
    }

    // Add more tests for other methods in the Member class
}
