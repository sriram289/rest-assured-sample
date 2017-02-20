var express = require('express'),
    wines = require('./routes/wines');

var app = express();

app.configure(function () {
    app.use(express.logger('dev'));     /* 'default', 'short', 'tiny', 'dev' */
    app.use(express.bodyParser());
});

app.get('/wines', wines.findAll);
app.get('/wines/:name', wines.findByName);
app.post('/wines', wines.addWine);
app.put('/wines/:name', wines.updateWine);
app.delete('/wines/:name', wines.deleteWine);

app.listen(8081);
console.log('Listening on port 8081...');
