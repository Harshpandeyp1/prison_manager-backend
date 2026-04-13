package com.prisonmanager.React.Repo;

import com.prisonmanager.React.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);
    List<User> findTop10ByOrderByLoginTimeDesc();
}
