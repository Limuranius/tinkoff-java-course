package edu.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Tasks {
    static final int MIN_AGE = 0;
    static final int MAX_AGE = 100;
    static final int MIN_HEIGHT = 0;
    static final int MAX_HEIGHT = 500;
    static final int MIN_WEIGHT = 0;
    static final int MAX_WEIGHT = 9999;

    private Tasks() {
    }

    public static List<Animal> task1(List<Animal> animals) {
        // Отсортировать животных по росту от самого маленького к самому большому
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static List<Animal> task2(List<Animal> animals, int k) {
        // Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых
        return animals
            .stream()
            .sorted((a1, a2) -> a2.weight() - a1.weight())
            .limit(k)
            .toList();
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        // Сколько животных каждого вида
        return animals
            .stream()
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    Collectors.collectingAndThen(
                        Collectors.counting(),
                        Long::intValue
                    )
                )
            );
    }

    public static Animal task4(List<Animal> animals) {
        // У какого животного самое длинное имя
        return animals
            .stream()
            .max(
                Comparator.comparingInt(a -> a.name().length())
            )
            .orElseThrow();
    }

    public static Animal.Sex task5(List<Animal> animals) {
        // Каких животных больше: самцов или самок
        var sexCount = animals
            .stream().collect(
                Collectors.groupingBy(
                    Animal::sex,
                    Collectors.counting()
                )
            );
        var maxSex = sexCount
            .entrySet()
            .stream()
            .max(
                Comparator.comparingLong(Map.Entry::getValue)
            ).orElseThrow();
        return maxSex.getKey();

    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        // Самое тяжелое животное каждого вида
        return animals
            .stream()
            .collect(
                Collectors.toMap(
                    Animal::type,
                    Function.identity(),
                    BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
                )
            );
    }

    public static Animal task7(List<Animal> animals, int k) {
        // K-е самое старое животное

        return animals
            .stream()
            .sorted((a1, a2) -> a2.age() - a1.age())  // descending sort by age
            .limit(k)
            .reduce((a1, a2) -> a2)  // find last
            .orElseThrow();
    }

    public static Optional<Animal> task8(List<Animal> animals, int k) {
        // Самое тяжелое животное среди животных ниже k см
        return animals
            .stream()
            .sorted((a1, a2) -> a2.weight() - a1.weight())  // descending sort by weight
            .filter(animal -> animal.height() < k)
            .findFirst();
    }

    public static Integer task9(List<Animal> animals) {
        // Сколько в сумме лап у животных в списке
        return animals
            .stream()
            .reduce(
                0,
                (pawCount, animal) -> pawCount + animal.paws(),
                Integer::sum
            );
    }

    public static List<Animal> task10(List<Animal> animals) {
        // Список животных, возраст у которых не совпадает с количеством лап
        return animals
            .stream()
            .filter(animal -> animal.paws() != animal.age())
            .toList();
    }

    public static List<Animal> task11(List<Animal> animals) {
        // Список животных, которые могут укусить (bites == true) и рост которых превышает 100 см
        final int min_h = 100;
        return animals
            .stream()
            .filter(animal -> animal.bites() && animal.height() > min_h)
            .toList();
    }

    public static Integer task12(List<Animal> animals) {
        // Сколько в списке животных, вес которых превышает рост
        return (int) animals
            .stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    public static List<Animal> task13(List<Animal> animals) {
        // Список животных, имена которых состоят из более чем двух слов
        return animals
            .stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }

    public static Boolean task14(List<Animal> animals, int k) {
        // Есть ли в списке собака ростом более k см
        return animals
            .stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        // Найти суммарный вес животных каждого вида, которым от k до l лет
        return animals
            .stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    Collectors.summingInt(Animal::weight)
                )
            );
    }

    public static List<Animal> task16(List<Animal> animals) {
        // Список животных, отсортированный по виду, затем по полу, затем по имени
        return animals
            .stream()
            .sorted(
                Comparator.comparing(Animal::type)
                    .thenComparing(Animal::sex)
                    .thenComparing(Animal::name)
            )
            .toList();
    }

    public static Boolean task17(List<Animal> animals) {
        // Правда ли, что пауки кусаются чаще, чем собаки (если данных для ответа недостаточно, вернуть false)
        int dogCount = (int) animals.stream().filter(animal -> animal.type() == Animal.Type.DOG).count();
        int spiderCount = (int) animals.stream().filter(animal -> animal.type() == Animal.Type.SPIDER).count();
        if (dogCount * spiderCount == 0) {
            return false;
        }
        var bitesCount = animals
            .stream()
            .filter(animal -> animal.type() == Animal.Type.DOG || animal.type() == Animal.Type.SPIDER)
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    Collectors.summingInt(animal -> animal.bites() ? 1 : 0)
                )
            );
        return bitesCount.get(Animal.Type.SPIDER) > bitesCount.get(Animal.Type.DOG);
    }

    public static Animal task18(List<Animal>... animals) {
        // Найти самую тяжелую рыбку в 2-х или более списках
        return Arrays.stream(animals)
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElseThrow();
    }

    private static List<ValidationError> validateAnimal(Animal animal) {
        List<ValidationError> errors = new ArrayList<>();
        if (animal.name().isEmpty()) {
            errors.add(new ValidationError("Empty name"));
        }
        if (animal.age() < MIN_AGE || animal.age() > MAX_AGE) {
            errors.add(new ValidationError("Age must be in range [" + MIN_AGE + ": " + MAX_AGE + "]"));
        }
        if (animal.height() < MIN_AGE || animal.height() > MAX_AGE) {
            errors.add(new ValidationError("Height must be in range [" + MIN_HEIGHT + ": " + MAX_HEIGHT + "]"));
        }
        if (animal.weight() < MIN_AGE || animal.weight() > MAX_AGE) {
            errors.add(new ValidationError("Weight must be in range [" + MIN_WEIGHT + ": " + MAX_WEIGHT + "]"));
        }
        return errors;
    }

    public static Map<String, List<ValidationError>> task19(List<Animal> animals) {
        // Животные, в записях о которых есть ошибки: вернуть имя и список ошибок

        return animals
            .stream()
            .filter(animal -> !validateAnimal(animal).isEmpty())
            .collect(
                Collectors.toMap(
                    Animal::name,
                    Tasks::validateAnimal
                )
            );
    }

    private static String errorsToStr(List<ValidationError> errors) {
        return errors
            .stream()
            .reduce(
                "",
                (str, error) -> str + error.getMessage() + "\n",
                String::concat
            );
    }

    public static Map<String, String> task20(List<Animal> animals) {
        // Сделать результат предыдущего задания более читабельным:
        // вернуть имя и названия полей с ошибками, объединенные в строку
        var result = task19(animals);
        return result
            .entrySet()
            .stream()
            .map(entry -> Map.entry(entry.getKey(), errorsToStr(entry.getValue())))
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue
                )
            );
    }
}
