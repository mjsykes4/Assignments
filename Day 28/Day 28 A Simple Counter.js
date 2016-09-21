function modify_count(val) {
  var count = document.getElementById('count').value;
    var newTotal = parseInt(count) + val;
    
    if (newTotal < 0) {
        newTotal = 0;
	}
	if (newTotal > 8) {
		$("#count").addClass("red");
	}else{
		$("#count").removeClass("red");
	}
    if (newTotal % 2 == 0) {
		$("#count").addClass("italics");
	}else{
		$("#count").removeClass("italics");
	}
	
    document.getElementById('count').value = newTotal;
    return newTotal;
}
function reset_count() {
	document.getElementById('count').value =0;
			$("#count").removeClass("red");
}

