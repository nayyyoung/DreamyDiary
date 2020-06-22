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

<title>Dreamy Diary | Sign Up</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid bg-primary">
		<div class="container">
			<h1 class="display-4">Dreamy Dream에 가입하세요!</h1>
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
				<label for="inputAddress">이름</label> <input type="text"
					class="form-control" id="inputAddress" placeholder="홍길동"
					name="name" required>
			</div>
			<div class="form-group">
				<label for="inputAddress2">E-Mail</label> <input type="email"
					class="form-control" id="inputEmail" placeholder="abc@abc.com"
					name="email" required>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputCity">전화번호</label> <input type="tel"
						class="form-control" id="inputPhoneNumber" name="phoneNumber"
						pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="010-0000-0000" required>
				</div>
				<div class="form-group col-md-4">
					<label for="inputState">생일</label> <input type="date"
						id="inputState" class="form-control" value="2000-01-01"
						name="birthDay" required>
					<!-- 					<input id="inputState" class="form-control" name="birthDay"> -->
				</div>
				<div class="form-group col-md-2">
					<label for="inputZip">성별</label> <select class="form-control"
						id="inputGender" name="gender">
						<option selected>남</option>
						<option>여</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck">
					<label class="form-check-label" for="gridCheck"> 체크하세요 </label>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">회원가입</button>
		</form>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="<c:url value='/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/js/popper.min.js'/>"></script>
	<script src="<c:url value='/js/bootstrap.min.js'/>"></script>
</body>
</html>