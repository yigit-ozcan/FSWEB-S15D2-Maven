package org.example.entity;

import java.util.Collections;
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
}
