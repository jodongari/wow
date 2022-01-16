import React from 'react';
import {Button, Header} from "semantic-ui-react";
import styles from "../../styles/Item.module.css"

// 추후 any 를 VideoItem 타입으로 변경 예정
const VideoItem = ({item}: any) => {
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
            <div className={styles.wrap}>
                <div className={styles.img_item}>
                    <img src={image_link} alt={name}/>
                </div>
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

// 추후 Video 정보에 대한 interface (type)을 만들어 정적 type화를 진행할 예정
interface VideoItem {
    name: string;
    image_link: string;
    price: number;
    description: string;
    updated_at: string;
    category: string;
    product_type: string;
    product_link: string;
}
