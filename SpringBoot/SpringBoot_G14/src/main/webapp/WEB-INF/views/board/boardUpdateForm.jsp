<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/board.css">
<script  src="/script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
		<h1>게시글 수정</h1>
		
	
	    <form name="frm" method="post" action="boardUpdate">
			 
			 
			<table>
				<tr>
					<th>작성자</th>
					<td>${loginUser.userid}<input type="hidden" name="userid"
						value="${loginUser.userid}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> * 필수 (게시물 수정
						삭제시 필요합니다.)</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${loginUser.email}"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title"
						value="${dto.title}"> * 필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content">${dto.content}</textarea>
					</td>
				</tr>
				<tr>
					<th>이미지</th>
					<td>
					<c:choose>
					   <c:when test="${empty dto.imgfilename }"> </c:when>
					     <c:otherwise>
					        <img src="upload/noname.jpg" height="80" width="80"><br>
					     </c:otherwise>					  
					</c:choose>									      
                 <div id="image" style="float:left"> </div>  <input type="hidden" name="imgfilename">
                  <input type="button" value="파일 선택" onClick="selectimg();">	 
                    <img src=""id="previewimg"  style = "width:150px; display:none;"/> <br> 파일을 수정하고자 할 때만 선택하셈	                                                                                                      	
                      <input type="hidden" name="oldfilename" value="${dto.imgfilename }"> 
                      </td>
                      </tr>	
                     
                                	                			
				
			</table>
			<br> <br> 
			<input type="submit" value="수정"> 			
			<input type="button" value="목록"	onclick="location.href='main'">
		</form>
		<br>${message }
	</div>
</body>
</html>