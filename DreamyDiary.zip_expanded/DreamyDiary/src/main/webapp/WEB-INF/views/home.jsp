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

<!-- Login CSS -->
<link href="<c:url value='/css/login.css'/>" rel="stylesheet"
	id="bootstrap-css">

<title>Log In!</title>

</head>
<body>


	<div class="sidenav">
		<div class="login-main-text">
			<h2>
				Dreamy Diary!<br><br>
			</h2>
			<p>Dreamy Diary는 언제 어디서나 접속할 수 있고 마음대로 꾸밀수 있습니다!</p>
			<p>로그인 또는 회원가입 하세요!</p>
		</div>
	</div>
	<div class="main">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
				<form accept-charset="utf-8"
					name="member_info" method="post">
					<div class="form-group">
						<label>ID</label> <input type="text" name="userId" class="form-control"
							placeholder="User Name" required>
					</div>
					<div class="form-group">
						<label>비밀번호</label> <input type="password" name="passWord"
							class="form-control" placeholder="Password"	required>
					</div>
					<button type="submit" class="btn btn-black">로그인</button>
				</form>
				<form accept-charset="utf-8" method="get">
					<button type="submit" class="btn btn-secondary" formaction="/dd/signup">회원가입</button>
					<button type="submit" class="btn btn-secondary" formaction="/dd/resign">회원탈퇴</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="<c:url value='/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/js/popper.min.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
</body>
</html>