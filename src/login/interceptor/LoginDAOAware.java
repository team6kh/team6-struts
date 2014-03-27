package login.interceptor;

import login.dao.LoginDAO;

public interface LoginDAOAware {
	public void setLoginDAO(LoginDAO loginDAO);
}
