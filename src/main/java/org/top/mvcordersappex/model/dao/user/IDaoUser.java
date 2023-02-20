package org.top.mvcordersappex.model.dao.user;


import org.top.mvcordersappex.model.entity.User;

// DAO-интерфейс пользователя
public interface IDaoUser {
    User getUserByLogin(String login);
    User addUser(User user);
}
