package com.hashlama.hackathon.dal;

import com.hashlama.hackathon.logic.user.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends PagingAndSortingRepository<UserEntity, String> {

    Boolean existsByUsernameAndPassword(String username, String password);

    Boolean existsByUsername(String username);

    Optional<UserEntity> findByUsername(String username);

    List<UserEntity> findUserEntitiesByCity(String city);

    List<UserEntity> findUserEntitiesByIsIsolatedFalse();

    List<UserEntity> findUserEntitiesByIsIsolatedTrue();
}
