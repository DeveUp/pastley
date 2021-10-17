import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

/**
 * Components
 */
import Layout from "./components/layout/Layout";
import Login from './pages/account/Login';

/**
 * Style
 */
import "primereact/resources/primereact.min.css";
import "primereact/resources/themes/bootstrap4-light-blue/theme.css";
import "primeicons/primeicons.css";
import 'primeflex/primeflex.css';

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