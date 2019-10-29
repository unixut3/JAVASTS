package com.mybatis3.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Address;

public class AddressDao {
	
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE=
			"com.mybatis3.mapper.AddressMapper.";
	public AddressDao() {
		InputStream in=null;
		try {
			in=Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory = 
					new SqlSessionFactoryBuilder()
					.build(in);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Address findAddressById(Integer addrId) {
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Address findAdress=
				sqlSession.selectOne(NAMESPACE+"findAddressById",addrId);
		sqlSession.close();
		return findAdress;
	}
	public Address findAddressByIdResultMap(Integer addrId) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Address findAdress=
				sqlSession.selectOne(
						NAMESPACE+"findAddressByIdResultMap",addrId);
		sqlSession.close();
		return findAdress;
	}
	
	
}











