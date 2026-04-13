package com.prisonmanager.React.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Inmate {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank
        private String cid;
        private String name;

        @NotNull
        private Integer age;
        private String crime;
        private String sentence;
        private String status = "Under Trial";

        private String block;





        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getCid() {
                return cid;
        }

        public void setCid(String cid) {
                this.cid = cid;
        }

        public Integer getAge() {
                return age;
        }

        public void setAge(Integer age) {
                this.age = age;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getCrime() {
                return crime;
        }

        public void setCrime(String crime) {
                this.crime = crime;
        }

        public String getSentence() {
                return sentence;
        }

        public void setSentence(String sentence) {
                this.sentence = sentence;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getBlock() {
                return block;
        }

        public void setBlock(String block) {
                this.block = block;
        }

        public Inmate() {} // REQUIRED by JPA

        public Inmate(String cid) {
                this.cid = cid;
        }

        @CreationTimestamp
        private LocalDateTime createdAt;

        public LocalDateTime getCreatedAt() {
                return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
                this.createdAt = createdAt;
        }
}
