import React, {useEffect, useState} from 'react';
import NavBar from "./header/NavBar";
import Header from "./header/Header"
import VideoList from "./video/VideoList";
import axios from "axios";

const Layout = () => {

    const [list, setList] = useState<any>([]);
    const API_URL = "http://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline"
    const getDate = () => {
        axios.get(API_URL).then((res) => {
            console.log(res.data);
            setList(res.data);
        })
    }

    useEffect(() => {
        getDate();
    }, []);

    return (
        <div>
            <Header/>
            <NavBar/>
            <VideoList list={list}/>
        </div>
    );
};

export default Layout;
