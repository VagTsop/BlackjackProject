<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="chat.css">
        <!-- Latest compiled and minified JavaScript -->

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" crossorigin="anonymous"></script> 

        <style>
            
            .mytext{
    border:0;padding:10px;background:whitesmoke;
}
.text{
    width:75%;display:flex;flex-direction:column;
}
.text > p:first-of-type{
    width:100%;margin-top:0;margin-bottom:auto;line-height: 13px;font-size: 12px;
}
.text > p:last-of-type{
    width:100%;text-align:right;color:silver;margin-bottom:-7px;margin-top:auto;
}
.text-l{
    float:left;padding-right:10px;
}        
.text-r{
    float:right;padding-left:10px;
}
.avatar{
    display:flex;
    justify-content:center;
    align-items:center;
    width:25%;
    float:left;
    padding-right:10px;
}
.macro{
    margin-top:5px;width:85%;border-radius:5px;padding:5px;display:flex;
}
.msj-rta{
    float:right;background:whitesmoke;
}
.msj{
    float:left;background:white;
}
.frame{
    background:#e0e0de;
    height:450px;
    overflow:hidden;
    padding:0;
}
.frame > div:last-of-type{
    position:absolute;bottom:0;width:100%;display:flex;
}
body > div > div > div:nth-child(2) > span{
    background: whitesmoke;padding: 10px;font-size: 21px;border-radius: 50%;
}
body > div > div > div.msj-rta.macro{
    margin:auto;margin-left:1%;
}
ul {
    width:100%;
    list-style-type: none;
    padding:18px;
    position:absolute;
    bottom:47px;
    display:flex;
    flex-direction: column;
    top:0;
    overflow-y:scroll;
}
.msj:before{
    width: 0;
    height: 0;
    content:"";
    top:-5px;
    left:-14px;
    position:relative;
    border-style: solid;
    border-width: 0 13px 13px 0;
    border-color: transparent #ffffff transparent transparent;            
}
.msj-rta:after{
    width: 0;
    height: 0;
    content:"";
    top:-5px;
    left:14px;
    position:relative;
    border-style: solid;
    border-width: 13px 13px 0 0;
    border-color: whitesmoke transparent transparent transparent;           
}  
input:focus{
    outline: none;
}        
::-webkit-input-placeholder { /* Chrome/Opera/Safari */
    color: #d4d4d4;
}
::-moz-placeholder { /* Firefox 19+ */
    color: #d4d4d4;
}
:-ms-input-placeholder { /* IE 10+ */
    color: #d4d4d4;
}
:-moz-placeholder { /* Firefox 18- */
    color: #d4d4d4;
}  
        </style>
        
        
    </head>
    <body>
        <div>
            <div class="col-md-9 col-sm-9" >
                <div  >
                    <a>player 1</a>
                    <a id="player1"></a>
                </div><br>
                <div  >
                    <a>player 2</a>
                    <a id="player2"></a>
                </div><br>
                <button id="change" >change all</button>
                <button id="onlymine">change only mine</button> 



            </div>
            <div class="col-md-3 col-sm-3">
                <div class="col-sm-12 frame">
                    <ul></ul>
                    <div>
                        <div class="msj-rta macro">                        
                            <div class="text text-r" style="background:whitesmoke !important">
                                <input class="mytext" placeholder="Type a message"/>
                            </div> 

                        </div>
                        <div style="padding:10px;">
                            <span class="glyphicon glyphicon-share-alt"></span>
                        </div>                
                    </div>
                </div>
                <div class="col-sm-12">
                    <a>edo kato tha mpoun ta button tou player</a>
                </div>       
            </div>
        </div>

        <script src="resources/websocket.js"></script>
        <script src="resources/chat.js"></script>
        <script>
var me = {};
me.avatar = "https://cdn3.iconfinder.com/data/icons/shipping-and-delivery-2-1/512/54-512.png";

