import React from "react";
import "./style.css"
import { HiX } from "react-icons/hi";
import { HiOutlineTicket } from "react-icons/hi";

export default function Cart({cartItems, setCartItems, showCart, setShowCart}) {
    if (!showCart) return null;
    return (
        <div id="display">
            <div id="cart-tab">
                <div id="cart-tab-header">
                    <div id="cart-tab-item-counter">
                        <span className="sec-txt-color">Seu carrinho tem&nbsp;</span><span className="prim-txt-color"><strong>{cartItems?.length}</strong>&nbsp;itens</span>
                    </div>
                    <div id="cart-tab-exit">
                        <button id="cart-tab-exit-button" onClick={() => setShowCart(false)}><HiX size={28}/></button>
                    </div>
                </div>
                <div id="cart-tab-items">
                    {
                        cartItems?.map((item, index) => {
                            return (
                                <div className="cart-item-area" key={index}>
                                    <div className="cart-item-img-area">
                                        <img src={item.image}/>
                                    </div>
                                    <div className="cart-item-info">
                                        <div className="cart-item-title">
                                            <p className="sec-txt-color">{item.name}</p>
                                        </div>
                                        <div className="cart-item-footer">
                                            <div className="cart-item-price">
                                                <p className="sec-txt-color">R${item.price}</p>
                                            </div>
                                            <div className="cart-item-controls">
                                                <div className="cart-item-decrease-qty">
                                                    <button>–</button>
                                                </div>
                                                <div className="cart-item-quantity prim-txt-color">
                                                    <p>1</p>
                                                </div>
                                                <div className="cart-item-increase-qty">
                                                    <button>+</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            )
                        })
                    }
                </div>
                <div id="cart-tab-footer">
                    <div id="cart-tab-total-value">
                        <p className="sec-txt-color">Total:</p><p className="prim-txt-color"><strong>R${" "}{
                                cartItems?.length > 0
                                ? cartItems
                                    .reduce((total, item) => total + item.price, 0)
                                    .toFixed(2)
                                    .replace(".", ",")
                                : "0,00"
                            }</strong></p>
                    </div>
                    <div id="cart-tab-add-coupon">
                        <HiOutlineTicket size={24}/>
                        <button href="null">Adicionar cupom</button>
                    </div>
                    <div id="cart-tab-checkout">
                        <button id="cart-tab-checkout-button" onClick={() => setCartItems([])}>Finalizar compra</button>
                    </div>
                </div>
            </div>
        </div>
    )
}