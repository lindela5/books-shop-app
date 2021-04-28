import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import './Book.css';
import {
    Card, Button, ButtonGroup
} from "react-bootstrap";


export class Book extends React.Component {

    render = () => {
        const authors = this.props.book.bookAuthor.map(author => author.authorLastName).join(", ");
        // console.log(this.props.book.bookAuthor)
        return (<Card key={this.props.book.bookId} className="book-card">
            {/*{this.props.book.bookTitle}*/}
            <Card.Img variant="top" src={this.props.book.picture}/>
            <Card.Body>
                {/*<CardTitle>{this.props.book.bookTitle}</CardTitle>*/}
                <Card.Text>
                    <span>Author(s): {authors}</span><br/>
                    <span>Year: {this.props.book.yearOfIssue}</span><br/>
                    <span>Price: {this.props.book.price}$</span>
                </Card.Text>
                <ButtonGroup>
                    <Button variant="primary" className="button">Buy</Button>
                    <Button variant="primary" className="button">Favorite</Button>
                </ButtonGroup>
            </Card.Body>

        </Card>)

    };

}