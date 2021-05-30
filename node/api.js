var express = require("express");
var mysql = require("mysql");
var app = express();


var connection = mysql.createPool({
    connectionLimit: 10,
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'doctors',
    port: '8889'

});


app.get('/all',function(req,res,next){  
    var query = "select * from users"
    connection.query(query,function(error,results){
      if (error) { next(error) } else {
    res.send(JSON.stringify(results));
    }
  })
  });
  

  app.get('/getteam/:name',function(req,res,next){ 
    var data = Object() 
    var query = "select * from team where name=?"
    connection.query(query,[req.params.name],function(error,results){
      if (error) { next(error) } else {
        if(results.length>0) {
          data = results[0]
        }
    res.send(JSON.stringify(data));
    }
  })
  });



// End add new stock

   var server = app.listen(3000,function(){
      var host = server.address().address
      var port = server.address().port
    });