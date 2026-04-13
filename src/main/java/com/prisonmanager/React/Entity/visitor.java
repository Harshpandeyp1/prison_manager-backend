package com.prisonmanager.React.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String prisonerid;
    private String name;
    private String relationship;
    private LocalDate visitdate;
    private String status;
    private LocalDateTime visitin;

    public visitor() {
    }

    public visitor(long id, String prisonerid, String name, String relationship, LocalDate visitdate, String status, LocalDateTime visitin) {
        this.id = id;
        this.prisonerid = prisonerid;
        this.name = name;
        this.relationship = relationship;
        this.visitdate = visitdate;
        this.status = status;
        this.visitin = visitin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrisonerid() {
        return prisonerid;
    }

    public void setPrisonerid(String prisonerid) {
        this.prisonerid = prisonerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public LocalDate getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(LocalDate visitdate) {
        this.visitdate = visitdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getVisitin() {
        return visitin;
    }

    public void setVisitin(LocalDateTime visitin) {
        this.visitin = visitin;
    }
}
