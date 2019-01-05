package pl.coderslab.warsztatkoncowycrm.DTO;

import pl.coderslab.warsztatkoncowycrm.validators.UniqueLogin;

import javax.validation.constraints.NotEmpty;

public class UserDto {
  private Long id;
  @NotEmpty @UniqueLogin private String login;

  private String name;
  private String surname;
  @NotEmpty private String password;

  public UserDto() {}

  public UserDto(String login, String name, String surname, String password) {
    this.login = login;
    this.name = name;
    this.surname = surname;
    this.password = password;
  }

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
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
