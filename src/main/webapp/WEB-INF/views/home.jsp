<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
<%@ include file="include/header.jsp" %>	
</head>
<body>
<%@ include file="include/menu.jsp" %>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<!-- create table memo (
idx number not null primary key,
writer varchar2(50) not null,
memo varchar2(200) not null,
post_date date default sysdate
);

Insert into memo (idx,writer,memo) values(1,'kim','첫번째 메모');
Insert into memo (idx,writer,memo) values(2,'park','두번째 메모'); -->

</body>
</html>
