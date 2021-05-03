import React, { Component } from 'react';
import ProductRow from './ProductRow';

class ProductList extends React.Component {
    render() {
      const filterText = this.props.filterText;


  
      const rows = [];
      let lastCategory = null;
  
      this.props.products.forEach((product) => {
        if (product.name.toLowerCase().indexOf(filterText.toLowerCase()) === -1) {
          return;
        }
        rows.push(
          <ProductRow
            product={product}
            key={product.id}
          />
        );
        lastCategory = product.category;
      });
  
      return (
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Price</th>
              <th>Auantity</th>
            </tr>
          </thead>
          <tbody>{rows}</tbody>
        </table>
      );
    }
  }

  export default ProductList;