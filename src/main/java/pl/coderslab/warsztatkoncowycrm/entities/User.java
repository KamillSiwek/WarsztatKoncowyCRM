package pl.coderslab.warsztatkoncowycrm.entities;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.warsztatkoncowycrm.DTO.UserDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
  @Id private Long id;

  @Column(unique = true)
  private String login;

  @NotNull private String name;
  @NotNull private String surname;
  @NotNull private String password;
  @Transient private String plainTextPassword;

  @ManyToMany(mappedBy = "projectUsers")
  private List<Project> projectList = new ArrayList<>();

  @ManyToMany(mappedBy = "currentAttachedUser")
  private List<Task> taskList = new ArrayList<>();

  public User() {}

  public User(String name) {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password =
        password == null || password.isEmpty()
            ? password
            : BCrypt.hashpw(password, BCrypt.gensalt());
  }
  public boolean passwordMatches(String plainTextPassword) {
    return BCrypt.checkpw(plainTextPassword, this.password);
  }

  public List<Project> getProjectList() {
    return projectList;
  }

  public void setProjectList(List<Project> projectList) {
    this.projectList = projectList;
  }

  public List<Task> getTaskList() {
    return taskList;
  }

  public void setTaskList(List<Task> taskList) {
    this.taskList = taskList;
  }

  @Transient
  public UserDto toDto() {
    UserDto dto = new UserDto();
    dto.setId(this.getId());
    dto.setName(this.getName());
    dto.setSurname(this.getSurname());
    return dto;
  }
}
