package login.action;

import user.dto.UserDTO;
import login.dao.LoginDAO;
import login.interceptor.LoginDAOAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class LoginAction implements Action, Preparable, ModelDriven, LoginDAOAware {
	// 도메인 오브젝트
	UserDTO userDto;
	LoginDAO loginDao;
	
	public String execute() throws Exception {
		// LoginDAO loginDao = new LoginDAO();
		if (loginDao.loginCheck(userDto)){
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}
	
	// Preparable 인터페이스의 prepare
	public void prepare() throws Exception {
		userDto = new UserDTO();		
	}
	
	// ModelDriven 인터페이스의 getModel 구현
	public Object getModel() {
		return userDto;		
	}
	
	// LoginDAOInterceptor에서 LoginDAO를 주입한다.
	public void setLoginDAO(LoginDAO loginDao) {
		this.loginDao = loginDao;
	}
}