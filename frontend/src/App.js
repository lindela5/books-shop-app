import logo from './logo.svg';
import React from "react";
import './App.css';
import {Main} from "./component/Main";
import Footer from "./component/Footer";
import Header from "./component/Header";
import Sections from "./component/Sections";



function App() {
        return (<div>
            <Header/>
            <Sections/>
            <Main/>
            {/*<BookSection all={true}/>*/}
            {/*<span>{books}</span>// вызывать BookSection all="true/false"*/}
            <Footer/>
        </div>
    );
}

export default App;