package pl.coderslab.warsztatkoncowycrm.Services.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.warsztatkoncowycrm.DTO.ProjectDto;
import pl.coderslab.warsztatkoncowycrm.Services.BaseService;
import pl.coderslab.warsztatkoncowycrm.entities.Project;
import pl.coderslab.warsztatkoncowycrm.repositories.ProjectRepository;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProjectService implements BaseService<ProjectDto, Long> {

  private final ProjectRepository projectRepository;

  public ProjectService(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @Override
  public ProjectDto save(ProjectDto dto) {
    Project project = new Project();
    project.setProjectName(dto.getProjectName());
    projectRepository.save(project);
    return project.toDto();
  }

  @Override
  public ProjectDto update(ProjectDto dto) {
    Project project = projectRepository.findProjectById(dto.getId());
    project.setProjectName(dto.getProjectName());
    project.setProjectDescription(dto.getProjectDescription());
    project.setProjectWebsite(dto.getProjectWebsite());
    project.setProjectIdentificator(
        org.apache.commons.lang3.StringUtils.stripAccents(dto.getProjectDescription())
            .replace(' ', '_'));
    return project.toDto();
  }

  @Override
  public ProjectDto find(Long id) {
    Project project = projectRepository.findProjectById(id);
    if (Objects.nonNull(project)) {
      return project.toDto();
    }
    return null;
  }

  @Override
  public Boolean remove(Long id) {
    Project project = projectRepository.findProjectById(id);
    projectRepository.delete(project);
    return true;
  }

  @Override
  public Collection<ProjectDto> getAll() {
    return projectRepository
        .findAll()
        .stream()
        .filter(Objects::nonNull)
        .map(Project::toDto)
        .collect(Collectors.toList());

  }
}
