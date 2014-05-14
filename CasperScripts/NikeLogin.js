//http://www.nike.com/us/en_us/

var casper = require('casper').create();
var xpath  = require('casper').selectXPath
var page = require('webpage').create();

casper.userAgent('Mozilla/7.0 (compatible;  Windows NT 5.1)');
//casper.userAgent('Chrome/34.0(compatible; MSIE 6.0; Windows NT 5.1)');

phantom.cookiesEnabled = true;
casper.enableCookieSupport = true;

var fs      = require('fs');
var cookies = phantom.cookies;
fs.write('cookies.txt', cookies, 644); 



casper.start('http://store.nike.com/us/en_us/?l=shop,login', function(){
  this.echo(this.getTitle());
  casper.echo('Cookies enabled?: ' + phantom.cookiesEnabled);
  casper.echo(document.cookie);

  console.log(JSON.stringify(phantom.cookies, null, 2));

  casper.capture('NikeBegin.png');
 // casper.sendKeys(xpath('//*[@id="exp-login-email"]'), 'alanturing847@yahoo.com');
  //casper.sendKeys(xpath('//*[@id="exp-login-password"]'), 'HeyCookie99');
casper.fill('form[name="login-form"]', {
             "email" : 'alanturing847@yahoo.com',
             "password" : 'HeyCookie99'},true);



});

casper.thenClick(xpath('/html/body/div[9]/div/div/div/div/div/div/form/button'), function(){
  casper.wait(500);
  casper.capture('NikeAFTER.png');
  phantom.clearCookies();
});

//*[@id="accountStandalone"]/div[1]/div[1]/form/button



 /*
casper.fill('form[name="login-form"]', {
             "email" : 'alanturing847@yahoo.com',
             "password" : 'HeyCookie99'});

  //casper.sendKeys(xpath('/html/body/div[9]/div/div/div/div/div/div/form/div[2]/input'), 'alanturing847@yahoo.com');
  //casper.sendKeys(xpath('/html/body/div[9]/div/div/div/div/div/div/form/div[3]/input'), '\n');


  //casper.thenClick('#exp-login-rememberMe');
  //casper.thenClick('/html/body/div[9]/div/div/div/div/div/div/form/button');
  
});

casper.thenClick(xpath('/html/body/div[9]/div/div/div/div/div/div/form/button'), function(){

  console.log(casper.getCurrentUrl());
    casper.wait('10000');
  casper.capture('NikeLoginFinish.png'); 


});

casper.thenOpen('http://store.nike.com/us/en_us/pd/dunk-sky-high-liberty-shoe/pid-1548655', function(){


});
*/
//     /html/body/div[6]/nav/div[5]/div/div/div[2]/div[1]/form    'form'
//     //*[@id="exp-login-email"]
//     //*[@id="exp-login-password"]
//     /html/body/div[6]/nav/div[5]/div/div/div[2]/div[1]/form/button    'button'



function exit(){casper.exit(); }
 
casper.run();
