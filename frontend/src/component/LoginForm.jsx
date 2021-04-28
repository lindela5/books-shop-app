import React, {useState} from 'react';
import {Button, Form} from "react-bootstrap";
import axios from "axios";
import ReactModalLogin from 'react-modal-login';

// import {facebookConfig, googleConfig} from "social-config";


export const LoginForm  = ({ onSubmit }) => {
    // const theme = useTheme();
    // const classes = useStyles(theme);

    const [loginData, setLoginData] = useState({...this.props.loginData});
    const [passwordData, setPasswordData] = useState({...this.props.passwordData});

    const [/*loginError,*/ setLoginError] = useState(false);
    const [/*passwordError, */setPasswordError] = useState(false);

    // const validate = () => {
    //     let valid = true;
    //     if (loginData.trim().length < 1) {
    //         setLoginError(true);
    //         valid = false;
    //     }
    //     if (passwordData.trim().length < 1) {
    //         setPasswordError(true);
    //         valid = false;
    //     }
    //     return valid;
    // }



    return (
        <Form onSubmit={onSubmit}>
            <Form.Group controlId="formBasicEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control type="textfield"
                              placeholder="Enter login"
                              value={loginData}
                              onChange={(e) => setLoginData(e.target.value)}/>
                <Form.Text className="text-muted">
                    We'll never share your email with anyone else.
                </Form.Text>
            </Form.Group>

            <Form.Group controlId="formBasicPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password"
                              placeholder="Password"
                              value={passwordData}
                              onChange={(e) => setPasswordData(e.target.value)}/>
            </Form.Group>
            {/*<Form.Group controlId="formBasicCheckbox">*/}
            {/*    <Form.Check type="checkbox" label="Check me out"/>*/}
            {/*</Form.Group>*/}
            <Button variant="primary" type="submit">
                Login
            </Button>
        </Form>
    )
}