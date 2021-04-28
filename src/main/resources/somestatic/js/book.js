function searchById() {
    var id = document.getElementById("search_field").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var book = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '        <th>Book id</th>\n' +
                '        <th>Book title</th>\n' +

                '        <th>Delete</th>\n' +
                '    </tr>';
            html = html + '<tr><td>' + book.bookId + '</td>\n' +
                '        <td>' + book.bookTitle + '</td>\n' +

                '        <td><button onclick="deleteBook(' + book.bookId + ')">Delete</button></td></tr>';
            document.getElementById("bookList").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:9090/books/getbyid?id=" + id, true);
    xhttp.send();
}

function searchBySection() {
    var id = document.getElementById("search_field1").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var books = JSON.parse(this.responseText);
            let html = '<tr>\n' +
                '        <th>Book id</th>\n' +
                '        <th>Book title</th>\n' +
                '        <th>Delete</th>\n' +
                '    </tr>';


            document.getElementById("bookList").innerHTML = html;

            books.forEach((book) => {

                document.getElementById("bookList").innerHTML = document.getElementById("bookList").outerHTML +
                    '<tr><td>' + book.bookId + '</td>\n' +
                    '        <td>' + book.bookTitle + '</td>\n' +

                    '        <td><button onclick="deleteBook(' + book.id + ')">Delete</button></td></tr>';


            })
        }
    };
    xhttp.open("GET", "http://localhost:9090/books/getbysection?section=" + id, true);
    xhttp.send();
}


function deleteBook(bookId) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:9090/books/delete/" + bookId, true);
    xhttp.send();
}

function createBook() {
    var bookTitle = document.getElementById("book_title").value;
    var bookIsbn = document.getElementById("book_isbn").value;
    var bookYearOfIssue = document.getElementById("book_year_of_issue").value;

    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "http://localhost:9090/books/save");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({name: bookTitle, login: bookIsbn, email: bookYearOfIssue}));

    loadBooks();
}

function loadBooks() {
    let html;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var books = JSON.parse(this.responseText);
            let html = '<tr>\n' +
                '        <th>Book id</th>\n' +
                '        <th>Book title</th>\n' +
                '        <th>Delete</th>\n' +
                '    </tr>';


            document.getElementById("bookList").innerHTML = html;

            books.forEach((book) => {

                document.getElementById("bookList").innerHTML = document.getElementById("bookList").outerHTML +
                    '<tr><td>' + book.bookId + '</td>\n' +
                    '        <td>' + book.bookTitle + '</td>\n' +

                    '        <td><button onclick="deleteBook(' + book.id + ')">Delete</button></td></tr>';


            })

        }
    };
    xhttp.open("GET", "http://localhost:9090/books/findAll", true);
    xhttp.send();
}

loadBooks();