import "./products.css";
import { products } from "./products.js"
import Cart from "../cart";
import React, { useEffect } from "react";
import { HiOutlineShoppingCart } from "react-icons/hi";


export default function Products() {
    const [cartItems, setCartItems] = React.useState([]);
    const [showCart, setShowCart] = React.useState(false);

    function addItem(item) {
        setCartItems((prev) => [...prev, item]);
    }

    function fillCart() {
        setCartItems((prev) => [...prev, ...products]);
    }
    
    useEffect(() => {
        fillCart();
    }, []);

    return (
        <div id="store-container">
            <div id="store-navbar">
                <div id="store-name">Loja</div>
            </div>
            <div id="products-section">
                <div className="product-area">

                </div>
            </div>
            <div id="cart-button">
                <button onClick={() => setShowCart(!showCart)}><HiOutlineShoppingCart size={32}/></button>
            </div>
            <Cart cartItems={cartItems} setCartItems={setCartItems} showCart={showCart} setShowCart={setShowCart}/>
        </div>

    )
}

