package com.sschen.mybatis.provider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sschen.mybatis.model.UserInfo;

public class UserInfoTest {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		List<UserInfo> userInfos = null;
		try {
			userInfos = session.selectList("com.mybatislearn.mapper.getUserInfo");
		} finally {
			session.close();
		}
		System.out.println(userInfos.size());
		for (UserInfo userInfo : userInfos) {
			System.out.println(userInfo.toString());
		}
	}
}
