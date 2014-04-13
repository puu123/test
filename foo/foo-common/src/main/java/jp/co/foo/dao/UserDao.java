package jp.co.foo.dao;

import jp.co.foo.domain.User;

public interface UserDao {
	
	User findByAccount(String account);
}
