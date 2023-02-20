package org.top.mvcordersappex.model.dao.user;

import org.springframework.data.repository.CrudRepository;
import org.top.mvcordersappex.model.entity.User;


public interface UserRepository extends CrudRepository<User,Integer> {
    User findByLogin(String login);
}
