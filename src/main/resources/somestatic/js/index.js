function viewdiv(id) {
    var el = document.getElementById(id);
    var link = document.getElementById('toggleLink');
    if (el.style.display == "block") {
        el.style.display = "none";
        link.innerText = link.getAttribute('data-text-hide');
    } else {
        el.style.display = "block";
        link.innerText = link.getAttribute('data-text-show');
    }
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


            } )

        }
    };
    xhttp.open("GET", "http://localhost:9090/book/findAll", true);
    xhttp.send();
}

loadBooks();