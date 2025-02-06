import Grid from "@mui/material/Grid2";
import React from "react";
import OrderCard from "./OrderCard";

const orderStatus = [
  {
    label: "On the way",
    value: "on_the_way",
  },
  {
    label: "Delivered",
    value: "delivered",
  },
  {
    label: "Cancelled",
    value: "on_the_way",
  },
  {
    label: "Returned",
    value: "returned",
  },
];
const Order = () => {
  return (
    <div className="px:5 lg:px-20">
      <Grid container sx={{ justifyContent: "space-between" }}>
        <Grid size={{ xs: 2.5 }}>
          <div className="h-auto shadow-lg bg-white p-5 sticky top-5">
            <h1>Filter</h1>

            <div className="space-y-4 mt-10">
              <h1 className="font-semibold">Order status</h1>
              {orderStatus.map((option) => (
                <div className="flex items-center">
                  <input
                    defaultValue={option.value}
                    type="checkbox"
                    className="h-4 w-4 border-gray-300 text-indigo-600 focus:ring-indigo-500"
                  />
                  <label
                    className="ml-3 text-sm text-gray-600"
                    htmlFor={option.value}
                  >
                    {option.label}
                  </label>
                </div>
              ))}
            </div>
          </div>
        </Grid>
        <Grid size={{ xs: 9 }}>
          <div className="space-y-5">

          {[1, 2, 2, 2, 3].map((item) => (
            <OrderCard />
          ))}
          </div>
        </Grid>
      </Grid>
    </div>
  );
};

export default Order;
