<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>   
<!DOCTYPE html>
<html lang="en">
<head>
  <title>우리반 화이팅♥</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$('button').on('click',function(e){
		 var fData=$("#frm");
		 var btn=$(this).data('btn');
		 
		 if(btn=='reply'){
			 fData.attr("action","${root}/board/reply");
			 
		 }else if(btn=='list'){
			 var fData1=$("#fr1");
			 fData1.attr("action","${root}/board/list");
			 fData1.submit();
			 return;
			 
		 }else if(btn=='reset'){
			 fData[0].reset();
			 return;
		 }
		 fData.submit();
	});	
})
</script>

</head>
<body>

<div class="container">
  <h2>화이팅♥</h2>
    <div class="panel-body">  <!-- 답글쓰는 폼 쓴느중 -->
    	<form id="frm" method="post">  <!--넘어갈때 저장해야함  action="${root }/board/reply" -->
         <input type="hidden" name="page" value="<c:out value='${cri.page }'/>"/>
         <input type="hidden" name="perPageNum" value="<c:out value='${cri.perPageNum }'/>"/>   	 <!-- 현재보고있는 페이지 값ㄴ -->
    	
    	
    	<input type="hidden" name="idx" value="${vo.idx }"/>  <!-- 겟매핑에 vo에 담았다 -->
    	<input type="hidden" name="memberID" value="${mem.memberID }"/>  <!-- 로그인한 사람이름을 띄우기 위해 세션영역에 검  -->
    		<div class="form-group">
    			<label>제목</label>
    			<input type="text" name="title" class="form-control" value="<c:out value='${vo.title }'/>"/>
    		</div>
    		
    		<div class="form-group">
    			<label>답글</label>
    			<textarea rows="10" name="content" class="form-control"></textarea>
    		</div>
    		
    		 <div class="form-group">
    			<label>작성자</label>
    			<input type="text" readonly="readonly" name="writer" class="form-control"
    			 value="${mem.memberName }"/> <!-- 로그인한 사람쓸수있다.  -->  <!-- 로그인한 사람이름을 띄우기 위해 세션영역에 검  -->
    		</div>
    		
    		<button type="button" data-btn="reply" class="btn btn-default btn-md">답글</button>
        	<button type="button" data-btn="reset" class="btn btn-default btn-md">취소</button>
        	<button type="button" data-btn="list" class="btn btn-default btn-md">목록</button>
       	</form>
       	
       	<!-- 겟매핑 추가 ^ 서브밋 버튼들 바꾸자 -->
			<form id="fr1" method="get">
       			<input type="hidden" name="page" value="<c:out value='${cri.page }'/>"/>
				<input type="hidden" name="perPageNum" value="<c:out value='${cri.perPageNum }'/>"/>
 										<input type="hidden" name="type" value="<c:out value='${cri.type }'/>"/>
				<input type="hidden" name="keyword" value="<c:out value='${cri.keyword }'/>"/>
       		</form>
       	
    </div>
    </div>
	</div>
</body>
</html>