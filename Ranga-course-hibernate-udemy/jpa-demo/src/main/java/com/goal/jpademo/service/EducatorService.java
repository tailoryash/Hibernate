package com.goal.jpademo.service;

import com.goal.jpademo.entity.jdbc.Educator;
import com.goal.jpademo.jdbcdao.EducatorDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducatorService {

    private final EducatorDao educatorDao;

    public List<Educator> findAllEducators() {
        return educatorDao.findAll();
    }

    public Educator findEducator(int id) {
        return educatorDao.findById(id);
    }

    public int deleteEducator(int id) {
        return educatorDao.deleteById(id);
    }

    public int saveEducator(Educator educator) {
        return educatorDao.insert(educator);
    }

    public int updateEducator(Educator educator) {
        return educatorDao.update(educator);
    }

}
