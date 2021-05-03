import React, { Component } from 'react';
import { connect } from 'react-redux'
import ProductList from './ProductList';
import Search from "./Search.js"

class Home extends React.Component {

    constructor(props) {
      super(props);
      this.state = {
        filterText: ''
      };
      
      this.handleFilterTextChange = this.handleFilterTextChange.bind(this);
    }
  
    handleFilterTextChange(filterText) {
      this.setState({
        filterText: filterText
      });
    }
  
    render() {
        const PRODUCTS = this.props.products

      return (
        <div>
          <Search
            filterText={this.state.filterText}
            inStockOnly={this.state.inStockOnly}
            onFilterTextChange={this.handleFilterTextChange}
          />

<ProductList
          products={PRODUCTS}
          filterText={this.state.filterText}
        />
        </div>
      );
    }
  }

  const mapStateToProps = state => ({
    products: state.products,
  })
  
  export default connect(mapStateToProps, null)(Home);  