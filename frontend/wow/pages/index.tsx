import type { NextPage } from 'next'
import Head from 'next/head'
import 'semantic-ui-css/semantic.min.css'
import Layout from "../component/Layout";
import styles from "../styles/Home.module.css"

const Home: NextPage = () => {
  return (
    <div className={styles.header}>
        <Head>
            <title>WoW-tube</title>
            <meta name="description" content="Generate by create next app" />
        </Head>
        <Layout/>
    </div>
  )
}

export default Home
