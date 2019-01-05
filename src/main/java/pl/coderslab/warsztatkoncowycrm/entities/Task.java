package pl.coderslab.warsztatkoncowycrm.entities;

import pl.coderslab.warsztatkoncowycrm.DTO.TaskDto;
import pl.coderslab.warsztatkoncowycrm.entities.embeddables.Creation;
import pl.coderslab.warsztatkoncowycrm.entities.embeddables.TaskStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Embedded private Creation creation = new Creation();
  @NotNull private String topic;
  @ManyToOne private Project project;
 @Embedded
 private TaskStatus taskStatus = new TaskStatus();

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private User currentAttachedUser;

  public Task() {}

  public Task(String topic) {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Creation getCreation() {
    return creation;
  }

  public void setCreation(Creation creation) {
    this.creation = creation;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public TaskStatus getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(TaskStatus taskStatus) {
    this.taskStatus = taskStatus;
  }


  public User getCurrentAttachedUser() {
    return currentAttachedUser;
  }

  public void setCurrentAttachedUser(User currentAttachedUser) {
    this.currentAttachedUser = currentAttachedUser;
  }

  @Transient
  public TaskDto toDto() {
    TaskDto dto = new TaskDto();
    dto.setId(this.getId());
    dto.setTopic(this.getTopic());
    dto.setProject(this.getProject());
    return dto;
  }
}
