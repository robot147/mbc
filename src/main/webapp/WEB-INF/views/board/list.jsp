<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<%@ include file="../include/header.jsp" %>

<script type="text/javascript">
	$(function(){
		
		$("#btnWriter").click(function(){
			location.href="${path}/board/write.do";
		});
		function list(page) {
			location.href="${path}/board/list.do?curPage="+page
					+"&search_option=${map.search_option}"
					+"&keyword=${map.keyword}";
		}
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>

	<h2>게시판</h2>
	<button type="button" id="btnWriter">글 쓰기</button>
	${map.count }개의 게시물이 있습니다.
	<table border="1" width="600px"> 
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>이름</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
						
	<c:forEach var="row" items="${map.list}">
	<tr>
	<td>${row.bno}</td>
	   <td>${row.title}</td>
	   <td>${row.name}</td>
	   <td>
	   	<fmt:formatDate value="${row.regdate}"
	   		pattern="yyyy-MM-dd HH:mm:ss"/> 
	   </td>
	   <td>${row.viewcnt}</td>
	   </tr>
	  </c:forEach>
	  <!-- 페이지 네비게이션 -->
	  <tr>
	  	<td colspan="5" align="center">
	  		<c:forEach var="num" begin="1" end="${map.pager.totPage }">
	  			<a href="javascript:list('${num}')">${num }</a>
	  		</c:forEach>
	  	</td>
	  </tr>
	</table>
	

</body>
</html>