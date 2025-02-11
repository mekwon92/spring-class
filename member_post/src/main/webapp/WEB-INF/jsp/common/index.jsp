<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp" />
<style>
   .layer-popup {width: 420px; position: absolute; top:150px; left:calc(50% - 210px); display:none;}
   .layer-popup img {display: block;}
   .layer-popup p {background-color: lightblue; color: #eee; margin: 0; padding: 8px; font-size: 13px;}
   .layer-popup p input {vertical-align: middle;}
   .layer-popup p a {color: #eee; text-decoration: none; float: right;}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<div class='wrap'>
		<!-- xml문법을 따름..? include 하기 -->
		<jsp:include page="header.jsp" />
		<main class="container">
			<div class="row">
				<div class="col-md-9">
					<div class="p-3">
						<h1>index</h1>
					</div>
				</div>
				<div class="col-md-3">
					<div class="p-3 d-grid gap-2">
					<c:if test="${empty member}">
						<a href="${cp}member/signin" class="btn btn-primary btn-block">로그인</a>
						<div class="small clearfix">
							<a href="${cp}member/signup" class="small float-start text-decoration-none">회원가입</a>
							<a href="${cp}member/signin" class="small float-end text-decoration-none">아이디/비밀번호 찾기</a>
						</div>
					</c:if>
					<c:if test="${not empty member}">
						<p><a href="${cp}member/mypage" class="text-decoration-none text-dark"><strong>${member.name}</strong></a>님 환영합니다.</p>
						<div class="small clearfix">
							<a href="${cp}member/logout" class="small float-start text-decoration-none">로그아웃</a>
							<a href="${cp}member/mypage" class="small float-end text-decoration-none">마이페이지</a>
						</div>
					</c:if>	
					</div>
				</div>
			</div>
		</main>
		<div class="layer-popup">
			<img src="https://image.yes24.com/momo/scmfiles/AdvertFiles/202410/2578206_241014101146.jpg">
			<p class="clearfix">
				<span>오늘은 그만보기 <input type="checkbox"></span> <a href="#">닫기</a>
			</p>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
	<script>
	//쿠키 여부 확인(없을 때) jquery cookie cdn 사용함
	if(!$.cookie("layer")) {
		$(".layer-popup").show();
	}
	
	
	//레이어 팝업 내의 닫기 버튼 클릭시 이벤트
	$(".layer-popup a").click(function() {
		event.preventDefault();
		const checked = $(this).prev().find("input:checkbox").prop("checked");
		console.log(checked);
		if(checked){
		$.cookie('layer', 'yes', {expires: 1});
		}
		$(".layer-popup").hide();
	});
	</script>
</body>
</html>