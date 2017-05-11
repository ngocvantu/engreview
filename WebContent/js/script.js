var ws;
function connect() {
	var log = document.getElementById("log");
	log.style.height="200px";
	log.style.width="500px";
	log.style.wordWrap="break-word";
	log.style.overflow = "auto";
	log.scrollTop = log.scrollHeight;
	
	var username = document.getElementById("username").value;
	var wsURI = "ws://localhost:8080/ChaoStruts/chao/" + username;
	
	ws =  new WebSocket(wsURI);
	
	ws.onopen = function(evt) {
		log.innerHTML = "connected";
		document.getElementById("connect").disabled = true;
	}
	
	ws.onmessage = function(event) {
		var i=0;
		log.innerHTML += "<br>" + event.data;
		log.scrollTop = log.scrollHeight;
//		var audio = new Audio('bong.mp3');
//		audio.play(); 
	}
	
	ws.onclose = function(evt) {
	}
}

function send() {
	var msg = document.getElementById("msg");
	ws.send(msg.value);
	msg.value="";
}

function handle(e){
    if(e.keyCode === 13){ 
    	send();
    }
}

window.onbeforeunload = function() {
	ws.close()
};