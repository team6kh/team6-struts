프로젝트 이름 : team6-struts
타겟 런타임 : Apache Tomcat v6.0

0. 테스트 게시판 "test"
1. 로그인/회원가입 "login" and "registration"
2. 식당(서비스아이템) 게시판 "rest" or "restaurant"
3. 후기 게시판 "review"
4. 공지사항/이벤트 게시판 "notice"
5. 문의하기 게시판  "qna"
6. 팁 게시판 "tip"

Java Resources
	src
		board
			test
				CreateTestAction.java // 글 쓰기 액션
				DeleteTestAction.java // 글 삭제 액션
				ListTestAction.java // 목록 리스트 액션
				*PagingAction.java
				ReadTestAction.java // 글 읽기 액션
				TestDTO.java // DTO
				UpdateTestAction.java // 글 수정 액션
		sql
			boardSQL.xml
		dbconnect.properties
		sqlMapConfig.xml
		struts.xml			
WebContent
	board
		test
			createTest.jsp // 글 쓰기
			listTest.jsp // 목록 리스트
			readTest.jsp // 글 읽기
				
						