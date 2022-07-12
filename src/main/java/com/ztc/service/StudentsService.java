package com.ztc.service;

import com.ztc.entity.Roles;
import com.ztc.entity.Student_export;
import com.ztc.entity.Students;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 22838
 * @description 针对表【students】的数据库操作Service
 * @createDate 2022-04-30 12:02:31
 */
public interface StudentsService extends IService<Students> {

    public List<Students> findAll(Students students);

    public int count(Students students);

    public List<Student_export> exportstudents(Students students);

    public int upddelete(int id);

    public List<Students> notinId(Students students);

    //咨询经理
    public List<Students> findall(Students students);

    public int countAll(Students students);


    public List<Roles> getRolesByUserId(Integer usersId);
}
