package com.itwill.user.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;
@Service("userService2")
public class UserServiceImplAnnotation2 implements UserService {
	@Autowired
	@Qualifier("userDaoJDBC2")
	private UserDao userDao;
	
	public UserServiceImplAnnotation2() {
		System.out.println("#### UserServiceImplAnnotation2() : 기본생성자호출");
	}
	public UserServiceImplAnnotation2(UserDao userDao) {
		this.userDao = userDao;
		System.out.println("#### UserServiceImplAnnotation2(UserDao userDao) : 생성자호출");
	}
	public void setUserDao(UserDao userDao) {
		System.out.println("#### UserServiceImplAnnotation2 : setUserDao(" + userDao + ") 호출");
		this.userDao = userDao;
	}
	public int create(User user) throws ExistedUserException, Exception {
		System.out.println("#### UserServiceImplAnnotation2 : create() 호출");
		// 1. 아이디중복체크
		if (userDao.existedUser(user.getUserId())) {
			throw new ExistedUserException(user.getUserId() + " 는 이미존재하는 아이디입니다");
		}
		
		return userDao.create(user);
	}
	/*
	 * 회원리스트
	 */
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserServiceImplAnnotation2 : findUserList() 호출  ");
		return userDao.findUserList();
	}
	/*
	 * 아이디중복체크
	 * 
	 */
	public boolean isDuplcateUserId(String userId) throws Exception {
		System.out.println("#### UserServiceImplAnnotation2 : isDuplcateUserId() 호출  ");
		boolean isExist = userDao.existedUser(userId);
		if (isExist) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 회원 로그인
	 */
	public User login(String userId, String password)
			throws UserNotFoundException, PasswordMismatchException, Exception {
		System.out.println("#### UserServiceImplAnnotation2 : login() 호출");
		// 1.아이디존재여부
		User findUser = userDao.findUser(userId);
		if (findUser == null) {
			throw new UserNotFoundException(userId + " 는 존재하지않는 아이디입니다");
		}
		// 2.패쓰워드일치여부
		if (!findUser.isMatchPassword(password)) {
			throw new PasswordMismatchException("패쓰워드가 일치하지않습니다");
		}
		return findUser;
	}
	/*
	 * 회원1명보기
	 */
	public User findUser(String userId) throws UserNotFoundException, Exception {
		System.out.println("#### UserServiceImplAnnotation2 : findUser() 호출");
		User findUser = userDao.findUser(userId);
		if (findUser == null) {
			throw new UserNotFoundException(userId + " 는 존재하지않는 아이디입니다.");
		}
		return findUser;
	}
	/*
	 * 회원탈퇴
	 */
	public int remove(String userId) throws Exception {
		System.out.println("#### UserServiceImplAnnotation2 : remove() 호출");
		return userDao.remove(userId);
	}
	/*
	 * 회원수정
	 */
	public int update(User user) throws Exception {
		System.out.println("#### UserServiceImplAnnotation2 : update() 호출");
		return userDao.update(user);
	}
	
	
	
	
	
	
}
