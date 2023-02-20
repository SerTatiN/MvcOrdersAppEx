package org.top.mvcordersappex.model.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.top.mvcordersappex.model.entity.User;

@Service
public class DbDaoUser implements IDaoUser {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;


    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }


    @Override
    public User addUser(User user) {
        // перед добавлением пользователя захешируем его пароль
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }
}