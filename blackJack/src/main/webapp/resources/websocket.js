




var socket = new WebSocket("ws://localhost:8080/hello");

socket.onmessage = onMessage;


function onMessage(event) {
    var msg = JSON.parse(event.data);
    insertChat(msg.name, msg.text, msg.date);

}

function say(name, text) {
    var msg = {
        type: "message",
        request: "chat",
        text: text,
        name: name,
        date: new Date(Date.now()).toLocaleString() 
    };
    socket.send(JSON.stringify(msg));
}




