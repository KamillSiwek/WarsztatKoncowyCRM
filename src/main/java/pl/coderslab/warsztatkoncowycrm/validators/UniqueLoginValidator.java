package pl.coderslab.warsztatkoncowycrm.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.warsztatkoncowycrm.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

  @Autowired
  UserRepository userRepository;

  @Override
  public void initialize(UniqueLogin constraintAnnotation) {}

  public boolean isValid(String username, ConstraintValidatorContext context) {
    return username == null || userRepository.findUserByName(username) == null;
  }


}