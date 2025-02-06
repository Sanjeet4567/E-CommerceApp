import { Avatar, Box, Rating} from '@mui/material'
import Grid from '@mui/material/Grid2'
import React from 'react'

const ProductReviewCard = () => {
  return (
    <div>
        <Grid conatiner spacing={2} gap={3}>
            <Grid size={{xs:1}}>
                <Box>
                    <Avatar className='text-white' sx={{width:56,height:56,bgcolor:"#9155fd"}}>R</Avatar>
                </Box>
            </Grid>
            <Grid size={{xs:9}}>
                <div className='space-y-2'>
                    <div>
                        <p className='font-semibold text-large'>Ram</p>
                        <p className='opacity-70'>April 5,2023</p>
                    </div>
                </div>

                <Rating value={4.5 } name='half-rating' readOnly precision={0.5}/>
                <p>Good Product. Please buy it while in discount.</p>
            </Grid>
        </Grid>
      
    </div>
  )
}

export default ProductReviewCard
