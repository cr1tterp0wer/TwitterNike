

var casper = require('casper').create();
var xpath  = require('casper').selectXPath


//casper.userAgent('Mozilla/7.0 (Macintosh; Intel Mac OS X)');
//casper.userAgent('Chrome/34.0.1847.131 (compatible; MSIE 6.0; Windows NT 5.1)');
//casper.userAgent('Mozilla/6.0 (compatible; MSIE 6.0; Windows NT 5.1)');
casper.userAgent('Mozilla/5.0 (Macintosh; Intel Mac OS X)');
phantom.cookiesEnabled = true;
casper.cookiesEnabled  = true;

   var fs      = require('fs');
   //var cookies = JSON.stringify(phantom.cookies);
   var cookies = document.cookie;

   fs.write('cookies.txt', cookies, 644); 



casper.start('http://store.nike.com/us/en_us/pd/dunk-sky-high-liberty-shoe/pid-1548655', function() { 
   

});


//QUANTITY
casper.thenClick(xpath('//*[@id="exp-pdp-buying-tools-container"]/form/div[1]/div[2]/ul/li[8]'), function(){ 
////*[@id="exp-pdp-buying-tools-container"]/form/div[1]/div[2]/ul/li[2]


  console.log('choosing quantity...8');

});


//SIZE
casper.thenClick(xpath('//*[@id="exp-pdp-buying-tools-container"]/form/div[1]/div[1]/div/ul/li[5]'), function(){
		console.log('choosing size...7');
	});


//ADD TO CART
casper.thenClick(xpath('//*[@id="exp-pdp-buying-tools-container"]/form/div[2]/button'), function(){ 
   console.log('Adding to cart...');



   
});

//Wait
casper.wait('500',function(){
   console.log('Waiting for load...');


})

//checkout button
casper.thenClick(xpath('/html/body/div[7]/div/div[2]/div[1]/div[2]/div[3]/a[2]'), function(){ 
  console.log('Clicking checkout btn...');


});


//Wait
casper.wait('500', function()
{
  console.log('Order Placed...');
 // console.log(this.getCurrentUrl());
    
//exit();
});





//fill_login_form
casper.then( function(){

//phantom.cookies = this.cookie;
  casper.capture('BeforeLog.png');

  casper.sendKeys(xpath('/html/body/div[6]/nav/div[5]/div/div/div[2]/div/form/div[2]/input'), 'alanturing847@yahoo.com');
  casper.sendKeys(xpath('/html/body/div[6]/nav/div[5]/div/div/div[2]/div/form/div[3]/input'), 'HeyCookie99');


//*[@id="tunnelEmailInput"]
 // casper.sendKeys(xpath('/html/body/div/div[2]/div[4]/div/div/form/div[2]/div[3]/input"]'), 'alanturing847@yahoo.com');
  //casper.sendKeys(xpath('/html/body/div/div[2]/div[4]/div/div/form/div[2]/div[5]/input'), 'HeyCookie99');

 casper.capture('FinalOrder.png');
   
});

//LoginButton
casper.thenClick(xpath('//*[@id="ch4_loginButton"]'), function(){
   console.log('Capturing Screen...');
   exit();
});






function exit(){casper.exit(); }
 
casper.run();






