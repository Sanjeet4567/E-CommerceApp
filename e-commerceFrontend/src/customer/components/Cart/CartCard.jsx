import { AddCircleOutline, RemoveCircleOutline } from "@mui/icons-material";
import { Button, IconButton } from "@mui/material";
import React from "react";
import { useDispatch } from "react-redux";
import { removeCartItem, updateCartItem } from "../../../State/Cart/Action";

const CartCard = ({item}) => {
  const dispatch=useDispatch();
  const handleUpdateCartItem=(num)=>{
    const data={data:{quantity:item?.quantity+num},cartItemId:item?.id}
    dispatch(updateCartItem(data))
  }

  const handleRemoveCartItem=()=>{
    dispatch(removeCartItem(item.id));
  }

  return (
    <div className="p-5 shadow-lg border rounded-md ">
      <div className="flex items-center">
        <div className="w-[5rem] h-[5rem] lg:w-[9rem] lg:h-[9rem]">
          <img
            className="w-full h-full object-cover object-top"
            src={item?.product?.imageUrl}
            alt=""
          />
        </div>
        <div className="ml-5 space-y-1">
          <p className="font-semibold">{item?.product?.title}</p>
          <p className="opacity-70">Size:{item?.size},{item?.product?.color}</p>
          <p className="opacity-70 mt-2">Seller:{item?.product?.brand}</p>
          <div className="flex space-x-5 items-center text-gray-900 pt-6">
            <p className="font-semibold">₹{item?.discountedPrice}</p>
            <p className="opacity-50 line-through">₹{item?.price}</p>
            <p className="text-green-600 font-semibold">{item?.product?.discountPercent}% off</p>
          </div>
          <div className="lg:flex items-center lg:space-x-10 pt-4">
            <div className="flex items-center space-x-2">
              <IconButton onClick={()=>handleUpdateCartItem(-1) } disabled={item?.quantity<=1}>
                <RemoveCircleOutline />
              </IconButton>
              <span className="px-1 px-7 border rounded-sm">{item?.quantity}</span>
              <IconButton sx={{color:"#9155fd"}} onClick={()=>handleUpdateCartItem(1) } >
                <AddCircleOutline />
              </IconButton>
            </div>
            <div>
              <Button sx={{color:"#9155fd"}} onClick={handleRemoveCartItem}>Remove</Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CartCard;
