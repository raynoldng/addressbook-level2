package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    // format: BLOCK, STREET, UNIT, POSTAL_CODE
    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format of: " +
            "'a/BLOCK, STREET, UNIT, POSTAL_CODE'";
    public static final String ADDRESS_VALIDATION_REGEX = "(.+), (.+), (.+), (.+)";

    private static final int BLOCK_INDEX = 1;
    private static final int STREET_INDEX = 2;
    private static final int UNIT_INDEX = 3;
    private static final int POSTAL_CODE_INDEX = 4;

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    public final String value;

    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        Pattern regexPattern = Pattern.compile(ADDRESS_VALIDATION_REGEX);
        Matcher matcher = regexPattern.matcher(trimmedAddress);
        if (matcher.find()) {
            this.block = new Block(matcher.group(BLOCK_INDEX));
            this.street = new Street(matcher.group(STREET_INDEX));
            this.unit = new Unit(matcher.group(UNIT_INDEX));
            this.postalCode = new PostalCode(matcher.group(POSTAL_CODE_INDEX));
        } else {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.isPrivate = isPrivate;
        this.value = String.format("%s, %s, %s, %s", block.toString(), street.toString(), unit.toString(),
                postalCode.toString());
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public Block getBlock() {
        return block;
    }

    public Street getStreet() {
        return street;
    }

    public Unit getUnit() {
        return unit;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }
}
