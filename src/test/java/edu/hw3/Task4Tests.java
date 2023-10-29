package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Tests {
    @Test
    @DisplayName("852")
    void test1() {
        int num = 852;

        String roman = Task4.convertToRoman(num);

        assertThat(roman).isEqualTo("DCCCLII");
    }

    @Test
    @DisplayName("1337")
    void test2() {
        int num = 1337;

        String roman = Task4.convertToRoman(num);

        assertThat(roman).isEqualTo("MCCCXXXVII");
    }

    @Test
    @DisplayName("28")
    void test3() {
        int num = 28;

        String roman = Task4.convertToRoman(num);

        assertThat(roman).isEqualTo("XXVIII");
    }

    @Test
    @DisplayName("808")
    void test4() {
        int num = 808;

        String roman = Task4.convertToRoman(num);

        assertThat(roman).isEqualTo("DCCCVIII");
    }

    @Test
    @DisplayName("69")
    void test5() {
        int num = 69;

        String roman = Task4.convertToRoman(num);

        assertThat(roman).isEqualTo("LXIX");
    }
}
