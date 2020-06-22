<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="false"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">

<title>Dreamy Diary | Resign</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid bg-primary">
		<div class="container">
			<h1 class="display-4">정말 탈퇴하시겠습니까?</h1>
			<p class="lead">Dreamy Diary는 언제 어디서나 접속할 수 있고 마음대로 꾸밀수 있습니다</p>
		</div>
	</div>

	<div class="container-sm">
		<form accept-charset="utf-8" method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Id</label> <input type="text"
						class="form-control" id="inputId" name="userId" required>
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">비밀번호</label> <input type="password"
						class="form-control" id="inputPassword" name="passWord" required>
				</div>
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck">
					<label class="form-check-label" for="gridCheck"> 체크하세요 </label>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">탈퇴</button>
		</form>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="<c:url value='/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/js/popper.min.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
</body>
</html>