package pl.coderslab.warsztatkoncowycrm.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.warsztatkoncowycrm.DTO.UserDto;
import pl.coderslab.warsztatkoncowycrm.Services.BaseService;
import pl.coderslab.warsztatkoncowycrm.entities.User;
import pl.coderslab.warsztatkoncowycrm.repositories.UserRepository;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService implements BaseService<UserDto,Long> {

    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        
    }

    @Override
    public UserDto save(UserDto dto) {
        User user = new User(dto.getName());
        user.setName(dto.getName());
        userRepository.save(user);
        return user.toDto();
    }

    @Override
    public UserDto update(UserDto dto) {
        User user = userRepository.findUserById(dto.getId());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user = userRepository.save(user);
        return user.toDto();
    }

    @Override
    public UserDto find(Long id) {
        User user = userRepository.findUserById(id);
        if (Objects.nonNull(user)) {
            return user.toDto();
        }
        return null;
    }

    @Override
    public Boolean remove(Long id) {
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
        return true;
    }

    @Override
    public Collection<UserDto> getAll() {
        return userRepository.findAll().stream().filter(Objects::nonNull).map(User::toDto).collect(Collectors.toList());
    }
}

