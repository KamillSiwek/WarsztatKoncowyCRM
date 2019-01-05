package pl.coderslab.warsztatkoncowycrm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztatkoncowycrm.DTO.TaskDto;
import pl.coderslab.warsztatkoncowycrm.Services.impl.TaskService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/task")
public class TaskController {

  private final TaskService taskService;

  @Autowired
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  public Result post(@RequestBody TaskDto taskDto) {
    return Result.ok(taskService.save(taskDto));
  }

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public Result get(@RequestBody Long id) {
    return Result.ok(taskService.find(id));
  }

  @GetMapping(path = "/all", produces = APPLICATION_JSON_VALUE)
  public Result getAll() {
    return Result.ok(taskService.getAll());
  }

  @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public Result put(@RequestBody TaskDto taskDto) {
    return Result.ok(taskService.update(taskDto));
  }

  @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public Result delete(@PathVariable Long id) {
    return Result.ok(taskService.remove(id));
  }
}
