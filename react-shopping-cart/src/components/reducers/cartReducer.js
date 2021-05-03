
import { ADD_QUANTITY } from '../actions/action-types/cart-actions'


const initState = {
    products: [
        {id: 123, price: '$199.99', name: 'Macbook Air', quantity: 0},
        {id: 143, price: '$129.99', name: 'IPad', quantity: 0},
        {id: 456, price: '$99.99', name: 'iPod Touch', quantity: 0},
        {id: 236, price: '$399.99', name: 'iPhone 5', quantity: 0},
        {id: 1122, price: '$199.99', name: 'Nexus 7', quantity: 0}
      ]
}
const cartReducer= (state = initState,action)=>{
   
    switch(action.type) {
        case ADD_QUANTITY :
         return {
             ...state, 
            products: [...action.products]
        };
        default:
            return state;
    }
    
}

export default cartReducer
