package pl.coderslab.warsztatkoncowycrm.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.warsztatkoncowycrm.DTO.TaskDto;
import pl.coderslab.warsztatkoncowycrm.Services.BaseService;
import pl.coderslab.warsztatkoncowycrm.entities.Task;
import pl.coderslab.warsztatkoncowycrm.repositories.TaskRepository;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TaskService implements BaseService<TaskDto, Long> {

  private final TaskRepository taskRepository;

  @Autowired
  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public TaskDto save(TaskDto dto) {
    Task task = new Task(dto.getTopic());
    task.setTopic(dto.getTopic());
    taskRepository.save(task);
    return task.toDto();
  }

  @Override
  public TaskDto update(TaskDto dto) {
    Task task = taskRepository.findTaskById(dto.getId());
    task.setTopic(dto.getTopic());
    task.setProject(dto.getProject());
    task.setTaskStatus(dto.getTaskStatus());
    taskRepository.save(task);
    return task.toDto();
  }

  @Override
  public TaskDto find(Long id) {

    Task task = taskRepository.findTaskById(id);
    if (Objects.nonNull(task)) {
      return task.toDto();
    }
    return null;
  }

  @Override
  public Boolean remove(Long id) {

    Task task = taskRepository.findTaskById(id);
    taskRepository.delete(task);
    return true;
  }

  @Override
  public Collection<TaskDto> getAll() {

    return taskRepository
        .findAll()
        .stream()
        .filter(Objects::nonNull)
        .map(Task::toDto)
        .collect(Collectors.toList());
  }
}
