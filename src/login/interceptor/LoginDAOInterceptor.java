package login.interceptor;

import login.dao.LoginDAO;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginDAOInterceptor implements Interceptor {
	
	LoginDAO loginDAO;
	
	public void init() {
		loginDAO = new LoginDAO(); // 서버 실행 시 DAO가 메모리에 올라간다.
	}
	
	public void destroy() {
		loginDAO = null;
	}
	
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		if (action instanceof LoginDAOAware) {
			LoginDAOAware loginDAOAware = (LoginDAOAware)action;
			loginDAOAware.setLoginDAO(loginDAO);
		}
		return invocation.invoke();
	}
}