package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class Task5 {

    private static final Pattern CONTACT_FULL_NAME_REGEX = Pattern.compile("[A-Z][a-z]* [A-Z][a-z]*");
    private static final Pattern CONTACT_NAME_ONLY_REGEX = Pattern.compile("[A-Z][a-z]*");

    private Task5() {
    }

    private static Contact parseContactString(String contact) {
        String trimmed = contact.trim();
        Matcher matcherFullname = CONTACT_FULL_NAME_REGEX.matcher(trimmed);
        Matcher matcherOnlyName = CONTACT_NAME_ONLY_REGEX.matcher(trimmed);
        if (matcherFullname.matches()) {
            return new Contact(
                trimmed.split(" ")[0],
                trimmed.split(" ")[1]
            );
        } else if (matcherOnlyName.matches()) {
            return new Contact(
                trimmed
            );
        } else {
            throw new RuntimeException("Could not parse contact string");
        }
    }

    public static List<Contact> parseContacts(List<String> contactsStr, String sortType) {
        List<Contact> contacts = new ArrayList<>();
        for (String contactStr : contactsStr) {
            contacts.add(parseContactString(contactStr));
        }
        switch (sortType) {
            case "DESC" -> Collections.sort(contacts, Collections.reverseOrder());
            case "ASC" -> Collections.sort(contacts);
            default -> throw new RuntimeException("Unknown sortType");

        }
        return contacts;
    }

    public record Contact(String name, String surname) implements Comparable<Contact> {

        Contact(String name) {
            this(name, null);
        }

        @Override
        public int compareTo(@NotNull Contact other) {
            if (this.surname == null && other.surname == null) {
                return this.name.compareTo(other.name);
            } else if (this.surname == null && other.surname != null) {
                return -1;
            } else if (this.surname != null && other.surname == null) {
                return 1;
            } else {
                return this.surname.compareTo(other.surname);
            }
        }

    }

}
