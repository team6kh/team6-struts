package board.test.action;

import board.test.dto.TestDTO;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.io.IOException;

public class DeleteTestAction extends ActionSupport implements ConDAOAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private TestDTO paramClass; // 파라미터를 저장할 객체
	private TestDTO resultClass; // 쿼리 결과 값을 저장할 객체

	private int currentPage;	// 현재 페이지
	
	private int no;
	
	private ConDAO conDao;
	
	public void setConDAO(ConDAO conDao){
		this.conDao = conDao;
	}

	// 게시글 글 삭제
	public String execute() throws Exception {
		
		sqlMapper = conDao.getCon();
		
		// 파라미터와 리절트 객체 생성.
		paramClass = new TestDTO();
		resultClass = new TestDTO();
		
		// 해당 번호의 글을 가져온다.
		resultClass = (TestDTO) sqlMapper.queryForObject("Test.selectOne", getNo());

		// 삭제할 항목 설정.
		paramClass.setNo(getNo());
				
		// 삭제 쿼리 수행.
		sqlMapper.update("Test.deleteBoard", paramClass);

		return SUCCESS;
	}

	public TestDTO getParamClass() {
		return paramClass;
	}

	public void setParamClass(TestDTO paramClass) {
		this.paramClass = paramClass;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public TestDTO getResultClass() {
		return resultClass;
	}

	public void setResultClass(TestDTO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}