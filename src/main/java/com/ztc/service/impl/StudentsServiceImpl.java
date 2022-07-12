package com.ztc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztc.entity.Roles;
import com.ztc.entity.Student_export;
import com.ztc.entity.Students;
import com.ztc.service.StudentsService;
import com.ztc.mapper.StudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【students】的数据库操作Service实现
 * @createDate 2022-04-30 12:02:31
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students>
        implements StudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public List<Students> findAll(Students students) {
        return studentsMapper.findAll(students);
    }

    @Override
    public int count(Students students) {
        return studentsMapper.count(students);
    }

    @Override
    public List<Student_export> exportstudents(Students students) {
        return studentsMapper.exportstudents(students);
    }

    @Override
    public int upddelete(int id) {
        return studentsMapper.upddelete(id);
    }

    @Override
    public List<Students> notinId(Students students) {
        return studentsMapper.notinId(students);
    }

    @Override
    public List<Students> findall(Students students) {
        return studentsMapper.findall(students);
    }

    @Override
    public int countAll(Students students) {
        return studentsMapper.countAll(students);
    }

    @Override
    public List<Roles> getRolesByUserId(Integer usersId) {
        return studentsMapper.getRolesByUserId(usersId);
    }
}




