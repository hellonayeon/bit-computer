package me.hellonayeon.backend.user.dao;

import me.hellonayeon.backend.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

	int getId(User dto);
	int account(User dto);
	User login(User dto);
}
