import React from 'react';
import {Button, Header} from "semantic-ui-react";
import styles from "../../styles/Item.module.css"
import Head from 'next/head';

const VideoItem = ({item}: { item: any }) => {
    const {
        name,
        image_link,
        price,
        description,
        updated_at,
        category,
        product_type,
        product_link,
    } = item;
    return (
        <>
            <Head>
                <script async src="http://cdn.dashjs.org/v3.1.0/dash.all.min.js"></script>
            </Head>
            <div className={styles.wrap}>
                <video className={styles.video}
                       data-dashjs-player
                       autoPlay
                       src="https://dash.akamaized.net/envivio/EnvivioDash3/manifest.mpd"
                       controls>
                </video>
                <div className={styles.info_item}>
                    <strong className={styles.tit_item}>{name}</strong>
                    <strong className={styles.num_price}>${price}</strong>
                    <span className={styles.txt_info}>
                        {category ? `${category}/` : ""}
                        {product_type}
                    </span>
                    <Button color="orange">시청하기</Button>
                </div>
            </div>
            <Header as="h3">Description</Header>
            <p style={{paddingBottom: 20, fontSize: 18}}>{description}</p>
        </>
    );
};

export default VideoItem;
