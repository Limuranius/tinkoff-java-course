package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.ListAssert.assertThatList;
import static org.assertj.core.api.Assertions.assertThat;

public class Tests {
    private static final List<Animal> ANIMALS = Arrays.asList(new Animal[] {
        new Animal("Мурка", Animal.Type.CAT, Animal.Sex.F, 10, 25, 5, true),
        new Animal("Барсик", Animal.Type.CAT, Animal.Sex.M, 4, 50, 15, true),
        new Animal("Кеша", Animal.Type.CAT, Animal.Sex.M, 7, 45, 9, false),
        new Animal("Нюра", Animal.Type.CAT, Animal.Sex.F, 15, 33, 7, true),
        new Animal("Василий", Animal.Type.DOG, Animal.Sex.M, 7, 75, 25, false),
        new Animal("Василиса", Animal.Type.DOG, Animal.Sex.F, 4, 65, 17, false),
        new Animal("Гоша", Animal.Type.BIRD, Animal.Sex.F, 1, 7, 1, false),
        new Animal("Кит Максим Витальевич", Animal.Type.FISH, Animal.Sex.M, 27, 400, 5000, false),
        new Animal("Дельфин Алиса Ивановна", Animal.Type.FISH, Animal.Sex.F, 13, 200, 1500, true),
        new Animal("Акула", Animal.Type.FISH, Animal.Sex.F, 17, 250, 2000, true),
        new Animal("Павел", Animal.Type.SPIDER, Animal.Sex.M, 2, 15, 2, true),
        new Animal("Герман", Animal.Type.SPIDER, Animal.Sex.M, 3, 17, 3, false),
        new Animal("Дина", Animal.Type.SPIDER, Animal.Sex.F, 8, 10, 1, true)
    });

    @Test
    void task1_1() {
        List<Animal> animals = ANIMALS;

        var result = Tasks.task1(animals);
        Integer[] expectedHeights = {7, 10, 15, 17, 25, 33, 45, 50, 65, 75, 200, 250, 400};

        assertThatList(result)
            .hasSize(13)
            .extracting(Animal::height)
            .containsExactly(expectedHeights);
    }

    @Test
    void task1_2_emptyList() {
        List<Animal> animals = new ArrayList<>();

        var result = Tasks.task1(animals);

        assertThatList(result).isEmpty();
    }

    @Test
    void task2_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task2(animals, 5);
        Integer[] expectedWeights = {5000, 2000, 1500, 25, 17};

