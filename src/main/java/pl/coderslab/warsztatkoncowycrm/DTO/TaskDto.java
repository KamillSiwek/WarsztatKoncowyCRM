package pl.coderslab.warsztatkoncowycrm.DTO;

import pl.coderslab.warsztatkoncowycrm.entities.Project;
import pl.coderslab.warsztatkoncowycrm.entities.User;

import java.util.Date;

public class TaskDto {

  private Long id;

  private java.util.Date creationDate;

  private String topic;

  private Project project;

  private TaskStatus taskStatus;
  private TaskPriority taskPriority;
  private User currentAttachedUser;

  public TaskDto() {}

  public TaskDto(String topic, Project project) {
    this.topic = topic;
    this.project = project;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
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

  public TaskPriority getTaskPriority() {
    return taskPriority;
  }

  public void setTaskPriority(TaskPriority taskPriority) {
    this.taskPriority = taskPriority;
  }

  public User getCurrentAttachedUser() {
    return currentAttachedUser;
  }

  public void setCurrentAttachedUser(User currentAttachedUser) {
    this.currentAttachedUser = currentAttachedUser;
  }
}
