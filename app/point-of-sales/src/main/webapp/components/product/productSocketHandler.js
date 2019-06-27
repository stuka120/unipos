//# sourceURL=pos.productSocketHandler.js
define([
    'angular'
], function (angular) {
    return ['pos.productService', 'pos.socketService', function (productService, socketService) {
        socketService.subscribeBroadcast("stockAmountChanged", function (data) {
            var updates = JSON.parse(data.payload);
            updates.forEach(function(updateLine) {
                productService.updateStockAmountForProduct(updateLine.productGuid, updateLine.newStockAmount)
            });
            //productService.setAllProducts(true);
        });
    }];
});