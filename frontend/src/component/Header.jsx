import React from 'react';
import {Nav} from "react-bootstrap";

const Header = () => {
    return <div className="book-header">
        <div className="flex-container flex-end">
            <a href="/login">Login</a> /// nav link или link
        </div>
        <div className="fig">
            <img src="https://i.ibb.co/tzy7qSS/unnamed.png" className="img-fluid" alt=""/>
        </div>
        <Nav defaultActiveKey="/home" as="ul" className="nav-menu">
            <Nav.Item>
                <Nav.Link href="/">
                    <li>Home</li>
                </Nav.Link>
            </Nav.Item>
            <Nav.Item>
                <Nav.Link href="/books">
                    <li>Books</li>
                </Nav.Link>
            </Nav.Item>
        </Nav>
    </div>
};


export default Header;

