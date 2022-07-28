package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0.0;
        int countSubject = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                sumScore += subject.getScore();
                countSubject++;
            }
        }
        return sumScore / countSubject;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            labels.add(new Label(pupil.getName(), averageScore(List.of(pupil))));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new HashMap<>();
        List<Label> labels = new ArrayList<>();
        int countPupil = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                if (subject != null) {
                    if (!map.containsKey(subject.getName())) {
                        map.put(subject.getName(), subject.getScore());
                    } else {
                        map.put(subject.getName(), map.get(subject.getName()) + subject.getScore());
                    }
                }
            }
            countPupil++;
        }
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            labels.add(new Label(item.getKey(), (double) item.getValue() / countPupil));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double sumScore = 0.0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                sumScore += subject.getScore();
            }
            labels.add(new Label(pupil.getName(), sumScore));
            sumScore = 0.0;
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new HashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                if (subject != null) {
                    if (!map.containsKey(subject.getName())) {
                        map.put(subject.getName(), subject.getScore());
                    } else {
                        map.put(subject.getName(), map.get(subject.getName()) + subject.getScore());
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            labels.add(new Label(item.getKey(), item.getValue()));
        }

        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}