package crud.service;

import crud.entity.User;
import crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User create(User user) {
        user.setId(null);
        userRepository.save(user);
        return user;
    }

    @Transactional
    public User read(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }

    @Transactional
    public User update(User user) {
        User updateUser = userRepository.findById(user.getId()).orElseThrow(() -> new EntityNotFoundException("User not found!"));
        if (Objects.nonNull(user.getName()))
            updateUser.setName(user.getName());
        return updateUser;
    }

    @Transactional
    public boolean delete(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
