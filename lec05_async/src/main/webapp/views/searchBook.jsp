<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도서 검색</h1>
	<form id="book_get_btn">
		<label>도서명: </label>
		<input type="text" id="searchBook">
		<button>조회</button>
	</form>
	<div id="book_get_div"></div>
	
	<script type="text/javascript">
		$(function() {
			$('#book_get_btn').submit(function(e) {
				e.preventDefault(); // form태그의 submit을 막고 아래 코드를 실행
				const keyword = $('#searchBook').val();
				$.ajax({
					url : '/searchBook',
					type : 'post',
					data : {keyword:keyword},
					dataType : 'json',
					success : function(data) {
						const arr = data.arr;
						console.log(arr);
						if (arr.length == 0) {
							$('#book_get_div').html('검색 결과가 없습니다.');
						} else {
							let str = '';
							for (let book of arr) {
								str += '<p>' + book.no + '. ' + book.title + ' - '
										+ book.author + '<p>';
							}
							$('#book_get_div').html(str);
						}
						
					},
				});
			});
		});
		
	</script>
</body>
</html>