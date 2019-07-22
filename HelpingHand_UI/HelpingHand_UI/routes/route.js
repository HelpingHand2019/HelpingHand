var express = require("express");
var path = require("path");
var router = express.Router();
var ejs = require('ejs');
router.get("/", (req, res) => {
    console.log("hi");
    res.render("login.html");
});


module.exports = router;