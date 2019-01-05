package pl.coderslab.warsztatkoncowycrm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztatkoncowycrm.DTO.ProjectDto;
import pl.coderslab.warsztatkoncowycrm.Services.impl.ProjectService;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class ProjectController {

  private final ProjectService projectService;

  @Autowired
  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  public Result post(@RequestBody ProjectDto projectDto) {
    return Result.ok(projectService.save(projectDto));
  }

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public Result get(@RequestBody Long id) {
    return Result.ok(projectService.find(id));
  }

  @GetMapping(path = "/all", produces = APPLICATION_JSON_VALUE)
  public Result getAll() {
    return Result.ok(projectService.getAll());
  }

  @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public Result put(@RequestBody ProjectDto projectDto) {
    return Result.ok(projectService.update(projectDto));
  }

  @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public Result delete(@PathVariable Long id) {
    return Result.ok(projectService.remove(id));
  }
}
