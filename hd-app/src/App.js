import React, { Component } from 'react';
import { Container } from 'react-bootstrap';
import { Row } from 'react-bootstrap';
import { Col } from 'react-bootstrap';
import Navigation from './navigation/Navigation';
import SideNavigation from './listgroup/SideNavigation';

import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

class App extends Component {
  render() {
    return (
      <div>
        <Navigation></Navigation>
        <Container fluid>
          <Row>
            <Col xs={2} className="side-bar px-0 vh-100" >
              <SideNavigation></SideNavigation>
            </Col>
            <Col xs={10}>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}

export default App;