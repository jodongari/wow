import type {NextPage} from 'next'
import Head from 'next/head'
import 'semantic-ui-css/semantic.min.css'
import styles from "../styles/Home.module.css"
import VideoList from "../component/video/VideoList";
import axios from "axios";

const Home: NextPage = ({list}: any) => {
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

