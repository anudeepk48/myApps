
import { ADD_QUANTITY } from './action-types/cart-actions'

//add qt action
 const addQuantity=(products)=>{
    return{
        type: ADD_QUANTITY,
        products
    }
}

export default addQuantity;
