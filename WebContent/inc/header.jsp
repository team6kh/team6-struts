<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="homeAction.action">JOGIYO</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="listRestAction.action">레스토랑</a></li>
            <li><a href="/team6-struts/oard/rest/listReview.jsp">후기</a></li>
            <li><a href="/team6-struts/board/rest/listRecipe.jsp">레시피</a></li>
            <li><a href="/team6-struts/board/rest/listNotice.jsp">공지사항</a></li>
            <li><a href="/team6-struts/board/rest/listQna.jsp">문의하기</a></li>
          </ul>
          <form class="navbar-form navbar-right" role="form" action="/team6-struts/loginAction.action">
            <div class="form-group">
              <input type="text" placeholder="아이디" class="form-control" name="userId">
            </div>
            <div class="form-group">
              <input type="password" placeholder="비밀번호" class="form-control" name="password">
            </div>
            <button type="submit" class="btn btn-success">로그인</button>
          </form>
        </div><!--/.nav-collapse -->
      </div>
    </div>