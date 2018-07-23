package com.example.demosql.service;

import com.example.demosql.entity.Grade;
import com.example.demosql.repositroy.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService{
    @Autowired
    private GradeRepository gradeRepository;
    @Override
    public List<Grade> getAllGrade() {
        return gradeRepository.findAll();
    }
}