var you = {};
you.avatar = "https://cdn3.iconfinder.com/data/icons/shipping-and-delivery-2-1/512/54-512.png";

function formatAMPM(date) {
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var ampm = hours >= 12 ? 'PM' : 'AM';
    hours = hours % 12;
    hours = hours ? hours : 12; // the hour '0' should be '12'
    minutes = minutes < 10 ? '0' + minutes : minutes;
    var strTime = hours + ':' + minutes + ' ' + ampm;
    return strTime;
}

//-- No use time. It is a javaScript effect.
function insertChat(who, text, time) {
    if (time === undefined) {
        time = 0;
    }
    var control = "";
    var date = formatAMPM(new Date());

    if (who == "me") {
        control = '<li style="width:100%">' +
                '<div class="msj macro">' +
                '<div class="avatar"><img class="img-circle" style="width:100%;" src="' + me.avatar + '" /></div>' +
                '<div class="text text-l">' +
                '<p>' + text + '</p>' +
                '<p><small>' + date + '</small></p>' +
                '</div>' +
                '</div>' +
                '</li>';
    } else {
        control = '<li style="width:100%;">' +
                '<div class="msj-rta macro">' +
                '<div class="text text-r">' +
                '<p>' + text + '</p>' +
                '<p><small>' + date + '</small></p>' +
                '</div>' +
                '<div class="avatar" style="padding:0px 0px 0px 10px !important"><img class="img-circle" style="width:100%;" src="' + you.avatar + '" /></div>' +
                '</li>';
    }
    setTimeout(
            function () {
                $("ul").append(control).scrollTop($("ul").prop('scrollHeight'));
            }, time);

}

function resetChat() {
    $("ul").empty();
}

$(".mytext").on("keydown", function (e) {
    if (e.which === 13) {
        var text = $(this).val();
        if (text !== "") {
//            console.log("sdfsdfsdf");
            insertChat("me", text, new Date(Date.now()).toLocaleString());
            say("mpampis", text);

            $(this).val('');
        }
    }
});

$('body > div > div > div:nth-child(2) > span').click(function () {
    $(".mytext").trigger({type: 'keydown', which: 13, keyCode: 13}, );
});

//-- Clear Chat
resetChat();









var socket = new WebSocket("ws://localhost:8080/WebSocketTomcat/hello");

socket.onmessage = onMessage;


function onMessage(event) {
    var msg = JSON.parse(event.data);
    console.log(msg);
    switch (msg.type) {
        case "message":
            insertChat(msg.name, msg.text,msg.date); 
            break;
        case "moirase":
            console.log("moirase");
              document.getElementById("player1").innerHTML=msg.player1;
              document.getElementById("player2").innerHTML=msg.player2;
    }
}

function say(name, text) {
    var msg = {
        type: "message",
        request: "chat",
        text: text,
        name: name,
        date: new Date(Date.now()).toLocaleString() //https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date/toLocaleString
    };
    socket.send(JSON.stringify(msg));
}





//SHUFFLE

document.getElementById("change").addEventListener("click", giveCards);
document.getElementById("onlymine").addEventListener("click", giveCardsToMe);

function random(array) {

    const x = array[Math.floor(Math.random() * array.length)];
    return x;
}

function giveCards(event) {
    event.preventDefault();
    const array = ["assos", "rigas", "vales", "duo"];
    const player1 = random(array);
    const player2 = random(array);
    submitResult(player1, player2,"public");

}

function giveCardsToMe(event) {
    event.preventDefault();
    const array = ["assos", "rigas", "vales", "duo"];
    const player1 = random(array);
    const player2 = random(array);
    submitResult(player1, player2,"private");

}

function submitResult(player1, player2,request) {
    var msg = {
        type: "moirase",
        request: request,
        player1: player1,
        player2: player2
    };
    socket.send(JSON.stringify(msg));
    console.log(msg);
}
        </script>
    </body>
</html>