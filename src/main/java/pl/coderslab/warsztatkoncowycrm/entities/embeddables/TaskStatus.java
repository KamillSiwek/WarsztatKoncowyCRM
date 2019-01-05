package pl.coderslab.warsztatkoncowycrm.entities.embeddables;

import pl.coderslab.warsztatkoncowycrm.enums.Priority;
import pl.coderslab.warsztatkoncowycrm.enums.Status;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;

@Embeddable
public class TaskStatus {
    @Column
    private Priority priority;

    @Column private Status status;

    @PrePersist
    public void prePersist() {
        priority = Priority.NORMAL;
        status = Status.AWAITING_ASSIGNMENT;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