        assertThatList(results)
            .hasSize(5)
            .extracting(Animal::weight)
            .containsExactly(expectedWeights);
    }

    @Test
    void task2_2_k0() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task2(animals, 0);

        assertThatList(results).isEmpty();
    }

    @Test
    void task3_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task3(animals);

        assertThat(results.size()).isEqualTo(5);
        assertThat(results.get(Animal.Type.CAT)).isEqualTo(4);
        assertThat(results.get(Animal.Type.DOG)).isEqualTo(2);
        assertThat(results.get(Animal.Type.BIRD)).isEqualTo(1);
        assertThat(results.get(Animal.Type.FISH)).isEqualTo(3);
        assertThat(results.get(Animal.Type.SPIDER)).isEqualTo(3);
    }

    @Test
    void task3_2_emptyList() {
        List<Animal> animals = new ArrayList<>();

        var results = Tasks.task3(animals);

        assertThat(results.isEmpty()).isTrue();
    }

    @Test
    void task4_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task4(animals);

        assertThat(results.name()).isEqualTo("Дельфин Алиса Ивановна");
    }

    @Test
    void task4_2_emptyList() {
        List<Animal> animals = new ArrayList<>();

        assertThatThrownBy(() -> Tasks.task4(animals));
    }

    @Test
    void task5_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task5(animals);

        assertThat(results).isEqualTo(Animal.Sex.F);
    }

    @Test
    void task6_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task6(animals);

        assertThat(results.size()).isEqualTo(5);
        assertThat(results.get(Animal.Type.CAT).weight()).isEqualTo(15);
        assertThat(results.get(Animal.Type.DOG).weight()).isEqualTo(25);
        assertThat(results.get(Animal.Type.BIRD).weight()).isEqualTo(1);
        assertThat(results.get(Animal.Type.FISH).weight()).isEqualTo(5000);
        assertThat(results.get(Animal.Type.SPIDER).weight()).isEqualTo(3);
    }

    @Test
    void task7_1() {
        List<Animal> animals = ANIMALS;

        assertThat(Tasks.task7(animals, 1).age()).isEqualTo(27);
        assertThat(Tasks.task7(animals, 4).age()).isEqualTo(13);
        assertThat(Tasks.task7(animals, 3).age()).isEqualTo(15);
        assertThat(Tasks.task7(animals, 2).age()).isEqualTo(17);
    }

    @Test
    void task8_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task8(animals, 50);

        assertThat(results.isPresent()).isTrue();
        assertThat(results.get().weight()).isEqualTo(9);
    }

    @Test
    void task8_2_null() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task8(animals, 0);

        assertThat(results.isEmpty()).isTrue();
    }

    @Test
    void task9_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task9(animals);

        assertThat(results).isEqualTo(50);
    }

    @Test
    void task9_2_emptyList() {
        List<Animal> animals = new ArrayList<>();

        var results = Tasks.task9(animals);

        assertThat(results).isEqualTo(0);
    }

    @Test
    void task10_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task10(animals);
        String[] expectedNames = {
            "Мурка",
            "Кеша",
            "Нюра",
            "Василий",
            "Гоша",
            "Кит Максим Витальевич",
            "Дельфин Алиса Ивановна",
            "Акула",
            "Павел",
            "Герман",
        };

        assertThatList(results)
            .hasSize(expectedNames.length)
            .extracting(Animal::name)
            .containsExactlyInAnyOrder(expectedNames);
    }

    @Test
    void task11_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task11(animals);

        assertThatList(results)
            .hasSize(2)
            .extracting(Animal::name)
            .containsExactlyInAnyOrder("Дельфин Алиса Ивановна", "Акула");
    }

    @Test
    void task12_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task12(animals);

        assertThat(results).isEqualTo(3);
    }

    @Test
    void task13_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task13(animals);
        String[] expectedNames = {
            "Кит Максим Витальевич",
            "Дельфин Алиса Ивановна"
        };

        assertThatList(results)
            .hasSize(2)
            .extracting(Animal::name)
            .containsExactlyInAnyOrder(expectedNames);
    }

    @Test
    void task14_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task14(animals, 50);

        assertThat(results).isTrue();
    }

    @Test
    void task14_2() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task14(animals, 150);

        assertThat(results).isFalse();
    }

    @Test
    void task15_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task15(animals, 8, 20);

        assertThat(results.size()).isEqualTo(3);
        assertThat(results.get(Animal.Type.CAT)).isEqualTo(12);
        assertThat(results.get(Animal.Type.FISH)).isEqualTo(3500);
        assertThat(results.get(Animal.Type.SPIDER)).isEqualTo(1);
    }

    @Test
    void task16_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task16(animals);
        Animal.Type[] expectedTypes = {
            Animal.Type.CAT,
            Animal.Type.CAT,
            Animal.Type.CAT,
            Animal.Type.CAT,
            Animal.Type.DOG,
            Animal.Type.DOG,
            Animal.Type.BIRD,
            Animal.Type.FISH,
            Animal.Type.FISH,
            Animal.Type.FISH,
            Animal.Type.SPIDER,
            Animal.Type.SPIDER,
            Animal.Type.SPIDER
        };

        Animal.Sex[] expectedSexes = {
            Animal.Sex.M,
            Animal.Sex.M,
            Animal.Sex.F,
            Animal.Sex.F,
            Animal.Sex.M,
            Animal.Sex.F,
            Animal.Sex.F,
            Animal.Sex.M,
            Animal.Sex.F,
            Animal.Sex.F,
            Animal.Sex.M,
            Animal.Sex.M,
            Animal.Sex.F
        };

        String[] expectedNames = {
            "Барсик",
            "Кеша",
            "Мурка",
            "Нюра",
            "Василий",
            "Василиса",
            "Гоша",
            "Кит Максим Витальевич",
            "Акула",
            "Дельфин Алиса Ивановна",
            "Герман",
            "Павел",
            "Дина"
        };

        assertThatList(results)
            .extracting(Animal::type)
            .containsExactly(expectedTypes);
        assertThatList(results)
            .extracting(Animal::sex)
            .containsExactly(expectedSexes);
        assertThatList(results)
            .extracting(Animal::name)
            .containsExactly(expectedNames);
    }

    @Test
    void task17_1() {
        List<Animal> animals = ANIMALS;

        var results = Tasks.task17(animals);

        assertThat(results).isTrue();
    }

    @Test
    void task17_2_noInfoDogs() {
        List<Animal> animals = List.of(
            new Animal("Павел", Animal.Type.SPIDER, Animal.Sex.M, 2, 15, 2, true),
            new Animal("Герман", Animal.Type.SPIDER, Animal.Sex.M, 3, 17, 3, false),
            new Animal("Дина", Animal.Type.SPIDER, Animal.Sex.F, 8, 10, 1, true)
        );

        var results = Tasks.task17(animals);

        assertThat(results).isFalse();
    }

    @Test
    void task17_2_noInfoSpiders() {
        List<Animal> animals = List.of(
            new Animal("Василий", Animal.Type.DOG, Animal.Sex.M, 4, 75, 25, false),
            new Animal("Василиса", Animal.Type.DOG, Animal.Sex.F, 7, 65, 17, false)
        );

        var results = Tasks.task17(animals);

        assertThat(results).isFalse();
    }

    @Test
    void task18_1() {
        List<Animal> animals1 = List.of(
            new Animal("Карась", Animal.Type.FISH, Animal.Sex.F, 10, 10, 10, false),
            new Animal("Скат", Animal.Type.FISH, Animal.Sex.M, 20, 20, 20, false),
            new Animal("Лещ", Animal.Type.FISH, Animal.Sex.F, 30, 30, 30, true)
        );
        List<Animal> animals2 = ANIMALS;

        var results = Tasks.task18(animals1, animals2);

        assertThat(results.name()).isEqualTo("Кит Максим Витальевич");
    }

    @Test
    void task19_1() {
        List<Animal> animals = List.of(
            new Animal("", Animal.Type.CAT, Animal.Sex.F, -1, -2, 99999, false),
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 3, 4, true),
            new Animal("ab", Animal.Type.CAT, Animal.Sex.F, 500, 12345, -500, false)
        );

        var results = Tasks.task19(animals);

        assertThat(results.size()).isEqualTo(2);
        assertThat(results.keySet())
            .containsExactly("", "ab");
        assertThat(results.get("")).hasSize(4);
        assertThat(results.get("ab")).hasSize(3);
    }

    @Test
    void task20_1() {
        List<Animal> animals = List.of(
            new Animal("", Animal.Type.CAT, Animal.Sex.F, -1, -2, 99999, false),
            new Animal("cat", Animal.Type.CAT, Animal.Sex.M, 5, 3, 4, true),
            new Animal("ab", Animal.Type.CAT, Animal.Sex.F, 500, 12345, -500, false)
        );

        var results = Tasks.task20(animals);

        assertThat(results.size()).isEqualTo(2);
        assertThat(results.keySet())
            .containsExactly("", "ab");

        assertThat(results.get("")).isEqualTo(
            "Empty name\nAge must be in range [" + Tasks.MIN_AGE + ": " + Tasks.MAX_AGE +
                "]\nHeight must be in range [" + Tasks.MIN_HEIGHT + ": " + Tasks.MAX_HEIGHT +
                "]\nWeight must be in range [" + Tasks.MIN_WEIGHT + ": " + Tasks.MAX_WEIGHT + "]\n");
        assertThat(results.get("ab")).isEqualTo(
            "Age must be in range [" + Tasks.MIN_AGE + ": " + Tasks.MAX_AGE +
                "]\nHeight must be in range [" + Tasks.MIN_HEIGHT + ": " + Tasks.MAX_HEIGHT +
                "]\nWeight must be in range [" + Tasks.MIN_WEIGHT + ": " + Tasks.MAX_WEIGHT + "]\n");
    }
}
