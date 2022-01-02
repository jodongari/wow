import type {NextPage} from 'next'
import Head from 'next/head'
import 'semantic-ui-css/semantic.min.css'
import styles from "../styles/Home.module.css"
import VideoList from "../component/video/VideoList";
import React, {useEffect, useState} from "react";
import axios from "axios";

const Home: NextPage = () => {

    // 영상 List 를 요청할 URL
    const API_VIDEO_URL = "http://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline"
    const [list, setList] = useState<any>([]);

    const getDate = () => {
        axios.get(API_VIDEO_URL).then((res) => {
            setList(res.data);
        })
    }

    useEffect(() => {
        getDate();
    }, []);

    return (
        <div className={styles.header}>
            <Head>
                <title>WoW-tube</title>
                <meta name="description" content="Generate by create next app"/>
            </Head>
            <div>
                <VideoList list={list}/>
            </div>
        </div>
    )
}

export default Home
