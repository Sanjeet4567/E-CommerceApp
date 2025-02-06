import React, { useEffect } from "react";
import CartCard from "./CartCard";
import { Button } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { getCart } from "../../../State/Cart/Action";

const Cart = () => {
  const navigate=useNavigate()
  const {cart}=useSelector(store=>store)
  const dispatch=useDispatch()
  const handleCheckout=()=>{
    navigate(`/checkout?step=${2}`)
  }
  useEffect(()=>{
    dispatch(getCart())
    
    
  },[cart.updateCartItem,cart.removeCartItem])
  return (
    <div>
      <div className="lg:grid grid-cols-3 lg:px-16 relative">
        <div className="col-span-2">
          {cart.cartItems?.map(item=><CartCard item={item}/>)}
        </div>
        <div className="px-5 sticky top-0 h-[100vh] mt-5 lg:mt-0">
          <div className="border">
            <p className="uppercase font-bold opacity-60 pb-4">Price Details</p>
            <hr/>
            <div className="space-y-3 font-semibold mb-10 p-2">
              <div className="flex justify-between pt-3 text-black">
                <span>Price</span>
                <span>₹{cart.cart?.totalPrice}</span>
              </div>
              <div className="flex justify-between pt-3 text-black">
                <span>Discount</span>
                <span className="text-green-600 font-bold">-₹{cart.cart?.discount}</span>
              </div>
              <div className="flex justify-between pt-3 text-black">
                <span>Delivery Charges</span>
                <span className="text-green-600 font-bold">Free</span>
              </div>
              <div className="flex justify-between pt-3 text-black">
                <span>Toatal Amount</span>
                <span className="text-green-600 font-bold">₹{cart.cart?.totalDiscountedPrice}</span>
              </div>
            </div>
            <Button onClick={handleCheckout} variant="contained" className="w-full" sx={{px:"2.5rem",py:"0.7rem",bgcolor:"#9155fd"}}>
                Checkout
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Cart;
