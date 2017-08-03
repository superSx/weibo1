package com.core.dao;

import com.core.domin.LoginBean;
import com.core.domin.RegistBean;

public interface UserDao {
	public boolean login(LoginBean loginBean);
	public boolean regist(RegistBean registBean);
	
	
}
