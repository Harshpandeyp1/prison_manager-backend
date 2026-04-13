package com.prisonmanager.React.service;

import com.prisonmanager.React.Entity.Inmate;
import com.prisonmanager.React.Repo.InmateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class service {
    @Autowired
    private InmateRepository repo;

    public Inmate save(Inmate inmate) {
        return repo.save(inmate);
}

    public List<Inmate> getAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Inmate releaseInmate(Long id) {
        Inmate inmate = repo.findById(id).orElseThrow(() -> new RuntimeException("Inmate not found"));
        inmate.setStatus("Released");
        return repo.save(inmate);
    }
}
