package com.prisonmanager.React.Repo;


import com.prisonmanager.React.Entity.staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface staffRepository extends JpaRepository<staff, Long> {
}
