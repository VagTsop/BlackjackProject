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



        <script
            src="https://code.jquery.com/jquery-3.5.0.js"
            integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="
        crossorigin="anonymous"></script>

        <link rel="stylesheet" href="/resources/chat.css">
        <link rel="stylesheet" href="/resources/table.css">



    </head>
    <body>
        <div>
            <div class="col-md-9 col-sm-9" id="table">

                <div id="game-status"></div><br><br>
                <div class="user-area">
                    <div id="money"></div>
                    <div class="score-parent">
                        <p>Score</p>
                        <div id="user-score"class="score">
                        </div>
                    </div>
                    <div id="user-hand" class="hand">
                        <h2 id="headers">${theBlackjackPlayer.username}</h2>
                    </div>
                </div>
                <div class="dealer-area">
                    <div class="score-parent">
                        <p>Score</p>
                        <div id="dealer-score"class="score">
                        </div>
                    </div>
                    <div id="dealer-hand" class="hand">
                        <h2>Dealer Hand</h2>
                    </div>
                </div>



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
                <div class="col-sm-12" id="actionDiv">
                    <div class="col-sm-6">
                        <div class="row">
                            <button type="button" class="btn btn-secondary" id="hit">Hit</button>
                        </div>
                        <div class="row">
                            <button type="button" class="btn btn-secondary" id="stand">Stand</button>
                        </div>
                    </div>   
                    <div class="col-sm-6">
                        <div class="row">
                            <button type="button" class="btn btn-secondary" id="replay">Play again</button>
                        </div>
                    </div>  
                </div>       
            </div>
        </div>
        <input type="hidden" id="username" name="custId" value="${theBlackjackPlayer.username}">
        <script type="text/javascript" src="/resources/chat.js"></script>
        <script type="text/javascript" src="/resources/websocket.js"></script>

        
        <script>
            
window.addEventListener("load", start, false);

function start()
{
    play();
}

function play()
{
    var deck1 = new Deck();
    deck1.createDeck();
    deck1.shuffle();
    deck1.deal21();
    document.getElementById("hit").addEventListener("click", function () {
        deck1.hit();
    }, false);
    document.getElementById("stand").addEventListener("click", function () {
        deck1.stand();
    }, false);
    document.getElementById("replay").addEventListener("click", function () {
        deck1.deal21();
    }, false);
}

