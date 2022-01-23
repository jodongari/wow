import type {NextPage} from 'next'
import Head from 'next/head'
import 'semantic-ui-css/semantic.min.css'
import styles from "../styles/Home.module.css"
import VideoList from "../component/video/VideoList";
import axios from "axios";
import {Divider, Header} from 'semantic-ui-react';

const Home: NextPage = ({list}: any) => {
    return (
        <div className={styles.header}>
            <Head>
                <title>WoW-tube</title>
                <meta name="description" content="Generate by create next app"/>
            </Head>
            <div>
                <Header as="h3" style={{paddingTop: 40}}>
                    베스트 영상
                </Header>
                <Divider/>
                <VideoList list={list.slice(0, 9)}/>
                <Header as="h3" style={{paddingTop: 40}}>
                    최신 영상
                </Header>
                <Divider/>
                <VideoList list={list.slice(9)}/>
            </div>
        </div>
    )
}

export async function getStaticProps(){
    const apiUrl: any = process.env.apiUrl;
    const res = await axios.get(apiUrl);
    const data = res.data;

    return {
        props: {
            list: data,
            name: process.env.name,
        },
    };
}
export default Home

