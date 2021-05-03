import React, { Component } from 'react';

class ProductRow extends React.Component {
    render() {
      const product = this.props.product;
  
      return (
        <tr>
          <td><a href={`/product/${product.id}`}> {product.name}</a></td>
          <td>{product.price}</td>
          <td>{product.quantity}</td>
        </tr>
      );
    }
  }

  export default ProductRow;