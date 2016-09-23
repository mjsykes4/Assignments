var slackToken = getSlackToken();

function postMessage(msg, channel) {
 $.ajax("https://slack.com/api/chat.postMessage", {
	 data: {
	 token: slackToken,
	 channel: channel,
	 username:"Akili Smith",
	 "text": msg	 
	 },
	   method: "POST"
	})
	console.log(msg,channel);

};
$(document).ready(function(){
$("#Gere").hide();
$("#showGere").click(function() {
$("#Gere").toggle();
});
$("#postMessage").click(function() {
	var text = $("#textarea").val()
	var channel=$('input[name="channel"]:checked').val();
	postMessage(text, channel);
	$("#textarea").val('');
});
$.ajax("https://slack.com/api/channels.list", {
	"data": {token:slackToken
},
	method: "POST"
}).then(function(channelsList) {
	 for (var i=0; i < channelsList.channels.length; i ++) {
			var selectAChannel = $("<li><input type= 'radio' name = 'channel' value= '" + channelsList.channels[i].name+"'>" + channelsList.channels[i].name + "</input></li>")
			$("#Pub").append(selectAChannel);
		};
		console.log(channelsList);		
});
$.ajax("https://slack.com/api/groups.list", {
	"data": {token:slackToken
},
	method: "POST"
}).then(function(groupsList) {
	 for (var i=0; i < groupsList.groups.length; i ++) {
			var selectAGroup = $("<li><input type= 'radio' name = 'channel' value= '" + groupsList.groups[i].name+"'>" + groupsList.groups[i].name + "</input></li>")
			$("#Gere").append(selectAGroup);
		};		
});
});