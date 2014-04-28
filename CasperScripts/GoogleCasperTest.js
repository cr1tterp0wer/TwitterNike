

var casper = require('casper').create();

var xpath  = require('casper').selectXPath


casper.userAgent('Mozilla/5.0 (Macintosh; Intel Mac OS X)');
casper.start('http://store.nike.com/us/en_us/pd/dunk-sky-high-liberty-shoe/pid-1548655', function() {
    this.echo(this.status(true));

});

//QUANTITY
casper.thenClick(xpath('//*[@id="exp-pdp-buying-tools-container"]/form/div[1]/div[2]/ul/li[8]'), function(){

  console.log('choosing quantity...8');

});


//SIZE
casper.thenClick(xpath('//*[@id="exp-pdp-buying-tools-container"]/form/div[1]/div[1]/div/ul/li[5]'), function()
	{
		console.log('choosing size...7');
	});


//ADD TO CART
casper.thenClick(xpath('//*[@id="exp-pdp-buying-tools-container"]/form/div[2]/button'), function()
{
   console.log('Adding to cart...');
   
});

//Wait
casper.wait('5000',function(){
   console.log('Waiting for response...');

})

//checkout button
casper.thenClick(xpath('/html/body/div[7]/div/div[2]/div[1]/div[2]/div[3]/a[2]'), function(){
  console.log('Checking out...');
});


//Wait
casper.wait('5000', function()
{
  console.log('Order Placed...');
  console.log(this.getCurrentUrl());
//exit();
});

//Click OKAY to clos popups
//casper.thenClick(xpath('/html/body/div[11]/div/a'), function(){
  //console.log("attempting to disable Popups..."); 

//});

//Wait


//fill_login_form
casper.then( function(){
  
   casper.capture('FinalOrder.png');


//*[@id="tunnelEmailInput"]
  casper.sendKeys(xpath('/html/body/div/div[2]/div[4]/div/div/form/div[2]/div[3]/input"]'), 'alanturing847@yahoo.com');
  casper.sendKeys(xpath('/html/body/div/div[2]/div[4]/div/div/form/div[2]/div[5]/input'), 'HeyCookie99');


   
});

//LoginButton
casper.thenClick(xpath('//*[@id="ch4_loginButton"]'), function(){
   console.log('Capturing Screen...');

});



function exit(){casper.exit(); }
 
casper.run();






