package com.michaeldowden.jwf.web;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michaeldowden.jwf.model.Bourbon;
import com.michaeldowden.jwf.model.OrderItem;
import com.michaeldowden.jwf.model.ShoppingCart;
import com.michaeldowden.jwf.service.CartService;
import com.michaeldowden.jwf.service.ItemDao;

@RestController
public class CartController {

	@Autowired
	ItemDao itemDao;

	@Autowired
	CartService cartSvc;

	@RequestMapping("/svc/cart")
	public ShoppingCart fetchCart() {
		return cartSvc.fetchCart();
	}

	@RequestMapping(value = "/svc/cart/{itemId}", method = PUT)
	public void addToCart(@PathVariable("itemId") Integer itemId) {
		final Bourbon bourbon = itemDao.findBourbon(itemId);

		cartSvc.addToCart(new OrderItem(bourbon));
	}

	@RequestMapping(value = "/svc/cart/{itemId}", method = POST)
	public void updateQuantity(@PathVariable("itemId") Integer itemId,
			@RequestParam("qty") Integer qty) {
		cartSvc.updateQuantity(itemId, qty);
	}

	@RequestMapping(value = "/svc/cart/{itemId}", method = DELETE)
	public void removeFromCart(@PathVariable("itemId") Integer itemId) {
		cartSvc.removeFromCart(itemId);
	}

}
