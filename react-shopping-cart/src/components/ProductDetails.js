import React from "react";
import { connect } from "react-redux";
import addQuantity from "./actions/cartActions"

class ProductDetails extends React.Component {

    constructor(params) {
        super(params);
        const productId = this.props.match.params.id;
        const products = this.props.products;
        console.log(products);
        console.log(productId);
        if (productId) {
            this.state = {
                product : products.filter(product => product.id == productId)[0]};
        }

        this.pushBack = this.pushBack.bind(this);
        this.addQuantityClick = this.addQuantityClick.bind(this);

    }

    pushBack = () => {
        this.props.history.push("/");
    }

    addQuantityClick = (id) => {
        const products = this.props.products;
        const product = products.filter(product => product.id === id)[0];
        product.quantity = 5;
        this.props.addQuantity(products);
    }

    render() {
        return (
            <>
            <div><a onClick={() => this.pushBack()} href="#">Back</a></div>
            <div>
                <span> <h3>Name</h3></span> &nbsp; <span>{this.state.product.name}</span>
                <span> <h3>Price</h3></span> &nbsp; <span>{this.state.product.price}</span>
                <span> <h3>Quantity</h3></span> &nbsp; <span>{this.state.product.quantity}</span>
                <span><button onClick={() => this.addQuantityClick(this.state.product.id)}> Add</button></span>
            </div>
            </>
        );
    }

}

const mapStateToProps = state => ({
    products: state.products,
})

const mapDispatchToProps = dispatch => ({
    addQuantity: products => {
    dispatch(addQuantity(products));
    },
   });

  export default connect(mapStateToProps, mapDispatchToProps)(ProductDetails); 