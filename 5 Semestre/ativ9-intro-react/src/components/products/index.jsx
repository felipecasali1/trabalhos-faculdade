import "./products.css";
import { products } from "./products.js"
import Cart from "../cart";
import React, { useEffect } from "react";
import { HiOutlineShoppingCart } from "react-icons/hi";
import { HiOutlineChip } from "react-icons/hi";
import { HiMenu } from "react-icons/hi";
import { HiPlus } from "react-icons/hi";

export default function Products() {
    const [cartItems, setCartItems] = React.useState([]);
    const [showCart, setShowCart] = React.useState(false);

    function addItem(item) {
        setCartItems((prev) => [...prev, item]);
    }

    return (
        <div id="store-container">
            <div id="store-navbar">
                <div id="store-menu">
                    <button><HiMenu size={35}/></button>
                </div>
                <div id="store-logo-name">
                    <div id="store-logo">
                        <HiOutlineChip size={45}/>
                    </div>
                    <div id="store-name">Loja</div>
                </div>
                <div id="cart-button">
                    <button onClick={() => setShowCart(!showCart)}><HiOutlineShoppingCart size={30}/></button>
                </div>
            </div>
            <div id="products-section">
                <div id="products">
                    {
                        products.map((item, index) => { return (
                            <div className="product-area" key={index}>
                                <div className="product-image">
                                    <img src={item.image}/>
                                </div>
                                <div className="product-info">
                                    <div className="product-name">
                                        <p>{item.name}</p>
                                    </div>
                                    <div className="product-price-button">
                                        <div className="product-price">
                                            <h5>R$ {(item.price * 1.25).toFixed(2)}</h5>
                                            <p>R$ {item.price}</p>
                                        </div>
                                        <div className="product-add-to-cart">
                                            <button onClick={() => addItem(item)}><HiPlus size={18}/><HiOutlineShoppingCart size={20}/></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        )})
                    }
                </div>
            </div>
            <Cart cartItems={cartItems} setCartItems={setCartItems} showCart={showCart} setShowCart={setShowCart}/>
        </div>

    )
}

