<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>우리반 화이팅</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {  //로딩된 이후에 
	$("button").on("click",function(e){  //버튼을 클릭했을때
		 var fData=$("#frm");
		     var btn=$(this).data("btn"); //현재 클릭한 버튼 ->data-btn btn은 이름 맘대로바꿈 제이쿼리에 연결되있다 데이터와
	  		
        if(btn=='modify'){
            fData.attr("action","${root}/board/modify");
         }      
         else if(btn=='remove'){
            fData.find("#title").remove();
            fData.find("#content").remove();
            fData.find("#writer").remove();
            
            fData.attr("action","${root}/board/remove");
            fData.attr("method","get");
         }
         else if(btn=='list'){
            fData.find("#idx").remove();
            fData.find("#title").remove();
            fData.find("#content").remove();
            fData.find("#writer").remove();
            
            fData.attr("action","${root}/board/list");
            fData.attr("method","get");
            
         }
         fData.submit();
   });
});

</script>
</head>
<body>
   <div class="container">
      <h2>화이팅♥</h2>
         <div class="panel-body">
         <form id="frm" method="post">   <!-- action="${root }/board/modify"유알엘지움  -->
         <table class="table table-bordered">
         	<tr>
         		<td>번호</td>
         		<td><input type="text" class="form-control" name="idx" id="idx" readonly="readonly" value="${vo.idx }"></td>
         		</tr>
      
         	<tr>
         		<td>제목</td>
         		<td><input type="text" id="title" class="form-control" name="title" value="<c:out value='${vo.title }'/>"/></td>
         		</tr>
         		
        		<tr>
         		<td>내용</td>
         		<td><textarea rows="10" id="content" class="form-control" name="content" ><c:out value='${vo.content }'/></textarea></td>
         		</tr>
          		<tr>	
         		<td>작성자</td>
         		<td><input type="text" id="writer" class="form-control" name="writer" readonly="readonly" value="${vo.writer }"></td>
         		</tr>
         	<tr>
         	<td colspan="2" style="text-align:center;">
         	<c:if test="${!empty mem && mem.memberID eq vo.memberID }">   <!-- 로그인한사람이랑 작성자랑 같아야한다 조건이 두가지가있다. 엔드기호는 양쪽이 모두 같아야 된다 -->
         		<button type="button" data-btn="modify" class="btn btn-md btn-primary">수정완료</button>  <!-- 수정 서브밋 폼으로감 -->
         		<button type="button" data-btn="remove" class="btn btn-md btn-success">삭제</button>  <!-- 리무버는 삭제임 -->
         	</c:if>	
         	<c:if test="${empty mem || mem.memberID ne vo.memberID }">   <!-- 로그인이 안되어있는작업  작성자랑 로그인한사람이랑 일치하지않으면 비활성화할거다-->
         		<button type="button" class="btn btn-md btn-primary" disabled="disabled">수정완료</button>  <!-- 수정 서브밋 폼으로감 -->
         		<button type="button" class="btn btn-md btn-success" disabled="disabled">삭제</button>  <!-- 리무버는 삭제임 onclick="location.href='${root}/board/remove?idx=${vo.idx }'"--> 
         	</c:if>
         		<button type="button" data-btn="list" class="btn btn-md btn-info">목록</button>  <!--date-btn="list" 이거넣고 온클릭삭제   onclick="location.href='${root}/board/list'" -->
         	</td>
         </table>
         <input type="hidden" name="page" value="<c:out value='${cri.page }'/>"/>
         <input type="hidden" name="perPageNum" value="<c:out value='${cri.perPageNum }'/>"/>
         							<input type="hidden" name="type" value="<c:out value='${cri.type }'/>"/>
				<input type="hidden" name="keyword" value="<c:out value='${cri.keyword }'/>"/>
         </form>

         </div>
         </div>
         </body>
         </html>
         
         
         