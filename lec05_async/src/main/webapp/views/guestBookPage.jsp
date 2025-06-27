<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<form id="inputMsg">
		<div>
			<label>이름: </label>
			<input type="text" id="name">
		</div>
		<div>
			<label>메세지: </label>
			<input type="text" id="msg">
		</div>
		<button>입력</button>
	</form>
	<ul id="guestBook"></ul>
	
	<script>
		$(document).ready(function() {
			$('#inputMsg').submit(function(e) {
				e.preventDefault();
				const name = $('#name').val();
				const msg = $('#msg').val();
				$.ajax({
					url : '/guestBookWrite',
					type : 'post',
					data : {
							name : name,
							msg : msg,
					},
					dataType : 'json',
					success : function(data) {
						const name = data.name;
						const msg = data.msg;
						const now = data.now;
						console.log(data);
						// $('#guestBook').empty();
						$('#guestBook').append('<li>(' + now + ') ' + name + ': ' 
								+ msg + '</li>');
						
					},
					error : function() {
						console.log('에러 발생');
					}
				});
			});
		});
	</script>
</body>
</html>