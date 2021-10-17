import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

/**
 * Components
 */
import Layout from "./components/layout/Layout";
import Login from './pages/account/Login';

/**
 * Start
 */
const Pastley = ()  =>{
  return (
    <BrowserRouter>
      <Layout>
        <Switch>
          <Route exact path='/' component={Login}/>
        </Switch>
      </Layout>
    </BrowserRouter>
  );
}

/**
 * Export
 */
export default Pastley;