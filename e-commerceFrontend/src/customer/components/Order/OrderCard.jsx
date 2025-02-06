import React from "react";
import { Grid2 } from "@mui/material";
import { Adjust } from "@mui/icons-material";
import { useNavigate } from "react-router-dom";
const OrderCard = () => {
  const navigate=useNavigate();
  return (
    <div onClick={()=>navigate(`/account/order/${5}`)}className="p-5 shadow-md  hover:shadow-2xl border m-1">
      <Grid2 container spacing={2} sx={{ justifyContent: "space-between" }}>
        <Grid2 size={{xs:6}}>
          <div className="flex cursor-pointer">
            <img
              className="w-[5rem] h-[5rem] object-cover object-top"
              src="https://rukminim1.flixcart.com/image/612/612/xif0q/jean/d/s/c/36-mj-bk-pl-48-comfits-original-imagqbrnyjfzhs8v.jpeg?q=70"
              alt=""
            />
            <div className="ml-5 space-y-2">
              <p className="">Men Slim Mid Rise Black Jeans</p>
              <p className="opacity-50 text-xs font-semibold">Size: M</p>
              <p className="opacity-50 text-xs font-semibold">Color: Black</p>
            </div>
          </div>
        </Grid2>
        <Grid2 size={{ xs: 2 }}>
          <p>₹1099</p>
        </Grid2>
        <Grid2 size={{ xs: 4 }}>
          {true && (
            <div>
              <p>
                <Adjust
                  sx={{ width: "15px", height: "15px" }}
                  className="text-green-600 mr-2"
                />
                <span>Delivered on Mar 03</span>
              </p>
              <p className="text-xs">
                Your Item has been Delivered
              </p>
            </div>
          )}
          {false && (
            <p>
              <span>Expected Delivery on Mar 03</span>
            </p>
          )}
        </Grid2>
      </Grid2>
    </div>
  );
};

export default OrderCard;
