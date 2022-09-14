package ru.job4j.stream;

import ru.job4j.map.Pupil;
import ru.job4j.map.Subject;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> pupils) {
        return pupils
                .flatMapToInt(p -> p.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore))
                .average()
                .orElse(0D);

    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> pupils) {
        return pupils.map(p -> new Tuple(p.getName(), averageScore(List.of(p).stream())))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> pupils) {
        return pupils.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> pupils) {
        return pupils.map(p -> new Tuple(
                p.getName(),
                p.getSubjects().stream()
                        .mapToDouble(Subject::getScore)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> pupils) {
        return pupils.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