function Deck()
{
    this.deck = new Array();
    this.userTotal;
    this.dealerTotal;
    this.money = 100;
    this.userBust;
    this.dealerBust;
    this.curusrHand;
    this.curdlrHand;
    var userHand = document.getElementById("user-hand");
    var dealerHand = document.getElementById("dealer-hand");
    var userScore = document.getElementById("user-score");
    var dealerScore = document.getElementById("dealer-score");
    var status = document.getElementById("game-status");
    var moneyDiv = document.getElementById("money");

    this.newDeck = function newDeck()
    {
        this.createDeck();
        this.shuffle();
        status.innerHTML = "NEW DECK IN PLAY!";
    }

    this.createDeck = function createDeck()
    {
        var numCards = 0;
        var suit, symbol, name;
        for (var k = 1; k <= 4; k++)
        {
            switch (k)
            {
                case 1:
                    suit = "hearts";
                    break;
                case 2:
                    suit = "diamonds";
                    break;
                case 3:
                    suit = "spades";
                    break;
                case 4:
                    suit = "clubs";
                    break;
            }

            for (var i = 1; i <= 13; i++)
            {
                symbol = i;
                switch (i)
                {
                    case 1:
                        name = "Ace";
                        symbol = "A";
                        break;
                    case 2:
                        name = "two";
                        break;
                    case 3:
                        name = "three";
                        break;
                    case 4:
                        name = "four";
                        break;
                    case 5:
                        name = "five";
                        break;
                    case 6:
                        name = "six";
                        break;
                    case 7:
                        name = "seven";
                        break;
                    case 8:
                        name = "eight";
                        break;
                    case 9:
                        name = "nine";
                        break;
                    case 10:
                        name = "ten";
                        break;
                    case 11:
                        name = "jack";
                        symbol = "J";
                        break;
                    case 12:
                        name = "queen";
                        symbol = "Q";
                        break;
                    case 13:
                        name = "king";
                        symbol = "K";
                        break;
                }
                this.deck[numCards] = new Card(suit, i, name, symbol);
                numCards++;
            }
        }
    }

    this.shuffle = function shuffle()
    {
        var randomDeck = new Array();
        var empty = false;
        while (!empty)
        {
            var randomIndex = Math.floor(Math.random() * this.deck.length);
            randomDeck.push(this.deck[randomIndex]);
            this.deck.splice(randomIndex, 1);
            if (this.deck.length <= 0)
                empty = true;
        }
        for (var i = 0; i < randomDeck.length; i++)
        {
            this.deck[i] = randomDeck[i];
        }
    };


    this.calcValue = function calcValue(hand)
    {
        var val = 0;
        var tempArr = hand;
        tempArr.sort(function (a, b) {
            return parseFloat(a.val) - parseFloat(b.val)
        });
        for (var i = tempArr.length - 1; i >= 0; i--)
        {
            var temp = tempArr[i];
            if (temp.val === 1 && val <= 10)
                temp.val = 11;
            else if (temp.val >= 10)
                temp.val = 10;
            val += temp.val;
        }
        return val;
    };

    this.emptyDeck = function emptyDeck()
    {
        if (this.deck.length < 1)
            return true;
        else
            return false;
    }

    this.deal21 = function deal21()
    {
        status.innerHTML = "";
        this.money--;

        //reset all the stuff that needs to be reset if the game is being replayed
        money.innerHTML = "Money: " + this.money;
        dealerHand.innerHTML = "<h2>Dealer Hand</h2>";
        userHand.innerHTML = "<h2>${theBlackjackPlayer.username}</h2>";
        this.userTotal = 0;
        this.dealerTotal = 0;
        this.userBust = false;
        this.dealerBust = false;
        hit.setAttribute("style", "");
        stand.setAttribute("style", "");
        dealerScore.setAttribute("style", "");
        this.curusrHand = new Array();
        this.curdlrHand = new Array();


        for (i = 0; i < 2; i++)
        {
            if (this.emptyDeck())
                this.newDeck();
            this.curusrHand.push(this.deck.pop());
            userHand.innerHTML += this.curusrHand[i].showCard();
        }
        this.userTotal = this.calcValue(this.curusrHand);
        userScore.innerHTML = this.userTotal;

        for (i = 0; i < 2; i++)
        {
            if (this.emptyDeck())
                this.newDeck();
            this.curdlrHand.push(this.deck.pop());
            dealerHand.innerHTML += this.curdlrHand[i].showCard();
        }
        this.dealerTotal = this.calcValue(this.curdlrHand);
        dealerScore.innerHTML = this.dealerTotal;
        //hide dealers first card
        var firstCard = dealerHand.getElementsByClassName("card")[0];
        firstCard.setAttribute("id", "hidden-card");
        var blackjack = true;
        if (this.userTotal === 21 && this.dealerTotal < 21)
            this.gameOver(blackjack);
        else if (this.dealerTotal === 21)
            this.gameOver();
    };

    this.hit = function hit()
    {
        if (this.emptyDeck())
            this.newDeck();
        this.curusrHand.push(this.deck.pop());
        userHand.innerHTML += this.curusrHand[this.curusrHand.length - 1].showCard();
        this.userTotal = this.calcValue(this.curusrHand);
        userScore.innerHTML = this.userTotal;
        if (this.userTotal > 21)
        {
            userScore.innerHTML += " <span style='color:red; font-weight: bold;'> BUST</span>";
            this.userBust = true;
            this.gameOver();
        }
    };

    this.stand = function stand()
    {
        while (this.dealerTotal < 17)
        {
            if (this.emptyDeck())
                this.newDeck();
            this.curdlrHand.push(this.deck.pop());
            dealerHand.innerHTML += this.curdlrHand[this.curdlrHand.length - 1].showCard();
            this.dealerTotal = this.calcValue(this.curdlrHand);
            dealerScore.innerHTML = this.dealerTotal;
            if (this.dealerTotal > 21)
            {
                dealerScore.innerHTML += " <span style='color:red; font-weight: bold;'> BUST</span>";
                this.dealerBust = true;
            }
        }
        this.gameOver();
    }

    this.gameOver = function gameOver(blackjack)
    {
        document.getElementById("hidden-card").setAttribute("id", "");
        dealerScore.setAttribute("style", "visibility: visible;");
        hit.setAttribute("style", "visibility:hidden;");
        stand.setAttribute("style", "visibility:hidden;");

        if (blackjack)
        {
            this.money += 3;
            status.innerHTML = "BLACKJACK!!!!!!!!!";
        } else if (this.userTotal > this.dealerTotal && this.userBust === false || this.dealerBust === true)
        {
            //user wins
            this.money += 2;
            status.innerHTML = "YOU WIN!";
        } else if (this.userTotal === this.dealerTotal && this.userBust === false)
        {
            //push
            this.money++;
            status.innerHTML = "PUSH :o";
        } else
            status.innerHTML = "YOU LOSE!";

        money.innerHTML = "Money: " + this.money;

    }

    this.dump = function dump()
    {
        for (var i = 0; i < this.deck.length; i++)
        {
            this.deck[i].showCard();
        }
    };
}

function Card(suit, val, name, symbol)
{
    this.suit = suit;
    this.val = val;
    this.name = name;
    this.symbol = symbol;

    this.showCard = function showCard()
    {
        var html = "";
        switch (this.suit)
        {
            case "hearts":
                suit_text = "&hearts;";
                break;
            case "diamonds":
                suit_text = "&diams;";
                break;
            case "spades":
                suit_text = "&spades;";
                break;
            case "clubs":
                suit_text = "&clubs;";
                break;
        }
        html = "<div class='card " + this.suit + "'><div class='card-value'>" + this.symbol + "</div><div class='suit'>" + suit_text + "</div><div class='main-number'>" + this.symbol + "</div><div class='invert card-value'>" + this.symbol + "</div><div class='invert suit'>" + suit_text + "</div></div>";
        return html;
    }
}


        </script>
        
    </body>
</html>