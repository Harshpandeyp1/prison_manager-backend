package com.prisonmanager.React.Repo;

import com.prisonmanager.React.Entity.visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface visitorRepository extends JpaRepository<visitor,Long> {
    List<visitor> findByPrisonerid(String Prisonerid);
}
