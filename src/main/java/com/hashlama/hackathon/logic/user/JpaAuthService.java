package com.hashlama.hackathon.logic.user;

import com.hashlama.hackathon.dal.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JpaAuthService implements AuthService {

    private UserDao userDao;

    @Autowired
    public JpaAuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public ResponseEntity<?> authenticateUser(String username, String password) {
        if (this.userDao.existsByUsernameAndPassword(username, password))
            return ResponseEntity.ok(this.userDao.findByUsername(username));
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> addUser(String fullName, String username, String password, String phoneNumber, String city, Boolean isIsolated) {
        if(userDao.existsByUsername(username))
            return new ResponseEntity<>(
                    "User Already exists with the username: " + username,
                    HttpStatus.BAD_REQUEST);

        // Creating user
        UserEntity newUser = new UserEntity(fullName, username, password, phoneNumber, city, isIsolated);
        UserEntity result = userDao.save(newUser);

        return new ResponseEntity<>(
                "User created successfully" + result.toString(),
                HttpStatus.CREATED);
    }

    @Override
    public void cleanup() {
        this.userDao.deleteAll();
    }
}
