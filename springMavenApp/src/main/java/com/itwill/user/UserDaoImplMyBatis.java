package com.itwill.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class UserDaoImplMyBatis implements UserDao {
	public static final String NAMESPACE = "com.itwill3.dao.UserMapper";
	private SqlSession sqlSession;
	
	public UserDaoImplMyBatis() {
		System.out.println("#### UserDaoImplMyBatis() : 디폴트생성자 호출  ");
	}
		
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("#### UserDaoImplMyBatis() : setsqlSession ("+sqlSession+")");
		this.sqlSession = sqlSession;
	}

	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	


	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : create() 호출  ");
		return 0;
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	
	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : update() 호출  ");
		return 0;
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	
	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : remove() 호출  ");
		return 0;
	}
	
	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서
	 * User 도메인클래스에 저장하여 반환
	 */
	
	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : findUser() 호출  ");
		return sqlSession.selectOne(NAMESPACE+".findUser",userId);
	}
	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 
	 * List<User> 콜렉션 에 저장하여 반환
	 */
	
	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatis : findUserList 호출  ");
		return sqlSession.selectList(NAMESPACE+".findUserList");
	}
	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	
	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImplMyBatis : existedUser() 호출  ");
		return true;
	}
	
}





