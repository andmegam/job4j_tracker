package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class JobTest {

    @Test
    public void whenJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("1 task", 1),
                new Job("3 task", 3),
                new Job("2 task", 2),
                new Job("4 task", 4)
        );
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("1 task", 1),
                new Job("2 task", 2),
                new Job("3 task", 3),
                new Job("4 task", 4)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("1 task", 1),
                new Job("3 task", 3),
                new Job("2 task", 2),
                new Job("4 task", 4)
        );
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("4 task", 4),
                new Job("3 task", 3),
                new Job("2 task", 2),
                new Job("1 task", 1)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("1 task", 1),
                new Job("3 task", 3),
                new Job("2 task", 2),
                new Job("4 task", 4)
        );
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("1 task", 1),
                new Job("2 task", 2),
                new Job("3 task", 3),
                new Job("4 task", 4)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("1 task", 1),
                new Job("3 task", 3),
                new Job("2 task", 2),
                new Job("4 task", 4)
        );
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("4 task", 4),
                new Job("3 task", 3),
                new Job("2 task", 2),
                new Job("1 task", 1)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenJobAscByNameAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("1 task", 1),
                new Job("3 task", 3),
                new Job("2 task", 2),
                new Job("Fix bug", 2),
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        jobs.sort(cmpNamePriority);
        List<Job> expected = Arrays.asList(
                new Job("1 task", 1),
                new Job("2 task", 2),
                new Job("3 task", 3),
                new Job("Fix bug", 0),
                new Job("Fix bug", 1),
                new Job("Fix bug", 2)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenJobAscByPriorityDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("1 task", 1),
                new Job("3 task", 3),
                new Job("2 task", 2),
                new Job("Fix bug", 2),
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobDescByName());
        jobs.sort(cmpNamePriority);
        List<Job> expected = Arrays.asList(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1),
                new Job("1 task", 1),
                new Job("Fix bug", 2),
                new Job("2 task", 2),
                new Job("3 task", 3)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }

    @Test
    public void whenJobAscByNameDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("1 task", 1),
                new Job("3 task", 3),
                new Job("2 task", 2),
                new Job("Fix bug", 2),
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        jobs.sort(cmpNamePriority);
        List<Job> expected = Arrays.asList(
                new Job("1 task", 1),
                new Job("2 task", 2),
                new Job("3 task", 3),
                new Job("Fix bug", 2),
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(jobs).containsExactlyElementsOf(expected);
    }
}