package board.test;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.InputStream;
import java.io.IOException;

public class ReadTestAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private TestDTO paramClass = new TestDTO(); // 파라미터를 저장할 객체
	private TestDTO resultClass = new TestDTO(); // 쿼리 결과 값을 저장할 객체

	private int currentPage;

	private int no;
	private String password;

	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;

	// 생성자
	public ReadTestAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	// 상세보기
	public String execute() throws Exception {

		// 해당 글의 조회수 +1.
		paramClass.setNo(getNo());
		sqlMapper.update("updateReadHit", paramClass);

		// 해당 번호의 글을 가져온다.
		resultClass = (TestDTO) sqlMapper.queryForObject("selectOne", getNo());

		return SUCCESS;
	}
	
	// 비밀번호 체크 폼
	public String checkForm() throws Exception {

		return SUCCESS;
	}

	// 비밀번호 체크 액션
	public String checkAction() throws Exception {

		// 비밀번호 입력값 파라미터 설정.
		paramClass.setNo(getNo());
		paramClass.setPassword(getPassword());

		// 현재 글의 비밀번호 가져오기.
		resultClass = (TestDTO) sqlMapper.queryForObject("selectPassword", paramClass);

		// 입력한 비밀번호가 틀리면 ERROR 리턴.
		if (resultClass == null)
			return ERROR;

		return SUCCESS;
	}

	public TestDTO getParamClass() {
		return paramClass;
	}

	public void setParamClass(TestDTO paramClass) {
		this.paramClass = paramClass;
	}

	public TestDTO getResultClass() {
		return resultClass;
	}

	public void setResultClass(TestDTO resultClass) {
		this.resultClass = resultClass;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}