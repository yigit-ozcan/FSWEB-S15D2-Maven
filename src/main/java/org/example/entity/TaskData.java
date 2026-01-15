package org.example.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks,
                    Set<Task> bobsTasks,
                    Set<Task> carolsTasks,
                    Set<Task> unassignedTasks) {
        this.annsTasks = Collections.unmodifiableSet(Set.copyOf(annsTasks));
        this.bobsTasks = Collections.unmodifiableSet(Set.copyOf(bobsTasks));
        this.carolsTasks = Collections.unmodifiableSet(Set.copyOf(carolsTasks));
        this.unassignedTasks = Collections.unmodifiableSet(Set.copyOf(unassignedTasks));
    }

    public Set<Task> getTasks(String name) {
        if (name == null) {
            return Set.of();
        }

        switch (name.toLowerCase()) {
            case "unassigned":
                return unassignedTasks;
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                allTasks.addAll(unassignedTasks);
                return Collections.unmodifiableSet(allTasks);
            default:
                return Set.of();
        }
    }

    public Set<Task> getUnion(Set<Task>... sets) {
        if (sets == null) {
            return Set.of();
        }

        Set<Task> result = new HashSet<>();
        for (Set<Task> set : sets) {
            if (set != null) {
                result.addAll(set);
            }
        }

        return Collections.unmodifiableSet(result);
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        if (set1 == null || set2 == null) {
            return Set.of();
        }

        Set<Task> result = new HashSet<>(set1);
        result.retainAll(set2);
        return Collections.unmodifiableSet(result);
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        if (set1 == null) {
            return Set.of();
        }

        Set<Task> result = new HashSet<>(set1);
        if (set2 != null) {
            result.removeAll(set2);
        }

        return Collections.unmodifiableSet(result);
    }

}
