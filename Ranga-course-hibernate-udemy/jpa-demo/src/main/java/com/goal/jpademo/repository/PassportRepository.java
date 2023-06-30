package com.goal.jpademo.repository;

import com.goal.jpademo.entity.relation.Passport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PassportRepository {

    //EM is the interface of PC
    @PersistenceContext
    EntityManager entityManager;

    public Passport findBydId(int id){
        return entityManager.find(Passport.class,id);
    }

    // if id is present in object add else update
    public Passport insertUpdate(Passport passport){
        return entityManager.merge(passport);
    }

    public void deletePassport(int id){
        entityManager.remove(findBydId(id));
    }

}
