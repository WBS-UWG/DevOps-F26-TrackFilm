//setup express to handle routing and rendering
var express = require('express');
var app = express();
app.set('view engine', 'ejs');

//setup bodyparser to extra data from form posts
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true })); 

app.use(express.static('public'));

// route to index page
app.get('/', function(req, res) {
    res.render('page/index');
});

app.get('/documentation', function(req, res) {
    res.render('page/documentation');
});

app.get('/quickstart', function(req, res) {
    res.render('page/quickstart');
});

app.get('/features/add_watched_item', function(req, res) {
    res.render('page/features/add_watched_item');
});

app.get('/features/add_whishlist_item', function(req, res) {
    res.render('page/features/add_whishlist_item');
});

app.get('/features/autofill_item', function(req, res) {
    res.render('page/features/autofill_item');
});


//start the web app
app.listen(8080, function () {
	console.log('App listening on port 8080!');
});
