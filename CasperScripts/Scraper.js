/* var page = require('webpage').create();
page.open('http://www.netflix.com', function() {
 
  printcookie();


  phantom.exit();
});  

var http_request = new XMLHttpRequest();
    http_request.open("GET", "http://www.google.com", true);


function printcookie()
{
  var cookie= document.cookie;
  console.log(cookie);
}
*/


//to disable cookies, run casperjs --cookies-file=/dev/null? cookies.js
 
var casper = require('casper').create();
 
casper.start('http://www.nike.com/', function() {
    this.echo('Browser Cookie: ' + this.evaluate(function() {
        return document.cookie;
    }));
});
 
casper.run(function() {
    this.echo('Done.').exit();
});




