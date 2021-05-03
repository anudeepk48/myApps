import React, { Component } from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom'
import Home from './components/Home.js'
import ProductDetails from './components/ProductDetails.js';

class App extends Component {
  render() {
    return (
       <BrowserRouter>
            <div className="App">
                <Switch>
                    <Route exact path="/" component={Home}/>
                    <Route exact path="/product/:id" render={(props) => <ProductDetails {...props} />}/>
                  </Switch>
             </div>
       </BrowserRouter>
      
    );
  }
}

export default App;
