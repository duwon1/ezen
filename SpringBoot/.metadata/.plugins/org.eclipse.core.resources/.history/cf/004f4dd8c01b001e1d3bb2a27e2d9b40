<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>
	<h1>배너 보기</h1>
	<table id="EDList">
		<tr>
			<th align="center">배너 제목</th>
			<td colspan="5">${bannerVO.subject}</td>
		</tr>
		<tr>
			<th>배너 동영상</th>
			<td width="1470px;" colspan="5"	style="vertical-align: top; position: relative;">
				<div style="position: relative; width: 1470px;">
					<video src="../videos/${bannerVO.video}" width="100%"></video>
					<div style="position: absolute;  top: ${bannerVO.top}; left: ${bannerVO.left}; z-index: 1;">
						<h1 style="color:white">${bannerVO.btitle}</h1>
						<h3 style="color:white">${bannerVO.btext}</h3>
					</div>
				</div>
			</td>
		</tr>
	</table>

	<div class="Bottm-btn-container">
		<div>
			<input class="btn" type="button" value="목록" onClick="go_mov()">
		</div>
	</div>

</article>

<%@ include file="../../admin/footer.jsp"%>
<body>

</body>
</html>