package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Task5Tests {
    @Test
    @DisplayName("ASC Full names")
    void test1() {
        var names = List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        var sortType = "ASC";

        var contacts = Task5.parseContacts(names, sortType);

        assertThat(contacts.size()).isEqualTo(4);
        assertThat(contacts.get(0).name()).isEqualTo("Thomas");
        assertThat(contacts.get(0).surname()).isEqualTo("Aquinas");
        assertThat(contacts.get(1).name()).isEqualTo("Rene");
        assertThat(contacts.get(1).surname()).isEqualTo("Descartes");
        assertThat(contacts.get(2).name()).isEqualTo("David");
        assertThat(contacts.get(2).surname()).isEqualTo("Hume");
        assertThat(contacts.get(3).name()).isEqualTo("John");
        assertThat(contacts.get(3).surname()).isEqualTo("Locke");
    }

    @Test
    @DisplayName("DESC Full names")
    void test2() {
        var names = List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes");
        var sortType = "DESC";

        var contacts = Task5.parseContacts(names, sortType);

        assertThat(contacts.size()).isEqualTo(4);
        assertThat(contacts.get(0).name()).isEqualTo("John");
        assertThat(contacts.get(0).surname()).isEqualTo("Locke");
        assertThat(contacts.get(1).name()).isEqualTo("David");
        assertThat(contacts.get(1).surname()).isEqualTo("Hume");
        assertThat(contacts.get(2).name()).isEqualTo("Rene");
        assertThat(contacts.get(2).surname()).isEqualTo("Descartes");
        assertThat(contacts.get(3).name()).isEqualTo("Thomas");
        assertThat(contacts.get(3).surname()).isEqualTo("Aquinas");
    }

    @Test
    @DisplayName("ASC Names")
    void test3() {
        var names = List.of("Aa", "Cc", "Bb");
        var sortType = "ASC";

        var contacts = Task5.parseContacts(names, sortType);

        assertThat(contacts.size()).isEqualTo(3);
        assertThat(contacts.get(0).name()).isEqualTo("Aa");
        assertThat(contacts.get(0).surname()).isEqualTo(null);
        assertThat(contacts.get(1).name()).isEqualTo("Bb");
        assertThat(contacts.get(1).surname()).isEqualTo(null);
        assertThat(contacts.get(2).name()).isEqualTo("Cc");
        assertThat(contacts.get(2).surname()).isEqualTo(null);
    }

    @Test
    @DisplayName("DESC Names")
    void test4() {
        var names = List.of("Aa", "Cc", "Bb");
        var sortType = "DESC";

        var contacts = Task5.parseContacts(names, sortType);

        assertThat(contacts.size()).isEqualTo(3);
        assertThat(contacts.get(0).name()).isEqualTo("Cc");
        assertThat(contacts.get(0).surname()).isEqualTo(null);
        assertThat(contacts.get(1).name()).isEqualTo("Bb");
        assertThat(contacts.get(1).surname()).isEqualTo(null);
        assertThat(contacts.get(2).name()).isEqualTo("Aa");
        assertThat(contacts.get(2).surname()).isEqualTo(null);
    }

    @Test
    @DisplayName("Mixed full names and names")
    void test5() {
        var names = List.of("Bob White", "Abb", "Walter Black");
        var sortType = "DESC";

        var contacts = Task5.parseContacts(names, sortType);

        assertThat(contacts.size()).isEqualTo(3);
        assertThat(contacts.get(0).name()).isEqualTo("Bob");
        assertThat(contacts.get(0).surname()).isEqualTo("White");
        assertThat(contacts.get(1).name()).isEqualTo("Walter");
        assertThat(contacts.get(1).surname()).isEqualTo("Black");
        assertThat(contacts.get(2).name()).isEqualTo("Abb");
        assertThat(contacts.get(2).surname()).isEqualTo(null);
    }

    @Test
    @DisplayName("Wrong contact format")
    void test6() {
        var names = List.of("Joe Doe123");
        var sortType = "DESC";
        assertThatThrownBy(() -> Task5.parseContacts(names, sortType)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Wrong sort type")
    void test7() {
        var names = List.of("Joe Doe");
        var sortType = "aslkdjfaslk;df123123aslkdasdl";
        assertThatThrownBy(() -> Task5.parseContacts(names, sortType)).isInstanceOf(RuntimeException.class);
    }
}

