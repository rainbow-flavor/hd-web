import React, { Component } from 'react';
import { ListGroup } from 'react-bootstrap';
import { Container } from 'react-bootstrap';

class sideNavigation extends Component {
    render() {
        return (
            <ListGroup variant="flush" className="black text-center">
                <ListGroup.Item action href="#link1">link1</ListGroup.Item>
                <ListGroup.Item action href="#link2">link2</ListGroup.Item>
                <ListGroup.Item action href="#link3">link3</ListGroup.Item>
                <ListGroup.Item action href="#link4">link4</ListGroup.Item>
                <ListGroup.Item action href="#link5">link5</ListGroup.Item>
                <ListGroup.Item action href="#link6">link6</ListGroup.Item>
                <ListGroup.Item action href="#link7">link7</ListGroup.Item>
                <ListGroup.Item action href="#link8">link8</ListGroup.Item>
                <ListGroup.Item action href="#link9">link9</ListGroup.Item>
                <ListGroup.Item action href="#link10">link10</ListGroup.Item>
                <ListGroup.Item action href="#link11">link11</ListGroup.Item>
            </ListGroup>
        );
    }
}

export default sideNavigation;