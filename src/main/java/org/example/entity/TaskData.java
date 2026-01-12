package org.example.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private final Set<Task> annsTasks;
    private final Set<Task> bobsTasks;
    private final Set<Task> carolsTasks;
    private final Set<Task> unassignedTasks;

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

}
