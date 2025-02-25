import Grid from "@mui/material/Grid2";
import React, { useEffect } from "react";
import AddressCard from "../AddressCard/AddressCard";
import { Box, Button, TextField } from "@mui/material";
import { useDispatch, useSelector } from "react-redux";
import { createOrder } from "../../../State/Order/Action";
import { useNavigate } from "react-router-dom";
import { getCart } from "../../../State/Cart/Action";

const DeliveryAddressForm = () => {
  const dispatch=useDispatch();
  const navigate=useNavigate();
  const {cart}=useSelector(store=>store)
  
  const handleSubmit=(e)=>{
    e.preventDefault();
    const data=new FormData(e.currentTarget);
    const Address={
      firstName:data.get("firstName"),
      lastName:data.get("lastName"),
      streetAddress:data.get("address"),
      city:data.get("city"),
      state:data.get("state"),
      zipCode:data.get("zip"),
      mobile:data.get("phoneNumber")
    }
    const orderData={"address":Address,navigate}
    dispatch(createOrder(orderData))
    
    
  }
  return (
    <div>
      <Grid container spacing={4}>
        <Grid
          size={{ xs: 12, lg: 5 }}
          className="border rounded-e-md shadow-md h-[30.5rem] overflow-y-scroll"
        >
          {cart?.cart?.user?.address?.map(item=>(<div className="p-5 py-7 border-b cursor-pointer ">
            <AddressCard address={item}/>
            <Button
              sx={{ mt: 2, bgcolor: "#9155fd" }}
              size="large"
              variant="contained"
            >
              Deliver Here
            </Button>
          </div>))}
        </Grid>
        <Grid size={{ xs: 12 ,lg:7 }}>
          <Box className="border rounded-md shadow-md p-5">
            <form onSubmit={handleSubmit}>
              <Grid container spacing={3}>
                <Grid size={{ xs: 12, sm: 6 }}>
                  <TextField
                    required
                    id="firstName"
                    name="firstName"
                    label="First Name"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid>
                <Grid size={{ xs: 12, sm: 6 }}>
                  <TextField
                    required
                    id="lastName"
                    name="lastName"
                    label="Last Name"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid>
                <Grid size={{ xs: 12 }}>
                  <TextField
                    required
                    id="address"
                    name="address"
                    label="Address"
                    fullWidth
                    multiline
                    rows={4}
                    autoComplete="given-name"
                  />
                </Grid>
                <Grid size={{ xs: 12, sm: 6 }}>
                  <TextField
                    required
                    id="city"
                    name="city"
                    label="City"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid>
                <Grid size={{ xs: 12, sm: 6 }}>
                  <TextField
                    required
                    id="state"
                    name="state"
                    label="State/Province/Region"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid>
                <Grid size={{ xs: 12, sm: 6 }}>
                  <TextField
                    required
                    id="zip"
                    name="zip"
                    label="Zip / Postal Code"
                    fullWidth
                    autoComplete="shipping postal-code"
                  />
                </Grid>
                <Grid size={{ xs: 12, sm: 6 }}>
                  <TextField
                    required
                    id="phoneNumber"
                    name="phoneNumber"
                    label="Phone Number"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid>
                <Grid size={{ xs: 12, sm: 6 }}>
                  <Button
                    sx={{ py:1.5,mt: 2, bgcolor: "#9155fd" }}
                    size="large"
                    variant="contained"
                    type="submit"
                  >
                    Deliver Here
                  </Button>
                </Grid>
              </Grid>
            </form>
          </Box>
        </Grid>
      </Grid>
    </div>
  );
};

export default DeliveryAddressForm;
