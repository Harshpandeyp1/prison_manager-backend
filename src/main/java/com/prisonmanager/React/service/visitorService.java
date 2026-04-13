package com.prisonmanager.React.service;

import com.prisonmanager.React.Entity.visitor;
import com.prisonmanager.React.Repo.visitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class visitorService {

    @Autowired
    private visitorRepository repo;

    public visitor addVisitor(visitor visitor){
        visitor.setStatus("PRESENT");
        return repo.save(visitor);
    }
    public List<visitor>getAllVisitor(){
        return repo.findAll();
    }
    public List<visitor>getVisitorByPrisoner(String prisonerid){
        return repo.findByPrisonerid(prisonerid);
    }
}
