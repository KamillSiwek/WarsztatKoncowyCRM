package pl.coderslab.warsztatkoncowycrm.DTO;

import pl.coderslab.warsztatkoncowycrm.entities.Task;
import pl.coderslab.warsztatkoncowycrm.entities.User;
import pl.coderslab.warsztatkoncowycrm.entities.embeddables.ProjectStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectDto {

  private Long id;
  private java.util.Date creationDate;
  private String projectName;
  private String projectDescription;
  private String projectWebsite;
  private String projectIdentificator;
  private List<User> projectUsers = new ArrayList<>();
  private List<Task> taskList = new ArrayList<>();
  private boolean projectActivityStatus;


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

  public List<User> getProjectUsers() {
    return projectUsers;
  }

  public void setProjectUsers(List<User> projectUsers) {
    this.projectUsers = projectUsers;
  }

  public boolean isProjectActivity() {
    return projectActivityStatus;
  }

  public void setProjectActivity(boolean projectActivityStatus) {
    this.projectActivityStatus = projectActivityStatus;
  }


  public String getProjectIdentificator() {
    return projectIdentificator;
  }

  public void setProjectIdentificator(String projectIdentificator) {
    this.projectIdentificator =
        org.apache.commons.lang3.StringUtils.stripAccents(this.projectName).replace(' ', '_');
  }
}
