var express    = require("express");
var app        = express();

var port = process.env.PORT || 3002;

app.use(express.static("./"));

app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
  });
  

app.get("/", function(req, res) {
    res.sendFile(__dirname + "/Client/src/views/login.html"); 
});

app.get("/home", function(req, res) {
    res.sendFile(__dirname + "/Client/src/views/dashboard.html"); 
});

// Start Server
app.listen(port, function () {
    console.log( "Express server listening on port " + port);
});