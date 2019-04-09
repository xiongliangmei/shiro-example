package com.gitub.xl137010393.dao;



import com.gitub.xl137010393.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Component
public interface IUserDao {

    List<User> findAll();
}
