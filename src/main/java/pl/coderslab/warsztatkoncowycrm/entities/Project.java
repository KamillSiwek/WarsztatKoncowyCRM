package pl.coderslab.warsztatkoncowycrm.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.URL;
import pl.coderslab.warsztatkoncowycrm.DTO.ProjectDto;
import pl.coderslab.warsztatkoncowycrm.DTO.UserDto;
import pl.coderslab.warsztatkoncowycrm.entities.embeddables.Creation;
import pl.coderslab.warsztatkoncowycrm.entities.embeddables.ProjectStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Embedded private Creation projectCreation = new Creation();
  @NotNull private String projectName;
  private String projectDescription;

  @URL(
      regexp =
          "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]"
              + "{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$")
  private String projectWebsite;

  private String projectIdentificator;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<User> projectUsers = new ArrayList<>();

  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
  private List<Task> taskList = new ArrayList<>();

  private boolean projectActivityStatus;

  @Embedded private ProjectStatus projectStatus = new ProjectStatus();

  public Project() {}

  public Project(@NotNull String projectName) {
    this.projectName = projectName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Creation getProjectCreation() {
    return projectCreation;
  }

  public void setProjectCreation(Creation projectCreation) {
    this.projectCreation = projectCreation;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getProjectDescription() {
    return projectDescription;
  }

  public void setProjectDescription(String projectDescription) {
    this.projectDescription = projectDescription;
  }

  public String getProjectWebsite() {
    return projectWebsite;
  }

  public void setProjectWebsite(String projectWebsite) {
    this.projectWebsite = projectWebsite;
  }

  public String getProjectIdentificator() {
    return projectIdentificator;
  }

  public void setProjectIdentificator(String projectIdentificator) {
    this.projectIdentificator = projectIdentificator;
  }

  public List<User> getProjectUsers() {
    return projectUsers;
  }

  public void setProjectUsers(List<User> projectUsers) {
    this.projectUsers = projectUsers;
  }

  public List<Task> getTaskList() {
    return taskList;
  }

  public void setTaskList(List<Task> taskList) {
    this.taskList = taskList;
  }

  public boolean isProjectActivityStatus() {
    return projectActivityStatus;
  }

  public void setProjectActivityStatus(boolean projectActivityStatus) {
    this.projectActivityStatus = projectActivityStatus;
  }

  public ProjectStatus getProjectStatus() {
    return projectStatus;
  }

  public void setProjectStatus(ProjectStatus projectStatus) {
    this.projectStatus = projectStatus;
  }

  @Transient
  public ProjectDto toDto() {
    ProjectDto dto = new ProjectDto();
    dto.setId(this.getId());
    dto.setProjectName(this.getProjectName());
    return dto;
  }
}
