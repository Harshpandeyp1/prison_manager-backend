package com.prisonmanager.React.Repo;

import com.prisonmanager.React.Entity.Inmate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InmateRepository extends JpaRepository<Inmate, Long> {
}
