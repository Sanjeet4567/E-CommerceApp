import React from "react";
import AddressCard from "../AddressCard/AddressCard";
import OrderTracker from "./OrderTracker";
import { Box, Grid2 } from "@mui/material";
import { Star } from "@mui/icons-material";

const OrderDetails = () => {
  return (
    <div className="px:5 lg:px-20 ">
      <div>
        <h1 className="font-bold text-xl py-7">Delivery Address</h1>
        <AddressCard />
      </div>
      <div className="py-20">
        <OrderTracker activeStep={3} />
      </div>
      <Grid2 container className="space-y-5">
        {[1,1,1,1,1].map(item=>(

        <Grid2
          container
          size={{ xs: 12 }}
          className="shadow-xl rounded-md p-5 border"
          sx={{ alignItems: "center", justifyContent: "space-between" }}
        >
          <Grid2 size={{ xs: 6 }}>
            <div className="flex items-center space-x-4">
              <img
                className="w-[5rem] h-[5rem] object-cover object-top"
                src="https://rukminim1.flixcart.com/image/612/612/xif0q/jean/d/s/c/36-mj-bk-pl-48-comfits-original-imagqbrnyjfzhs8v.jpeg?q=70"
                alt=""
              />
              <div className="space-y-2 ml-5">
                <p className="font-semibold">Men Slim Mid Rise Black Jeans</p>
                <p className="space-x-5 opacity-50 text-xs font-semibold ">
                  <span>Color:pink</span>Size:M <span></span>
                </p>
                <p>Seller: linaria</p>
                <p>₹1099</p>
              </div>
            </div>
          </Grid2>
          <Grid2> 
            <Box sx={{color:"#900880"}}>
                <Star sx={{fontSize:"2rem"}} className="px-2 text-5xl"/>
                <span>Rate & Review Product</span>
            </Box>
          </Grid2>
        </Grid2>
        ))}
      </Grid2>
    </div>
  );
};

export default OrderDetails;
