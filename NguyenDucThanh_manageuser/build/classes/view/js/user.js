var showHide = function() {
	var list = document.getElementsByClassName("japaneseLevel");
	if (list[0].hidden){
		for(let i = 0; i < list.length; i++){
			list[i].hidden = false;
		}
	} else {
		for(let i = 0; i < list.length; i++){
			list[i].hidden = true;
		}
	}
}

// hàm xử lý button xóa cho ADM005
function deleteUser() {
	// lấy ra message
	var message = document.getElementsByName("message")[0].value; 
	// confirm message
	var check = confirm(message); 
	if (check) { // nếu được confirm
		// khởi tạo form
		var form = document.createElement("form"); 
		// set method là post
		form.setAttribute("method", "post");
		// set id là delete 
		form.setAttribute("id", "delete");
		// set action cho form 
		form.setAttribute("action", "deleteUser.do"); 
		// set input là userID
		var input = document.getElementsByName("userID")[0];
		// gắn input vào form 
		form.appendChild(input);
		// lấy ra body và gắn form vào body 
		document.getElementsByTagName("body")[0].appendChild(form);
		// thực hiện submit với id là delete 
		document.getElementById("delete").submit();
		}
}