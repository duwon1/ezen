<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>
<article>
	<h1>배너수정</h1>
	<form action="/bannerUpdate" name="frm" method="post">
		<input type="hidden" name="bseq" value="${bannerVO.bseq}">
		<input type="hidden" name="oldfilename" value="${bannerVO.video}">

		<table id="BannerUpdateList">
			<tr>
				<th>배너 제목</th>
				<td width="343" colspan="5">
				<input type="text" name="subject" size="47" value="${bannerVO.subject}">
				</td>
			</tr>

			<tr>
				<th>순위</th>
				<td id="BannerOrder"width="40">
				<select  name="order_seq">
						<option value="">디스플레이될 순서를 선택하세요</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">사용안함</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>배너 타이틀 수정</th>
				<td width="343" colspan="5">
				<input type="text" name="btitle" size="47" value="${bannerVO.btitle}">
				</td>
			</tr>
			<tr>
				<th>배너 내용 수정</th>
				<td width="343" colspan="5">
				<input type="text" name="btext"	size="47" value="${bannerVO.btext}">
				</td>
			</tr>

			<tr>
				<th>텍스트 위치 수정</th>
				<td width="130" colspan="5">X축:
				<input type="text" name="top" size="5" value="${bannerVO.top}">px <br>Y축:
				<input	type="text" name="left" size="5" value="${bannerVO.left}">px
				</td>
			</tr>

			<tr>
				<th>배너 비디오</th>
				<td width="343" colspan="5" style="vertical =align: top;">현재
					비디오 : <video src="../videos/${bannerVO.video}" width="200px;"></video><br>
					<!--  <input type="file" name="image"> --> * 주의 : 비디오를 수정할때에만	선택해주세요.
					 <input type="hidden" name="video" id="video">
					<div id="filename"></div>
				</td>
			</tr>
		</table>		  
    <div id = "BannerUpdateButton" style="position: relative; left:800px; top:5px;">
	    <input class="btn" type="submit" value="수정" />
		<input class="btn" type="button" value="취소" onClick="go_mov()">
     </div>
	</form>

	<div style="position: relative; border: 1px solid black; width: 500px; margin: 0 auto;">
		<form name="fromm" id="fileupForm" method="post" enctype="multipart/form-data">
			<input type="file" name="fileimage"> 
			<input type="button" id="myButton" value="추가">
		</form>
	</div>

  



</article>
<%@ include file="../../admin/footer.jsp"%> 

