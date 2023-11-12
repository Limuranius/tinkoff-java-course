package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    @DisplayName("А123ВЕ777")
    void test0() {
        String string = "А123ВЕ777";

        boolean isValid = Task5.validateNumberPlate(string);

        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("О777ОО177")
    void test1() {
        String string = "О777ОО177";

        boolean isValid = Task5.validateNumberPlate(string);

        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("Е001ЕЕ234")
    void test2() {
        String string = "Е001ЕЕ234";

        boolean isValid = Task5.validateNumberPlate(string);

        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("123АВЕ777")
    void test3() {
        String string = "123АВЕ777";

        boolean isValid = Task5.validateNumberPlate(string);

        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("А123ВГ77")
    void test4() {
        String string = "А123ВГ77";

        boolean isValid = Task5.validateNumberPlate(string);

        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("А123ВЕ7777")
    void test5() {
        String string = "А123ВЕ7777";

        boolean isValid = Task5.validateNumberPlate(string);

        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Ы321ЙЁ123")
    void test6() {
        String string = "Ы321ЙЁ123";

        boolean isValid = Task5.validateNumberPlate(string);

        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("А000АА000")
    void test7() {
        String string = "А000АА000";

        boolean isValid = Task5.validateNumberPlate(string);

        assertThat(isValid).isFalse();
    }
}
