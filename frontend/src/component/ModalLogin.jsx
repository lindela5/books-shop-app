import React, {useState} from "react";
import {LoginForm} from "./LoginForm";
import {Button, Modal} from "react-bootstrap";
import axios from "axios";


const ModalLogin = (props) => {

    const [loginData, setLoginData] = useState('');
    const [passwordData, setPasswordData] = useState('');

    const [/*loginError,*/ setLoginError] = useState(false);
    const [/*passwordError, */setPasswordError] = useState(false);


    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    // const onLoginFormSubmit = (e) => {
    //     e.preventDefault();
    //     handleClose();
    // };

    const validate = () => {
        let valid = true;
        if (loginData.trim().length < 1) {
            setLoginError(true);
            valid = false;
        }
        if (passwordData.trim().length < 1) {
            setPasswordError(true);
            valid = false;
        }
        return valid;
    }

    const handleSubmit = e => {
        console.log(e);
        e.preventDefault();
        if (validate()) {
            console.log(loginData + ' ' + passwordData);
            const config = {
                headers: {'Accept': 'application/json'}
            };
            axios.post("/auth/login", {login: loginData, password: passwordData}, config)
                .then(res => {
                    //this.setState({user: res.data});
                    localStorage.setItem('user', res.data)
                })
                .catch(error => console.log(error));
        }
    }


    // const [isOpen, setIsOpen] = React.useState(false);
    // const [timer, setTimer] = React.useState(0);
    // const [startTime, setStartTime] = React.useState(0);
    // const [endTime, setEndTime] = React.useState(0);

    // const showModal = () => {
    //     setIsOpen(true);
    //     // setTitle("Modal Ready");
    //     document.body.style.backgroundColor = "white";
    // };

    // const hideModal = () => {
    //     setIsOpen(false);
    // };
    //
    // const startTimer = () => {
    //     setStartTime(Date.now());
    // };
    //
    // const modalLoaded = () => {
    //     setEndTime(Date.now());
    // };
    //
    // const onExit = () => {
    //     // setTitle("Goodbye 😀");
    // };
    //
    // const onExited = () => {
    //     document.body.style.backgroundColor = "green";
    //     // <Books />
    // };


    // return <div>
    //     {/*<button onClick={showModal}>Display Modal</button> ///через  props ->show model перенести в main*/}
    //     <Modal
    //         show={props.show}
    //         onEnter={startTimer}
    //         onEntered={modalLoaded}
    //         onExit={onExit}
    //         onExited={onExited}
    //     >
    //         {/*<Modal show={true} dialogClassName={"primaryModal"}>*/}
    //         <Modal.Header>
    //             <Modal.Title>Hi</Modal.Title>
    //         </Modal.Header>
    //         <Modal.Body><LoginForm close = {true}/></Modal.Body>
    //         <Modal.Footer>This is the footer</Modal.Footer>
    //     </Modal>
    // </div>
    return (
        <Modal
            show={props.show} onHide={handleClose}>
            <Modal.Header>
                <Modal.Title>Login Form</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <LoginForm onSubmit={handleSubmit} loginData={loginData} passwordData={passwordData}/>
            </Modal.Body>
            <Modal.Footer>This is the footer</Modal.Footer>
        </Modal>
)
    ;
};

export default ModalLogin;