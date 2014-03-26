package board.test;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

public class CreateTestAction extends ActionSupport {

	public static Reader reader; // 파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper; // SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private TestDTO paramClass; // 파라미터를 저장할 객체
	private TestDTO resultClass; // 쿼리 결과 값을 저장할 객체

	private int currentPage; // 현재 페이지

	private int no;
	private String subject;
	private String name;
	private String password;
	private String content;
	Calendar today = Calendar.getInstance(); // 오늘 날짜 구하기.

	// 생성자
	public CreateTestAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	public String form() throws Exception {
		// 등록 폼.
		return SUCCESS;
	}

	// 게시판 WRITE 액션
	public String execute() throws Exception {

		//파라미터와 리절트 객체 생성.
		paramClass = new TestDTO();
		resultClass = new TestDTO();

		// 등록할 항목 설정.
		paramClass.setSubject(getSubject());
		paramClass.setName(getName());
		paramClass.setPassword(getPassword());
		paramClass.setContent(getContent());
		paramClass.setRegdate(today.getTime());

		// 등록 쿼리 수행.
		sqlMapper.insert("insertBoard", paramClass);

		return SUCCESS;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public TestDTO getParamClass() {
		return paramClass;
	}

	public void setParamClass(TestDTO paramClass) {
		this.paramClass = paramClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
