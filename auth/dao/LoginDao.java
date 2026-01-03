//package com.example.demo.dao;
//
//import com.example.demo.bean.User;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//import java.util.Optional;
//
//@Repository
//public interface LoginDao extends CrudRepository<User, Integer> {
//
//    // Spring Data JPA derives the query from the method name
//    Optional<User> findByEmail(String email);
//}

package com.example.auth.dao;

import com.example.auth.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginDao extends CrudRepository<User, Integer> {

    /**
     * JPA automatically generates the SQL:
     * SELECT * FROM user WHERE email = ?
     */
    Optional<User> findByEmail(String email);

}