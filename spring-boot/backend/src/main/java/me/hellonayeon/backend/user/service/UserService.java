package me.hellonayeon.backend.user.service;

import me.hellonayeon.backend.user.dao.UserDao;
import me.hellonayeon.backend.user.dto.param.CreateUserParam;
import me.hellonayeon.backend.user.dto.request.JoinRequest;
import me.hellonayeon.backend.user.dto.response.JoinResponse;
import me.hellonayeon.backend.user.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	private final UserDao dao;
	private final PasswordEncoder encoder;

	public UserService(UserDao dao, PasswordEncoder encoder) {
		this.dao = dao;
		this.encoder = encoder;
	}

	public HttpStatus checkIdDuplicate(String id) {
		isExistUserId(id);
		return HttpStatus.OK;
	}

	@Transactional
	public JoinResponse join(JoinRequest req) {

		// 아이디 중복 확인
		isExistUserId(req.getId());

		// 패스워드 일치 확인
		checkPwd(req.getPwd(), req.getCheckPwd());

		// 회원 정보 생성
		String encodedPwd = encoder.encode(req.getPwd());
		CreateUserParam param = new CreateUserParam(req, encodedPwd);

		Integer result = dao.createUser(param);
		if (result == 0) {
			throw new UserException("회원 등록을 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new JoinResponse(req.getId());
	}

	private void isExistUserId(String id) {
		Integer result = dao.isExistUserId(id);
		if (result == 1) {
			throw new UserException("이미 사용중인 아이디입니다.", HttpStatus.BAD_REQUEST);
		}
	}

	private void checkPwd(String pwd, String checkPwd) {
		if (!pwd.equals(checkPwd)) {
			throw new UserException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}
	}
}




