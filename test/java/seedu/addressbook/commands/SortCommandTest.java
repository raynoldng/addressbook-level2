package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.util.TestUtil;

import java.util.*;

import static org.junit.Assert.*;

public class SortCommandTest {

    @Test
    public void execute_sortCommand_threePersons() {
        SortCommand command = new SortCommand();

        Person alice = TestUtil.generateTestPerson("Alice");
        Person bob = TestUtil.generateTestPerson("Bob");
        Person carl = TestUtil.generateTestPerson("Carl");

        AddressBook book = TestUtil.createAddressBook(carl, bob, alice);
        List<Person> expectedSortedList = Arrays.asList(alice, bob, carl);

        command.setData(book, Collections.emptyList());
        command.execute();

        UniquePersonList peopleInBook = book.getAllPersons();
        UniquePersonList expected = null;

        try {
            expected = new UniquePersonList(expectedSortedList);
        } catch (UniquePersonList.DuplicatePersonException e) {
            e.printStackTrace();
        }

        assertTrue(peopleInBook.equals(expected));
    }

}
