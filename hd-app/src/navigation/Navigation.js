import React, { Component } from 'react';
import { Navbar } from 'react-bootstrap';
import { Nav } from 'react-bootstrap';

class navigation extends Component {
    render() {
        return (
            <Navbar bg="primary" fixed="top" variant="dark">
                <Navbar.Brand href="#home">LOGO</Navbar.Brand>
                <Nav className="ml-auto">
                    <Nav.Link href="#edit">EDIT PROFILE</Nav.Link>
                    <Nav.Link href="#logout">LOGOUT</Nav.Link>
                    <Nav.Link href="#signin">SIGNIN</Nav.Link>
                    <Nav.Link href="#signup">SIGNUP</Nav.Link>
                </Nav>
            </Navbar>
        );
    }
}

export default navigation;