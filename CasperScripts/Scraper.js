var casper = require('casper').create();
var x = require('casper').selectXPath;

casper.start('http://www.guru.com/emp/search.aspx?keyword=#&&page=1&sort=Earnings');

/*casper.then(function() {
    this.test.assertExists({
        type: 'xpath',
        path: '//*[@class="paddingLeft5 txt11px txt666"]/a[text()="Next"]'
    }, "Got Here");
});
*/
casper.then(function() {
    var firstUrl = this.getCurrentUrl()
});

casper.thenClick(x('//*[@class="paddingLeft5 txt11px txt666"]/a[text()="Next"]'), function() {
    console.log("Woop!");
});

casper.waitFor(function check() {
    return this.evaluate(function() {
        return this.getCurrentUrl() != firstUrl;
    });
}, function then() {
    console.log(this.getCurrentUrl());
});


casper.run();