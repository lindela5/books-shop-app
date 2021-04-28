import React from "react";
import axios from "axios";
import {Book} from "./Book";
import {CardColumns} from "react-bootstrap";
import './Book.css';

class BookSection extends React.Component {

    state = {
        sectionName: "",
        books: []
    }

    getBooks = () => {
        const config = {headers: {'Accept': 'application/json'}};

        let urlBooks;

        if (this.props.all) {
            urlBooks = "/book/findAll";
        } else {
            const sectionId = this.props.match.params.id;
            urlBooks = "/book/getbysection/" + sectionId;
        }

        axios.get(urlBooks, config)
            .then(response => this.setState({books: response.data}))
            .catch(error => console.log(error))
    };

    componentDidMount() {
        this.getBooks();
    };


    render() {
        //console.log(this.state.books);
        const books = this.state.books.length > 0 ?
            this.state.books.map((book) => <Book key={book.bookId} book={book}/>) : <div>No such book</div>

        return (<div>
            {/*<div className="flex-container flex-end"><p>admin</p></div>*/}
            {/*<div className="fig"><img src="https://i.ibb.co/tzy7qSS/unnamed.png" className="img-fluid"*/}
            {/*                          alt="Responsive image">*/}
            {/*</img>*/}
            {/*</div>*/}
            {/*<Navbar/>*/}
            {/*<Sections/>*/}
            <div className="container-fluid">
                <CardColumns className="card-columns col-book">
                    {books}
                </CardColumns>
                {/*<Footer/>*/}
            </div>
        </div>);
    }
}

export default BookSection;