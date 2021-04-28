import React from "react";
import {LoginForm} from "./LoginForm";
import ModalLogin from "./ModalLogin";
import BookSection from "./BookSection";
import {
    Route,
    Redirect,
    Switch
} from 'react-router-dom'
import Books from "./Books";
import './Book.css';

const authentication = {
    isAuthenticated: false,
    authenticate() {
        const loggedInUser = localStorage.getItem("user");
        if (loggedInUser) {
            //const foundUser = JSON.parse(loggedInUser);
             this.isAuthenticated = true;
            //setUser(foundUser);
        }
        // this.isAuthenticated = true;
        // const config = {
        //     headers: {'Accept': 'application/json'}
        // };
        // axios.get("/auth/check", config)
        //     .then(res => this.setState({sections: res.data}))
        //     .catch(error => console.log(error));
        //
        // //setTimeout(cb, 100) // fake async
    },
    signout() {
        this.isAuthenticated = false
        //setTimeout(cb, 100) // fake async
    }
}

const PrivateRoute = ({component: Component, ...rest}) => (
    <Route {...rest} render={(props) => (
        authentication.isAuthenticated === true
            ? <Component {...props} />
            : <Redirect to='/login'/>
    )}/>
)

export class Main extends React.Component {

    render = () => {

        return (
            <>
                <Switch>
                    <Route exact path="/" render={() => <BookSection all={true}/>}/>
                    {/*<Route exact path="/books" component={Books}/>*/}
                    <Route exact path="/section/:id" component={BookSection}/>
                    <Route path="/login" render={() => <ModalLogin show={true}/>}/> /// как booksection c showmodal
                    <PrivateRoute path='/books' component={Books}/>
                </Switch>
            </>
        );
    };


};