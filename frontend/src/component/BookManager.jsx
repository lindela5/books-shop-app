import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './Book.css';
import {
    Card, Button, ButtonGroup
} from "react-bootstrap";


export class BookManager extends React.Component {

    render = () => {
        const authors = this.props.book.bookAuthor.map(author => author.authorLastName).join(", ");
        // console.log(this.props.book.bookAuthor)
        return (<tr key={this.props.book.bookId} className="book-tr">

            <td>{this.props.book.bookId}</td>
            <td>{this.props.book.title}</td>
            <td>{authors}</td>
            <td>{this.props.book.isbn}</td>
            <td>{this.props.book.section}</td>
            <td>{this.props.book.yearOfIssue}</td>
            <td>{this.props.book.publishingHouse}</td>
            <td>{this.props.book.price}</td>
            <td>{this.props.book.stockBalances}</td>
            <td>{this.props.book.picture}</td>

                {/*<ButtonGroup>*/}
                {/*    <Button variant="primary" className="button">Buy</Button>*/}
                {/*    <Button variant="primary" className="button">Favorite</Button>*/}
                {/*</ButtonGroup>*/}

        </tr>)

    };
}