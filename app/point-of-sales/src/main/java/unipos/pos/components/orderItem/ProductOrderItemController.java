package unipos.pos.components.orderItem;

import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unipos.common.remote.data.DataRemoteInterface;
import unipos.pos.components.orderItem.model.ProductOrderItem;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dominik on 28.08.15.
 */

@RestController
@RequestMapping("/productOrderItem")
public class ProductOrderItemController extends OrderItemController<ProductOrderItem> {

    @Autowired
    DataRemoteInterface dataRemoteInterface;

    @Override
    protected void afterOrderItemCreation(HttpServletRequest request, ProductOrderItem orderItem) {
        dataRemoteInterface.reduceStockAmountForProductGuid(Integer.parseInt(orderItem.productNumber), orderItem.quantity);
    }
}
