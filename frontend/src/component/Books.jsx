import React from "react";
import Navbar from "./Header";
import {BookManager} from "./BookManager";
import {Table} from "react-bootstrap";
import axios from "axios";

// export default function Books() {
class Books extends React.Component {
    state = {
        sectionName: "",
        books: []
    }

    getBooks = () => {
        const config = {headers: {'Accept': 'application/json'}};


        axios.get("/book/findAll", config)
            .then(response => this.setState({books: response.data}))
            .catch(error => console.log(error))
    };

    componentDidMount() {
        this.getBooks();
    };

    render() {
    const books = this.state.books.length > 0 ?
        this.state.books.map((book) => <BookManager key={book.bookId} book={book}/>) : <div>No such book</div>

    return (<div>
        {/*<Navbar/>*/}
        {/*<span>books page</span>*/}
        <Table striped bordered hover>
            <thead>
            <tr>
                <th>#</th>
                <th>Title</th>
                <th>Author(s)</th>
                <th>ISBN</th>
                <th>Section</th>
                <th>Year Of Issue</th>
                <th>Publishing House</th>
                <th>Price</th>
                <th>Stock Balances</th>
                <th>Picture</th>
            </tr>
            </thead>
            <tbody>
            {books}
            {/*<tr>*/}
            {/*    <td>1</td>*/}
            {/*    <td>Mark</td>*/}
            {/*    <td>Otto</td>*/}
            {/*    <td>@mdo</td>*/}
            {/*</tr>*/}
            {/*<tr>*/}
            {/*    <td>2</td>*/}
            {/*    <td>Jacob</td>*/}
            {/*    <td>Thornton</td>*/}
            {/*    <td>@fat</td>*/}
            {/*</tr>*/}
            {/*<tr>*/}
            {/*    <td>3</td>*/}
            {/*    <td colSpan="2">Larry the Bird</td>*/}
            {/*    <td>@twitter</td>*/}
            {/*</tr>*/}
            </tbody>
        </Table>


    </div>);
    }
}

export default Books;