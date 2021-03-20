import React, {useState, useEffect} from 'react';
import {Link, useHistory} from 'react-router-dom';
import {FiPower, FiEdit, FiTrash2} from 'react-icons/fi';
import api from '../../services/api';
import './styles.css';

import logoImage from "../../assets/logo.svg";

export default function Books(){

    const [books, setBooks] = useState([]);
    const [page, setPages] = useState(1);

    const username = localStorage.getItem('username');
    const accessToken = localStorage.getItem('accessToken');

    const history = useHistory();

    async function logout(){
        localStorage.clear();
        history.push('/')
    }

    async function editBook(id){
        try {
            history.push(`book/new/${id}`);
        } catch (err) {
            alert('Edit failed! Try Again!')
        }
    }

    async function deleteBook(id){
        try {
            await api.delete(`api/book/v1/${id}`,{ 
                headers:{
                    Authorization: `Bearer ${accessToken}`
                }
            })

            setBooks(books.filter(book => book.id !== id))
        } catch (err) {
            alert('Delete Falied! Try Again')
        }
    }

    async function fetchMoreBooks(){
        const response = await api.get('api/book/v1',{
            headers:{
                Authorization: `Bearer ${accessToken}`
            },
            params:{
                page : page,
                limit : 4,
                direction : 'asc',
            }
        });

        setBooks([...books, ...response.data_embebed.bookVO])
        setPages(page + 1);
    }

    useEffect(() => {
        fetchMoreBooks();   
    }, []);

    return (
        <div className="book-container">
            <header>
                <img src={logoImage} alt="Guilherme"/>
                <span>Welcome, <strong>{username.toUpperCase()}</strong>!</span>
                <Link className="button" to='book/new/0'>Add new book</Link>
                <button onclikck={logout} type="button">
                    <FiPower size ={18} color="#251FC5" />
                </button>
            </header>

            <h1>Registered Books</h1>
            <ul>
                {books.map(book =>(
                    <li key={book.id}>
                        <strong>Title:</strong>
                        <p>{book.title}</p>
                        <strong>Author:</strong>
                        <p>{book.author}</p>
                        <strong>Prico:</strong>
                        <p>{Intl.NumberFormat('pt-BR', {style: 'currency', currency:'BRL'}).format(book.price)}</p>
                        <strong>Realease Date:</strong>
                        <p>{Intl.DateTimeFormat('pt-BR').format(new Date(book.launchDate))}</p>

                        <buton onclikck={()=> editBook(book.id)} type="button">
                            <FiEdit size={20} color="#251FC5"/>
                        </buton>

                        <buton onclikck={() => deleteBook(book.id)} type="button">
                            <FiTrash2 size={20} color="#251FC5"/>
                        </buton>

                    </li>
                ))}
            </ul>

            <button classname="button" onclikck={fetchMoreBooks} type="button">Load More</button>
        </div>
    );
}