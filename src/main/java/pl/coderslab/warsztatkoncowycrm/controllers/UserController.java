package pl.coderslab.warsztatkoncowycrm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztatkoncowycrm.DTO.UserDto;
import pl.coderslab.warsztatkoncowycrm.Services.impl.UserService;


import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
public class UserController {



  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  public Result post(@RequestBody UserDto userDto) {
    return Result.ok(userService.save(userDto));
  }

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public Result get(@PathVariable Long id) {
    return Result.ok(userService.find(id));
  }

  @GetMapping(path = "/all", produces = APPLICATION_JSON_VALUE)
  public Result getAll() {
    return Result.ok(userService.getAll());
  }

  @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public Result put(@RequestBody UserDto dto) {
    return Result.ok(userService.update(dto));
  }

  @DeleteMapping(path = "/{id}")
  public Result delete(@PathVariable Long id) {
    return Result.ok(userService.remove(id));
  }
}
