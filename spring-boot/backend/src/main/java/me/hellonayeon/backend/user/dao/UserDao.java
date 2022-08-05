package me.hellonayeon.backend.user.dao;

import me.hellonayeon.backend.user.domain.User;
import me.hellonayeon.backend.user.dto.param.CreateUserParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

	Integer isExistUserId(String id);

	Integer createUser(CreateUserParam param);
}
